package bankRegister;

import bankRegister.client.BankRegisterClient;
import bankRegister.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.client.Client;

/**
 * Created by Peter on 22/11/2016.
 */
public class BankRegisterApp extends Application<BankRegisterConf>{

    public static void main(String[] args) throws Exception{
        new BankRegisterApp().run(args);
    }

    @Override
    public void run(BankRegisterConf configuration, Environment environment) throws Exception {
        final Client client = setupClient(environment);
        environment.jersey().register(new BankRegisterClient(client));
        environment.jersey().register(new UserResource());
    }

    private Client setupClient(Environment environment) {
        return new JerseyClientBuilder(environment).build("REST Client");
    }
}
