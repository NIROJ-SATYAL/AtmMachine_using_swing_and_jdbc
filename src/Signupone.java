import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
public class Signupone extends JFrame implements  ActionListener {


    long rand;


    JTextField nameTextField,emailTextField,phoneTextField,addressTextField,cityTextField,stateTextField;
    JDateChooser dateChooser;
    JRadioButton male ,female,others;
    JButton clear,next;

    public  Signupone(){


        Random ran =new Random();
         rand=Math.abs((ran.nextLong() % 9000l) + 10000l);
        setSize(850,800);
        setLayout(null);
        setTitle("Sign up form");

        //to set the location of frame we use setLocation function
        setLocation(350,30);
//        to change the background color of frame
        getContentPane().setBackground(Color.white);




//main title
        JLabel titles=new JLabel("APPLICATION NO  " + rand );
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

         nameTextField = new JTextField(20);
        nameTextField.setBounds(300, 150, 350, 30);
        add(nameTextField);




//        label for email
        JLabel emaillabel=new JLabel("Email:");
        emaillabel.setBounds(100,200,100 ,40);
        emaillabel.setFont(new Font("osward",Font.BOLD,20) );
        emaillabel.setForeground(Color.black);
        add(emaillabel);

        emailTextField = new JTextField(20);
        emailTextField.setBounds(300, 200, 350, 30);
        add(emailTextField);


        //        label for phonenumber
        JLabel phonelabel=new JLabel("Phone:");
        phonelabel.setBounds(100,250,100 ,40);
        phonelabel.setFont(new Font("osward",Font.BOLD,20) );
        phonelabel.setForeground(Color.black);
        add(phonelabel);


       phoneTextField = new JTextField(20);
        phoneTextField.setBounds(300, 250, 350, 30);
        add(phoneTextField);
//Label for date of birth
        JLabel dateofbirth=new JLabel("DOB:");
        dateofbirth.setBounds(100,300,100 ,40);
        dateofbirth.setFont(new Font("osward",Font.BOLD,20) );
        dateofbirth.setForeground(Color.black);
        add(dateofbirth);


         dateChooser=new JDateChooser();
        dateChooser.setBounds(300,300 ,350,30);
        add(dateChooser);
//label for gender

        JLabel gender=new JLabel("GENDER:");
        gender.setBounds(100,350,100 ,40);
        gender.setFont(new Font("osward",Font.BOLD,20) );
        gender.setForeground(Color.black);
        add(gender);



        male=new JRadioButton("Male");
        male.setBounds(300 , 350, 80 ,40);
        male.setBackground(Color.white);
        add(male);

         female=new JRadioButton("Female");
        female.setBounds(400 , 350, 80 ,40);
        female.setBackground(Color.white);
        add(female);


        others=new JRadioButton("OTHERS");
        others.setBounds(500 , 350, 80 ,40);
        others.setBackground(Color.white);
        add(others);


        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);


//        label for address


        JLabel address=new JLabel("ADDRESS:");
        address.setBounds(100,400,100 ,40);
        address.setFont(new Font("osward",Font.BOLD,20) );
        address.setForeground(Color.black);
        add(address);

        addressTextField = new JTextField(20);
        addressTextField.setBounds(300, 400, 350, 30);
        add(addressTextField);
//label for city

        JLabel city=new JLabel("CITY:");
        city.setBounds(100,450,100 ,40);
        city.setFont(new Font("osward",Font.BOLD,20) );
        city.setForeground(Color.black);
        add(city);


        cityTextField = new JTextField(20);
        cityTextField.setBounds(300, 450, 350, 30);
        add(cityTextField);




//        label for state


        JLabel state=new JLabel("STATE:");
        state.setBounds(100,500,100 ,40);
        state.setFont(new Font("osward",Font.BOLD,20) );
        state.setForeground(Color.black);
        add(state);

         stateTextField = new JTextField(20);
        stateTextField.setBounds(300, 500, 350, 30);
        add(stateTextField);


         clear=new JButton("Clear");
        clear.setBounds(150 ,600,100,40);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

         next=new JButton("Next");
        next.setBounds(600 ,600,100,40);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);









        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next)
        {
            System.out.println("sign_up successfully");
        }
        else if (e.getSource()==clear) {

            System.out.println("clear all data");
        }


    }


    public static void main(String[] args) {
            new Signupone();
    }

}
