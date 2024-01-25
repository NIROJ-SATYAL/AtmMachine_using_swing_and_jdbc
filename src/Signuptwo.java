import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Signuptwo  extends JFrame   {

    private Connection connection;
    String formno;
    JLabel Additional_Details, religion, category, income, education, occupation, panLabel, adharLabel, seniorCitizenLabel,l10, QualidicationLabel, formNumLabel, formnum, fatherNameLabel, motherNameLabel;
    JButton nextButtton;
    JRadioButton yesLabel, NoLabel;

    JTextField panfield, adharfield, fatherNameField, motherNameField,t5;
    JComboBox religionField, categoryField, incomeField, educationField, occupationField;


    public  Signuptwo(long rand,Connection connection) {


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Perform your operations here
                // For example, ask the user for confirmation
                int option = JOptionPane.showConfirmDialog(
                        Signuptwo.this,
                        "Do you really want to exit?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                       String query="Delete from personaldetails where user_formnum=?";
                       try{
                           PreparedStatement pst=connection.prepareStatement(query);
                           pst.setString(1,formno);
                           int rowAffected=pst.executeUpdate();
                           if(rowAffected>0)
                           {
                               dispose();
                           }


                       } catch (SQLException ex) {
                           throw new RuntimeException(ex);
                       }

                }
                else {



                }
            }
        });

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l14 = new JLabel(i3);
//        l14.setBounds(150, 0, 100, 100);
//        add(l14);


        this.formno =  "" + rand;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        Additional_Details = new JLabel("Page 2: Additonal Details");
        Additional_Details.setFont(new Font("Raleway", Font.BOLD, 22));




        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));

        category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 18));

        income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 18));

        education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 18));

        QualidicationLabel = new JLabel("Qualification:");
        QualidicationLabel.setFont(new Font("Raleway", Font.BOLD, 18));

        occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));

        panLabel = new JLabel("PAN Number:");
        panLabel.setFont(new Font("Raleway", Font.BOLD, 18));

        adharLabel = new JLabel("Aadhar Number:");
        adharLabel.setFont(new Font("Raleway", Font.BOLD, 18));

        seniorCitizenLabel = new JLabel("Senior Citizen:");
        seniorCitizenLabel.setFont(new Font("Raleway", Font.BOLD, 18));
//
//        l10 = new JLabel("Existing Account:");
//        l10.setFont(new Font("Raleway", Font.BOLD, 18));

        formNumLabel = new JLabel("Form No:");
        formNumLabel.setFont(new Font("Raleway", Font.BOLD, 13));

        formnum = new JLabel(formno);
        formnum.setFont(new Font("Raleway", Font.BOLD, 13));


        fatherNameLabel = new JLabel(" Father Name");
        fatherNameLabel.setFont(new Font("Raleway", Font.BOLD, 22));

        motherNameLabel = new JLabel(" Mother Name");
        motherNameLabel.setFont(new Font("Raleway", Font.BOLD, 22));

        nextButtton = new JButton("Next");
        nextButtton.setFont(new Font("Raleway", Font.BOLD, 14));
        nextButtton.setBackground(Color.BLACK);
        nextButtton.setForeground(Color.WHITE);

        panfield = new JTextField();
        panfield.setFont(new Font("Raleway", Font.BOLD, 14));

        adharfield = new JTextField();
        adharfield.setFont(new Font("Raleway", Font.BOLD, 14));

        fatherNameField = new JTextField();
        fatherNameField.setFont(new Font("Raleway", Font.BOLD, 14));

        motherNameField = new JTextField();
        motherNameField.setFont(new Font("Raleway", Font.BOLD, 14));

        yesLabel = new JRadioButton("Yes");
        yesLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        yesLabel.setBackground(Color.WHITE);

        NoLabel = new JRadioButton("No");
        NoLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        NoLabel.setBackground(Color.WHITE);

