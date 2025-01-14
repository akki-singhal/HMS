package HMSP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;

class Patient extends JFrame implements ActionListener
{
    JMenuBar JMB;

    JMenu JMExit, JMHelp;

    JMenuItem JMIExitApplication, JMIAbout, JMIAboutPage ,JMICurrentPatient, JMIAllPatient;

    JLabel JLHName, JLPLogo , JLPId, JLPName, JLPAddress, JLPAge, JLPPhoneNumber, JLPGender, JLPDisease, JLPBGroup, JLPAdmitDate, JLPDischargeDate, JLPNurse, JLPRoomNumber, JLPDoctor, JLPInformation;

    JTextField JTFPId, JTFPName, JTFPAddress, JTFPAge, JTFPPhoneNumber, JTFPDisease,  JTFPAdmitDate, JTFPDischargeDate, JTFPAdmitDateFormat, JTFPDischargeDateFormat;

    JTextArea JTAPInformation;

    JButton JBMainPage, JBAdd, JBGetData, JBUpdate, JBDelete, JBClear, JBGenerateId;

    ImageIcon IIPLogo, IIMainPage, IIUpdateRecord, IIAddRecord, IIDeleteRecord, IIGetData, IIClear, IIGenerateId;
    JRadioButton JRBPMale ,JRBPFemale, JRBPOther;


    JComboBox JCBPBloodGroup, JCBRType, JCBRNumber, JCBPDoctorName, JCBPDepartment, JCBPNurseName;
    
