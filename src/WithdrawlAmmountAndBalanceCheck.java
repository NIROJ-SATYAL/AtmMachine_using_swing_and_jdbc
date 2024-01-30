import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WithdrawlAmmountAndBalanceCheck {


    private String account_number;
    private String pin_number;
    private Connection connection;


    public WithdrawlAmmountAndBalanceCheck(String account_number , String pin_number ,Connection connection)
    {
        this.account_number=account_number;
        this.connection=connection;
        this.pin_number=pin_number;
    }
    public  void withDraw(double ammount) {
        if (balancecheck(ammount)) {
//           Transaction here


            try {
                String query = "update accountdetails set ammount=ammount-? where account_number=? and pin_number=?";

                connection.setAutoCommit(false);
                PreparedStatement pst = connection.prepareStatement(query);
                pst.setDouble(1, ammount);
                pst.setString(2, account_number);
                pst.setString(3, pin_number);
                int rowAffected = pst.executeUpdate();
                if (rowAffected > 0) {
                    connection.commit();
                    connection.setAutoCommit(true);
                    JOptionPane.showMessageDialog(null, "collect your ammount");

                } else {
                    JOptionPane.showMessageDialog(null, "something went wrong .please try again");
                    connection.rollback();
                    new Transaction(account_number, pin_number);
                }


            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient ammount...");

        }
    }


    public   boolean balancecheck(double ammount) {
        String query = "select ammount from accountdetails where account_number=? and pin_number=?";
        Conn conn=new Conn();
        connection=conn.c;
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, account_number);
            pst.setString(2, pin_number);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                double fetch_ammount=result.getDouble("ammount");
                System.out.println(fetch_ammount);
                if (ammount < result.getDouble("ammount")) {
                    return true;

                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (SQLException e) {
            return false;
        }


    }


}
