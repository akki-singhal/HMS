package HMSP;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;

public class Room extends JFrame implements ActionListener
{
    JMenuBar JMB;

    JMenu JMExit, JMHelp;

    JMenuItem JMIExitApplication, JMIAbout;

    JLabel JLHName ,JLRLogo;

    JButton  JBMainPage;

    ImageIcon IIRLogo, IIMainPage;


    Room()
    {
        setSize(950,530);
        setLayout(null);
        setVisible(true);
        setTitle("Room Detail");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color col= new Color(149,183,94);
        getContentPane().setBackground(col);

        //Image Icons
        IIMainPage= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/MainPage.png")));

       //Menu bar
        JMB= new JMenuBar();
        setJMenuBar(JMB);

        //Exit menu
        JMExit= new JMenu("Exit");
        JMB.add(JMExit);
        JMIExitApplication= new JMenuItem("Exit Application");
        JMIExitApplication.addActionListener(this);
        JMExit.add(JMIExitApplication);
        JMHelp= new JMenu("Help");
        JMB.add(JMHelp);
        JMIAbout= new JMenuItem("About");
        JMIAbout.addActionListener(this);
        JMHelp.add(JMIAbout);

        //Hospital name label
        JLHName= new JLabel("Vardhman Hospital");
        JLHName.setBounds(300,10,200,30);
        add(JLHName);

        //Room Image Logo
        IIRLogo= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Room.png")));
        JLRLogo= new JLabel(IIRLogo);
        JLRLogo.setBounds(670,80,225,225);
        add(JLRLogo);


        //Main Page
        JBMainPage= new JButton("Main Page",IIMainPage);
        JBMainPage.setBounds(670,340,150,30);
        JBMainPage.addActionListener(this);
        add(JBMainPage);


        //for table
        class RoomTable extends JPanel
        {
            RoomTable()
            {
                JTable Table= new JTable();
                try
                {
                    String url="jdbc:mysql://localhost:3306/HospitalMgtSystem";
                    String Uname="root";
                    String pass="@Tiger123";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection(url,Uname,pass);
                    Statement st= con.createStatement();
                    String query= "Select * from Room  ";
                    ResultSet rs= st.executeQuery(query);
                    ResultSetMetaData rsmd= rs.getMetaData();
                    DefaultTableModel model= (DefaultTableModel) Table.getModel();
                    int cols= rsmd.getColumnCount();
                    String[] colName={"R.Number", "R.Type", "R.Availability", "P.Id", "P.Name"};
                    model.setColumnIdentifiers(colName);
                    String RNumber;
                    String Name;
                    String Availability;
                    String PID;
                    String PName;

                    while(rs.next())
                    {
                        RNumber=rs.getString(1);
                        Name=rs.getString(2);
                        Availability=rs.getString(3);
                        PID= rs.getString(4);
                        PName=rs.getString(5);
                        String[] row={RNumber,Name,Availability,PID,PName};
                        model.addRow(row);

                    }
                    st.close();
                    rs.close();
                    con.close();
                }

                catch(Exception e)
                {

                }

                Table.setPreferredScrollableViewportSize(new Dimension(600,350));
                Table.setFillsViewportHeight(true);
                JScrollPane js=new JScrollPane(Table);
                js.setVisible(true);
                add(js);
            }


        }
        HMSP.RoomTable pt =new HMSP.RoomTable();
        pt.setBounds(10,50,620,390);
        add(pt);
        setSize(951,500);


    }

    String url="jdbc:mysql://localhost:3306/HospitalMgtSystem";
    String uname="root";
    String pass="@Tiger123";
    public void actionPerformed(ActionEvent evtRoom)
    {
        JFrame jf=new JFrame();
        if(evtRoom.getSource()==JBMainPage)
        {
           new MainPage();
           dispose();
        }

        else if(evtRoom.getSource()==JMIExitApplication)
        {
            System.exit(0);
        }

        else if(evtRoom.getSource()==JMIAbout)
        {
            JOptionPane.showMessageDialog(null, "-This app is developed by Akshat Singhal. \n-BCA 5th sem (R.NO.08) \n-Minor project \n-HOSPITAL MANAGEMENT SYSTEM \n-In future this app is getting  updates as per requirements \n-©Copyright 2023 Akshat Singhal &Co. All Rights Reserved. \n-CONTACT US The Akshat Singhal &Co. is managed by Akshat Singhal, Inc. \n-Email us: akkisinghal2510@gmail.com  ","About",JOptionPane.PLAIN_MESSAGE);
        }

    }

    public static void main(String[] args) 
    {
        new Room();
    }
}
