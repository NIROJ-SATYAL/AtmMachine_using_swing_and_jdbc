import java.sql.*;

public class    Conn {
     Connection c;


    public Conn() {
        try {

//            step 1:register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver load successfully...");
//                    step2 :create connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/AtmMachine","root","jorin!@#1");
            System.out.println("connection created successfully...");



        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}