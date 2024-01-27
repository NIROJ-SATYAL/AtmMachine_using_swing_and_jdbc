import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.NewsAddress;
import java.util.Properties;


public class SendMail {

    private static Connection connection;
    private static String user_id;
    private static String account_num;
    private  static String pin_num;


    public SendMail(String user_id , String Card_Num, String Pin, Connection connection)
    {
        this.account_num=Card_Num;
        this.connection=connection;
        this.user_id=user_id;
        this.pin_num=Pin;


        String email=fetch_email();

        if(!email.equals(""))
        {


            mailSend(email);

        }
        else {
            System.out.println("email doesn't found.....");
        }

    }



    public String fetch_email ()
    {

        String email="";

        String query="select  user_email ,user_name from personaldetails where user_formnum=?";


        try{
            PreparedStatement pst=connection.prepareStatement(query);
            pst.setString(1,user_id);
            ResultSet result=pst.executeQuery();
            if(result.next())
            {
                 email=result.getString("user_email");

                 return email;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  email;
    }


    public void mailSend( String email)
    {
        //        variable for gmail
        String host = "smtp.gmail.com";
        String subject="Account_Number";
        String message="Account Number:" + account_num +"\n" + "Pin Number" + pin_num + "\n" + "userId" + user_id + "\n";

//        load the properties


        Properties  properties=System.getProperties();
//        System.out.println("system properties" + properties);

//        setting important information to system

//        put host

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

//        step 1: To get the session object
        Session session= Session.getDefaultInstance(properties, new Authenticator() {
            @Override
//            it check the whether the email address exist or not
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("satyalvai72@gmail.com", "eefabomxysdgmexx");

            }
        });


        session.setDebug(true);

//        compose the message
        Message m= new MimeMessage(session);

        try {

            m.setFrom(new InternetAddress("satyalvai72@gmail.com"));
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            m.setSubject(subject);
            m.setText(message);
//        step 3 send the message using Transport class;
            Transport.send(m);
            System.out.println("send successfully.....");
        } catch (MessagingException me)
        {
            me.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }












}
