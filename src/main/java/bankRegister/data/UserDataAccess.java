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


        try {
            Connection conn = this.getConnection();

            String sql = "SELECT kunde_id, Vorname, Nachname FROM kunden";

            Statement s = conn.createStatement();
            s.execute(sql);
            ResultSet r = s.getResultSet();

            while(r.next()){
               // userList.add( new UserModel(r.getInt("kunde_id"), r.getString("Vorname"), r.getString("Nachname")));
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }finally {
            this.closeConnection();
        }

    }

}
