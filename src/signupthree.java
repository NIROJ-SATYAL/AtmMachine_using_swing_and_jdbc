import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class signupthree extends JFrame implements ActionListener {

    private String  formnum;
    private Connection connection;



    JLabel accountDetailslabel, accounttypelabel, cardnumberlabel, anlabel, cardnumlabel, conditionlabel, pinlabel, pinnumberlabel, digitlabel, servicerequiredlabel, formnumlabel, formnumber;
    JRadioButton savingAccount, fixedDeposit, currentAccount, RecureDeposit;
    JButton submit, cancel;
    JCheckBox atm, internetBanking, mobileBanking, emailAlerts, chequeBook, eStatement,c7;



    public signupthree(String formnum , Connection conn)

    {

        this.formnum=formnum;
        this.connection=conn;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l14 = new JLabel(i3);
//        l14.setBounds(150, 0, 100, 100);
//        add(l14);

        accountDetailslabel = new JLabel("Page 3: Account Details");
        accountDetailslabel.setFont(new Font("Raleway", Font.BOLD, 22));

        accounttypelabel = new JLabel("Account Type:");
        accounttypelabel.setFont(new Font("Raleway", Font.BOLD, 18));

        cardnumberlabel = new JLabel("Card Number:");
        cardnumberlabel.setFont(new Font("Raleway", Font.BOLD, 18));

        anlabel = new JLabel("XXXX-XXXX-XXXX-4184");
        anlabel.setFont(new Font("Raleway", Font.BOLD, 18));

        cardnumlabel = new JLabel("(Your 16-digit Card number)");
        cardnumlabel.setFont(new Font("Raleway", Font.BOLD, 12));

        conditionlabel = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        conditionlabel.setFont(new Font("Raleway", Font.BOLD, 12));

        pinlabel = new JLabel("PIN:");
        pinlabel.setFont(new Font("Raleway", Font.BOLD, 18));

        pinnumberlabel = new JLabel("XXXX");
        pinnumberlabel.setFont(new Font("Raleway", Font.BOLD, 18));

        digitlabel = new JLabel("(4-digit password)");
        digitlabel.setFont(new Font("Raleway", Font.BOLD, 12));

        servicerequiredlabel = new JLabel("Services Required:");
        servicerequiredlabel.setFont(new Font("Raleway", Font.BOLD, 18));

        formnumlabel = new JLabel("Form No:");
        formnumlabel.setFont(new Font("Raleway", Font.BOLD, 14));

        formnumber = new JLabel(formnum);
        formnumber.setFont(new Font("Raleway", Font.BOLD, 14));

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);


        atm = new JCheckBox("ATM CARD");
        atm.setBackground(Color.WHITE);
        atm.setFont(new Font("Raleway", Font.BOLD, 16));

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Raleway", Font.BOLD, 16));

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Raleway", Font.BOLD, 16));

        emailAlerts = new JCheckBox("EMAIL Alerts");
        emailAlerts.setBackground(Color.WHITE);
        emailAlerts.setFont(new Font("Raleway", Font.BOLD, 16));

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Raleway", Font.BOLD, 16));

        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(Color.WHITE);
        eStatement.setFont(new Font("Raleway", Font.BOLD, 16));

        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));


        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        savingAccount.setBackground(Color.WHITE);

        fixedDeposit = new JRadioButton("Fixed Deposit Account");
        fixedDeposit.setFont(new Font("Raleway", Font.BOLD, 16));
        fixedDeposit.setBackground(Color.WHITE);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        currentAccount.setBackground(Color.WHITE);

        RecureDeposit = new JRadioButton("Recurring Deposit Account");
        RecureDeposit.setFont(new Font("Raleway", Font.BOLD, 16));
        RecureDeposit.setBackground(Color.WHITE);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(savingAccount);
        groupgender.add(fixedDeposit);
        groupgender.add(currentAccount);
        groupgender.add(RecureDeposit);

        setLayout(null);

        formnumlabel.setBounds(700,10,70,30);
        add(formnumlabel);

        formnumber.setBounds(770,10,40,30);
        add(formnumber);

        accountDetailslabel.setBounds(280,40,400,40);
        add(accountDetailslabel);

        accounttypelabel.setBounds(100,100,200,30);
        add(accounttypelabel);

        savingAccount.setBounds(100,140,150,30);
        add(savingAccount);

        fixedDeposit.setBounds(350,140,300,30);
        add(fixedDeposit);

        currentAccount.setBounds(100,180,250,30);
        add(currentAccount);

        RecureDeposit.setBounds(350,180,250,30);
        add(RecureDeposit);

        cardnumberlabel.setBounds(100,220,200,30);
        add(cardnumberlabel);

        anlabel.setBounds(330,220,250,30);
        add(anlabel);

        cardnumlabel.setBounds(100,270,200,20);
        add(cardnumlabel);

        conditionlabel.setBounds(330,270,500,20);
        add(conditionlabel);

        pinlabel.setBounds(100,310,200,30);
        add(pinlabel);

        pinnumberlabel.setBounds(330,310,200,30);
        add(pinnumberlabel);

        digitlabel.setBounds(100,330,200,20);
        add(digitlabel);

        servicerequiredlabel.setBounds(100,370,200,30);
        add(servicerequiredlabel);

        atm.setBounds(100,410,200,30);
        add(atm);

        internetBanking.setBounds(350,410,200,30);
        add(internetBanking);

        mobileBanking.setBounds(100,460,200,30);
        add(mobileBanking);

        emailAlerts.setBounds(350,460,200,30);
        add(emailAlerts);

        chequeBook.setBounds(100,500,200,30);
        add(chequeBook);

        eStatement.setBounds(350,500,200,30);
        add(eStatement);

        c7.setBounds(100,560,560,20);
        add(c7);

        submit.setBounds(250,610,100,30);
        add(submit);
        submit.addActionListener(this);

        cancel.setBounds(420,610,100,30);
        add(cancel);
        cancel.addActionListener(this);


        getContentPane().setBackground(Color.WHITE);

        setSize(950,950);
        setLocation(100,30);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        b1.addActionListener((ActionListener) this);