    Patient()
    {
        setSize(900,870);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Patient Detail");
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
        IIClear = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Clear.png")));
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

        JMICurrentPatient= new JMenuItem("Current Patient");
        JMICurrentPatient.addActionListener(this);
        JMHelp.add(JMICurrentPatient);

        JMIAllPatient= new JMenuItem("All Patient");
        JMIAllPatient.addActionListener(this);
       JMHelp.add(JMIAllPatient);

        // Patient Image Logo
        IIPLogo= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Patient.jpeg")));
        JLPLogo= new JLabel(IIPLogo);
        JLPLogo.setBounds(600,80,220,220);
        add(JLPLogo);

        // Hospital name label
        JLHName= new JLabel("Vardhman Hospital");
        JLHName.setBounds(350, 20, 300, 30);
        add(JLHName);

        //Patient ID
        JLPId=new JLabel("ID NO:");
        JLPId.setBounds(30,70,100,30);
        add(JLPId);

        JTFPId=new JTextField();
        JTFPId.setBounds(150, 70, 200, 30);
        add(JTFPId);

        //Patient Name
        JLPName=new JLabel("Name:");
        JLPName.setBounds(30,120,100,30);
        add(JLPName);

        JTFPName=new JTextField();
        JTFPName.setBounds(150, 120, 200, 30);
        add(JTFPName);

        //Patient Address
        JLPAddress=new JLabel("Address:");
        JLPAddress.setBounds(30,170,100,30);
        add(JLPAddress);

        JTFPAddress=new JTextField();
        JTFPAddress.setBounds(150, 170, 200, 30);
        add(JTFPAddress);

        //Patient Age
        JLPAge=new JLabel("Age:");
        JLPAge.setBounds(30,220,100,30);
        add(JLPAge);

        JTFPAge=new JTextField();
        JTFPAge.setBounds(150, 220, 200, 30);
        add(JTFPAge);

        //Patient Phone number
        JLPPhoneNumber=new JLabel("Phone Number:");
        JLPPhoneNumber.setBounds(30,270,100,30);
        add(JLPPhoneNumber);

        JTFPPhoneNumber=new JTextField();
        JTFPPhoneNumber.setBounds(150, 270, 200, 30);
        add(JTFPPhoneNumber);

        //Patient Gender
        JLPGender=new JLabel("Gender:");
        JLPGender.setBounds(30,320,100,30);
        add(JLPGender);

    
        JRBPMale= new JRadioButton("Male");
        JRBPMale.setBounds(150, 320,70,30 );
        

        JRBPFemale= new JRadioButton("Female");
        JRBPFemale.setBounds(220, 320,90,30 );
        
        JRBPOther= new JRadioButton("Other");
        JRBPOther.setBounds(300, 320,70,30 );
        
        ButtonGroup BGPGender =new ButtonGroup();
        BGPGender.add(JRBPMale);
        BGPGender.add(JRBPFemale);
        BGPGender.add(JRBPOther);

        add(JRBPMale);
        add(JRBPFemale);
        add(JRBPOther);


        //Patient Disease
        JLPDisease=new JLabel("Disease:");
        JLPDisease.setBounds(30,370,100,30);
        add(JLPDisease);

        JTFPDisease=new JTextField();
        JTFPDisease.setBounds(150, 370, 200, 30);
        add(JTFPDisease);

        //Patient Blood group
        JLPBGroup=new JLabel("Blood Group:");
        JLPBGroup.setBounds(30,420,100,30);
        add(JLPBGroup);

        String[] bloodGroup ={"-Select-", "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+" };
        JCBPBloodGroup =new JComboBox<>(bloodGroup);
        JCBPBloodGroup.setBounds(150, 420, 200, 30);
        add(JCBPBloodGroup);

        //Patient Admit date
        JLPAdmitDate=new JLabel("Admit Date:");
        JLPAdmitDate.setBounds(30,470,100,30);
        add(JLPAdmitDate);

        JTFPAdmitDate=new JTextField();
        JTFPAdmitDate.setBounds(150, 470, 200, 30);
        add(JTFPAdmitDate);

        JTFPAdmitDateFormat=new JTextField("Format: DD/MM/YYYY");
        JTFPAdmitDateFormat.setBounds(370,470,200,30);
        add(JTFPAdmitDateFormat);
        JTFPAdmitDateFormat.setEditable(false);

        //Patient Discharge date
        JLPDischargeDate=new JLabel("Discharge Date:");
        JLPDischargeDate.setBounds(30,520,100,30);
        add(JLPDischargeDate);

        JTFPDischargeDate=new JTextField();
        JTFPDischargeDate.setBounds(150, 520, 200, 30);
        add(JTFPDischargeDate);

        JTFPDischargeDateFormat=new JTextField("Format:DD/MM/YYYY");
        JTFPDischargeDateFormat.setBounds(370,520,200,30);
        add(JTFPDischargeDateFormat);
        JTFPDischargeDateFormat.setEditable(false);

        //Patient Nurse
        JLPNurse=new JLabel("Nurse:");
        JLPNurse.setBounds(30,570,100,30);
        add(JLPNurse);


        String[] department={"--Select--","Joint Replacement", "Orthopaedics", "Trauma", "Gynaecology", "Obstetrics",  "IVF"};
        JCBPDepartment=new JComboBox<>(department);
        JCBPDepartment.setBounds(150,570,200,30);
        JCBPDepartment.addActionListener(this);
        add(JCBPDepartment);


        JCBPNurseName=new JComboBox<>();
        JCBPNurseName.setBounds(370,570,200,30);
        add(JCBPNurseName);


        //Patient Room Number
        JLPRoomNumber=new JLabel("Room Number:");
        JLPRoomNumber.setBounds(30,620,100,30);
        add(JLPRoomNumber);

        String[] roomNumber= {"--Select--","G-1","G-2","G-3","G-4","G-5","G-6","F-1","F-2","F-3","F-4","F-5","F-6","S-1","S-2","S-3","S-4","S-5","S-6","T-1","T-2","T-3","T-4","ICU-1","ICU-2"};
        JCBRNumber=new JComboBox<>(roomNumber);
        JCBRNumber.setBounds(150,620,200,30);
        JCBRNumber.addActionListener(this);
        add(JCBRNumber);


        //Room Type
        String[] roomType ={"-Select-","General","Private","Deluxe","Super Deluxe","Normal"};
        JCBRType= new JComboBox<>(roomType);
        JCBRType.setBounds(370,620,200,30);
        add(JCBRType);

        //Patient Doctor
        JLPDoctor=new JLabel("Doctor:");
        JLPDoctor.setBounds(30,670,100,30);
        add(JLPDoctor);

        JCBPDoctorName= new JComboBox<>();
        JCBPDoctorName.setBounds(150,670,200,30);
        add(JCBPDoctorName);


        //Patient Information
        JLPInformation= new JLabel("Information:");
        JLPInformation.setBounds(30,720,100,30);
        add(JLPInformation);

        JTAPInformation= new JTextArea();
        JTAPInformation.setBounds(150,720,350,60);
        add(JTAPInformation);

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
        JBAdd= new JButton("Add record",IIAddRecord);
        JBAdd.setBounds(600,410,150,30);
        JBAdd.addActionListener(this);
        add(JBAdd);

        //Delete record button
        JBDelete= new JButton("Delete record",IIDeleteRecord);
        JBDelete.setBounds(600,450,150,30);
        JBDelete.addActionListener(this);
        add(JBDelete);

        //Get data button
        JBGetData= new JButton("Get Data",IIGetData);
        JBGetData.setBounds(600,490,150,30);
        JBGetData.addActionListener(this);
        add(JBGetData);

        //clear button
        JBClear= new JButton("Clear form",IIClear);
        JBClear.setBounds(600,530,150,30);
        JBClear.addActionListener(this);
        add(JBClear);

        //Generate Patient Id button
        JBGenerateId= new JButton("",IIGenerateId);
        JBGenerateId.setBounds(370,70,40,30);
        JBGenerateId.addActionListener(this);
        add(JBGenerateId);

    }

