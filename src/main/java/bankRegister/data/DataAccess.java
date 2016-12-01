package bankRegister.data;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public abstract class DataAccess {

    private Properties config;
    protected Connection conn;

    public DataAccess() {

        File file = new File("src/main/java/bankRegister/db_conf.txt");
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            config = new Properties();
            config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getConfigProperties(){
        return this.config;
    }

    public Connection getConnection(){

        String sql_name     = this.config.get("SQL_NAME").toString();
        String sql_db       = this.config.get("SQL_DB").toString();
        String sql_pw       = this.config.get("SQL_PW").toString();
        String sql_address  = this.config.get("SQL_ADDRESS").toString();
        String sql_port  = this.config.get("SQL_PORT").toString();

        String url = "jdbc:mysql://"+sql_address+":"+ sql_port +"/"+ sql_db;

        Properties props = new Properties();
        props.put("user", sql_name);
        props.put("password", sql_pw);


        if(this.conn != null){
            return this.conn;
        }

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //Verbindung mit der Datenbank

            this.conn = DriverManager.getConnection(url, props);



        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(){
        try {
            this.conn.close();
            this.conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void beginTransaction(){

        Connection conn = this.getConnection();

        try {
            conn.setAutoCommit(false);

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void endTransaction(){

        Connection conn = this.getConnection();

        try {
            conn.setAutoCommit(true);
            if(this.conn != null){
                this.closeConnection();
            }


        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void commitTransaction(){
        Connection conn = this.getConnection();

        try {
            conn.commit();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    public void rollBackTransaction(){
        Connection conn = this.getConnection();

        try {
            conn.rollback();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

}
