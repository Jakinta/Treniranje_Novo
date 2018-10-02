
package ws;

import db.DBHelper;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import json.JSONArray;
import json.JSONObject;


@Path("komentar")
public class KomentarResource {

    @Context
    private UriInfo context;

    
    public KomentarResource() {
    }

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String prikaziKomentar() {
        
        List<Object[]> komentari = DBHelper.query("SELECT p.posIme,p.posEmail, k.komDatum, k.komTekst "
                + "FROM Komentar k JOIN Posetilac p ON k.posId = p.posId "); 
        JSONArray a = new JSONArray();
        for(Object[] k: komentari){
            JSONObject obj = new JSONObject();
            String ime = k[0] + "";
            String email = k[1] + "";
            Date d = (Date)k[2];
            LocalDateTime dt = LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());
            String datum = DateTimeFormatter.ISO_LOCAL_DATE.format(dt);
            String tekst = k[3] + "";
            obj.put("ime",ime); 
            obj.put("email",email);
            obj.put("datum",datum);
            obj.put("tekst",tekst);
            a.put(obj);    
        }
        return a.toString();
       
    }

   
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