    String url="jdbc:mysql://localhost:3306/HospitalMgtSystem";
    String Uname="root";
    String pass="@Tiger123";

    public void actionPerformed(ActionEvent evtPatient)
    {
        if(evtPatient.getSource()== JBMainPage)
        {
            new MainPage();
            dispose();
        }

        else if(evtPatient.getSource()== JBUpdate)
        {
            int PId= Integer.parseInt(JTFPId.getText());//fetching Patient id from GUI
            String PName= JTFPName.getText();//fetching Patient name from GUI
            String PAddress= JTFPAddress.getText();//fetching Patient address from GUI
            int PAge= Integer.parseInt(JTFPAge.getText());//fetching Patient age from GUI
            long PPhoneNumber= Long.parseLong(JTFPPhoneNumber.getText());//fetching Patient phone number from GUI
            //fetching Patient gender from GUI
            String PGender= null;
            if(JRBPMale.isSelected())
            {
                PGender="m";
            }
            if(JRBPFemale.isSelected())
            {
                PGender="f";
            }
            if(JRBPOther.isSelected())
            {
                PGender="o";
            }
            String PDisease= JTFPDisease.getText();//fetching Patient disease from GUI
            String PBloodGroup= String.valueOf(JCBPBloodGroup.getSelectedItem());//fetching Patient blood group from GUI
            String PAdmitDate= JTFPAdmitDate.getText();//fetching Patient admit date from GUI
            String PDischargeDate= JTFPDischargeDate.getText();//fetching Patient discharge date from GUI
            String PNurseName= String.valueOf(JCBPNurseName.getSelectedItem());//fetching Patient nurse name from GUI
            String PRoomNumber= String.valueOf(JCBRNumber.getSelectedItem());//fetching Patient room number from GUI
            String PRoomType= String.valueOf(JCBRType.getSelectedItem());//fetching Patient room type from GUI
            String PDoctorName= String.valueOf(JCBPDoctorName.getSelectedItem());//fetching Patient doctor name from GUI
            String PInformation= JTAPInformation.getText();//fetching Patient information from GUI

            //Patient table
            {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, Uname, pass);
                    Statement st = con.createStatement();
                    String query = "Select * from Patient where Pt_Id = '" + PId + "'";
                    ResultSet rs = st.executeQuery(query);
                    String query1 = "update Patient set  Pt_Name = ?, Pt_Address = ?, Pt_Age = ?, Pt_PhoneNumber = ?, Pt_Gender = ?, Pt_Disease = ?, Pt_BGroup = ?, Pt_AdmitDate = ?, Pt_DischargeDate = ?, Pt_NurseName = ?, Pt_RoomNumber = ?, Pt_RoomType = ?, Pt_DoctorName = ?, Pt_Information = ? where Pt_Id =?";
                    if (rs.next()) {
                        int DBPId = rs.getInt("Pt_Id");

                        if (PId == DBPId) {
                            PreparedStatement pst = con.prepareStatement(query1);
                            pst.setString(1, PName);
                            pst.setString(2, PAddress);
                            pst.setInt(3, PAge);
                            pst.setLong(4, PPhoneNumber);
                            pst.setString(5, PGender);
                            pst.setString(6, PDisease);
                            pst.setString(7, PBloodGroup);
                            pst.setString(8, PAdmitDate);
                            pst.setString(9, PDischargeDate);
                            pst.setString(10, PNurseName);
                            pst.setString(11, PRoomNumber);
                            pst.setString(12, PRoomType);
                            pst.setString(13, PDoctorName);
                            pst.setString(14, PInformation);
                            pst.setInt(15, PId);
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Update record successfully");


                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Patient id not found");
                        }
                        st.close();
                        rs.close();
                        con.close();
                    }
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }

            }

