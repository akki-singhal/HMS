package HMSP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;

class Forgot_password implements ActionListener
{
     JFrame JFMain;

     JLabel JLHospitalName,JLUserName,JLSecurityQuestion,JLAnswer,JLYourPassword; 

     JTextField JTFUserName,JTFAnswer,JTFYourPassword;

     JButton JBLogin,JBBack,JBRetrivePassword;

     JComboBox JCBSecurityQuestion;

     ImageIcon IILogin, IIBack, IIRetrivePassword;

     Forgot_password()
     {
        //frame
        JFMain=new JFrame();
        JFMain.setTitle("Forgot Password Form");
        JFMain.setSize(530,380);
        JFMain.setVisible(true);
        JFMain.setLocationRelativeTo(null);
        JFMain.setLayout(null);
        JFMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFMain.getContentPane().setBackground(Color.LIGHT_GRAY);

        IILogin= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Login.png")));
        IIBack= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Exit.png")));
        IIRetrivePassword= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/RetrivePassword.png")));

        //label
        JLHospitalName=new JLabel("Vardhman Hospital");
        JLHospitalName.setBounds(170, 10, 300, 30);
        JFMain.add(JLHospitalName);

        JLUserName=new JLabel("Username:");
        JLUserName.setBounds(50, 50, 150, 30);
        JFMain.add(JLUserName);

        JLSecurityQuestion=new JLabel("Security Question:");
        JLSecurityQuestion.setBounds(50, 100, 150, 30);
        JFMain.add(JLSecurityQuestion);

        JLAnswer=new JLabel("Answer:");
        JLAnswer.setBounds(50, 150, 150, 30);
        JFMain.add(JLAnswer);

        JLYourPassword=new JLabel("Your Password :");
        JLYourPassword.setBounds(50, 200, 150, 30);
        JFMain.add(JLYourPassword);

        //text field
        JTFUserName=new JTextField();
        JTFUserName.setBounds(220, 50, 150, 30);
        JFMain.add(JTFUserName);

        JTFAnswer=new JTextField();
        JTFAnswer.setBounds(220, 150, 150, 30);
        JFMain.add(JTFAnswer);

        JTFYourPassword=new JTextField();
        JTFYourPassword.setBounds(220, 200, 150, 30);
        JFMain.add(JTFYourPassword);

        //button
        JBLogin=new JButton("Login Page",IILogin);
        JBLogin.setBounds(100,250,100,30);
        JBLogin.addActionListener(this);
        JFMain.add(JBLogin);

        JBBack=new JButton("Back",IIBack);
        JBBack.setBounds(220,250,100,30);
        JBBack.addActionListener(this);
        JFMain.add(JBBack);

        JBRetrivePassword=new JButton("Retrive pswd",IIRetrivePassword);
        JBRetrivePassword.setBounds(380,150,130,30);
        JBRetrivePassword.addActionListener(this);
        JFMain.add(JBRetrivePassword);

        //combobox
        String s1[]={"-Select-","Who is your childhood hero?" ,"What is your favorite book?","What is your first school name?"};
        JCBSecurityQuestion=new JComboBox <>(s1);
        JCBSecurityQuestion.setBounds(220,100,250,30);
        JFMain.add(JCBSecurityQuestion);
     }

    String url="jdbc:mysql://localhost:3306/HospitalMgtSystem";
    String Uname="root";
    String pass="@Tiger123";

     public void actionPerformed(ActionEvent evtFP)
     {
        if(evtFP.getSource()==JBLogin)
        {
            JFMain.setVisible(false);
            new Login();
        }
        if(evtFP.getSource()==JBBack)
        {
            //System.exit(0);
            JFMain.setVisible(false);
        }
        if(evtFP.getSource()==JBRetrivePassword)
        {
            String s1 = JTFUserName.getText();//fetching username from GUI
            String s2 = String.valueOf(JCBSecurityQuestion.getSelectedItem());//fetching security question from GUI
            String s3 = JTFAnswer.getText();//fetch answer of security question from GUI
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, Uname, pass);
                Statement st = con.createStatement();
                String query = "Select * from UserTable  ";
                ResultSet rs = st.executeQuery(query);
                if(rs.next())
                {
                    String s4= rs.getString("User_Name");
                    String s5= rs.getString("Security_Question");
                    String s6= rs.getString("Answer");
                    String s7= String.valueOf(rs.getString("User_Password"));
                    if(  (s1.equals(s4))  &&  (s2.equalsIgnoreCase(s5))  &&  (s3.equalsIgnoreCase(s6))  )
                    {
                        JTFYourPassword.setBackground(new Color(58, 181, 62));
                        JTFYourPassword.setText(s7);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Incorrect details");
                    }
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
     }
    public static void main(String... args)
    {
        new Forgot_password();
    }
}
