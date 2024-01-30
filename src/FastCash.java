import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class FastCash  extends JFrame implements ActionListener {


    private static String account_number;
    private  static String pin_number;
    private static Connection connection;


    public FastCash(String account_number, String pin_number, Connection connection) {
        this.account_number = account_number;
        this.pin_number = pin_number;
        this.connection = connection;

        JLabel l1, l2;
        JButton b1, b2, b3, b4, b5, b6, b7, b8;
        JTextField t1;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(235, 400, 700, 35);
        l3.add(l1);

        b1.setBounds(170, 499, 150, 35);
        l3.add(b1);

        b2.setBounds(390, 499, 150, 35);
        l3.add(b2);

        b3.setBounds(170, 543, 150, 35);
        l3.add(b3);

        b4.setBounds(390, 543, 150, 35);
        l3.add(b4);

        b5.setBounds(170, 588, 150, 35);
        l3.add(b5);

        b6.setBounds(390, 588, 150, 35);
        l3.add(b6);

        b7.setBounds(390, 633, 150, 35);
        l3.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent a) {

        String amount = ((JButton)a.getSource()).getText().substring(3);
        double actual_amount = Double.parseDouble(amount);
        withDraw(actual_amount);


    }


    public static void withDraw(double ammount) {
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


    public  static boolean balancecheck(double ammount) {
        String query = "select amount from accountdetails where account_number=? and pin_num=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, account_number);
            pst.setString(2, pin_number);
            ResultSet result = pst.executeQuery();
            if (result.next()) {

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

