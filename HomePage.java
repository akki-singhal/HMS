package HMSP;

import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class HomePage extends JFrame implements ActionListener
{
    JMenuBar JMBar;

    JMenu JMUser, JMHelp ,JMExit;

    JMenuItem JMILogin, JMIChangePassword, JMIForgotPassWord, JMINewUser, JMIHAbout, JMIExitApplication;

    JLabel JLHospitalImg;
    
    ImageIcon IIhospital;

     HomePage()
     {

        setExtendedState(MAXIMIZED_BOTH);
        setSize(1450,870);
        setLayout(null);
        setVisible(true);
        setTitle("Home Page");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         IIhospital= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/HospitalOutside copy.jpg")));
         JLHospitalImg=new JLabel(IIhospital);
         JLHospitalImg.setBounds(0, 0, 1450, 870);
         add(JLHospitalImg);


        JMBar= new JMenuBar();
        setJMenuBar(JMBar);
        JMUser= new JMenu("User");
        JMBar.add(JMUser);
        JMILogin= new JMenuItem("Login");
        JMUser.add(JMILogin);
        JMILogin.addActionListener(this);
        JMIChangePassword= new JMenuItem("Change Password");
        JMUser.add(JMIChangePassword);
        JMIChangePassword.addActionListener(this);
        JMIForgotPassWord= new JMenuItem("Forgot Password");
        JMUser.add(JMIForgotPassWord);
        JMIForgotPassWord.addActionListener(this);
        JMINewUser= new JMenuItem("New User");
        JMUser.add(JMINewUser);
        JMINewUser.addActionListener(this);
        
        JMExit=new JMenu("Exit");
        JMBar.add(JMExit);
        JMIExitApplication= new JMenuItem("Exit Application");
        JMIExitApplication.addActionListener(this);
        JMExit.add(JMIExitApplication);

        JMHelp= new JMenu("Help");
        JMBar.add(JMHelp);
        JMIHAbout=new JMenuItem("About");
        JMIHAbout.addActionListener(this);
        JMHelp.add(JMIHAbout);
        new Welcome();
        new Information();
        new LoginToContinue();
     }

     public void actionPerformed(ActionEvent evtHomePage)
     {
        if(evtHomePage.getSource()==JMILogin)
        {
            new Login();
            //setVisible(false);
        }

        else if(evtHomePage.getSource()==JMIChangePassword)
        {
            new Change_password();
            //setVisible(false);
        }

        else if(evtHomePage.getSource()==JMIForgotPassWord)
        {
            new Forgot_password();
            //setVisible(false);
        }

        else if(evtHomePage.getSource()==JMINewUser)
        {
            new New_user();
            //setVisible(false);
        }

        else if(evtHomePage.getSource()==JMIExitApplication)
        {
            System.exit(0);
        }

        else if(evtHomePage.getSource()==JMIHAbout)
        {
            JOptionPane.showMessageDialog(null, "-This app is developed by Akshat Singhal. \n-BCA 5th sem (R.NO.08) \n-Minor project \n-HOSPITAL MANAGEMENT SYSTEM \n-In future this app is getting  updates as per requirements \n-©Copyright 2023 Akshat Singhal &Co. All Rights Reserved. \n-CONTACT US The Akshat Singhal &Co. is managed by Akshat Singhal, Inc. \n-Email us: akkisinghal2510@gmail.com  ","About",JOptionPane.PLAIN_MESSAGE);
            
        }

     }

    public static void main(String[] args) 
    {
        new HomePage();
    }
}