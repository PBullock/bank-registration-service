package bankRegister.resources;

import bankRegister.bankRegisterService.AccountService;
import bankRegister.bankRegisterService.UserService;
import bankRegister.data.UserDataAccess;
import org.glassfish.jersey.client.JerseyClient;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("register")
public class UserResource extends JerseyClient
{
    @Path("/user")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(
            @FormParam("Nachname") String Nachname,
            @FormParam("Vorname") String Vorname,
            @FormParam("PLZ") String PLZ,
            @FormParam("Ort") String Ort,
            @FormParam("Strasse") String Strasse,
            @FormParam("Geburtsdatum") String Geburtsdatum,
            @FormParam("Passwort") String Passwort
    )
    {
        UserDataAccess userDao = new UserDataAccess();
        String ID = userDao.addUser(Nachname, Vorname, PLZ, Ort, Strasse, Geburtsdatum, Passwort).toString();

        UserService userService = new UserService(Nachname, Vorname, PLZ, Ort, Strasse, Geburtsdatum, Passwort);

        WebTarget target =  this.target("http://localhost:18185/api/"); //account service url
        target.register(String.class);

        WebTarget resourceTarget = target.path("user/account");
        Form kontoForm = new Form();
        kontoForm.param("Dispo", "5000");
        kontoForm.param("Guthaben", "100");
        kontoForm.param("Kunden_ID", ID);

        Invocation.Builder invocationBuilder =
                resourceTarget.request(MediaType.APPLICATION_JSON);
        Response accountResponse = invocationBuilder.post(Entity.form(kontoForm));
        Object account = accountResponse.getEntity();

        return Response.ok(account).build();
    }

    @Path("/user")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser()
    {
        UserService userService = new UserService("updated_user","customer");
        return Response.ok(userService).build();
    }

    @Path("/user")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser()
    {
        UserService userService = new UserService("deleted_user","customer");
        return Response.ok(userService).build();
    }

    @Path("/user")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(
            @QueryParam("Kontonummer") String Kontonummer
    )
    {
        UserDataAccess userDao = new UserDataAccess();
        UserService userService = userDao.getUser(Kontonummer);

        return Response.ok(userService).build();

    }
}
