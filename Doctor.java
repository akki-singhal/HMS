package HMSP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;

public class Doctor extends JFrame implements ActionListener
{
    JMenuBar JMB;

    JMenu JMExit, JMHelp;

    JMenuItem JMIExitApplication, JMIAbout,  JMIAboutPage,JMICurrentDoctor, JMIDoctorHistory;
    
    JLabel JLHName, JLDLogo , JLDId, JLDName, JLDFName, JLDAge, JLDPhoneNumber, JLDGender, JLDFees, JLDAddress, JLDDepartment, JLDQualification, JLDJoiningDate, JLDBGroup;

    JTextField JTFDId, JTFDName, JTFDFName, JTFDAge, JTFDPhoneNumber, JTFDFees, JTFDAddress,  JTFDQualification, JTFDJoiningDate, JTFDateFormat;

    JButton JBMainPage, JBAdd, JBGetData, JBUpdate, JBDelete, JBClear, JBGenerateId;

    ImageIcon IIDoctorLogo, IIMainPage, IIUpdateRecord, IIAddRecord, IIDeleteRecord, IIGetData, IIClearForm, IIGenerateId;

    JRadioButton JRBDMale ,JRBDFemale, JRBDOther;

    JComboBox JCBDBloodGroup, JCBDDepartment;
    
