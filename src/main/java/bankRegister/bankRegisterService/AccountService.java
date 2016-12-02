package bankRegister.bankRegisterService;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Peter on 01/12/2016.
 */

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class AccountService {
    @JsonProperty private Integer Kunden_ID;

    public AccountService(Integer Kunden_ID){
        this.Kunden_ID = Kunden_ID;
    }

    public void setKunden_ID(Integer kunden_ID) {
        Kunden_ID = kunden_ID;
    }

    public Integer getKunden_ID() {
        return Kunden_ID;
    }
}
