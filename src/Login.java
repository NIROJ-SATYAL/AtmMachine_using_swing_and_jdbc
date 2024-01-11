import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
//constructor of Login class .it will call whenever a object of login class is created....
    public Login(){
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
        JTextField cardfield = new JTextField(20);
        cardfield.setBounds(240,180,200 ,30);
        add(cardfield);

        JLabel pin_num=new JLabel("pin num:");
        pin_num.setBounds(120,220,100 ,30);
        pin_num.setFont(new Font("osward",Font.BOLD,16) );
        pin_num.setForeground(Color.BLUE);
        add(pin_num);

        //        text field for pin_num
        JTextField pinfield = new JTextField(20);
        pinfield.setBounds(240,220,200 ,30);
        add(pinfield);


//        button for singup

        JButton sign_button=new JButton("SIGN IN");
        sign_button.setBounds(200,300,100,30);
        sign_button.setBackground(Color.black);
        sign_button.setForeground(Color.WHITE);
        add(sign_button);


        //        button for clear

        JButton clear_button=new JButton("clear");
        clear_button.setBounds(450,300,100,30);
        clear_button.setBackground(Color.black);
        clear_button.setForeground(Color.WHITE);
        add(clear_button);



        //        button for sign up

        JButton SIGNUP_button=new JButton("SIGN UP");
        SIGNUP_button.setBounds(300,450,500,30);
        SIGNUP_button.setBackground(Color.black);
        SIGNUP_button.setForeground(Color.WHITE);
        add(SIGNUP_button);





//        initially frame is  hidden so..
        setVisible(true);
//to set the location of frame we use setLocation function
        setLocation(350,200);
//        to change the background color of frame
        getContentPane().setBackground(Color.white);
    }

    public static void main(String[] args) {
        new Login();

    }
}
