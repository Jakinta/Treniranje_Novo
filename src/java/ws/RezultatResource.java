
package ws;

import db.DBHelper;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import json.JSONArray;
import json.JSONObject;


@Path("rezultat")
public class RezultatResource {

    @Context
    private UriInfo context;
    
    @Context
    private HttpServletRequest request;

   
    public RezultatResource() {
    }

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("user") != null) {
        String user = session.getAttribute("user") + "";
        List<Object[]> rezultati = DBHelper.query("SELECT t.treDatum, t.trePuls, t.treIzdrzljivost, p.posEmail "
                + "FROM Trening t JOIN t.posId p "
                + "WHERE p.posEmail=?1" , user);
        
        JSONArray a = new JSONArray();
        for(Object[] r: rezultati){
            JSONObject obj = new JSONObject();
            
            Date d = (Date) r[0];
            LocalDateTime dt = LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());
            String datum = DateTimeFormatter.ISO_LOCAL_DATE.format(dt);
            int puls = (Integer)r[1];
            int izdrzljivost = (Integer)r[2];
            String email = r[3] + "";
            obj.put("datum",datum);
            if(puls!=0)
            obj.put("puls",puls);
            if(izdrzljivost!=0)
            obj.put("izdrzljivost",izdrzljivost);
            if(puls==0 && izdrzljivost==0)
                continue;
            obj.put("email",email);
            a.put(obj);
        }
        return a.toString();
    }
        else
            return "ERR";
    }
   
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
