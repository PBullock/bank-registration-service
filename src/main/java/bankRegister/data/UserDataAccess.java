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

    public ArrayList<UserModel> getUsers(){

        ArrayList<UserModel> userList = new ArrayList<UserModel>();
        try {
            Connection conn = this.getConnection();

            String sql = "SELECT kunde_id, Vorname, Nachname FROM kunden";

            Statement s = conn.createStatement();
            s.execute(sql);
            ResultSet r = s.getResultSet();

            while(r.next()){
                userList.add( new UserModel(r.getInt("kunde_id"), r.getString("Vorname"), r.getString("Nachname")));
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }finally {
            this.closeConnection();
        }

        return userList;
    }

    /*public UserModel getUser(int id){
        UserModel user = null;
        try {
            Connection conn = this.getConnection();

            String sql = "SELECT id, name, email, is_sys_admin FROM user WHERE id = " + id;

            Statement s = conn.createStatement();
            s.execute(sql);
            ResultSet r = s.getResultSet();

            while(r.next()){
                 user = new UserModel(r.getInt("id"), r.getString("name"), r.getString("email");
            }
        } catch (SQLException e) {

            e.printStackTrace();

        }finally {
            this.closeConnection();
        }

        return user;
    }

    public Boolean createUser(String name, String email, String password){
        try {
            Connection conn = this.getConnection();
            *//** TODO : correct insert sql to return user*//*
            String sql = "INSERT INTO USER (name, email, password) VALUES (?, ?, ?);";

            PreparedStatement s = conn.prepareStatement(sql);
            s.setString(1, name);
            s.setString(2, email);
            String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
            s.setString(3, hashed);
            s.execute();

        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        }finally {
            this.closeConnection();
        }
        return true;

    }

    public void deleteUser(int user_id){

        UserModel user = null;

        try {
            Connection conn = this.getConnection();
            String sql = "DELETE FROM user WHERE id = "+ user_id;

            Statement s = conn.createStatement();

            s.execute(sql);
            
        } catch (SQLException e) {

            e.printStackTrace();

        }finally {
            this.closeConnection();
        }



    }

    public ArrayList<UserModel> getUsersByGroup(int group_id){

        ArrayList<UserModel> userList = new ArrayList<UserModel>();
        try {
            Connection conn = this.getConnection();

            String sql = "SELECT u.id, u.name, u.email, u.is_sys_admin " +
                    "FROM user AS u " +
                    "LEFT JOIN user_projectgroup AS upg ON upg.user_id = u.id " +
                    "LEFT JOIN projectgroup AS pg ON pg.id = upg.projectgroup_id" +
                    " WHERE pg.id = "+group_id;

            Statement s = conn.createStatement();
            s.execute(sql);
            ResultSet r = s.getResultSet();

            while(r.next()){
                userList.add( new UserModel(r.getInt("id"), r.getString("name"), r.getString("email")));
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }finally {
            this.closeConnection();
        }

        return userList;
    }*/

}
