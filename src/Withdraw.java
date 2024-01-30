import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;



public class Withdraw  extends JFrame  implements ActionListener {



    private  String account_number;
    private String pin_number;
    private Connection connecction;



    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;


    public Withdraw(String account_number,String pin_number,Connection connection)
    {





        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 960, 1080);
        add(l4);

        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190,350,400,20);
        l4.add(l1);

        l2.setBounds(190,400,400,20);
        l4.add(l2);

        t1.setBounds(190,450,330,30);
        l4.add(t1);

        b1.setBounds(390,588,150,35);
        l4.add(b1);

        b2.setBounds(390,633,150,35);
        l4.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent a)
    {

        if(a.getSource()==b1)
        {
            System.out.println("withdrawl successfully..........");
        } else if (a.getSource()==b2) {
            new Transaction(account_number,pin_number);

        }

    }
}
