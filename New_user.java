package HMSP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;

//import java.util.ArrayList;
class New_user implements ActionListener
{ 
    JFrame JFMain;

    JLabel JLHospitalName,JLName,JLUserName,JLPassword,JLConfirmPassword,JLSecurityQuestion,JLAnswer;

    JTextField JTFName,JTFUserName,JTFAnswer;

    JPasswordField JPFPassword ,JPFConfirmPassword;

    JButton JBConfirm,JBLogin,JBBack; 

    JComboBox JCSecurityQuestion;
    
    ImageIcon IILogin, IIConfirm, IIBack;

    New_user()
    {
        //frame
        JFMain=new JFrame();
        JFMain.setTitle("New User Form");
        JFMain.setSize(500,450);
        JFMain.setVisible(true);
        JFMain.setLocationRelativeTo(null);
        JFMain.setLayout(null);
        JFMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFMain.getContentPane().setBackground(Color.LIGHT_GRAY);

        //icons pack
        IILogin= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Login.png")));
        IIConfirm= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Confirm.png")));
        IIBack= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Exit.png")));

        //Hospital label
        JLHospitalName=new JLabel("Vardhman Hoispital");
        JLHospitalName.setBounds(150, 10, 300, 30);
        JFMain.add(JLHospitalName);

        //Newuser name
        JLName=new JLabel("Name:");
        JLName.setBounds(50,50 , 150,30 );
        JFMain.add(JLName);

        JTFName=new JTextField();
        JTFName.setBounds(220, 50, 150, 30);
        JFMain.add(JTFName);

        //Newuser username
        JLUserName=new JLabel("User Name:");
        JLUserName.setBounds(50,100 , 150,30 );
        JFMain.add(JLUserName);

        JTFUserName=new JTextField();
        JTFUserName.setBounds(220, 100, 150, 30);
        JFMain.add(JTFUserName);

        //Newuser password
        JLPassword=new JLabel("Password:");
        JLPassword.setBounds(50,150 , 150,30 );
        JFMain.add(JLPassword);

        JPFPassword=new JPasswordField();
        JPFPassword.setBounds(220, 150, 150, 30);
        JFMain.add(JPFPassword);

        //Newuser confirm password
        JLConfirmPassword=new JLabel("Confirm Password:");
        JLConfirmPassword.setBounds(50,200 , 150,30 );
        JFMain.add(JLConfirmPassword);

        JPFConfirmPassword=new JPasswordField();
        JPFConfirmPassword.setBounds(220, 200, 150, 30);
        JFMain.add(JPFConfirmPassword);

        //Newuser security question
        JLSecurityQuestion=new JLabel("Security Question:");
        JLSecurityQuestion.setBounds(50,250 , 150,30 );
        JFMain.add(JLSecurityQuestion);

        String s1[]={"-Select-","Who is your childhood hero?" ,"What is your favorite book?","What is your first school name?"};
        JCSecurityQuestion=new JComboBox<> (s1);
        JCSecurityQuestion.setBounds(220,250,250,30);
        JFMain.add(JCSecurityQuestion);

        //Newuser security question answer
        JLAnswer=new JLabel("Answer:");
        JLAnswer.setBounds(50,300 , 150,30 );
        JFMain.add(JLAnswer);

        JTFAnswer=new JTextField();
        JTFAnswer.setBounds(220, 300, 150, 30);
        JFMain.add(JTFAnswer);


        //confirm buttons
        JBConfirm=new JButton("Confirm",IIConfirm);
        JBConfirm.setBounds(50, 350, 100, 30);
        JBConfirm.addActionListener(this);
        JFMain.add(JBConfirm);

        //Login button
        JBLogin=new JButton("login Page",IILogin);
        JBLogin.setBounds(170, 350, 100, 30);
        JBLogin.addActionListener(this);
        JFMain.add(JBLogin);

        //Back button
        JBBack=new JButton("Back",IIBack);
        JBBack.setBounds(290,350,100,30);
        JBBack.addActionListener(this);
        JFMain.add(JBBack);

    }
    String url= "jdbc:mysql://localhost:3306/HospitalMgtSystem";
    String Uname="root";
    String pass= "@Tiger123";
    public void actionPerformed(ActionEvent evtNU)
    {
        if(evtNU.getSource()==JBConfirm)
        {
            try
            {
                String query= "Insert into UserTable(UName, User_Name, User_Password, Security_Question, Answer)values(?,?,?,?,?)";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,Uname,pass);
                PreparedStatement pst= con.prepareStatement(query);
                //ResultSet rs=pst.executeQuery();
                String s1 = String.valueOf(JPFPassword.getPassword());
                String s2 = String.valueOf(JPFConfirmPassword.getPassword());
                String s3 = JTFUserName.getText();

                if (s1.equals(s3) && s1.equalsIgnoreCase(s3))
                  {
                     JOptionPane.showMessageDialog(null,"UserName and Password will not be same");
                  }

                else if(s1.equals(s2) )
                {
                    pst.setString(1,JTFName.getText());
                    pst.setString(2,JTFUserName.getText());
                    pst.setString(3,String.valueOf(JPFPassword.getPassword()));
                    pst.setString(4,String.valueOf(JCSecurityQuestion.getSelectedItem()));
                    pst.setString(5,JTFAnswer.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Register Successful");
                }



                else
                {
                   // new New_user();
                    JOptionPane.showMessageDialog(null,"Password and Confirm Password did not match");
                    JTFName.setText("");
                    JTFUserName.setText("");
                    JPFPassword.setText("");
                    JPFConfirmPassword.setText("");
                    JCSecurityQuestion.setSelectedIndex(0);
                    JTFAnswer.setText("");
                }

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        if(evtNU.getSource()==JBLogin)
        {
            JFMain.dispose();
            new Login();
        }
        if(evtNU.getSource()==JBBack)
        {
            //System.exit(0);
            JFMain.dispose();
        }
    }
    public static void main(String... args)
    {
        new New_user();
    }
}