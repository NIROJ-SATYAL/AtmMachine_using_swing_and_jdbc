import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deposit  extends JFrame  implements ActionListener {

    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin;
    String account_number;
    Connection connection;

   public Deposit(String account_number, String pin,Connection connection){
        this.pin = pin;
        this.account_number=account_number;
        this.connection=connection;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190,350,400,35);
        l3.add(l1);

        t1.setBounds(190,420,320,25);
        l3.add(t1);

        b1.setBounds(390,588,150,35);
        l3.add(b1);

        b2.setBounds(390,633,150,35);
        l3.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(960,960);
        setUndecorated(true);
        setLocation(0,20);
        setVisible(true);
    }







    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b1)
       {


           if(t1.getText().equals(""))
           {
               JOptionPane.showMessageDialog(null,"enter ammount");
           }
           else {
               double doubleValue = Double.parseDouble(t1.getText());
               try{

                   String query="update  accountdetails  set ammount=ammount + ? where account_number=? and pin_number=?";
                   connection.setAutoCommit(false);

                   PreparedStatement pst=connection.prepareStatement(query);
                   pst.setDouble(1,doubleValue);
                   pst.setString(2,account_number);
                   pst.setString(3,pin);

                   int rowAffected=pst.executeUpdate();
                   if(rowAffected>0)
                   {
                       connection.commit();
                       connection.setAutoCommit(true);
                       setVisible(false);
                       new Login();
                   }
                   else {
                       connection.rollback();
                       connection.setAutoCommit(true);
                   }
               } catch (SQLException ex) {
                   throw new RuntimeException(ex);
               }
           }




       } else if (e.getSource()==b2) {
           new Login();
           setVisible(false);

       }


    }
}
