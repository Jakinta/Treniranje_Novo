package ws;

import db.DBHelper;
import db.Vezba;
import java.util.List;
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

@Path("vezba")
public class VezbaResource {

    @Context
    private UriInfo context;

    public VezbaResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String ucitajVezbu(String content) {
        JSONObject vezba = new JSONObject(content);
        String naziv = vezba.getString("ime");
        List<Vezba> vezbe = DBHelper.query("SELECT v FROM Vezba v WHERE v.vezNaziv=?1", naziv);
        JSONArray a = new JSONArray();
        for (Vezba v : vezbe) {
            JSONObject obj = new JSONObject();
            naziv = v.getVezNaziv();
            String opis = v.getVezOpis();
            String slika = v.getVezSlika();
            obj.put("naziv", naziv);
            obj.put("opis", opis);
            obj.put("slika", slika);
            a.put(obj);
        }
     return a.toString();
    }
    

    

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
