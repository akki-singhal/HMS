package HMSP;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;
import javax.swing.*;

class Nurse extends JFrame implements ActionListener
{
    JMenuBar JMB;

    JMenu JMExit, JMHelp;

    JMenuItem JMIExitApplication, JMIAbout, JMIAboutPage, JMICurrentNurse, JMIAllNurse;

    JLabel JLHName, JLNLogo, JLNId, JLNName, JLNAddress, JLNQualification, JLNDepartment, JLNBloodGroup, JLNPhoneNumber;

    JTextField JTFNId, JTFNName, JTFNAddress, JTFNQualification, JTFNPhoneNumber;

    JButton JBMainPage, JBNAdd, JBNGetData, JBNUpdate, JBNDelete, JBClear, JBGenerateId;

    ImageIcon IINLogo, IIMainPage, IIUpdateRecord, IIAddRecord, IIDeleteRecord, IIGetData, IIClear, IIGenerateId;

    JComboBox JCBNBloodGroup, JCBNDepartment;

    Nurse()
    {
        setSize(900,650);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Nurse Detail");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color col= new Color(149,183,94);
        getContentPane().setBackground(col);

        //Image Icons
        IIMainPage= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/MainPage.png")));
        IIUpdateRecord= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/UpdateRecord.png")));
        IIAddRecord= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/SaveRecord.png")));
        IIDeleteRecord= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/DeleteRecord.png")));
        IIGetData= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/GetData.png")));
        IIClear= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Clear.png")));
        IIGenerateId= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/GenerateId.png")));

        //Menu bar
        JMB= new JMenuBar();
        setJMenuBar(JMB);

        //Exit menu
        JMExit= new JMenu("Exit");
        JMB.add(JMExit);

        JMIExitApplication= new JMenuItem("Exit Application");
        JMIExitApplication.addActionListener(this);
        JMExit.add(JMIExitApplication);

        //Help menu
        JMHelp= new JMenu("Help");
        JMB.add(JMHelp);

        JMIAbout= new JMenuItem("About");
        JMIAbout.addActionListener(this);
        JMHelp.add(JMIAbout);

        JMIAboutPage= new JMenuItem("About Page");
        JMIAboutPage.addActionListener(this);
        JMHelp.add(JMIAboutPage);

        JMICurrentNurse= new JMenuItem("Current Nurse");
        JMICurrentNurse.addActionListener(this);
        JMHelp.add(JMICurrentNurse);

        JMIAllNurse=new JMenuItem("All Nurse");
        JMIAllNurse.addActionListener(this);
        JMHelp.add(JMIAllNurse);

        //Nurse logo
        IINLogo= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Nurse.png")));
        JLNLogo= new JLabel(IINLogo);
        JLNLogo.setBounds(600,80,225,225);
        add(JLNLogo);

        //Hospital name
        JLHName= new JLabel("Vardhman Hospital");
        JLHName.setBounds(350,20,200,30);
        add(JLHName);

        //Nurse Id
        JLNId= new JLabel("ID NO:");
        JLNId.setBounds(50,70,100,30);
        add(JLNId);

        JTFNId= new JTextField();
        JTFNId.setBounds(170,70,200,30);
        add(JTFNId);

        //Nurse Name
        JLNName= new JLabel("Name:");
        JLNName.setBounds(50,120,100,30);
        add(JLNName);

        JTFNName= new JTextField();
        JTFNName.setBounds(170,120,200,30);
        add(JTFNName);

        //Nurse Address
        JLNAddress= new JLabel("Address:");
        JLNAddress.setBounds(50,170,100,30);
        add(JLNAddress);

        JTFNAddress= new JTextField();
        JTFNAddress.setBounds(170,170,200,30);
        add(JTFNAddress);

        //Nurse Qualification
        JLNQualification= new JLabel("Qualification:");
        JLNQualification.setBounds(50,220,100,30);
        add(JLNQualification);

        JTFNQualification= new JTextField();
        JTFNQualification.setBounds(170,220,200,30);
        add(JTFNQualification);

        //Nurse Department
        JLNDepartment= new JLabel("Department:");
        JLNDepartment.setBounds(50,270,100,30);
        add(JLNDepartment);

        String[] department={"--Select--", "Joint Replacement", "Orthopaedics", "Trauma", "Gynaecology", "Obstetrics",  "IVF"};
        JCBNDepartment=new JComboBox<>(department);
        JCBNDepartment.setBounds(170,270,200,30);
        add(JCBNDepartment);

        //Nurse Blood group
        JLNBloodGroup= new JLabel("Blood Group");
        JLNBloodGroup.setBounds(50,320,100,30);
        add(JLNBloodGroup);

        String[] BloodGroup ={"-Select-", "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+"};
        JCBNBloodGroup= new JComboBox<>(BloodGroup);
        JCBNBloodGroup.setBounds(170,320,200,30);
        add(JCBNBloodGroup);

        //Nurse Phone number
        JLNPhoneNumber=new JLabel("Phone Number:");
        JLNPhoneNumber.setBounds(50,370,100,30);
        add(JLNPhoneNumber);

        JTFNPhoneNumber=new JTextField();
        JTFNPhoneNumber.setBounds(170, 370, 200, 30);
        add(JTFNPhoneNumber);

        //Main page button
        JBMainPage= new JButton("Main Page",IIMainPage);
        JBMainPage.setBounds(600,330,150,30);
        JBMainPage.addActionListener(this);
        add(JBMainPage);

        //Update record button
        JBNUpdate= new JButton("Update Record",IIUpdateRecord);
        JBNUpdate.setBounds(600,370,150,30);
        JBNUpdate.addActionListener(this);
        add(JBNUpdate);

        //Add record button
        JBNAdd= new JButton("Add record",IIAddRecord);
        JBNAdd.setBounds(600,410,150,30);
        JBNAdd.addActionListener(this);
        add(JBNAdd);

        //Delete record button
        JBNDelete= new JButton("Delete record",IIDeleteRecord);
        JBNDelete.setBounds(600,450,150,30);
        JBNDelete.addActionListener(this);
        add(JBNDelete);

        //Get data button
        JBNGetData= new JButton("Get Data",IIGetData);
        JBNGetData.setBounds(600,490,150,30);
        JBNGetData.addActionListener(this);
        add(JBNGetData);

        //Clear button
        JBClear= new JButton("clear form",IIClear);
        JBClear.setBounds(600,530,150,30);
        JBClear.addActionListener(this);
        add(JBClear);

        //Nurse generate id
        JBGenerateId= new JButton("",IIGenerateId);
        JBGenerateId.setBounds(390,70,40,30);
        JBGenerateId.addActionListener(this);
        add(JBGenerateId);
    }

