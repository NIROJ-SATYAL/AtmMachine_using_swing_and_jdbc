import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceInquery {




    private String account_number;
    private String pin_number;
    private Connection connection;


    public BalanceInquery(String account_number,String pin_number)
    {
        this.account_number=account_number;
        this.pin_number=pin_number;

        Conn conn=new Conn();
        this.connection=conn.c;


        try{
            String query="select ammount from accountdetails where account_number=? and pin_number=?";

            PreparedStatement pst=connection.prepareStatement(query);

            pst.setString(1,account_number);
            pst.setString(2,pin_number);
            ResultSet result=pst.executeQuery();

            if(result.next())
            {
                double ammount=result.getDouble("ammount");
                JOptionPane.showMessageDialog(null,"your actual balance is:" + ammount);
            }



        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"cannot show ammount");
        }
    }
}
