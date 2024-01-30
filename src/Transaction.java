import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Transaction extends JFrame implements ActionListener {


    private  String  account_number;
    private   String user_pin;
    private Connection connection;


    JLabel l1;
    JButton DepositButton,CashWithdrawlButton,FastCashButton,TransferButton,PinChangeButton,BalanceEnqueryButton,ExitButton;





    public Transaction(String account_number,String pin)
    {
        this.account_number=account_number;
        this.user_pin=pin;

            Conn conn=new Conn();
            this.connection=conn.c;




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
        TransferButton = new JButton("Transfer Money");
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

        TransferButton.setBounds(390,543,150,35);
        l2.add(TransferButton);

        PinChangeButton.setBounds(170,588,150,35);
        l2.add(PinChangeButton);

        BalanceEnqueryButton.setBounds(390,588,150,35);
        l2.add(BalanceEnqueryButton);

        ExitButton.setBounds(390,633,150,35);
        l2.add(ExitButton);


        DepositButton.addActionListener(this);
        CashWithdrawlButton.addActionListener(this);
        FastCashButton.addActionListener(this);
        TransferButton.addActionListener(this);
        PinChangeButton.addActionListener(this);
        BalanceEnqueryButton.addActionListener(this);
        ExitButton.addActionListener(this);


        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);

    }






    @Override

    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==DepositButton){
            setVisible(false);
            new Deposit(account_number,user_pin).setVisible(true);
        }else if(a.getSource()==CashWithdrawlButton){
            setVisible(false);
            new Withdraw(account_number,user_pin).setVisible(true);
        }else if(a.getSource()==FastCashButton){
            setVisible(false);
            new FastCash(account_number,user_pin,connection).setVisible(true);
        }else if(a.getSource()==TransferButton){
            new Transfer_money(account_number,user_pin).setVisible(true);
        }else if(a.getSource()==PinChangeButton){
            setVisible(false);
            new PinChange(account_number,user_pin).setVisible(true);
        }else if(a.getSource()==BalanceEnqueryButton){
            this.setVisible(false);
            new BalanceInquery(account_number,user_pin);
        }else if(a.getSource()==ExitButton){
            System.exit(0);
        }
    }










}
