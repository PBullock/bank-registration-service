package bankRegister.resources;

import bankRegister.bankRegisterService.UserService;
import org.glassfish.jersey.client.JerseyClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("login")
public class UserResource extends JerseyClient
{
    @Path("/user")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser()
    {
        UserService userService = new UserService("new_user","customer");
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
    public Response getUser()
    {
        UserService userService = new UserService("listed_user","customer");
        return Response.ok(userService).build();

    }
}
