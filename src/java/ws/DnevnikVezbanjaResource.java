package ws;

import db.DBHelper;
import db.Posetilac;
import db.SadrzajTreninga;
import db.Trening;
import db.Vezba;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import json.JSONArray;
import json.JSONObject;

@Path("dnevnikVezbanja")
public class DnevnikVezbanjaResource {

    @Context
    private UriInfo context;

    @Context
    private HttpServletRequest request;

    public DnevnikVezbanjaResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String pregledPodataka() {

        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("user") != null) {

            String user = session.getAttribute("user") + "";
            List<Object[]> podaci = DBHelper.query("SELECT t.treDatum, t.treTrajanje, t.trePuls, t.treIzdrzljivost, v.vezNaziv, st.strTrajanje, st.strbrSerija, st.strbrPonavljanja,  p.posEmail "
                    + "FROM  SadrzajTreninga st JOIN st.trening t JOIN st.vezba v JOIN t.posId p "
                    + "WHERE p.posEmail=?1", user);
            JSONArray a = new JSONArray();
            for (Object[] t : podaci) {
                JSONObject obj = new JSONObject();

                Date d = (Date) t[0];
                LocalDateTime dt = LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());
                String datum = DateTimeFormatter.ISO_LOCAL_DATE.format(dt);
                int trajanjeTreninga = (Integer) t[1];
                int puls = (Integer) t[2];
                int izdrzljivost = (Integer) t[3];
                String naziv = t[4] + "";
                int trajanjeVezbe = (Integer) t[5];
                int brSerija = (Integer) t[6];
                int brPonavljanja = (Integer) t[7];
                String email = t[8] + "";
                obj.put("datum", datum);
                obj.put("trajanjeTreninga", trajanjeTreninga);
                if(puls!=0)
                obj.put("puls", puls);
                if(izdrzljivost!=0)
                obj.put("izdrzljivost", izdrzljivost);
                obj.put("naziv", naziv);
                if(trajanjeVezbe!=0)
                obj.put("trajanjeVezbe", trajanjeVezbe);
                if(brSerija!=0)
                obj.put("brSerija", brSerija);
                if(brPonavljanja!=0)
                obj.put("brPonavljanja", brPonavljanja);
                obj.put("email", email);
                a.put(obj);
            }
            return a.toString();
        } else {
            return "ERR";
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String upisPodataka(String content) {

        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("user") != null) {

            JSONObject podaci = new JSONObject(content);
            Date date = new Date();
            int trajanje = podaci.getInt("trajanje");
            int puls = 0;
            int izdrzljivost = 0;
            Trening t = new Trening();
            t.setTreDatum(date);
            t.setTreTrajanje(trajanje);
            if (podaci.has("puls")) {
                puls = podaci.getInt("puls");
                t.setTrePuls(puls);
            }
            if (podaci.has("izdrzljivost")) {
                izdrzljivost = podaci.getInt("izdrzljivost");
                t.setTreIzdrzljivost(izdrzljivost);
            }
            String user = session.getAttribute("user") + "";
            List<Posetilac> posetioci = DBHelper.query("SELECT p FROM Posetilac p WHERE p.posEmail=?1 ", user);
            for (Posetilac p : posetioci) {
                t.setPosId(p);

            }
            DBHelper.insert(t);
            return "OK";
        }
        
        else
            return "ERR";
        
    }

    @PUT
    @Path("vezbe")
    @Consumes(MediaType.APPLICATION_JSON)
    public void upisPodatakaOVezbi(String content) {

        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("user") != null) {

            JSONObject vezbe = new JSONObject(content);
            String naziv = vezbe.getString("naziv");
            int trajanje = 0;
            int brSerija = 0;
            int brPonavljanja = 0;
            int idVezbe = 0;
            int idTrening = 0;
            int anaerobna = 0;
            List<Vezba> Vezbe = DBHelper.query("SELECT v FROM Vezba v WHERE v.vezNaziv=?1 ", naziv);
            for (Vezba v : Vezbe) {
                idVezbe = v.getVezId();
                anaerobna = v.getVezAnaerobna();
            }
            Date d = new Date();
            
            String user = session.getAttribute("user") + "";
            List<Trening> trening = DBHelper.query("SELECT t FROM Trening t JOIN Posetilac p ON t.posId.posId = p.posId "
                    + "WHERE p.posEmail=?1 AND t.treDatum=?2", user, d);
            for (Trening t : trening) {
                idTrening = t.getTreId();
            }
            SadrzajTreninga st = new SadrzajTreninga(idTrening, idVezbe);
            if(anaerobna==0){
                trajanje = vezbe.getInt("trajanje");
                st.setStrTrajanje(trajanje);
            }else{
                brSerija = vezbe.getInt("brSerija");
                st.setStrbrSerija(brSerija);
                brPonavljanja = vezbe.getInt("brPonavljanja");
                st.setStrbrPonavljanja(brPonavljanja);
            } 
            DBHelper.insert(st);
        }
    }

}
