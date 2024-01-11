import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
//constructor of Login class .it will call whenever a object of login class is created....
    public Login(){
//       To Set The Title of frame
        setTitle("Bank Management System");
//        setsize set the height and width of frame
        setSize(800,480);
//        to add the image we use imageicon class .

        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2= image1.getImage().getScaledInstance(100,100 , Image.SCALE_DEFAULT);
        ImageIcon image2=new ImageIcon(i2);
        JLabel label=new JLabel(image2);
        add(label);
//        initially frame is  hidden so..
        setVisible(true);
//to set the location of frame we use setLocation function
        setLocation(350,200);
    }

    public static void main(String[] args) {
        new Login();

    }
}
