package bankRegister.resources;

import bankRegister.bankRegisterService.UserService;
import bankRegister.data.UserDataAccess;
import bankRegister.model.UserModel;
import org.glassfish.jersey.client.JerseyClient;

import javax.annotation.security.DenyAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

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
        userDao.addUser(Nachname, Vorname, PLZ, Ort, Strasse, Geburtsdatum, Passwort);

        UserService userService = new UserService(Nachname, Vorname, PLZ, Ort, Strasse, Geburtsdatum, Passwort);
        return Response.ok(userService).build();
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
    @DenyAll
    public Response getUser()
    {
        UserService userService = new UserService("listed_user","customer");
        return Response.ok(userService).build();

    }
}
