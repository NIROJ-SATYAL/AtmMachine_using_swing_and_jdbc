import com.sun.tools.javac.Main;

import java.sql.*;
import java.io.*;
import java.util.Properties;

public class    Conn {

    private  static String db_url;
    private  static String db_password;
    private  static String db_username;
    Connection c;


    static {
        loadDatabaseProperties();
    }

    private static void loadDatabaseProperties() {
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("env.properties")) {
            Properties properties = new Properties();
            if (input != null) {
                properties.load(input);
                db_url = properties.getProperty("db_url");
                db_username = properties.getProperty("db_username");
                db_password = properties.getProperty("db_password");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public Conn() {
        try {

//            step 1:register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver load successfully...");
//                    step2 :create connection
            c = DriverManager.getConnection(db_url,db_username,db_password);
            System.out.println("connection created successfully...");



        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}