//        r3 = new JRadioButton("Yes");
//        r3.setFont(new Font("Raleway", Font.BOLD, 14));
//        r3.setBackground(Color.WHITE);
//
//        r4 = new JRadioButton("No");
//        r4.setFont(new Font("Raleway", Font.BOLD, 14));
//        r4.setBackground(Color.WHITE);


        String religion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionField = new JComboBox(religion);
        religionField.setBackground(Color.WHITE);
        religionField.setFont(new Font("Raleway", Font.BOLD, 14));

        String category[] = {"General", "OBC", "SC", "ST", "Other"};
        categoryField = new JComboBox(category);
        categoryField.setBackground(Color.WHITE);
        categoryField.setFont(new Font("Raleway", Font.BOLD, 14));

        String income[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        incomeField = new JComboBox(income);
        incomeField.setBackground(Color.WHITE);
        incomeField.setFont(new Font("Raleway", Font.BOLD, 14));

        String education[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        educationField = new JComboBox(education);
        educationField.setBackground(Color.WHITE);
        educationField.setFont(new Font("Raleway", Font.BOLD, 14));

        String occupation[] = {"Salaried", "Self-Employmed", "Business", "Student", "Retired", "Others"};
        occupationField = new JComboBox(occupation);
        occupationField.setBackground(Color.WHITE);
        occupationField.setFont(new Font("Raleway", Font.BOLD, 14));


        setLayout(null);


        formNumLabel.setBounds(700, 10, 60, 30);
        add(formNumLabel);

        formnum.setBounds(760, 10, 60, 30);
        add(formnum);

        Additional_Details.setBounds(280, 30, 600, 40);
        add(Additional_Details);

        this.religion.setBounds(100, 120, 100, 30);
        add(this.religion);

        religionField.setBounds(350, 120, 320, 30);
        add(religionField);

        this.category.setBounds(100, 170, 100, 30);
        add(this.category);

        categoryField.setBounds(350, 170, 320, 30);
        add(categoryField);

        this.income.setBounds(100, 220, 100, 30);
        add(this.income);

        incomeField.setBounds(350, 220, 320, 30);
        add(incomeField);

        this.education.setBounds(100, 270, 150, 30);
        add(this.education);

        educationField.setBounds(350, 270, 320, 30);
        add(educationField);

        QualidicationLabel.setBounds(100, 290, 150, 30);
        add(QualidicationLabel);

        this.occupation.setBounds(100, 340, 150, 30);
        add(this.occupation);

        occupationField.setBounds(350, 340, 320, 30);
        add(occupationField);

        panLabel.setBounds(100, 390, 150, 30);
        add(panLabel);

        panfield.setBounds(350, 390, 320, 30);
        add(panfield);

        adharLabel.setBounds(100, 440, 180, 30);
        add(adharLabel);

        adharfield.setBounds(350, 440, 320, 30);
        add(adharfield);

        seniorCitizenLabel.setBounds(100, 490, 150, 30);
        add(seniorCitizenLabel);

        yesLabel.setBounds(350, 490, 100, 30);
        add(yesLabel);

        NoLabel.setBounds(460, 490, 100, 30);
        add(NoLabel);

        fatherNameLabel.setBounds(100, 540, 180, 30);
        add(fatherNameLabel);
        fatherNameField.setBounds(350,540,320,30);
        add(fatherNameField);

        motherNameLabel.setBounds(100, 590,180,30);
        add(motherNameLabel);
        motherNameField.setBounds(350,590, 320,30);
        add(motherNameField);


//        r3.setBounds(350, 540, 100, 30);
//        add(r3);
//
//        r4.setBounds(460, 540, 100, 30);
//        add(r4);

        nextButtton.setBounds(570, 640, 100, 30);
        add(nextButtton);

//            b.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 750);
        setLocation(250, 20);
        setVisible(true);



    }


    public static void main(String[] args) {
        System.out.println("signup2");
//        new Signuptwo(1234);
    }





}
