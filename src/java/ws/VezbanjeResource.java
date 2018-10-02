/* Ovaj RESTful sadrzi metode za prikaz programa vezbanja i programa ishrane za korisnika sa unetom trojkom krvna grupa, cilj i nivo,
   kao i mogucnost za unosenje komentara.
*/


package ws;

import db.DBHelper;
import db.Komentar;
import db.Posetilac;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import json.JSONArray;
import json.JSONObject;


@Path("vezbanje")
public class VezbanjeResource {

    @Context
    private UriInfo context;
    
    @Context 
    private HttpServletRequest request;

    
    public VezbanjeResource() {
    }

    /* metoda programaVezbanja opisuje kako se na osnovu unetih podataka
       (krvna grupa, cilj i nivo), upitom nad bazom podataka, dobijaju sve
       relevantne informacije o konkretnom programu vezbanja
       (ucestalost, trajanje, broj serija, broj ponavljanja,
       kao i eventualne napomene.
    */ 
  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String programVezbanja(String content) {
        
        HttpSession session = request.getSession();
        if(session!=null && session.getAttribute("user")!=null) {
        
        JSONObject parametri = new JSONObject(content);
        String krGrupa = parametri.getString("krGrupa");
        String cilj = parametri.getString("cilj");
        String nivo = parametri.getString("nivo");
        
        
        List<Object[]> vezbe = DBHelper.query("SELECT v.vezNaziv, epv.epvUcestalost, epv.epvbrSerija, epv.epvbrPonavljanja, epv.epvTrajanje, epv.epvNapomena "
                + "FROM ElementProgramaVezbanja epv JOIN  epv.vezba v JOIN epv.programVezbanjaAb0 prv "
                + "JOIN prv.cljId c JOIN prv.nivId n "
                + " WHERE prv.prvkrvnaGrupa=?1 AND c.cljNaziv=?2 AND n.nivNaziv=?3", krGrupa, cilj, nivo);
        
        JSONArray a = new JSONArray();
        if(vezbe.size()>0){
        for(Object[] v: vezbe){
            JSONObject obj = new JSONObject();
            String naziv = v[0] + "";
            int ucestalost = (Integer) v[1];
            int brSerija = (Integer) v[2];
            int brPonavljanja = (Integer)v[3];
            int trajanje = (Integer)v[4];
            String napomena = v[5] + "";
           
            obj.put("naziv",naziv); 
            obj.put("ucestalost",ucestalost);
            if(brSerija != 0) obj.put("brSerija",brSerija);
            if(brPonavljanja !=0) obj.put("brPonavljanja", brPonavljanja);
            if(trajanje != 0) obj.put("trajanje", trajanje);
            obj.put("napomena",napomena);

            a.put(obj);
        }
           return a.toString();
        }
        else{
            JSONObject obj = new JSONObject();
            obj.put("napomena","Ne preporucuje se");
            a.put(obj);
            return a.toString();
        }
        
        }
       
        else
            return ("ERR");
    }

    /* metoda programIshrane opisuje kako se na osnovu unetih podataka(krvna grupa, cilj, nivo)
       upitom nad bazom podataka, dobijaju relevantne informacije o adekvatnom programu ishrane
       (kolicina proteina, ugljenih hidrata, masti) kao i primer datog programa ishrane.
    */
   
    @POST
    @Path("ishrana")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String programIshrane(String content) {
        
        
        
        JSONObject parametri = new JSONObject(content);
        String krGrupa = parametri.getString("krGrupa");
        String cilj = parametri.getString("cilj");
        String nivo = parametri.getString("nivo");
        
        List<Object[]> ishrana = DBHelper.query("SELECT i.ishkolProteina, i.ishkolUgljenihHidrata, i.ishkolMasti, i.ishPrimer "
                + "FROM ProgramVezbanjaAb0 prv JOIN prv.priId i JOIN prv.cljId c JOIN prv.nivId n "
                + " WHERE prv.prvkrvnaGrupa=?1 AND c.cljNaziv=?2 AND n.nivNaziv=?3" , krGrupa, cilj, nivo);
        JSONArray a = new JSONArray();
        for(Object[] i: ishrana){
            JSONObject obj = new JSONObject();
            int proteini = (Integer) i[0];
            int ugljHidrati = (Integer) i[1];
            int masti = (Integer) i[2];
            String primer = i[3] + "";
            
            obj.put("proteini",proteini); 
            obj.put("ugljHidrati",ugljHidrati);
            obj.put("masti",masti);
            obj.put("primer", primer);
            a.put(obj);
        }
        return a.toString();
    }
    
    
    /*  metoda upisKomentara dozvoljava svakom ulogovanom posetiocu da ostavi
    komentar za odredjeni program vezbanja i program ishrane.*/
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void upisKomentara(String content) {
        HttpSession session = request.getSession();
        if(session!=null && session.getAttribute("user")!=null){
        
        JSONObject komentari = new JSONObject(content);
        String komentar = komentari.getString("tekst");
        Date d = new Date();
        Komentar k = new Komentar();
        k.setKomTekst(komentar);
        k.setKomDatum(d);
        String user = session.getAttribute("user") + "" ;
        List<Posetilac> posetioci = DBHelper.query("SELECT p FROM Posetilac p WHERE p.posEmail=?1",user);
        for(Posetilac p: posetioci)
            k.setPosId(p.getPosId());
        
        DBHelper.insert(k);
        }
    }
    
    
    }

