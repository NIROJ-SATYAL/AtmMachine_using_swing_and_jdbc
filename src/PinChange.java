import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PinChange extends JFrame implements  ActionListener {

    private String account_number;
    private String pin_number;
    private Connection connection;

    JPasswordField t1,t2;
    JButton b1,b2;
    JLabel l1,l2,l3;




    public PinChange( String account_number,String Pin_number)
    {

        Conn newconnection=new Conn();
        this.connection=newconnection.c;
        this.account_number=account_number;
        this.pin_number=pin_number;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 960, 1080);
        add(l4);

        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);

        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);

        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);

        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));

        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);

        l1.setBounds(280,330,800,35);
        l4.add(l1);

        l2.setBounds(180,390,150,35);
        l4.add(l2);

        l3.setBounds(180,440,200,35);
        l4.add(l3);

        t1.setBounds(350,390,180,25);
        l4.add(t1);

        t2.setBounds(350,440,180,25);
        l4.add(t2);

        b1.setBounds(390,588,150,35);
        l4.add(b1);

        b2.setBounds(390,633,150,35);
        l4.add(b2);

        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }



    @Override

    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==b1)
        {
            String npin = t1.getText();
            String rpin = t2.getText();

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            try{

                String query1="update accountdetails set pin_number=?  where account_number=?";
                String query2="update signup set pin_num=? where card_num=?";
                PreparedStatement pst1=connection.prepareStatement(query1);
                PreparedStatement pst2=connection.prepareStatement(query2);
                pst1.setString(1,npin);
                pst1.setString(2,account_number);
                pst2.setString(1,npin);
                pst2.setString(2,account_number);
                int rowAffected1=pst1.executeUpdate();
                int rowAffected2=pst2.executeUpdate();
                if(rowAffected1>0 && rowAffected2>0)
                {
                    JOptionPane.showMessageDialog(null,"pin change successfully...");
                    connection.close();
                }
                else {
                    JOptionPane.showMessageDialog(null,"failed to change pin..");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        } else if (a.getSource()==b2) {
            setVisible(false);
            new Login();

        }
    }





}
