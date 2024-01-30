import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transfer_money extends  JFrame implements ActionListener {






    private final String account_number;
    private final String pin_number;
    private final Connection connection;




    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;


    public Transfer_money(String account_number,String pin_number){
        this.account_number=account_number;
        this.pin_number=pin_number;

        Conn newconnection=new Conn();
        this.connection=newconnection.c;




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

        l1.setBounds(190,330,400,20);
        l4.add(l1);

        l2.setBounds(190,370,400,20);
        l4.add(l2);

        t1.setBounds(190,400,330,30);
        l4.add(t1);
        l3.setBounds(190 ,450,400,20);
        l4.add(l3);
        t2.setBounds(190,500,330,30);
        l4.add(t2);

        b1.setBounds(390,580,150,35);
        l4.add(b1);

        b2.setBounds(390,640,150,35);
        l4.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==b1)
        {


            String fetch_ammount=t1.getText();
            try {
                double actualAmount = Double.parseDouble(fetch_ammount);
                WithdrawlAmmountAndBalanceCheck ob=new WithdrawlAmmountAndBalanceCheck(account_number,pin_number,connection);

              if(ob.balancecheck(actualAmount))
              {
                  if(checkAccountNumber(t2.getText()))
                  {
                    String sendquery="update accountdetails set ammount=ammount-? where account_number=?";
                    String receivequery="update accountdetails set ammount=ammount+? where account_number=?";
                    try{
                        connection.setAutoCommit(false);

                        PreparedStatement sendpst=connection.prepareStatement(sendquery);
                        PreparedStatement receivepst=connection.prepareStatement(receivequery);

                        sendpst.setDouble(1,actualAmount);
                        sendpst.setString(2,account_number);
                        receivepst.setDouble(1,actualAmount);
                        receivepst.setString(2,t2.getText());
                        int sendrowaffected=sendpst.executeUpdate();
                        int receiverowafected=receivepst.executeUpdate();

                        if(sendrowaffected>0 && receiverowafected>0)
                        {
                            connection.commit();
                            connection.setAutoCommit(true);
                             JOptionPane.showMessageDialog(null,"Balance Transfer Successfully......");
                             connection.close();
                        }
                        else {
                            connection.rollback();
                            JOptionPane.showMessageDialog(null,"Error to Transfer Balance");
                            connection.setAutoCommit(true);
                            connection.close();
                        }

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                  }
                  else {
                      JOptionPane.showMessageDialog(null,"cannot find that account number");
                  }


              }
              else {
                  JOptionPane.showMessageDialog(null,"Insufficient ammoutn");
              }


            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid amount format");
            }

        } else if (a.getSource()==b2) {
            setVisible(false);

            new Transaction(account_number,pin_number);

        }
    }


    public boolean checkAccountNumber(String accountNumber){
        String query="select * from accountdetails where account_number=?";

        try{
            PreparedStatement pst=connection.prepareStatement(query);
            pst.setString(1,accountNumber);

            ResultSet result=pst.executeQuery();
            if (result.next()) {
                return true;

            }
            else{
                return false;
            }


        } catch (SQLException e) {
           return false;
        }
    }





}