    Doctor()
    {
        setSize(900,720);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Doctor Detail");
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
        IIClearForm= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Clear.png")));
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

       // Help menu
        JMHelp= new JMenu("Help");
        JMB.add(JMHelp);

        JMIAbout= new JMenuItem("About");
        JMIAbout.addActionListener(this);
        JMHelp.add(JMIAbout);

        JMIAboutPage= new JMenuItem("About Page");
        JMIAboutPage.addActionListener(this);
        JMHelp.add(JMIAboutPage);

        JMICurrentDoctor= new JMenuItem("Current Doctors");
        JMICurrentDoctor.addActionListener(this);
        JMHelp.add(JMICurrentDoctor);

        JMIDoctorHistory=new JMenuItem("All Doctors");
        JMIDoctorHistory.addActionListener(this);
        JMHelp.add(JMIDoctorHistory);

        // Doctor Image Icon
        IIDoctorLogo= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Doctor.png")));
        JLDLogo= new JLabel(IIDoctorLogo);
        JLDLogo.setBounds(600,80,220,220);
        add(JLDLogo);

        // Hospital name label
        JLHName= new JLabel("Vardhman Hospital");
        JLHName.setBounds(350, 20, 300, 30);
        add(JLHName);

        //Doctor ID
        JLDId=new JLabel("ID NO:");
        JLDId.setBounds(30,70,100,30);
        add(JLDId);

        JTFDId=new JTextField();
        JTFDId.setBounds(150, 70, 200, 30);
        add(JTFDId);

        //Doctor Name
        JLDName=new JLabel("Name:");
        JLDName.setBounds(30,120,100,30);
        add(JLDName);

        JTFDName=new JTextField();
        JTFDName.setBounds(150, 120, 200, 30);
        add(JTFDName);

        //Doctor Father Name
        JLDFName=new JLabel("Father's Name:");
        JLDFName.setBounds(30,170,100,30);
        add(JLDFName);

        JTFDFName=new JTextField();
        JTFDFName.setBounds(150, 170, 200, 30);
        add(JTFDFName);

        //Doctor Age
        JLDAge=new JLabel("Age:");
        JLDAge.setBounds(30,220,100,30);
        add(JLDAge);

        JTFDAge=new JTextField();
        JTFDAge.setBounds(150, 220, 200, 30);
        add(JTFDAge);

        //Doctor Phone number
        JLDPhoneNumber=new JLabel("Phone Number:");
        JLDPhoneNumber.setBounds(30,270,100,30);
        add(JLDPhoneNumber);

        JTFDPhoneNumber=new JTextField();
        JTFDPhoneNumber.setBounds(150, 270, 200, 30);
        add(JTFDPhoneNumber);

        //Doctor Gender
        JLDGender=new JLabel("Gender:");
        JLDGender.setBounds(30,320,100,30);
        add(JLDGender);

        JRBDMale= new JRadioButton("Male");
        JRBDMale.setBounds(150, 320,70,30 );


        JRBDFemale= new JRadioButton("Female");
        JRBDFemale.setBounds(220, 320,90,30 );


        JRBDOther= new JRadioButton("Other");
        JRBDOther.setBounds(300, 320,70,30 );


        ButtonGroup BGDGender= new ButtonGroup();
        BGDGender.add(JRBDMale);
        BGDGender.add(JRBDFemale);
        BGDGender.add(JRBDOther);

        add(JRBDMale);
        add(JRBDFemale);
        add(JRBDOther);


        //Doctor Fees
        JLDFees=new JLabel("Per Day Fees:");
        JLDFees.setBounds(30,370,100,30);
        add(JLDFees);

        JTFDFees=new JTextField();
        JTFDFees.setBounds(150, 370, 200, 30);
        add(JTFDFees);

        //Doctor Address
        JLDAddress=new JLabel("Address:");
        JLDAddress.setBounds(30,420,100,30);
        add(JLDAddress);

        JTFDAddress=new JTextField();
        JTFDAddress.setBounds(150, 420, 200, 30);
        add(JTFDAddress);

        //Doctor Department
        JLDDepartment=new JLabel("Department:");
        JLDDepartment.setBounds(30,470,100,30);
        add(JLDDepartment);


        String[] department={"--Select--","Joint Replacement", "Orthopaedics", "Trauma", "Gynaecology", "Obstetrics",  "IVF"};
        JCBDDepartment=new JComboBox<>(department);
        JCBDDepartment.setBounds(150,470,200,30);
        add(JCBDDepartment);

        //Doctor Qualification
        JLDQualification=new JLabel("Qualification:");
        JLDQualification.setBounds(30,520,100,30);
        add(JLDQualification);

        JTFDQualification=new JTextField();
        JTFDQualification.setBounds(150, 520, 200, 30);
        add(JTFDQualification);

        //Doctor Joining Date
        JLDJoiningDate=new JLabel("Joining Date:");
        JLDJoiningDate.setBounds(30,570,100,30);
        add(JLDJoiningDate);

 
        JTFDJoiningDate=new JTextField();
        JTFDJoiningDate.setBounds(150, 570, 200, 30);
        add(JTFDJoiningDate);

        JTFDateFormat= new JTextField("DD/MM/YYYY");
        JTFDateFormat.setBounds(370,570,100,30);
        add(JTFDateFormat);
        JTFDateFormat.setEditable(false);

        //Doctor BloodGroup
        JLDBGroup=new JLabel("Blood Group:");
        JLDBGroup.setBounds(30,620,100,30);
        add(JLDBGroup);

        String[] BloodGroup ={"-Select-", "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+" };
        JCBDBloodGroup =new JComboBox<>(BloodGroup);
        JCBDBloodGroup.setBounds(150, 620, 200, 30);
        add(JCBDBloodGroup);
        

        //Main page button
        JBMainPage= new JButton("Main Page",IIMainPage);
        JBMainPage.setBounds(600,330,150,30);
        JBMainPage.addActionListener(this);
        add(JBMainPage);

        //Update record button
        JBUpdate= new JButton("Update Record",IIUpdateRecord);
        JBUpdate.setBounds(600,370,150,30);
        JBUpdate.addActionListener(this);
        add(JBUpdate);

        //save record button
        JBAdd= new JButton("Add Record",IIAddRecord);
        JBAdd.setBounds(600,410,150,30);
        JBAdd.addActionListener(this);
        add(JBAdd);

        //Delete record button
        JBDelete= new JButton("Delete Record",IIDeleteRecord);
        JBDelete.setBounds(600,450,150,30);
        JBDelete.addActionListener(this);
        add(JBDelete);

        //Get data button
        JBGetData=new JButton("Get Data",IIGetData);
        JBGetData.setBounds(600,490,150,30);
        JBGetData.addActionListener(this);
        add(JBGetData);

        //Clear Button
        JBClear= new JButton("Clear form",IIClearForm );
        JBClear.setBounds(600,530,150,30);
        JBClear.addActionListener(this);
        add(JBClear);

        //Generate doctor id
        JBGenerateId= new JButton("",IIGenerateId);
        JBGenerateId.setBounds(370,70,40,30);
        JBGenerateId.addActionListener(this);
        add(JBGenerateId);
    }

