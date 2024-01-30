import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Transfer_money extends  JFrame implements ActionListener {






    private String account_number;
    private String pin_number;
    private Connection connection;




    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;


    public Transfer_money(String account_number,String pin_number){
        this.account_number=account_number;
        this.pin_number=pin_number;




        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 960, 1080);
        add(l4);

        l1 = new JLabel("MAXIMUM Transfer  IS RS.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));



        l3 = new JLabel("PLEASE ENTER Receiver Account  Number");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System", Font.BOLD, 16));

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));

        b1 = new JButton("Transfer");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190,350,400,20);
        l4.add(l1);

        l2.setBounds(190,400,400,20);
        l4.add(l2);

        t1.setBounds(190,450,330,30);
        l4.add(t1);
        l3.setBounds(190 ,500,400,20);
        l4.add(l3);
        t2.setBounds(190,550,400,30);

        b1.setBounds(390,630,150,35);
        l4.add(b1);

        b2.setBounds(390,688,150,35);
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


        }
    }
}
