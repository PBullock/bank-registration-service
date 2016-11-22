package bankRegister;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * Created by Peter on 22/11/2016.
 */
public class BankRegisterConf extends Configuration {

    @JsonProperty
    private String consumableValue;

    public String getConsumableValue()
    {
        return consumableValue;
    }
}