    String url="jdbc:mysql://localhost:3306/HospitalMgtSystem";
    String Uname="root";
    String pass="@Tiger123";

    public void actionPerformed(ActionEvent evtDoctor)
    {
        if(evtDoctor.getSource()==JBMainPage)
        {
            dispose();
            new MainPage();
        }

        else if(evtDoctor.getSource()==JBUpdate)
        {

            int DId= Integer.parseInt(JTFDId.getText());//fetching doctor id from GUI
            String DName= JTFDName.getText();//fetching doctor name from GUI
            String DFName= JTFDFName.getText();//fetching doctor father name from GUI
            int DAge= Integer.parseInt(JTFDAge.getText());//fetching doctor age from GUI
            long DPhoneNumber= Long.parseLong(JTFDPhoneNumber.getText());//fetching doctor phone number from GUI
            //fetching doctor gender from GUI
            String DGender= "null";
            if(JRBDMale.isSelected())
            {
                DGender= "M";
            }
            else if(JRBDFemale.isSelected())
            {
                DGender= "F";
            }
            else if(JRBDOther.isSelected())
            {
                DGender= "O";
            }


            int DFees= Integer.parseInt(JTFDFees.getText());//fetching doctor fees from GUI
            String DAddress= JTFDAddress.getText();//fetching doctor address from GUI
            String DDepartment= String.valueOf(JCBDDepartment.getSelectedItem());//fetching doctor department from GUI
            String DQualification= JTFDQualification.getText();//fetching doctor qualification from GUI
            String DJoiningDate= JTFDJoiningDate.getText();//fetching doctor joining date from GUI
            String DBloodGroup= String.valueOf(JCBDBloodGroup.getSelectedItem());//fetching doctor blood group from GUI
            //Doctor Table
            {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, Uname, pass);
                    Statement st = con.createStatement();
                    String query = "Select * from Doctor where Dr_Id = '" + DId + "'";
                    ResultSet rs = st.executeQuery(query);
                    String query1 = "update Doctor set Dr_Name = ? , Dr_FName = ? , Dr_Age = ? , Dr_PhoneNumber = ? , Dr_Gender = ? , Dr_Fees = ? , Dr_Address = ? , Dr_Department = ? , Dr_Qualification = ? , Dr_JoiningDate = ? , Dr_BloodGroup = ? where Dr_Id = ? ";
                    if (rs.next()) {
                        int DbDId = rs.getInt("Dr_Id");

                        if (DId == (DbDId)) {
                            PreparedStatement pst = con.prepareStatement(query1);
                            pst.setString(1, DName);
                            pst.setString(2, DFName);
                            pst.setInt(3, DAge);
                            pst.setLong(4, DPhoneNumber);
                            pst.setString(5, DGender);
                            pst.setInt(6, DFees);
                            pst.setString(7, DAddress);
                            pst.setString(8, DDepartment);
                            pst.setString(9, DQualification);
                            pst.setString(10, DJoiningDate);
                            pst.setString(11, DBloodGroup);
                            pst.setInt(12, DId);
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Update record successfully");
                        } else {
                            JOptionPane.showMessageDialog(null, "Doctor id not found");
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            //All Doctor Table
            {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, Uname, pass);
                    Statement st = con.createStatement();
                    String query = "Select * from AllDoctor where Dr_Id = '" + DId + "'";
                    ResultSet rs = st.executeQuery(query);
                    String query1 = "update AllDoctor set Dr_Name = ? , Dr_FName = ? , Dr_Age = ? , Dr_PhoneNumber = ? , Dr_Gender = ? , Dr_Fees = ? , Dr_Address = ? , Dr_Department = ? , Dr_Qualification = ? , Dr_JoiningDate = ? , Dr_BloodGroup = ? where Dr_Id = ? ";
                    if (rs.next()) {
                        int DbDId = rs.getInt("Dr_Id");

                        if (DId == (DbDId)) {
                            PreparedStatement pst = con.prepareStatement(query1);
                            pst.setString(1, DName);
                            pst.setString(2, DFName);
                            pst.setInt(3, DAge);
                            pst.setLong(4, DPhoneNumber);
                            pst.setString(5, DGender);
                            pst.setInt(6, DFees);
                            pst.setString(7, DAddress);
                            pst.setString(8, DDepartment);
                            pst.setString(9, DQualification);
                            pst.setString(10, DJoiningDate);
                            pst.setString(11, DBloodGroup);
                            pst.setInt(12, DId);
                            pst.executeUpdate();
                            //JOptionPane.showMessageDialog(null, "Update record successfully");
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
            }

        }

        else if(evtDoctor.getSource()==JBAdd)
        {
            int DId = Integer.parseInt(JTFDId.getText());//fetching doctor id from GUI
            String DName = JTFDName.getText();//fetching doctor name from GUI
            String DFName = JTFDFName.getText();//fetching doctor father name from GUI
            int DAge = Integer.parseInt(JTFDAge.getText());//fetching doctor age from GUI
            long DPhoneNumber = Long.parseLong(JTFDPhoneNumber.getText());//fetching doctor phone number from GUI

            //fetching doctor gender from GUI
            String DGender = null;
            if (JRBDMale.isSelected()) {
                DGender = "M";
            } else if (JRBDFemale.isSelected()) {
                DGender = "F";
            } else if (JRBDOther.isSelected()) {
                DGender = "O";
            }

            int DFees = Integer.parseInt(JTFDFees.getText());//fetching doctor fees from GUI
            String DAddress = JTFDAddress.getText();//fetching doctor address from GUI
            String DDepartment = String.valueOf(JCBDDepartment.getSelectedItem());//fetching doctor department from GUI
            String DQualification = JTFDQualification.getText();//fetching doctor qualification from GUI
            String DJoiningDate = JTFDJoiningDate.getText();//fetching doctor joining date from GUI
            //JTFDAddress.setText("qwerty");
            String DBloodGroup = String.valueOf(JCBDBloodGroup.getSelectedItem());//fetching doctor blood group from GUI

            //Doctor table
            {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, Uname, pass);
                    Statement st = con.createStatement();
                    String query = "insert into Doctor(Dr_Id , Dr_Name , Dr_FName , Dr_Age , Dr_PhoneNumber , Dr_Gender , Dr_Fees , Dr_Address , Dr_Department , Dr_Qualification , Dr_JoiningDate , Dr_BloodGroup )values(?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setInt(1, DId);
                    pst.setString(2, DName);
                    pst.setString(3, DFName);
                    pst.setInt(4, DAge);
                    pst.setLong(5, DPhoneNumber);
                    pst.setString(6, DGender);
                    pst.setInt(7, DFees);
                    pst.setString(8, DAddress);
                    pst.setString(9, DDepartment);
                    pst.setString(10, DQualification);
                    pst.setString(11, DJoiningDate);
                    pst.setString(12, DBloodGroup);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Add record successfully");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }

            //All Doctor Table
            {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, Uname, pass);
                    Statement st = con.createStatement();
                    String query = "insert into AllDoctor(Dr_Id , Dr_Name , Dr_FName , Dr_Age , Dr_PhoneNumber , Dr_Gender , Dr_Fees , Dr_Address , Dr_Department , Dr_Qualification , Dr_JoiningDate , Dr_BloodGroup )values(?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setInt(1, DId);
                    pst.setString(2, DName);
                    pst.setString(3, DFName);
                    pst.setInt(4, DAge);
                    pst.setLong(5, DPhoneNumber);
                    pst.setString(6, DGender);
                    pst.setInt(7, DFees);
                    pst.setString(8, DAddress);
                    pst.setString(9, DDepartment);
                    pst.setString(10, DQualification);
                    pst.setString(11, DJoiningDate);
                    pst.setString(12, DBloodGroup);

                    pst.executeUpdate();
                    //JOptionPane.showMessageDialog(null, "Add record successfully");

                } catch (SQLException ex)
                {
                    //JOptionPane.showMessageDialog(null, ex);
                } catch (Exception e)
                {
                    //JOptionPane.showMessageDialog(null,e);
                }
            }
        }

        else if(evtDoctor.getSource()==JBDelete)
        {
            int DId= Integer.parseInt(JTFDId.getText());//fetching doctor id from GUI
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,Uname,pass);
                String query= "delete from Doctor where Dr_Id = '"+DId+"' ";
                PreparedStatement pst= con.prepareStatement(query);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Delete record Successful");

                JTFDId.setText("");
                JTFDName.setText("");
                JTFDFName.setText("");
                JTFDAge.setText("");
                JTFDPhoneNumber.setText("");
                JRBDMale.setSelected(true);
                JTFDFees.setText("");
                JTFDAddress.setText("");
                JCBDDepartment.setSelectedIndex(0);
                JTFDQualification.setText("");
                JTFDJoiningDate.setText("");
                JCBDBloodGroup.setSelectedIndex(0);
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

        else if(evtDoctor.getSource()==JBGetData)
        {
            int DId= Integer.parseInt(JTFDId.getText());//fetching doctor id from GUI
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,Uname,pass);
                Statement st= con.createStatement();
                String query= "Select * from Doctor where Dr_Id= '"+DId+"'  ";
                ResultSet rs= st.executeQuery(query);
                if(rs.next())
                {
                    String DbDName = rs.getString("Dr_Name");
                    String DbDFName = rs.getString("Dr_FName");
                    String DbDAge = String.valueOf(rs.getInt("Dr_Age"));
                    String DbDPhoneNumber = String.valueOf(rs.getLong("Dr_PhoneNumber"));
                    String DbDGender = rs.getString("Dr_Gender");
                    String DbDFees = String.valueOf(rs.getInt("Dr_Fees"));
                    String DbDAddress = rs.getString("Dr_Address");
                    String DbDDepartment = rs.getString("Dr_Department");
                    String DBDQualification = rs.getString("Dr_Qualification");
                    String DbDJoiningDate = rs.getString("Dr_JoiningDate");
                    String DbDBloodGroup = rs.getString("Dr_BloodGroup");
                    JTFDName.setText(DbDName);
                    JTFDFName.setText(DbDFName);
                    JTFDAge.setText(DbDAge);
                    JTFDPhoneNumber.setText(DbDPhoneNumber);
                    if(DbDGender.equalsIgnoreCase("m"))
                    {
                        JRBDMale.setSelected(true);
                    }
                    else if(DbDGender.equalsIgnoreCase("f"))
                    {
                        JRBDFemale.setSelected(true);
                    }
                    else if(DbDGender.equalsIgnoreCase("o"))
                    {
                        JRBDOther.setSelected(true);
                    }
                    JTFDFees.setText(DbDFees);
                    JTFDAddress.setText(DbDAddress);
                    JCBDDepartment.setSelectedItem(DbDDepartment);
                    JTFDQualification.setText(DBDQualification);
                    JTFDJoiningDate.setText(DbDJoiningDate);
                    JCBDBloodGroup.setSelectedItem(DbDBloodGroup);
                }

                else
                {
                    JOptionPane.showMessageDialog(null, "No Doctor Found!");
                    JTFDId.setText("");
                    JTFDName.setText("");
                    JTFDFName.setText("");
                    JTFDAge.setText("");
                    JTFDPhoneNumber.setText("");
                    JRBDMale.setSelected(true);
                    JTFDFees.setText("");
                    JTFDAddress.setText("");
                    JCBDDepartment.setSelectedIndex(0);
                    JTFDQualification.setText("");
                    JTFDJoiningDate.setText("");
                    JCBDBloodGroup.setSelectedIndex(0);
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

        else if (evtDoctor.getSource()==JBClear)
        {

            JTFDId.setText("");
            JTFDName.setText("");
            JTFDFName.setText("");
            JTFDAge.setText("");
            JTFDPhoneNumber.setText("");
            JRBDMale.setSelected(true);
            JTFDFees.setText("");
            JTFDAddress.setText("");
            JCBDDepartment.setSelectedIndex(0);
            JTFDQualification.setText("");
            JTFDJoiningDate.setText("");
            JCBDBloodGroup.setSelectedIndex(0);
        }

        else if (evtDoctor.getSource()==JMICurrentDoctor)
        {
            JFrame jf=new JFrame();
            DoctorTable pt =new DoctorTable();
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jf.setTitle("Doctor Record");
            jf.setVisible(true);
            jf.setSize(410,510);
            jf.setResizable(false);
            jf.add(pt);
            jf.setLocationRelativeTo(null);
        }

        else if(evtDoctor.getSource()==JMIDoctorHistory)
        {
            JFrame jf=new JFrame();
            AllDoctorTable pt =new AllDoctorTable();
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jf.setTitle("All Doctors Record");
            jf.setVisible(true);
            jf.setSize(1410,510);
            jf.setResizable(false);
            jf.add(pt);
            jf.setLocationRelativeTo(null);
        }

        else if(evtDoctor.getSource()==JBGenerateId)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,Uname,pass);
                String countBill= "select * from AllDoctor";
                int count=1;
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(countBill);
                while (rs.next())
                {
                    count=count+1;
                }
                String sCount=String.valueOf(count);
                JTFDId.setText(sCount);
            }
            catch (Exception e)
            {

            }
        }

