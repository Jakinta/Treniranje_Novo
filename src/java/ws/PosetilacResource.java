
package ws;

import db.DBHelper;
import db.Posetilac;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import json.JSONObject;


@Path("posetilac")
public class PosetilacResource {

    @Context
    private UriInfo context;

   
    public PosetilacResource() {
    }

    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    
    
    public void dodaj(String content) {
        JSONObject obj = new JSONObject(content);
        String ime = obj.getString("ime");
        String prezime = obj.getString("prezime");
        String email = obj.getString("email");
        String pass = obj.getString("pass");
        
        Posetilac p = new Posetilac();
        p.setPosIme(ime);
        p.setPosPrezime(prezime);
        p.setPosEmail(email);
        p.setPosPassword(pass);
        DBHelper.insert(p);
        
        
        
    }

    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String proveri(String content) {
        JSONObject obj = new JSONObject(content);
        String email = obj.getString("email");
        List<Posetilac> posetilac = DBHelper.query("SELECT p FROM Posetilac p WHERE p.posEmail=?1", email);
        
           if(posetilac.size() == 0)
               return "OK";
           else
        return "ERR";
    
           
    }
}
