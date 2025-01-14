package HMSP;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

class MainPage extends JFrame implements ActionListener
{
    JMenuBar JMB;

    JMenu JMExit, JMHelp;

    JMenuItem JMIExitApplication,JMIBack, JMIAbout;

    JLabel JLWDoctor, JLWPatient, JLWRoom, JLWBill, JLWNurse;

    ImageIcon IIWDoctor, IIWPatient, IIWRoom, IIWBill, IIWNurse;

    JButton JBWDoctor, JBWPatient, JBWRoom, JBWBill, JBWNurse;

    MainPage()
    {
        setSize(760,620);
        setLayout(null);
        setVisible(true);
        setTitle("Vardhman Hospital");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color col= new Color(165,145,113);
        getContentPane().setBackground(col);


        //Menu bar
        JMB= new JMenuBar();
        setJMenuBar(JMB);

        //Exit menu
        JMExit= new JMenu("Exit");
        JMB.add(JMExit);
        JMIExitApplication= new JMenuItem("Exit Application");
        JMIExitApplication.addActionListener(this);
        JMExit.add(JMIExitApplication);
        JMIBack= new JMenuItem("Logout");
        JMIBack.addActionListener(this);
        JMExit.add(JMIBack);
        //Help menu
        JMHelp= new JMenu("Help");
        JMB.add(JMHelp);
        JMIAbout= new JMenuItem("About");
        JMIAbout.addActionListener(this);
        JMHelp.add(JMIAbout);


        //Doctor image
        IIWDoctor= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Doctor.png")));
        JLWDoctor= new JLabel(IIWDoctor);
        JLWDoctor.setBounds(20,20,225,225);
        add(JLWDoctor);
        //Doctor button
        JBWDoctor= new JButton("Doctor");
        JBWDoctor.setBounds(20,260,225,30);
        JBWDoctor.addActionListener(this);
        add(JBWDoctor);

        //Patient image
        IIWPatient= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Patient.jpeg")));
        JLWPatient= new JLabel(IIWPatient);
        JLWPatient.setBounds(270,20,225,225);
        add(JLWPatient);
        //Patient Button
        JBWPatient= new JButton("Patient");
        JBWPatient.setBounds(270,260,225,30);
        JBWPatient.addActionListener(this);
        add(JBWPatient);

        //Nurse image
        IIWNurse= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Nurse.png")));
        JLWNurse= new JLabel(IIWNurse);
        JLWNurse.setBounds(520,20,225,225);
        add(JLWNurse);
        //Nurse button
        JBWNurse= new JButton("Nurse");
        JBWNurse.setBounds(520,260,225,30);
        JBWNurse.addActionListener(this);
        add(JBWNurse);

        //Room image
        IIWRoom= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Room.png")));
        JLWRoom= new JLabel(IIWRoom);
        JLWRoom.setBounds(125,300,225,225);
        add(JLWRoom);
        //Room button
        JBWRoom= new JButton("Room");
        JBWRoom.setBounds(125,535,225,30);
        JBWRoom.addActionListener(this);
        add(JBWRoom);


        //Bill image
        IIWBill= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Bill.png")));
        JLWBill= new JLabel(IIWBill);
        JLWBill.setBounds(375,300,225,225);
        add(JLWBill);
        //Bill button
        JBWBill= new JButton("Bill");
        JBWBill.setBounds(375,535,225,30);
        JBWBill.addActionListener(this);
        add(JBWBill);

    }

    public void actionPerformed(ActionEvent evtMainPage)
    {
        if(evtMainPage.getSource()== JBWDoctor)
        {
            setVisible(false);
            new Doctor();
           
        }

        if(evtMainPage.getSource()== JBWPatient)
        {
            setVisible(false);
            //new Patient();
            new Patient();
        }

        if(evtMainPage.getSource()== JBWNurse)
        {
            setVisible(false);
            new Nurse();
        }

        if(evtMainPage.getSource()== JBWRoom)
        {
            setVisible(false);
            new Room();
        }

        if(evtMainPage.getSource()== JBWBill)
        {
            setVisible(false);
            new Bill();
        }

        else if(evtMainPage.getSource()==JMIExitApplication)
        {
            System.exit(0);
        }

        else if(evtMainPage.getSource()==JMIBack)
        {
            setVisible(false);
        }

        else if(evtMainPage.getSource()==JMIAbout)
        {
            JOptionPane.showMessageDialog(null, "-This app is developed by Akshat Singhal. \n-BCA 5th sem (R.NO.08) \n-Minor project \n-HOSPITAL MANAGEMENT SYSTEM \n-In future this app is getting  updates as per requirements \n-©Copyright 2023 Akshat Singhal &Co. All Rights Reserved. \n-CONTACT US The Akshat Singhal &Co. is managed by Akshat Singhal, Inc. \n-Email us: akkisinghal2510@gmail.com  ","About",JOptionPane.PLAIN_MESSAGE);
        }
    }
    public static void main(String... args)
    {
        new MainPage();
    }
}