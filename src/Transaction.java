import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class Transaction extends JFrame  {


    private  String  account_number;
    private   String user_pin;
    private Connection connection;





    public Transaction(String account_number,String pin)
    {
        this.account_number=account_number;
        this.user_pin=pin;

            Conn conn=new Conn();
            this.connection=conn.c;
        JLabel l1;
        JButton DepositButton,CashWithdrawlButton,FastCashButton,MiniStatementButoon,PinChangeButton,BalanceEnqueryButton,ExitButton;



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);

        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));


        DepositButton = new JButton("DEPOSIT");
        CashWithdrawlButton = new JButton("CASH WITHDRAWL");
        FastCashButton = new JButton("FAST CASH");
        MiniStatementButoon = new JButton("Transfer Money");
        PinChangeButton = new JButton("PIN CHANGE");
        BalanceEnqueryButton = new JButton("BALANCE ENQUIRY");
        ExitButton = new JButton("EXIT");

        setLayout(null);

        l1.setBounds(235,400,700,35);
        l2.add(l1);

        DepositButton.setBounds(170,499,150,35);
        l2.add(DepositButton);

        CashWithdrawlButton.setBounds(390,499,150,35);
        l2.add(CashWithdrawlButton);

        FastCashButton.setBounds(170,543,150,35);
        l2.add(FastCashButton);

        MiniStatementButoon.setBounds(390,543,150,35);
        l2.add(MiniStatementButoon);

        PinChangeButton.setBounds(170,588,150,35);
        l2.add(PinChangeButton);

        BalanceEnqueryButton.setBounds(390,588,150,35);
        l2.add(BalanceEnqueryButton);

        ExitButton.setBounds(390,633,150,35);
        l2.add(ExitButton);


//        DepositButton.addActionListener(this);
//        CashWithdrawlButton.addActionListener(this);
//        FastCashButton.addActionListener(this);
//        MiniStatementButoon.addActionListener(this);
//        PinChangeButton.addActionListener(this);
//        BalanceEnqueryButton.addActionListener(this);
//        ExitButton.addActionListener(this);


        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);

    }










}
