package bankRegister.data;




import bankRegister.model.UserModel;
import ext.BCrypt;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Peter on 14.06.2016.
 */
public class UserDataAccess extends DataAccess {

    public UserDataAccess() {
        super();

    }

    public void addUser(String Nachname,  String Vorname, String PLZ, String Ort, String Strasse, String Geburtsdatum, String Passwort){
        Integer Adresse_ID = 0;

        try {
            Connection conn = this.getConnection();

            this.beginTransaction();


            String adresse_sql = "INSERT INTO adresse (Straße, Ort, PLZ, Land) VALUES (?,?,?,?)";

            PreparedStatement adresse_s = conn.prepareStatement(adresse_sql);
            adresse_s.setString(1, Strasse);
            adresse_s.setString(2, Ort);
            adresse_s.setString(3, PLZ);
            adresse_s.setString(4, "DE");
            adresse_s.execute();

            String last_address_sql = "SELECT max(ID) AS ID FROM adresse";
            Statement last_address = conn.createStatement();
            last_address.execute(last_address_sql);
            ResultSet r = last_address.getResultSet();

            while(r.next()){
               Adresse_ID = r.getInt("ID");
            }



            String sql = "INSERT INTO kunden (Vorname, Nachname, Geburtsdatum, Passwort, Adresse_ID) VALUES (?,?,?,?, ?)";

            PreparedStatement s = conn.prepareStatement(sql);
            s.setString(1, Vorname);
            s.setString(2, Nachname);
            s.setString(3, Geburtsdatum);
            s.setString(4, Passwort);
            s.setInt(5, Adresse_ID);
            s.execute();

            this.commitTransaction();

        } catch (SQLException e) {
            this.rollBackTransaction();
            e.printStackTrace();

        }finally {
            this.closeConnection();
        }

    }

}