//        b2.addActionListener(this);

    }



    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource()==submit)
        {

            String accounttype="";
            if(savingAccount.isSelected())
            {
                accounttype="Saving Account";
            } else if (currentAccount.isSelected()) {
                accounttype="Current Account";

            } else if (fixedDeposit.isSelected()) {
                accounttype="Fixed Deopsit";

            } else if (RecureDeposit.isSelected()) {
                accounttype="Recure deposit";
            }



            String bank_service="";

            if(internetBanking.isSelected())
            {
                bank_service=bank_service + "Internet_Banking";
            } else if (emailAlerts.isSelected()) {
                bank_service=bank_service + " Email_Alerts";

            } else if (eStatement.isSelected()) {
                bank_service=bank_service + " E_Statement";

            } else if (chequeBook.isSelected()) {
                bank_service=bank_service + " Cheque_Book";

            } else if (mobileBanking.isSelected()) {
                bank_service=bank_service + " Mobile_Banking";

            }


            Random ran = new Random();
            long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
            String cardno = "" + Math.abs(first7);

            long first3 = (ran.nextLong() % 9000L) + 1000L;
            String pin = "" + Math.abs(first3);


            try{

                if(accounttype.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"accoutn type is required");
                } else if (bank_service.equals("")) {
                    JOptionPane.showMessageDialog(null,"please  add any services");

                } else if (cardno.equals("")) {
                    JOptionPane.showMessageDialog(null,"please wait account number is not ready");

                } else if (pin.equals("")) {
                    JOptionPane.showMessageDialog(null,"please wait pin number is not ready");

                }
                else {
                    String query="insert into accountdetails(account_number ,pin_number,user_Id,account_type,services) values(?,?,?,?,?)";

                    PreparedStatement pst= connection.prepareStatement(query);

                    pst.setString(1,cardno);
                    pst.setString(2,pin);
                    pst.setString(3,formnum);
                    pst.setString(4,accounttype);
                    pst.setString(5,bank_service);
                    int rowAffeced=pst.executeUpdate();
                    if(rowAffeced>0)
                    {
                        String loginquery="insert into signup(user_formnum,card_num,pin_num) values (?,?,?)";
                        try{
                            PreparedStatement loginpst=connection.prepareStatement(loginquery);
                            loginpst.setString(1,formnum);
                            loginpst.setString(2,cardno);
                            loginpst.setString(3,pin);
                            int rowaf=loginpst.executeUpdate();
                            if(rowaf>0)
                            {
                                    new SendMail(formnum,cardno,pin,connection);
                                    new Deposit(cardno,pin,connection);
                                    setVisible(false);
                            }
                            else {
                                JOptionPane.showMessageDialog(null,"something wrong.....");
                            }
                        }
                        catch (SQLException SE)
                        {
                            System.out.println(SE.getMessage());
                        }
                    }

                }


            }
            catch(SQLException se)
            {
                System.out.println(se.getMessage());
            }

        } else if (ae.getSource()==cancel) {


        }

    }




    public static void main(String[] args) {
//        new signupthree("1234");
    }
}