        else if(evtDoctor.getSource()==JMIAboutPage)
        {
            JOptionPane.showMessageDialog(null,"All fields are mandatory to fill for Update record & Add record.\n Id No is mandatory for Delete record & Get data \nId no= '0-9' \nName= 'a-z , A-Z , space'\nFather Name= 'a-z , A-Z , space' \nAge= '0-9' \nMobile Number='0-9'only 10 digit \n Gender='Select ay one of them' \nPer day fees='0-9' \nAddress='a-z , A-Z , space, Special characters' \nDepartment='a-z , A-Z , space' \nQualification='a-z , A-Z , space' \nJoining date='DD/MM/YYYY' \nBlood group='Select any one of them' \n\nIf any information is  not known please enter 'null' or 'Null' and in Mobile Number='00' ");
        }

        else if(evtDoctor.getSource()==JMIExitApplication)
        {
            System.exit(0);
        }

        else if(evtDoctor.getSource()==JMIAbout)
        {
            JOptionPane.showMessageDialog(null, "-This app is developed by Akshat Singhal. \n-BCA 5th sem (R.NO.08) \n-Minor project \n-HOSPITAL MANAGEMENT SYSTEM \n-In future this app is getting  updates as per requirements \n-©Copyright 2023 Akshat Singhal &Co. All Rights Reserved. \n-CONTACT US The Akshat Singhal &Co. is managed by Akshat Singhal, Inc. \n-Email us: akkisinghal2510@gmail.com  ","About",JOptionPane.PLAIN_MESSAGE);
            
        }
    }


    public static void main(String[] args) 
    {
        new Doctor();
    }
}
