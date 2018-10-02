
package ws;

import db.DBHelper;
import db.Vezba;
import java.util.List;
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


@Path("vezbe")
public class VezbeResource {

    @Context
    private UriInfo context;

    
    public VezbeResource() {
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        List<Vezba> vezbe = DBHelper.query("SELECT v FROM Vezba v");
        JSONArray a = new JSONArray();
        
        for(Vezba v: vezbe){
            String vez_naziv = v.getVezNaziv();
            JSONObject obj = new JSONObject();
            obj.put("vez_naziv", vez_naziv);
            a.put(obj);
        }
        return a.toString();
        
    }

    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
