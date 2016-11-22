package bankRegister.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
public class BankRegisterClient {

    private Client client;
    public BankRegisterClient(Client client) { this.client = client; }

    @GET
    @Path("user")
    public void consumeUserLogin () {

    }

}
