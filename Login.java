package HMSP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;
import javax.swing.border.Border;

class Login implements ActionListener
{
    JFrame JFMain;

    JLabel JLHName,JLUserName,JLPassword, JLUserLogo;

    JTextField JTFUserName, JTFIncorrectPassword;

    JPasswordField JPFPassword;

    JButton JBLogin,JBSignUp,JBChangePassword,JBForgotPassword,JBClear,JBBack;

    ImageIcon IIUser, IILogin, IISignUp, IIChangePassword, IIForgotPassword, IIClear, IIBack;

    // JComboBox c1;
    Login()
    {
        //frame
        JFMain=new JFrame();
        JFMain.setTitle("Login Form");
        JFMain.setSize(590,330);
        JFMain.setVisible(true);
        JFMain.setLocationRelativeTo(null);
        JFMain.setLayout(null);
        JFMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFMain.getContentPane().setBackground(Color.LIGHT_GRAY);


        IILogin= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Login.png")));
        IISignUp= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/NewUser.png")));
        IIChangePassword= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/ChangePassword.png")));
        IIForgotPassword= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/ForgotPassword.png")));
        IIClear= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Clear.png")));
        IIBack= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Exit.png")));


        //User logo
        IIUser= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/User.jpg")));
        JLUserLogo=new JLabel(IIUser);
        JLUserLogo.setBounds(400,30,100,100);
        JFMain.add(JLUserLogo);

        //Hospital lable
        JLHName=new JLabel("Vardhman Hospital");
        JLHName.setBounds(200,10,300,30);
        JFMain.add(JLHName);

        //User name
        JLUserName=new JLabel("User Name:");
        JLUserName.setBounds(120,50,100,30);
        JFMain.add(JLUserName);

        JTFUserName=new JTextField();
        JTFUserName.setBounds(220, 50, 150, 30);
        JFMain.add(JTFUserName);

        //Password
        JLPassword=new JLabel("Password:");
        JLPassword.setBounds(120,100,100,30);
        JFMain.add(JLPassword);

        JPFPassword=new JPasswordField();
        JPFPassword.setBounds(220, 100, 150, 30);
        JFMain.add(JPFPassword);


        //Login button
        JBLogin=new JButton("Login",IILogin);
        JBLogin.setBounds(50, 150, 150, 30);
        JBLogin.addActionListener(this);
        JFMain.add(JBLogin);

        //signup button
        JBSignUp=new JButton("Sign Up",IISignUp);
        JBSignUp.setBounds(220, 150, 150, 30);
        JBSignUp.addActionListener(this);
        JFMain.add(JBSignUp);

        //change passwordbutton
        JBChangePassword=new JButton("Change Password",IIChangePassword);
        JBChangePassword.setBounds(390, 150, 150, 30);
        JBChangePassword.addActionListener(this);
        JFMain.add(JBChangePassword);

        //forgot password button
        JBForgotPassword=new JButton("Forgot Password",IIForgotPassword);
        JBForgotPassword.setBounds(50, 200, 150, 30);
        JBForgotPassword.addActionListener(this);
        JFMain.add(JBForgotPassword);

        //clear button
        JBClear=new JButton("Clear",IIClear);
        JBClear.setBounds(220, 200, 150, 30);
        JBClear.addActionListener(this);
        JFMain.add(JBClear);

        //back button
        JBBack=new JButton("Back",IIBack);
        JBBack.setBounds(390, 200, 150, 30);
        JBBack.addActionListener(this);
        JFMain.add(JBBack);



    }
    String url= "jdbc:mysql://localhost:3306/HospitalMgtSystem";
    String Uname="root";
    String pass= "@Tiger123";

    public void actionPerformed(ActionEvent evtL)
    {
        if(evtL.getSource()==JBLogin)
        {
            try
            {
                String s3 = JTFUserName.getText();//fetching username from interface
                String s4 = String.valueOf(JPFPassword.getPassword());//fetching password from interface
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,Uname,pass);
                Statement st= con.createStatement();
                String query= "Select * from UserTable";
                ResultSet rs= st.executeQuery(query);
                while(rs.next())
                {
                    String s1= rs.getString("User_Name");//fetching username from database
                    String s2= rs.getString("User_Password");//fetching password from database

                    if (s1.equals(s3) && s2.equals(s4) && !s1.equals(s2))
                    {
                        JFMain.dispose();
                        new MainPage();
                    }


                    else
                    {
                        //Incorrect Password label

                        JTFIncorrectPassword = new JTextField("Username and Password did not matched!!");
                        JTFIncorrectPassword.setBackground(Color.red);
                        Border border= BorderFactory.createLineBorder(Color.red,3);
                        JTFIncorrectPassword.setBorder(border);
                        JTFIncorrectPassword.setBounds(150, 250, 280, 30);
                        JFMain.add(JTFIncorrectPassword);
                        JTFIncorrectPassword.setEditable(false);
                    }
                }


            }

            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }

        if(evtL.getSource()==JBSignUp)
        {
            JFMain.setVisible(false);
            new New_user();
        }

        if(evtL.getSource()==JBChangePassword)
        {
            JFMain.setVisible(false);
            new Change_password();
        }

        if(evtL.getSource()==JBForgotPassword)
        {
            JFMain.setVisible(false);
            new Forgot_password();
        }

        if(evtL.getSource()==JBClear)
        {
            JTFUserName.setText(null);
            JPFPassword.setText(null);
        }

        if(evtL.getSource()==JBBack)
        {
            //System.exit(0);
            JFMain.setVisible(false);
        }
    }
    public static void main(String... args)
    {
        new Login();
    }
} 