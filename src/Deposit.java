import javax.swing.*;
import java.awt.*;

public class Deposit  extends JFrame {

    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin;

   public Deposit(String pin){
        this.pin = pin;
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

//        b1.addActionListener(this);
//        b2.addActionListener(this);

        setSize(960,960);
        setUndecorated(true);
        setLocation(0,20);
        setVisible(true);
    }


    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
