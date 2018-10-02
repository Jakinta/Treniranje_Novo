
package ws;

import db.DBHelper;
import db.Posetilac;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import json.JSONObject;


@Path("login")
public class LoginResource {

    @Context
    private UriInfo context;
    
    @Context 
    private HttpServletRequest request;

    
    public LoginResource() {
    }

  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(String content) {
        JSONObject user = new JSONObject(content);
        String email = user.getString("email");
        String pass = user.getString("pass");
        List<Posetilac> posetilac = DBHelper.query("SELECT p FROM Posetilac p WHERE p.posEmail=?1 and p.posPassword=?2", email, pass);
        if(posetilac.size()>0){
            request.getSession(true).setAttribute("user", email);
              return("OK");
        }
            
       return "";
    }

    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
