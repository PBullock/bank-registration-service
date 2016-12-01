package bankRegister.bankRegisterService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserService {
    @JsonProperty
    private String Vorname;
    @JsonProperty
    private String Nachname;
    @JsonProperty
    private String Geburtsdatum;
    @JsonProperty
    private String Strasse;
    @JsonProperty
    private String Ort;
    @JsonProperty
    private String PLZ;
    @JsonProperty
    private String Passwort;

    public UserService (String Nachname, String Vorname) {
        this.Nachname     = Nachname;
        this.Vorname      = Vorname;
    }

    public UserService(String Nachname,
                       String Vorname,
                       String PLZ,
                       String Ort,
                       String Strasse,
                       String Geburtsdatum,
                       String Passwort)
    {
        this.Nachname     = Nachname;
        this.Vorname      = Vorname;
        this.PLZ          = PLZ;
        this.Ort          = Ort;
        this.Strasse      = Strasse;
        this.Geburtsdatum = Geburtsdatum;
        this.Passwort     = Passwort;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public String getGeburtsdatum() {
        return Geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        Geburtsdatum = geburtsdatum;
    }

    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String strasse) {
        Strasse = strasse;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String ort) {
        Ort = ort;
    }

    public String getPLZ() {
        return PLZ;
    }

    public void setPLZ(String PLZ) {
        this.PLZ = PLZ;
    }

    public String getPasswort() {
        return Passwort;
    }

    public void setPasswort(String passwort) {
        Passwort = passwort;
    }
}
