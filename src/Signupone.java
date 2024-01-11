import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Signupone extends JFrame {

    JTextField username , useremail, userphone,userAddress ;




    public  Signupone(){


        Random ran =new Random();
        long rand=Math.abs((ran.nextLong() % 9000l) + 10000l);
        setSize(850,800);
        setLayout(null);
        setTitle("Sign up form");
        setVisible(true);
        //to set the location of frame we use setLocation function
        setLocation(350,30);
//        to change the background color of frame
        getContentPane().setBackground(Color.white);




//main title
        JLabel titles=new JLabel("APPLICATION NO 2 " + rand );
        titles.setBounds(140,40,600 ,50);
        titles.setFont(new Font("osward",Font.BOLD,38) );
        titles.setForeground(Color.black);
        add(titles);


        //first page
        JLabel firstpage=new JLabel("PAGE NO 1:Personal details ");
        firstpage.setBounds(250,100,400 ,50);
        firstpage.setFont(new Font("osward",Font.BOLD,24) );
        firstpage.setForeground(Color.black);
        add(firstpage);


        //user name
        JLabel namelabel=new JLabel("Name:");
        namelabel.setBounds(100,150,100 ,40);
        namelabel.setFont(new Font("osward",Font.BOLD,20) );
        namelabel.setForeground(Color.black);
        add(namelabel);



        //        textfield for name
        username=new JTextField(20);
        useremail.setBounds(220,150,350 ,40);
        add(username);


//        label for email
        JLabel emaillabel=new JLabel("Email:");
        emaillabel.setBounds(100,200,100 ,40);
        emaillabel.setFont(new Font("osward",Font.BOLD,20) );
        emaillabel.setForeground(Color.black);
        add(emaillabel);



//        textfield for email
       useremail=new JTextField(20);
        useremail.setBounds(220,150,350 ,40);
        add(useremail);





        //        label for phonenumber
        JLabel phonelabel=new JLabel("Phone:");
        phonelabel.setBounds(100,250,100 ,40);
        phonelabel.setFont(new Font("osward",Font.BOLD,20) );
        phonelabel.setForeground(Color.black);
        add(phonelabel);


    }


    public static void main(String[] args) {
            new Signupone();
    }
}
