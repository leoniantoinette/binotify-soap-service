package binotify.helpers;

import java.sql.*;

public class DBConnector {
    private static Connection connection = null;
    private static DBConnector instance = null;
    private static String DBUrl = "jdbc:mysql://localhost:3306/spotify_soap";
    private static String username = "root";
    private static String password = "";

    private DBConnector() {
        try{
            System.out.println("Connecting to Database");
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(DBUrl, username, password);
            System.out.println("Database connected");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Error on connecting to Database");
        }
    }

    public static Connection getConnection() {
        if (DBConnector.instance == null) {
            DBConnector.instance = new DBConnector();
        }
        return DBConnector.connection;
    }
}
