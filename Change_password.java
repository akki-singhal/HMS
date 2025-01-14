package HMSP;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.sql.*;

class Change_password implements ActionListener
{
    JFrame JFMain;

    JLabel JLHospitalName,JLUserName,JLOldPassword,JLNewPassword,JLConfirmNewPassword;

    JTextField JTFUserName, JTFIncorrectPassword;

    JPasswordField JPFOldPassword,JPFNewPassword,JPFConfirmNewPassword;

    JButton JBConfirm,JBLoginPage,JBBack;
    
    ImageIcon IILogin, IIConfirm, IIBack;

    Change_password()
    {
        //frame
        JFMain=new JFrame();
        JFMain.setTitle("Change Password Form");
        JFMain.setSize(500,380);
        JFMain.setVisible(true);
        JFMain.setLocationRelativeTo(null);
        JFMain.setLayout(null);
        JFMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFMain.getContentPane().setBackground(Color.LIGHT_GRAY);

        //Image icons
        IILogin= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Login.png")));
        IIConfirm= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Confirm.png")));
        IIBack= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Exit.png")));

        //Hospital label
        JLHospitalName=new JLabel("Vardhman Hospital");
        JLHospitalName.setBounds(150,10,300,30);
        JFMain.add(JLHospitalName);

        //Username
        JLUserName=new JLabel("Username:");
        JLUserName.setBounds(50,50,150,30);
        JFMain.add(JLUserName);

        JTFUserName=new JTextField();
        JTFUserName.setBounds(220, 50, 150, 30);
        JFMain.add(JTFUserName);


        // Old Password
        JLOldPassword=new JLabel("Old Password:");
        JLOldPassword.setBounds(50,100,150,30);
        JFMain.add(JLOldPassword);

        JPFOldPassword=new JPasswordField();
        JPFOldPassword.setBounds(220, 100, 150, 30);
        JFMain.add(JPFOldPassword);

        //New Password
        JLNewPassword=new JLabel("New Password:");
        JLNewPassword.setBounds(50,150,150,30);
        JFMain.add(JLNewPassword);

        JPFNewPassword=new JPasswordField();
        JPFNewPassword.setBounds(220, 150, 150, 30);
        JFMain.add(JPFNewPassword);

        //Confirm Password
        JLConfirmNewPassword=new JLabel("Confirm New Password:");
        JLConfirmNewPassword.setBounds(50,200,150,30);
        JFMain.add(JLConfirmNewPassword);

        JPFConfirmNewPassword=new JPasswordField();
        JPFConfirmNewPassword.setBounds(220, 200, 150, 30);
        JFMain.add(JPFConfirmNewPassword);

        //shows user error
        JTFIncorrectPassword = new JTextField("");
        JTFIncorrectPassword.setHorizontalAlignment(JTextField.CENTER);
        JTFIncorrectPassword.setBackground(Color.lightGray);
        Border border= BorderFactory.createLineBorder(Color.lightGray,3);
        JTFIncorrectPassword.setBorder(border);
        JTFIncorrectPassword.setBounds(60, 310, 400, 30);
        JFMain.add(JTFIncorrectPassword);
        JTFIncorrectPassword.setEditable(false);


        //confirm button
        JBConfirm=new JButton("Confirm",IIConfirm);
        JBConfirm.setBounds(50,250,100,30);
        JBConfirm.addActionListener(this);
        JFMain.add(JBConfirm);

        //Login button
        JBLoginPage=new JButton("Login Page",IILogin);
        JBLoginPage.setBounds(170,250,100,30);
        JBLoginPage.addActionListener(this);
        JFMain.add(JBLoginPage);

        //Back button
        JBBack=new JButton("Back",IIBack);
        JBBack.setBounds(290,250,100,30);
        JBBack.addActionListener(this);
        JFMain.add(JBBack);

    }
    String url="jdbc:mysql://localhost:3306/HospitalMgtSystem";
    String Uname="root";
    String pass="@Tiger123";
    public void actionPerformed(ActionEvent evtCP)
    {
        if(evtCP.getSource()==JBConfirm)
        {
            try
            {
                String s1 = JTFUserName.getText();//fetching username from GUI
                String s2 = String.valueOf(JPFOldPassword.getPassword());//fetching old password from GUI
                String s3 = String.valueOf(JPFNewPassword.getPassword());//fetching new password from GUI
                String s4 = String.valueOf(JPFConfirmNewPassword.getPassword());//fetching confirm new password from GUI

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,Uname,pass);
                Statement st= con.createStatement();
                String query= "Select * from UserTable  ";
                ResultSet rs= st.executeQuery(query);
                String query1= "Update UserTable SET User_Password= '"+s3+"' where User_Name= '"+s1+"' ";

                if(rs.next())
                {

                    String s5 = rs.getString("User_Name");//fetching username from database
                    String s6 = String.valueOf(rs.getString("User_Password"));//fetching old password from database

                    if((s1.equals(s5))  &&  (s2.equals(s6))  &&  s3.equals(s4))
                    {
                        PreparedStatement pst = con.prepareStatement(query1);
                        pst.executeUpdate();
                        JTFIncorrectPassword.setBackground(Color.LIGHT_GRAY);
                        Border border= BorderFactory.createLineBorder(Color.LIGHT_GRAY,3);
                        JTFIncorrectPassword.setText(" ");
                        JTFUserName.setText("");
                        JPFOldPassword.setText("");
                        JPFNewPassword.setText("");
                        JPFConfirmNewPassword.setText("");
                        JOptionPane.showMessageDialog(null,"Password changed successfully");

                    }

                    else if(!s3.equals(s4))
                    {
                        JTFIncorrectPassword.setBackground(Color.red);
                        Border border= BorderFactory.createLineBorder(Color.red,3);
                        JTFIncorrectPassword.setText(" ");
                        JTFIncorrectPassword.setText("New password and Confirm new password did not matched!!");
                    }


                    else
                    {
                        JTFIncorrectPassword.setBackground(Color.red);
                        Border border= BorderFactory.createLineBorder(Color.red,3);
                        JTFIncorrectPassword.setText(" ");
                        JTFIncorrectPassword.setText("Username and Old password did not matched");
                    }

                }

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        if(evtCP.getSource()==JBLoginPage)
        {
            JFMain.setVisible(false);
            new Login();
        }
        if(evtCP.getSource()==JBBack)
        {
            //System.exit(0);
            JFMain.setVisible(false);
        }
    }
    public static void main(String... args)
    {
        new Change_password();
    }
}