package bankRegister.bankRegisterService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserService {
    @JsonProperty
    private String userName;

    @JsonProperty
    private String userType;

    @JsonProperty
    private String userPassword;

    public UserService(String userName, String userType)
    {
        this.userName = userName;
        this.userType = userType;
    }

    public UserService(String userName, String userType, String userPassword)
    {
        this.userName = userName;
        this.userType = userType;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
