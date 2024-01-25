import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
public class Signupone extends JFrame  implements   ActionListener {


    long rand;
    private Connection connection;


    JTextField nameTextField,emailTextField,phoneTextField,addressTextField,cityTextField,stateTextField;
    JDateChooser dateChooser;
    JRadioButton male ,female,others;
    JButton clear,next;
    ButtonGroup gendergroup;

    public  Signupone(){

        Conn conn=new Conn();
        this.connection=conn.c;


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


         gendergroup=new ButtonGroup();
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next)
        {
//            Extract the value from textfield
            String prinum="" + rand;
            String userName=nameTextField.getText();
            String userEmial=emailTextField.getText();
            String userPhone=phoneTextField.getText();
            String userAddress=addressTextField.getText();
            String userCity=cityTextField.getText();
            String userState=stateTextField.getText();
            String userDob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String userGender = "";
            if (male.isSelected()) {
                userGender = "Male";
            } else if (female.isSelected()) {
                userGender = "Female";
            } else if (others.isSelected()) {
                userGender = "Others";
            }
//validation

            try {
//

                if(userName.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "name s required");
                } else if (userEmial.equals("")) {
                    JOptionPane.showMessageDialog(null,"Email is required");
                } else if (userPhone.equals("")) {
                    JOptionPane.showMessageDialog(null,"Phone number is required");

                } else if (userGender.equals("")) {
                    JOptionPane.showMessageDialog(null,"Gender is required");

                } else if (userDob.equals("")) {
                    JOptionPane.showMessageDialog(null,"Date of Birth is required");

                } else if (userAddress.equals("")) {
                    JOptionPane.showMessageDialog(null,"Address is required");

                } else if (userCity.equals("")) {

                    JOptionPane.showMessageDialog(null,"city is required");

                } else if (userState.equals("")) {
                    JOptionPane.showMessageDialog(null,"State is required");
                }
                else {


                    String query="Insert into personaldetails(user_name,user_email,user_phone,user_dob,user_gender,user_address,user_city,user_state,user_formnum) values(?,?,?,?,?,?,?,?,?)";



                    PreparedStatement pst=connection.prepareStatement(query);
                    pst.setString(1,userName);
                    pst.setString(2,userEmial);
                    pst.setString(3,userPhone);
                    pst.setString(4,userDob);
                    pst.setString(5,userGender);
                    pst.setString(6,userAddress);
                    pst.setString(7,userCity);
                    pst.setString(8,userState);
                    pst.setString(9,prinum );
                    int rowAffected=pst.executeUpdate();
                    if(rowAffected>0)
                    {
                        System.out.println("data inserted successfully");
                        setVisible(false);
                        new Signuptwo(rand);

                    }
                    else
                    {
                        System.out.println("failed to signup");

                    }
                }

            }
            catch (Exception se)
            {
                JOptionPane.showMessageDialog(null,se.getMessage());
            }

        }
        else if (e.getSource()==clear) {

            nameTextField.setText("");
            emailTextField.setText("");
            phoneTextField.setText("");
            addressTextField.setText("");
            cityTextField.setText("");
            stateTextField.setText("");
            dateChooser.setDate(null);

            // Deselect radio buttons
            gendergroup.clearSelection();



        }


    }


    public static void main(String[] args) {
            new Signupone();
    }

}