    String url="jdbc:mysql://localhost:3306/HospitalMgtSystem";
    String uname="root";
    String pass="@Tiger123";
    public void actionPerformed(ActionEvent evtNurse)
    {
        if(evtNurse.getSource()==JBMainPage)
        {
            dispose();
            new MainPage();
        }

        else if(evtNurse.getSource()==JBNUpdate)
        {
            int NId= Integer.parseInt(JTFNId.getText());
            String NName= JTFNName.getText();
            String NAddress= JTFNAddress.getText();
            String NQualification= JTFNQualification.getText();
            String NDepartment= String.valueOf(JCBNDepartment.getSelectedItem());
            String NBloodGroup= String.valueOf(JCBNBloodGroup.getSelectedItem());
            long NPhoneNumber= Long.parseLong(JTFNPhoneNumber.getText());

            //Current Nurse
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,uname,pass);
                Statement st= con.createStatement();
                String query= "Select * from Nurse where N_Id = '"+NId+"'";
                ResultSet rs= st.executeQuery(query);
                String query1= "update Nurse set  N_Name = ?, N_Address = ?, N_Qualification = ?, N_Department = ?, N_BloodGroup = ?, N_PhoneNumber = ? where N_Id = ?";
                if (rs.next())
                {
                    int DbNId= rs.getInt("N_Id");
                    if (NId==DbNId)
                    {
                        PreparedStatement pst= con.prepareStatement(query1);
                        pst.setString(1,NName);
                        pst.setString(2,NAddress);
                        pst.setString(3,NQualification);
                        pst.setString(4,NDepartment);
                        pst.setString(5,NBloodGroup);
                        pst.setLong(6,NPhoneNumber);
                        pst.setInt(7,NId);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Update record successful");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Nurse Id not found!!");
                    }
                }
            }

            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex);
            }

            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }

            //All Nurse
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,uname,pass);
                Statement st= con.createStatement();
                String query= "Select * from Nurse where N_Id = '"+NId+"'";
                ResultSet rs= st.executeQuery(query);
                String query1= "update AllNurse set  N_Name = ?, N_Address = ?, N_Qualification = ?, N_Department = ?, N_BloodGroup = ?, N_PhoneNumber = ? where N_Id = ?";
                if (rs.next())
                {
                    int DbNId= rs.getInt("N_Id");
                    if (NId==DbNId)
                    {
                        PreparedStatement pst= con.prepareStatement(query1);
                        pst.setString(1,NName);
                        pst.setString(2,NAddress);
                        pst.setString(3,NQualification);
                        pst.setString(4,NDepartment);
                        pst.setString(5,NBloodGroup);
                        pst.setLong(6,NPhoneNumber);
                        pst.setInt(7,NId);
                        pst.executeUpdate();
                        //JOptionPane.showMessageDialog(null,"Update record successful");
                    }
                    else
                    {
                       // JOptionPane.showMessageDialog(null,"Nurse Id not found!!");
                    }
                }
            }

            catch (SQLException ex)
            {
                //JOptionPane.showMessageDialog(null, ex);
            }

            catch (Exception e)
            {
                //JOptionPane.showMessageDialog(null,e);
            }

        }

        else if(evtNurse.getSource()==JBNAdd)
        {
            int NId= Integer.parseInt(JTFNId.getText());
            String NName= JTFNName.getText();
            String NAddress= JTFNAddress.getText();
            String NQualification= JTFNQualification.getText();
            String NDepartment= String.valueOf(JCBNDepartment.getSelectedItem());
            String NBloodGroup= String.valueOf(JCBNBloodGroup.getSelectedItem());
            long NPhoneNumber= Long.parseLong(JTFNPhoneNumber.getText());

            //Current Nurse
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,uname,pass);
                Statement st= con.createStatement();
                String query= "insert into Nurse ( N_Id, N_Name, N_Address , N_Qualification, N_Department, N_BloodGroup, N_PhoneNumber)values(?,?,?,?,?,?,?)";
                PreparedStatement pst= con.prepareStatement(query);
                pst.setInt(1,NId);
                pst.setString(2,NName);
                pst.setString(3,NAddress);
                pst.setString(4,NQualification);
                pst.setString(5,NDepartment);
                pst.setString(6,NBloodGroup);
                pst.setLong(7,NPhoneNumber);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Add record successful");

            }

            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex);
            }

            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }

            //All Nurse
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,uname,pass);
                Statement st= con.createStatement();
                String query= "insert into AllNurse ( N_Id, N_Name, N_Address , N_Qualification, N_Department, N_BloodGroup, N_PhoneNumber)values(?,?,?,?,?,?,?)";
                PreparedStatement pst= con.prepareStatement(query);
                pst.setInt(1,NId);
                pst.setString(2,NName);
                pst.setString(3,NAddress);
                pst.setString(4,NQualification);
                pst.setString(5,NDepartment);
                pst.setString(6,NBloodGroup);
                pst.setLong(7,NPhoneNumber);
                pst.executeUpdate();
                //JOptionPane.showMessageDialog(null,"Add record successful");

            }

            catch (SQLException ex)
            {
                //JOptionPane.showMessageDialog(null, ex);
            }

            catch (Exception e)
            {
                //JOptionPane.showMessageDialog(null,e);
            }
        }

        else if(evtNurse.getSource()==JBNDelete)
        {
            int NId= Integer.parseInt(JTFNId.getText());//fetching nurse id from GUI
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,uname,pass);
                String query= "delete from Nurse where N_Id = '"+NId+"' ";
                PreparedStatement pst= con.prepareStatement(query);
                JOptionPane.showMessageDialog(null, "Delete record Successful");
                JTFNId.setText("");
                JTFNName.setText("");
                JTFNAddress.setText("");
                JCBNDepartment.setSelectedItem("");
                JTFNQualification.setText("");
                JCBNBloodGroup.setSelectedIndex(0);
                JTFNPhoneNumber.setText("");
                pst.executeUpdate();
            }

            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex);
            }

            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }

        else if(evtNurse.getSource()==JBNGetData)
        {
            int NId= Integer.parseInt(JTFNId.getText());//fetching nurse id from GUI
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,uname,pass);
                String query= "select * from Nurse where N_Id = '"+NId+"' ";
                Statement st= con.createStatement();
                ResultSet rs= st.executeQuery(query);
                if (rs.next())
                {
                    String DBNId= String.valueOf(rs.getInt("N_Id"));
                    String DBNName= rs.getString("N_Name");
                    String DBNAddress= rs.getString("N_Address");
                    String DBNQualification= rs.getString("N_Qualification");
                    String DBNDepartment= rs.getString("N_Department");
                    String DBNBloodgroup= rs.getString("N_BloodGroup");
                    String DBNPhoneNumber= String.valueOf(rs.getLong("N_PhoneNumber"));
                    JTFNId.setText(DBNId);
                    JTFNName.setText(DBNName);
                    JTFNAddress.setText(DBNAddress);
                    JTFNQualification.setText(DBNQualification);
                    JCBNDepartment.setSelectedItem(DBNDepartment);
                    JCBNBloodGroup.setSelectedItem(DBNBloodgroup);
                    JTFNPhoneNumber.setText(DBNPhoneNumber);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Record not found!");
                    JTFNId.setText("");
                    JTFNName.setText("");
                    JTFNAddress.setText("");
                    JCBNDepartment.setSelectedIndex(0);
                    JTFNQualification.setText("");
                    JCBNBloodGroup.setSelectedIndex(0);
                    JTFNPhoneNumber.setText("");
                }
            }

            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex);
            }

            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }

        else if (evtNurse.getSource()==JBClear)
        {
            JTFNId.setText("");
            JTFNName.setText("");
            JTFNAddress.setText("");
            JCBNDepartment.setSelectedIndex(0);
            JTFNQualification.setText("");
            JCBNBloodGroup.setSelectedIndex(0);
            JTFNPhoneNumber.setText("");
        }

        else if(evtNurse.getSource()==JBGenerateId)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,uname,pass);
                String countBill= "select * from AllNurse";
                int count=1;
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(countBill);
                while (rs.next())
                {
                    count=count+1;
                }
                String sCount=String.valueOf(count);
                JTFNId.setText(sCount);
            }
            catch (Exception e)
            {

            }
        }

        else if(evtNurse.getSource()==JMICurrentNurse)
        {
            JFrame jf=new JFrame();
            NurseTable pt =new NurseTable();
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jf.setTitle("Nurse Record");
            jf.setVisible(true);
            jf.setSize(410,510);
            jf.setResizable(false);
            jf.add(pt);
            jf.setLocationRelativeTo(null);
        }

        else if(evtNurse.getSource()==JMIAllNurse)
        {
            JFrame jf=new JFrame();
            AllNurseTable pt =new AllNurseTable();
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jf.setTitle("AllNurse Record");
            jf.setVisible(true);
            jf.setSize(1210,510);
            jf.setResizable(false);
            jf.add(pt);
            jf.setLocationRelativeTo(null);
        }

        else if(evtNurse.getSource()==JMIExitApplication)
        {
            System.exit(0);
        }

        else if(evtNurse.getSource()==JMIAbout)
        {
            JOptionPane.showMessageDialog(null, "-This app is developed by Akshat Singhal. \n-BCA 5th sem (R.NO.08) \n-Minor project \n-HOSPITAL MANAGEMENT SYSTEM \n-In future this app is getting  updates as per requirements \n-©Copyright 2023 Akshat Singhal &Co. All Rights Reserved. \n-CONTACT US The Akshat Singhal &Co. is managed by Akshat Singhal, Inc. \n-Email us: akkisinghal2510@gmail.com  ","About",JOptionPane.PLAIN_MESSAGE);
        }

        else if(evtNurse.getSource()==JMIAboutPage)
        {
            JOptionPane.showMessageDialog(null,"All fields are mandatory for add record and update record. \n only Id no is mandatory for Get data and delete record \nId no='0-9' \nName='a-z , A-z , Space' \nAddress='a-z , A-z , Space' \nQualification='a-z , A-z , Special characters' \nDepartment='Select any of them' \nBlood Group='Select any one of them' \nPhone Number='0-9' \n\nif any information is not known please enter 'null' , 'Null' and in Mobile Number=00");
        }
    }

    public static void main(String[] args) 
    {
        new Nurse();
    }
}