            //delete patient from old room
            {
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection(url,Uname,pass);
                    String s="update Room set R_Availability= 'yes', P_Id= '--', P_Name='--' where P_Id='"+PId+"' ";
                    PreparedStatement pst= con.prepareStatement(s);
                    pst.executeUpdate();
                    con.close();
                    pst.close();
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }

            }

            //Patient update room
            {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, Uname, pass);
                    String query2 = "update Room set  R_Type=?, R_Availability=?, P_Id=?, P_Name=? where R_Number=?";
                    PreparedStatement pst1 = con.prepareStatement(query2);
                    pst1.setString(1, PRoomType);
                    pst1.setString(2, "NO");
                    pst1.setInt(3, PId);
                    pst1.setString(4, PName);
                    pst1.setString(5, PRoomNumber);
                    pst1.executeUpdate();
                    con.close();
                    pst1.close();
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }
            }

            //All Patient table
            {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, Uname, pass);
                    Statement st = con.createStatement();
                    String query = "Select * from AllPatient where Pt_Id = '" + PId + "'";
                    ResultSet rs = st.executeQuery(query);
                    String query1 = "update AllPatient set  Pt_Name = ?, Pt_Address = ?, Pt_Age = ?, Pt_PhoneNumber = ?, Pt_Gender = ?, Pt_Disease = ?, Pt_BGroup = ?, Pt_AdmitDate = ?, Pt_DischargeDate = ?, Pt_NurseName = ?, Pt_RoomNumber = ?, Pt_RoomType = ?, Pt_DoctorName = ?, Pt_Information = ? where Pt_Id =?";
                    if (rs.next()) {
                        int DBPId = rs.getInt("Pt_Id");

                        if (PId == DBPId) {
                            PreparedStatement pst = con.prepareStatement(query1);
                            pst.setString(1, PName);
                            pst.setString(2, PAddress);
                            pst.setInt(3, PAge);
                            pst.setLong(4, PPhoneNumber);
                            pst.setString(5, PGender);
                            pst.setString(6, PDisease);
                            pst.setString(7, PBloodGroup);
                            pst.setString(8, PAdmitDate);
                            pst.setString(9, PDischargeDate);
                            pst.setString(10, PNurseName);
                            pst.setString(11, PRoomNumber);
                            pst.setString(12, PRoomType);
                            pst.setString(13, PDoctorName);
                            pst.setString(14, PInformation);
                            pst.setInt(15, PId);
                            pst.executeUpdate();
                            //JOptionPane.showMessageDialog(null, "Update record successfully");

                        } else {
                            //JOptionPane.showMessageDialog(null, "Patient id not found");
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
        }

        else if(evtPatient.getSource()== JBAdd)
        {
            int PId= Integer.parseInt(JTFPId.getText());//fetching Patient id from GUI
            String PName= JTFPName.getText();//fetching Patient name from GUI
            String PAddress= JTFPAddress.getText();//fetching Patient address from GUI
            int PAge= Integer.parseInt(JTFPAge.getText());//fetching Patient age from GUI
            long PPhoneNumber= Long.parseLong(JTFPPhoneNumber.getText());//fetching Patient phone number from GUI
            //fetching Patient gender from GUI
            String PGender= null;
            if(JRBPMale.isSelected())
            {
                PGender="m";
            }
            if(JRBPFemale.isSelected())
            {
                PGender="f";
            }
            if(JRBPOther.isSelected())
            {
                PGender="o";
            }
            String PDisease= JTFPDisease.getText();//fetching Patient disease from GUI
            String PBloodGroup= String.valueOf(JCBPBloodGroup.getSelectedItem());//fetching Patient blood group from GUI
            String PAdmitDate= JTFPAdmitDate.getText();//fetching Patient admit date from GUI
            String PDischargeDate= JTFPDischargeDate.getText();//fetching Patient discharge date from GUI
            String PNurseName= String.valueOf(JCBPNurseName.getSelectedItem());//fetching Patient nurse name from GUI
            String PRoomNumber= String.valueOf(JCBRNumber.getSelectedItem());//fetching Patient room number from GUI
            String PRoomType= String.valueOf(JCBRType.getSelectedItem());//fetching Patient room type from GUI
            String PDoctorName= String.valueOf(JCBPDoctorName.getSelectedItem());//fetching Patient doctor name from GUI
            String PInformation= JTAPInformation.getText();//fetching Patient information from GUI

            //Patient
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,Uname,pass);
                Statement st= con.createStatement();
                String query = "insert into Patient(Pt_id , Pt_Name , Pt_Address , Pt_Age , Pt_PhoneNumber , Pt_Gender , Pt_Disease , Pt_BGroup , Pt_AdmitDate , Pt_DischargeDate , Pt_NurseName , Pt_RoomNumber , Pt_RoomType , Pt_DoctorName , Pt_Information  )values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst= con.prepareStatement(query);
                pst.setInt(1,PId);
                pst.setString(2,PName);
                pst.setString(3,PAddress);
                pst.setInt(4,PAge);
                pst.setLong(5,PPhoneNumber);
                pst.setString(6,PGender);
                pst.setString(7,PDisease);
                pst.setString(8,PBloodGroup);
                pst.setString(9,PAdmitDate);
                pst.setString(10,PDischargeDate);
                pst.setString(11,PNurseName);
                pst.setString(12,PRoomNumber);
                pst.setString(13,PRoomType);
                pst.setString(14,PDoctorName);
                pst.setString(15,PInformation);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Add record successfully");

                String query2= "update Room set  R_Type=?, R_Availability=?, P_Id=?, P_Name=? where R_Number=?";
                PreparedStatement pst1= con.prepareStatement(query2);

                pst1.setString(1,PRoomType);
                pst1.setString(2,"NO");
                pst1.setInt(3,PId);
                pst1.setString(4,PName);
                pst1.setString(5,PRoomNumber);
                pst1.executeUpdate();

            }

            catch (SQLException ex)
            {

                JOptionPane.showMessageDialog(null, ex);
            }

            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }

            //All Patient
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,Uname,pass);
                Statement st= con.createStatement();
                String query = "insert into AllPatient(Pt_id , Pt_Name , Pt_Address , Pt_Age , Pt_PhoneNumber , Pt_Gender , Pt_Disease , Pt_BGroup , Pt_AdmitDate , Pt_DischargeDate , Pt_NurseName , Pt_RoomNumber , Pt_RoomType , Pt_DoctorName , Pt_Information  )values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst= con.prepareStatement(query);
                pst.setInt(1,PId);
                pst.setString(2,PName);
                pst.setString(3,PAddress);
                pst.setInt(4,PAge);
                pst.setLong(5,PPhoneNumber);
                pst.setString(6,PGender);
                pst.setString(7,PDisease);
                pst.setString(8,PBloodGroup);
                pst.setString(9,PAdmitDate);
                pst.setString(10,PDischargeDate);
                pst.setString(11,PNurseName);
                pst.setString(12,PRoomNumber);
                pst.setString(13,PRoomType);
                pst.setString(14,PDoctorName);
                pst.setString(15,PInformation);
                pst.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Add record successfully");

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

        else if(evtPatient.getSource()== JBDelete)
        {
            int PId= Integer.parseInt(JTFPId.getText());//fetching patient id from GUI
            String PRoomNumber= String.valueOf(JCBRNumber.getSelectedItem());//fetching Patient room number from GUI
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,Uname,pass);
                String query= "delete from Patient where Pt_Id = '"+PId+"' ";
                PreparedStatement pst= con.prepareStatement(query);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Delete record Successful");

                JTFPId.setText("");
                JTFPName.setText("");
                JTFPAddress.setText("");
                JTFPAge.setText("");
                JTFPPhoneNumber.setText("");
                JRBPMale.setSelected(true);
                JTFPDisease.setText("");
                JCBPBloodGroup.setSelectedIndex(0);
                JTFPAdmitDate.setText("");
                JTFPDischargeDate.setText("");
                JCBPNurseName.setSelectedItem("--Select--");
                JCBRNumber.setSelectedIndex(0);
                JCBRType.setSelectedIndex(0);
                JCBPDoctorName.setSelectedItem("--Select--");
                JTAPInformation.setText("");

                String getData="select * from Room where P_Id = '"+PId+"' ";
                Statement st = con.createStatement();
                ResultSet rs= st.executeQuery(getData);
                String RNumber = null;
                String RType = null;
                

                if(rs.next())
                {
                    RNumber=rs.getString("R_Number");
                    RType =rs.getString("R_Type");
                }

                String query2="update Room set  R_Type=?, R_Availability=?, P_Id=?, P_Name=? where R_Number=?";
                PreparedStatement pst1= con.prepareStatement(query2);
                pst1.setString(1,RType);
                pst1.setString(2,"yes");
                pst1.setString(3,"--");
                pst1.setString(4,"--");
                pst1.setString(5,RNumber);
                pst1.executeUpdate();
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

        else if(evtPatient.getSource()== JBGetData)
        {
            //nurse combo-box set all nurse name
            try
            {
                int i=0;
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,Uname,pass);
                String n=String.valueOf(JCBPDepartment.getSelectedItem());
                String s="select N_Name from Nurse ";
                Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs= st.executeQuery(s);
                int nor=0;
                while(rs.next())
                {
                    nor=nor+1;
                }
                Object[] strNurse=new Object[nor];
                rs.first();
                for( i=0; i<nor;i++)
                {
                    strNurse[i]=rs.getString(1);
                    rs.next();
                }
                for( i=0; i<nor;i++)
                {
                    JCBPNurseName.addItem(strNurse[i]);
                }
                con.close();
                rs.close();
                st.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
            //doctor combo-box sell all doctor name
            try
            {
                int i=0;
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,Uname,pass);
                String s="select Dr_Name from Doctor";
                Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs= st.executeQuery(s);
                int nor=0;
                while(rs.next())
                {
                    nor=nor+1;
                }
                Object[] strdocs=new Object[nor];
                rs.first();
                for( i=0; i<nor;i++)
                {
                    strdocs[i]=rs.getString(1);
                    rs.next();
                }
                for( i=0; i<nor;i++)
                {
                    JCBPDoctorName.addItem(strdocs[i]);
                }
                con.close();
                rs.close();
                st.close();

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }


            int PId= Integer.parseInt(JTFPId.getText());//fetching Patient id from GUI
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,Uname,pass);
                Statement st= con.createStatement();
                String query= "Select * from Patient where Pt_Id= '"+PId+"'  ";
                ResultSet rs= st.executeQuery(query);
                if(rs.next())
                {
                    String DBPId= String.valueOf(rs.getInt("Pt_Id"));
                    String DBPName =rs.getString("Pt_Name");
                    String DBPAddress=rs.getString("Pt_Address");
                    String DBPAge=String.valueOf(rs.getInt("Pt_Age"));
                    String DBPPhoneNumber=String.valueOf(rs.getLong("Pt_PhoneNumber"));
                    String DBPGender=rs.getString("Pt_Gender");
                    String DBPDisease=rs.getString("Pt_Disease");
                    String DBPBloodGroup=rs.getString("Pt_BGroup");
                    String DBPAdmitDate=rs.getString("Pt_AdmitDate");
                    String DBPDischargeDate=rs.getString("Pt_DischargeDate");
                    String DBPNurseName=rs.getString("Pt_NurseName");
                    String DBPRoomNumber=rs.getString("Pt_RoomNumber");
                    String DBPRoomType=rs.getString("Pt_RoomType");
                    String DBPDoctorName=rs.getString("Pt_DoctorName");
                    String DBPInformation=rs.getString("Pt_Information");

                    JTFPId.setText(DBPId);
                    JTFPName.setText(DBPName);
                    JTFPAddress.setText(DBPAddress);
                    JTFPAge.setText(DBPAge);
                    JTFPPhoneNumber.setText(DBPPhoneNumber);
                    if (DBPGender.equalsIgnoreCase("m"))
                    {
                        JRBPMale.setSelected(true);
                    }
                    if (DBPGender.equalsIgnoreCase("f"))
                    {
                        JRBPFemale.setSelected(true);
                    }
                    if (DBPGender.equalsIgnoreCase("0"))
                    {
                        JRBPOther.setSelected(true);
                    }
                    JTFPDisease.setText(DBPDisease);
                    JCBPBloodGroup.setSelectedItem(DBPBloodGroup);
                    JTFPAdmitDate.setText(DBPAdmitDate);
                    JTFPDischargeDate.setText(DBPDischargeDate);
                    JCBPNurseName.setSelectedItem(DBPNurseName);
                    JCBRNumber.setSelectedItem(DBPRoomNumber);
                    JCBRType.setSelectedItem(DBPRoomType);
                    JCBPDoctorName.setSelectedItem(DBPDoctorName);
                    JTAPInformation.setText(DBPInformation);

                    con.close();
                    rs.close();
                    st.close();
                }

                else
                {
                    JOptionPane.showMessageDialog(null, "No Patient Found!");
                    JTFPId.setText("");
                    JTFPName.setText("");
                    JTFPAddress.setText("");
                    JTFPAge.setText("");
                    JTFPPhoneNumber.setText("");
                    JRBPMale.setSelected(true);
                    JTFPDisease.setText("");
                    JCBPBloodGroup.setSelectedIndex(0);
                    JTFPAdmitDate.setText("");
                    JTFPDischargeDate.setText("");
                    JCBPNurseName.setSelectedItem("--Select--");
                    JCBRNumber.setSelectedIndex(0);
                    JCBRType.setSelectedIndex(0);
                    JCBPDoctorName.setSelectedItem("");
                    JTAPInformation.setText("");
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

        else if(evtPatient.getSource()== JBClear)
        {
            JTFPId.setText("");
            JTFPName.setText("");
            JTFPAddress.setText("");
            JTFPAge.setText("");
            JTFPPhoneNumber.setText("");
            JRBPMale.setSelected(true);
            JTFPDisease.setText("");
            JCBPBloodGroup.setSelectedIndex(0);
            JTFPAdmitDate.setText("");
            JTFPDischargeDate.setText("");
            JCBPNurseName.setSelectedItem("--Select--");
            JCBRNumber.setSelectedIndex(0);
            JCBRType.setSelectedIndex(0);
            JCBPDoctorName.setSelectedItem("--Select--");
            JTAPInformation.setText("");
        }

        else if (evtPatient.getSource()==JMICurrentPatient)
        {
            JFrame jf=new JFrame();
            PatientTable pt =new PatientTable();
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jf.setTitle("Patient Record");
            jf.setVisible(true);
            jf.setSize(410,510);
            jf.setResizable(false);
            jf.add(pt);
            jf.setLocationRelativeTo(null);

        }

        else if(evtPatient.getSource()==JMIAllPatient)
        {
            JFrame jf=new JFrame();
            AllPatientTable pt =new AllPatientTable();
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jf.setTitle("All Patient Record");
            jf.setVisible(true);
            jf.setSize(1410,510);
            jf.setResizable(false);
            jf.add(pt);
            jf.setLocationRelativeTo(null);
        }

        else if(evtPatient.getSource()==JBGenerateId)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,Uname,pass);
                String countBill= "select * from AllPatient";
                int count=1;
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(countBill);
                while (rs.next())
                {
                    count=count+1;
                }
                String sCount=String.valueOf(count);
                JTFPId.setText(sCount);
            }
            catch (Exception e)
            {

            }
        }

        else if(evtPatient.getSource()==JMIAboutPage)
        {
            JOptionPane.showMessageDialog(null,"All fields are mandatory for add record and update record \nonly Id no is mandatory is for get data and delete record \nId no='0-9' \nName='a-z , A-Z , Space' \nAddress='a-z , A-Z, all Special character' \nAge='0-9' \nPhone Number='0-9'only 10 digit \nGender='Select any one of them' \nDisease='a-z , A-Z , space' \nBlood group='Select any one of them' \nAdmit date='DD/MM/YYYY' \nDischarge date='DD/MM/YYYY' \nNurse='a-z , A-Z' \nRoom no='Select from both fields' \nDoctor='Select from 1st field ' \n Information='a-z , A-Z , Special character' \n\nIf any information is  not known please enter 'null' or 'Null' and in Mobile Number='00'" );
        }

        else if(evtPatient.getSource()==JMIExitApplication)
        {
            System.exit(0);
        }

        else if(evtPatient.getSource()==JMIAbout)
        {
            JOptionPane.showMessageDialog(null, "-This app is developed by Akshat Singhal. \n-BCA 5th sem (R.NO.08) \n-Minor project \n-HOSPITAL MANAGEMENT SYSTEM \n-In future this app is getting  updates as per requirements \n-©Copyright 2023 Akshat Singhal &Co. All Rights Reserved. \n-CONTACT US The Akshat Singhal &Co. is managed by Akshat Singhal, Inc. \n-Email us: akkisinghal2510@gmail.com  ","About",JOptionPane.PLAIN_MESSAGE);
        }

        else if(evtPatient.getSource()==JCBRNumber)
        {
            String a= String.valueOf(JCBRNumber.getSelectedItem());
            if(a.equals("G-1") || a.equals("G-2") || a.equals("G-3") || a.equals("G-4") || a.equals("G-5") || a.equals("G-6") || a.equals("F-1") || a.equals("F-2") ||  a.equals("F-3") || a.equals("F-4") || a.equals("F-5") || a.equals("F-6"))
            {
                JCBRType.setSelectedItem("General");
            }

            else if( a.equals("S-1") || a.equals("S-2") || a.equals("S-3"))
            {
                JCBRType.setSelectedItem("Private");
            }

            else if( a.equals("S-4") || a.equals("S-5") || a.equals("S-6"))
            {
                JCBRType.setSelectedItem("Deluxe");
            }
            else if( a.equals("T-1") || a.equals("T-2") || a.equals("T-3") || a.equals("T-4"))
            {
                JCBRType.setSelectedItem("Super Deluxe");
            }

            else if( a.equals("ICU-1") || a.equals("ICU-2"))
            {
                JCBRType.setSelectedItem("Normal");
            }
            else
            {

            }
        }

        else if(evtPatient.getSource()==JCBPDepartment)
        {
            //empty nurse combo-box
            int itemCountN= JCBPNurseName.getItemCount();
            for(int i=0; i<itemCountN;i++)
            {
                JCBPNurseName.removeItemAt(i);
            }
            //empty doctor combo-box
            int itemCountD= JCBPDoctorName.getItemCount();
            for(int i=0; i<itemCountD;i++)
            {
                JCBPDoctorName.removeItemAt(i);
            }
            try
            {
                int i=0;
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,Uname,pass);
                String n=String.valueOf(JCBPDepartment.getSelectedItem());
                String s="select N_Name from Nurse where N_Department= '"+n+"' ";
                Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs= st.executeQuery(s);
                int nor=0;
                while(rs.next())
                {
                    nor=nor+1;
                }
                Object[] strNurse=new Object[nor];
                rs.first();
                for( i=0; i<nor;i++)
                {
                    strNurse[i]=rs.getString(1);
                    rs.next();
                }
                for( i=0; i<nor;i++)
                {
                    JCBPNurseName.addItem(strNurse[i]);
                }
                con.close();
                rs.close();
                st.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }

            try
            {
                int i=0;
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,Uname,pass);
                String d=String.valueOf(JCBPDepartment.getSelectedItem());
                String s="select Dr_Name from Doctor where Dr_Department= '"+d+"' ";
                Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs= st.executeQuery(s);
                int nor=0;
                while(rs.next())
                {
                    nor=nor+1;
                }
                Object[] strDocs=new Object[nor];
                rs.first();
                for( i=0; i<nor;i++)
                {
                    strDocs[i]=rs.getString(1);
                    rs.next();
                }
                for( i=0; i<nor;i++)
                {
                    JCBPDoctorName.addItem(strDocs[i]);
                }
                con.close();
                rs.close();
                st.close();

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }

        }
    }

    public static void main(String[] args) 
    {
        new Patient();
    }

}

