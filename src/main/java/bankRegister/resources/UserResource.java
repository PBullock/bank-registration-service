package bankRegister.resources;

import bankRegister.bankRegisterService.UserService;
import bankRegister.data.UserDataAccess;
import org.glassfish.jersey.client.JerseyClient;

import javax.ws.rs.*;
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
        Integer ID = userDao.addUser(Nachname, Vorname, PLZ, Ort, Strasse, Geburtsdatum, Passwort);

        UserService userService = new UserService(Nachname, Vorname, PLZ, Ort, Strasse, Geburtsdatum, ID);

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
    public Response getUser(
            @QueryParam("Kontonummer") String Kontonummer
    )
    {
        UserDataAccess userDao = new UserDataAccess();
        UserService userService = userDao.getUser(Kontonummer);

        return Response.ok(userService).build();

    }
}
