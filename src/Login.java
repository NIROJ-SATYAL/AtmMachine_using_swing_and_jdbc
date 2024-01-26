import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame  implements ActionListener {
    Connection connection;
    JButton signin ,clear, signup;

    JTextField cardfield;
    JPasswordField pinfield;
//constructor of Login class .it will call whenever a object of login class is created....
    public Login(){

        Conn conn=new Conn();
        this.connection=conn.c;

//       To Set The Title of frame
        setTitle("Bank Management System");
//        to use custom layout
        setLayout(null);
//        setsize set the height and width of frame
        setSize(800,480);
//        to add the image we use imageicon class .

        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
//        to set the height and width of image
        Image i2= image1.getImage().getScaledInstance(100,100 , Image.SCALE_DEFAULT);
//        IMAGE cannot be add on label to again convert into image icon
        ImageIcon image2=new ImageIcon(i2);
        JLabel label=new JLabel(image2);
//        set the location of image icon
        label.setBounds(70,20,100,100);

        add(label);

        JLabel title=new JLabel("welome to ATM Machine");
        title.setBounds(200,40,500 ,40);
        title.setFont(new Font("osward",Font.BOLD,38) );
        title.setForeground(Color.BLUE);
        add(title);


        JLabel card_num=new JLabel("Card num:");
        card_num.setBounds(120,180,100 ,30);
        card_num.setFont(new Font("osward",Font.BOLD,16) );
        card_num.setForeground(Color.BLUE);
        add(card_num);


        //        text field for card_num
         cardfield = new JTextField(20);
        cardfield.setBounds(240,180,200 ,30);
        add(cardfield);

        JLabel pin_num=new JLabel("pin num:");
        pin_num.setBounds(120,220,100 ,30);
        pin_num.setFont(new Font("osward",Font.BOLD,16) );
        pin_num.setForeground(Color.BLUE);
        add(pin_num);

        //        text field for pin_num
       pinfield = new JPasswordField(20);
        pinfield.setBounds(240,220,200 ,30);
        add(pinfield);


//        button for singup

         signin=new JButton("SIGN IN");
        signin.setBounds(200,300,100,30);
        signin.setBackground(Color.black);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);


        //        button for clear

         clear=new JButton("clear");
        clear.setBounds(350,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);

        add(clear);



        //        button for sign up

         signup=new JButton("SIGN UP");
        signup.setBounds(200,350,250,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);







//        initially frame is  hidden so..
        setVisible(true);
//to set the location of frame we use setLocation function
        setLocation(350,200);
//        to change the background color of frame
        getContentPane().setBackground(Color.white);



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==signin){
            String  card_num=cardfield.getText();
            String pin_num=pinfield.getText();
            System.out.println(card_num);
            System.out.println(pin_num);
            String query="select * from signup where card_num=? and pin_num=?";
            try{
                PreparedStatement pst=connection.prepareStatement(query);
                pst.setString(1,card_num);
                pst.setString(2,pin_num);
                ResultSet result=pst.executeQuery();
                if(result.next())
                {
                    System.out.println("login successfully.....");
//                    create a object of transaction
                }
                else {
                    JOptionPane.showMessageDialog(null,"account doesn't exist..sign Up first");
                }

            }
            catch(SQLException ae)
            {
                JOptionPane.showMessageDialog(null , ae.getMessage());
            }


        } else if (e.getSource()==clear) {
            cardfield.setText("");
            pinfield.setText("");
        } else if (e.getSource()==signup) {
            System.out.println("signup button clicked.....");
            setVisible(false);
            new Signupone();
        }


    }

    public static void main(String[] args) {
        new Login();

    }


}
