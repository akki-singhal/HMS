package HMSP;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;
import javax.swing.*;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Graphics;


class Bill  extends JFrame implements ActionListener
{
    JLabel JLHospitalName, JLBillNumber,JLHospitalRegistrationNumber,JLPatientIdr, JLPatientName, JLDoctorCharges, JLMedicineCharges, JLOperationCharges, JLLabCharges, JLHospitalCharges,JLDiscount, JLTotalAmount, JLBILLIcon, JLSlogan1, JLSlogan2, JLRoomType, JLAdmitDays;

    JTextField JTFBillNumber,JTFPatientId, JTFPatientName, JTFDoctorCharges, JTFMedicineCharges, JTFOperationCharges, JTFLabCharges, JTFHospitalCharges,JTFDiscount, JTFTotalAmount, JTFRoomType, JTFAdmitDays, JTFCalculator, JTFResult;

    JButton JBConfirm, JBCalculateBill, JBSaveBill, JBMainPage, JBGetBill, JBClear, JBAddCalculator, JBCloseCalculator, JBAdd, JBMinus, JBMultiply, JBDivide, JBEquals, JBClearCalculator, JBGenerateId, JBPrintBill;

    JMenuBar JMB;

    JMenu JMExit, JMHelp;

    JMenuItem JMIExitApplication, JMIAbout, JMIAboutPage;

    ImageIcon IIConfirmIcon, IIBillIcon,IIMainPage, IIUpdateRecord, IISaveRecord, IIDeleteRecord, IIGetData, IIClear, IIGenerateBill,  IIPrintBill, IIOpenCalculator, IICloseCalculator , IIGenerateId;

    TextArea TABill;

    JTextArea  TAPrintBill;



    Bill()
    {
        
        setSize(900,740);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Bill Detail");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color col= new Color(149,183,94);
        getContentPane().setBackground(col);
        

        //Bill Logo
        IIBillIcon=new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Bill.png")));
        JLBILLIcon= new JLabel(IIBillIcon);
        JLBILLIcon.setBounds(600,80,225,225);
        add(JLBILLIcon);

        //Image Icons
        IIConfirmIcon=new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Confirm.png")));
        IIMainPage= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/MainPage.png")));
        IIUpdateRecord= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/UpdateRecord.png")));
        IISaveRecord= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/SaveRecord.png")));
        IIDeleteRecord= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/DeleteRecord.png")));
        IIGetData= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/GetData.png")));
        IIClear= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/Clear.png")));
        IIGenerateBill= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/GenerateBill.jpeg")));
        IIPrintBill= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/PrintBill.png")));
        IIOpenCalculator= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/AddCalculator.png")));
        IICloseCalculator= new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/CloseCalculator.png")));
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

        

        //Hospital Name
        JLHospitalName= new JLabel("Vardhman Hospital");
        JLHospitalName.setBounds(320,20,200,30);
        add(JLHospitalName);

        //Registration Number
        JLHospitalRegistrationNumber= new JLabel("R.Number:VH123UTVANX46XXX");
        JLHospitalRegistrationNumber.setBounds(300,50,200,30);
        add(JLHospitalRegistrationNumber);

        //Bill Number
        JLBillNumber= new JLabel("Bill Number:");
        JLBillNumber.setBounds(50,100,150,30);
        add(JLBillNumber);

        JTFBillNumber= new JTextField();
        JTFBillNumber.setBounds(220,100,200,30);
        add(JTFBillNumber);

        //Patient Id
        JLPatientIdr= new JLabel("Patient Id:");
        JLPatientIdr.setBounds(50,150,150,30);
        add(JLPatientIdr);

        JTFPatientId= new JTextField();
        JTFPatientId.setBounds(220,150,200,30);
        add(JTFPatientId);

        //Patient name
        JLPatientName= new JLabel("Patient Name:");
        JLPatientName.setBounds(50,200,150,30);
        add(JLPatientName);

        JTFPatientName= new JTextField();
        JTFPatientName.setBounds(220,200,200,30);
        add(JTFPatientName);


        //Number of admit days
        JLAdmitDays= new JLabel("Admit Days:");
        JLAdmitDays.setBounds(50,250,200,30);
        add(JLAdmitDays);

        JTFAdmitDays= new JTextField();
        JTFAdmitDays.setBounds(220,250,200,30);
        add(JTFAdmitDays);

        //Room type
        JLRoomType= new JLabel("Room Type:");
        JLRoomType.setBounds(50,300,150,30);
        add(JLRoomType);

        JTFRoomType= new JTextField();
        JTFRoomType.setBounds(220,300,200,30);
        add(JTFRoomType);
        
        //Doctor charge
        JLDoctorCharges= new JLabel("Doctor Charges:");
        JLDoctorCharges.setBounds(50,350,150,30);
        add(JLDoctorCharges);

        JTFDoctorCharges= new JTextField();
        JTFDoctorCharges.setBounds(220,350,200,30);
        add(JTFDoctorCharges);
        
        //Medicine charge
        JLMedicineCharges= new JLabel("Medicine Charges:");
        JLMedicineCharges.setBounds(50,400,150,30);
        add(JLMedicineCharges);

        JTFMedicineCharges= new JTextField();
        JTFMedicineCharges.setBounds(220,400,200,30);
        add(JTFMedicineCharges);
        
        //Operation charge
        JLOperationCharges= new JLabel("Operation Charges:");
        JLOperationCharges.setBounds(50,450,150,30);
        add(JLOperationCharges);

        JTFOperationCharges= new JTextField();
        JTFOperationCharges.setBounds(220,450,200,30);
        add(JTFOperationCharges);
        
        //Lab charge
        JLLabCharges= new JLabel("Lab Charges:");
        JLLabCharges.setBounds(50,500,150,30);
        add(JLLabCharges);

        JTFLabCharges= new JTextField();
        JTFLabCharges.setBounds(220,500,200,30);
        add(JTFLabCharges);
        
        //Hospital charge
        JLHospitalCharges= new JLabel("Hospital Charges:");
        JLHospitalCharges.setBounds(50,550,150,30);
        add(JLHospitalCharges);

        JTFHospitalCharges= new JTextField();
        JTFHospitalCharges.setBounds(220,550,200,30);
        add(JTFHospitalCharges);
        
        //Discount
        JLDiscount= new JLabel("Discount (in Rs):");
        JLDiscount.setBounds(50,600,150,30);
        add(JLDiscount);

        JTFDiscount= new JTextField();
        JTFDiscount.setBounds(220,600,200,30);
        add(JTFDiscount);
        
        //Total amount
        JLTotalAmount= new JLabel("Total Amount:");
        JLTotalAmount.setBounds(50,650,150,30);
        add(JLTotalAmount);

        JTFTotalAmount= new JTextField();
        JTFTotalAmount.setBounds(220,650,200,30);
        JTFTotalAmount.setEditable(false);
        add(JTFTotalAmount);

        //Confirm button
        JBConfirm=new JButton("",IIConfirmIcon);
        JBConfirm.setBounds(450,150,30,30);
        JBConfirm.addActionListener(this);
        add(JBConfirm);
        
        //Main Page button
        JBMainPage= new JButton("MainPage",IIMainPage);
        JBMainPage.setBounds(600,310,200,30);
        JBMainPage.addActionListener(this);
        add(JBMainPage);

        //Generate Bill button
        JBCalculateBill= new JButton("Calculate Bill",IIGenerateBill);
        JBCalculateBill.setBounds(600,350,200,30);
        JBCalculateBill.addActionListener(this);
        add(JBCalculateBill);

        //Print Button 
        JBSaveBill= new JButton("Save Bill",IIPrintBill);
        JBSaveBill.setBounds(600,390,200,30);
        JBSaveBill.addActionListener(this);
        add(JBSaveBill);

        //Get button
        JBGetBill= new JButton("Get Bill",IIGetData);
        JBGetBill.setBounds(600,430,200,30);
        JBGetBill.addActionListener(this);
        add(JBGetBill);

        //Clear button
        JBClear= new JButton("Clear form", IIClear);
        JBClear.setBounds(600,470,200,30);
        JBClear.addActionListener(this);
        add(JBClear);

        //Add calculator
        JBAddCalculator= new JButton("Open Calculator",IIOpenCalculator);
        JBAddCalculator.setBounds(600,510,200,30);
        JBAddCalculator.addActionListener(this);
        add(JBAddCalculator);

        //Close calculator
        JBCloseCalculator= new JButton("Close Calculator",IICloseCalculator);
        JBCloseCalculator.setBounds(600,550,200,30);
        JBCloseCalculator.addActionListener(this);
        add(JBCloseCalculator);


        //Slogan
        JLSlogan1= new JLabel("Stay Home Stay Safe!!!");
        JLSlogan1.setBounds(700,640,190,30);
        add(JLSlogan1);

        JLSlogan2= new JLabel("Wear mask Outside!!!");
        JLSlogan2.setBounds(700,660,190,30);
        add(JLSlogan2);

        //Calculator text field
        JTFCalculator= new JTextField("0");
        JTFCalculator.setBounds(930,250,150,30);
        add(JTFCalculator);

        //Add button
        JBAdd= new JButton("+");
        JBAdd.setBounds(950,300,40,30);
        JBAdd.addActionListener(this);
        add(JBAdd);

        //Minus button
        JBMinus= new JButton("-");
        JBMinus.setBounds(1020,300,40,30);
        JBMinus.addActionListener(this);
        add(JBMinus);

        //Multiply button
        JBMultiply= new JButton("*");
        JBMultiply.setBounds(950,340,40,30);
        JBMultiply.addActionListener(this);
        add(JBMultiply);

        //Divide button
        JBDivide= new JButton("/");
        JBDivide.setBounds(1020,340,40,30);
        JBDivide.addActionListener(this);
        add(JBDivide);

        //Equals button
        JBEquals= new JButton("=");
        JBEquals.setBounds(950,380,40,30);
        JBEquals.addActionListener(this);
        add(JBEquals);

        //clear calculator button
        JBClearCalculator= new JButton("C");
        JBClearCalculator.setForeground(Color.RED);
        JBClearCalculator.setBounds(1020,380,40,30);
        JBClearCalculator.addActionListener(this);
        add(JBClearCalculator);

        //Generate id button
        JBGenerateId= new JButton("",IIGenerateId);
        JBGenerateId.setBounds(440,100,40,30);
        JBGenerateId.addActionListener(this);
        add(JBGenerateId);

        //Result text field
        JTFResult= new JTextField("0");
        JTFResult.setBounds(930,410,150,30);
        JTFResult.setEditable(false);
        add(JTFResult);

        //bill text area
        TABill= new TextArea();
        TABill.setBounds(100,30,150,600);

        //print bill text area
        TAPrintBill= new JTextArea();
        TAPrintBill.setBounds(1100,80,225,625);
        TAPrintBill.setVisible(true);
        add(TAPrintBill);


        //JBPrintBill
        JBPrintBill= new JButton("Print Bill",IISaveRecord);
        JBPrintBill.setBounds(600,590,200,30);
        JBPrintBill.addActionListener(this);
        add(JBPrintBill);


    }

    String url="jdbc:mysql://localhost:3306/HospitalMgtSystem";
    String uname="root";
    String pass="@Tiger123";

    public void actionPerformed(ActionEvent evtBill)
    {
        double value=0;
        double result=0;

        if (evtBill.getSource()==JBConfirm)
        {

            String PID= JTFPatientId.getText();//fetching Patient id details from GUI
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,uname,pass);
                String query= "select * from AllPatient where Pt_Id = '"+PID+"' ";
                Statement st= con.createStatement();
                ResultSet rs= st.executeQuery(query);
                if(rs.next())
                {
                    String PtName = rs.getString("Pt_Name");
                    String PtRoomType= rs.getString("Pt_RoomType");
                    JTFPatientName.setText(PtName);
                    JTFRoomType.setText(PtRoomType);
                    if(PtRoomType.equals("General"))
                    {
                        JTFHospitalCharges.setText("1200");
                    }
                    else if(PtRoomType.equals("Private"))
                    {
                        JTFHospitalCharges.setText("2500");
                    }
                    else if(PtRoomType.equals("Deluxe"))
                    {
                        JTFHospitalCharges.setText("3700");
                    }
                    else if(PtRoomType.equals("Super Deluxe"))
                    {
                        JTFHospitalCharges.setText("5000");
                    }
                    else
                    {

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Patient not found");
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

        else if(evtBill.getSource()==JBGenerateId)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(url,uname,pass);
                String countBill= "select * from bill";
                int count=1;
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(countBill);
                while (rs.next())
                {
                    count=count+1;
                }
                String sCount=String.valueOf(count);
                JTFBillNumber.setText(sCount);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }

        else if(evtBill.getSource()==JBCalculateBill)
        {
            try
            {
                String billNumber=JTFBillNumber.getText();//fetching bill number details from GUI
                String patientId=JTFPatientId.getText();//fetching patient id details from GUI
                String patientName=JTFPatientName.getText();//fetching patient name details from GUI
                int admitDays=Integer.parseInt(JTFAdmitDays.getText());//fetching admit days details from GUI
                String roomType=JTFRoomType.getText();
                int doctorCharges=Integer.parseInt(JTFDoctorCharges.getText());//fetching doctor charges details from GUI
                int medicineCharges=Integer.parseInt(JTFMedicineCharges.getText());//fetching medicine charges details from GUI
                int operationCharges=Integer.parseInt(JTFOperationCharges.getText());//fetching operation charges details from GUI
                int labCharges=Integer.parseInt(JTFLabCharges.getText());//fetching lab charges details from GUI
                int discount= Integer.parseInt(JTFDiscount.getText());//fetching discount details from GUI
                int hospitalCharges=Integer.parseInt(JTFHospitalCharges.getText());//fetching hospital charges details from GUI


                int netTotalAmount=( admitDays * (doctorCharges + hospitalCharges) ) + medicineCharges + operationCharges + labCharges;
                int iTotalAmount= netTotalAmount - discount;
                String totalAmount=String.valueOf(iTotalAmount);
                JTFTotalAmount.setText(totalAmount);

            }


            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }

        }

        else if(evtBill.getSource()==JBSaveBill)
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, uname, pass);
                //fetching details from GUI
                String billNumber = "Bill Number:           " + String.valueOf(JTFBillNumber.getText());
                String patientId = "\nPatient Id:               " + String.valueOf(JTFPatientId.getText());
                String patientName = "\nPatient name:         " + JTFPatientName.getText();
                String admitDays = "\nAdmit days:            " + String.valueOf(JTFAdmitDays.getText());
                String roomType = "\nRoom type:             " + JTFRoomType.getText();
                String doctorCharges = "\nDoctor charges:      " + String.valueOf(JTFDoctorCharges.getText());
                String medicineCharges = "\nMedicine charges:   " + String.valueOf(JTFMedicineCharges.getText());
                String operationCharges = "\nOperation charges:  " + String.valueOf(JTFOperationCharges.getText());
                String labCharges = "\nLab charges:            " + String.valueOf(JTFLabCharges.getText());
                String hospitalCharges = "\nHospital charges:    " + String.valueOf(JTFHospitalCharges.getText());
                String discount = "\nDiscount:                " + String.valueOf(JTFDiscount.getText());
                String totalAmount = "\nTotal charges:         " + String.valueOf(JTFTotalAmount.getText());
                TABill.setText("");
                TABill.append(billNumber + patientId + patientName + admitDays + roomType + doctorCharges + medicineCharges + operationCharges + labCharges + hospitalCharges + discount + totalAmount);
                TABill.setEditable(false);
                JOptionPane.showMessageDialog(null, TABill);


                String insertBill = "insert into Bill (Bill_Number , Pt_Id , Pt_Name , Admit_Days , Room_Type , Doctor_Charges, Medicine_Charges , OperationCharges , Lab_Charges , Hospital_Charge , Discount , Bill_TAmt )values(?,?,?,?,?,?,?,?,?,?,?,?)";

                PreparedStatement pst = con.prepareStatement(insertBill);
                pst.setString(1, String.valueOf(JTFBillNumber.getText()));
                pst.setString(2, String.valueOf(JTFPatientId.getText()));
                pst.setString(3, JTFPatientName.getText());
                pst.setString(4, String.valueOf(JTFAdmitDays.getText()));
                pst.setString(5, JTFRoomType.getText());
                pst.setString(6, String.valueOf(JTFDoctorCharges.getText()));
                pst.setString(7, String.valueOf(JTFMedicineCharges.getText()));
                pst.setString(8, String.valueOf(JTFOperationCharges.getText()));
                pst.setString(9, String.valueOf(JTFLabCharges.getText()));
                pst.setString(10, String.valueOf(JTFHospitalCharges.getText()));
                pst.setString(11, String.valueOf(JTFDiscount.getText()));
                pst.setString(12, String.valueOf(JTFTotalAmount.getText()));
                pst.executeUpdate();

            }

            catch (Exception e)
            {
                    JOptionPane.showMessageDialog(null, e);
            }


        }

        else if(evtBill.getSource()==JBGetBill)
        {
            String billNumber=null;
            String patientId=null;
            billNumber=String.valueOf(JTFBillNumber.getText());
            patientId=String.valueOf(JTFPatientId.getText());
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection(url,uname,pass);
                if (billNumber!=null)
                {
                    String s="select * from Bill where Bill_Number= '"+billNumber+"'";
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery(s);
                    if(rs.next())
                    {
                        String DBBillNumber=rs.getString(1);
                        String DBPatientId=rs.getString(2);
                        String DBPatientName=rs.getString(3);
                        String DBAdmitDays=rs.getString(4);
                        String DBRoomType=rs.getString(5);
                        String DBDoctorCharges=rs.getString(6);
                        String DBMedicineCharges=rs.getString(7);
                        String DBOperationCharges=rs.getString(8);
                        String DBLabCharges=rs.getString(9);
                        String DBHospitalCharges=rs.getString(10);
                        String DBDiscount=rs.getString(11);
                        String DBTotalAmt=String.valueOf(rs.getInt(12));
                        JTFBillNumber.setText(DBBillNumber);
                        JTFPatientId.setText(DBPatientId);
                        JTFPatientName.setText(DBPatientName);
                        JTFAdmitDays.setText(DBAdmitDays);
                        JTFRoomType.setText(DBRoomType);
                        JTFDoctorCharges.setText(DBDoctorCharges);
                        JTFMedicineCharges.setText(DBMedicineCharges);
                        JTFOperationCharges.setText(DBOperationCharges);
                        JTFLabCharges.setText(DBLabCharges);
                        JTFHospitalCharges.setText(DBHospitalCharges);
                        JTFDiscount.setText(DBDiscount);
                        JTFTotalAmount.setText(DBTotalAmt);

                    }
                }

                else if(patientId!=null)
                {
                    String s="select * from Bill where Pt_Id= '"+patientId+"'";
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery(s);
                    if(rs.next())
                    {
                        String DBBillNumber=rs.getString(1);
                        String DBPatientId=rs.getString(2);
                        String DBPatientName=rs.getString(3);
                        String DBAdmitDays=rs.getString(4);
                        String DBRoomType=rs.getString(5);
                        String DBDoctorCharges=rs.getString(6);
                        String DBMedicineCharges=rs.getString(7);
                        String DBOperationCharges=rs.getString(8);
                        String DBLabCharges=rs.getString(9);
                        String DBHospitalCharges=rs.getString(10);
                        String DBDiscount=rs.getString(11);
                        String DBTotalAmt=String.valueOf(rs.getInt(12));
                        JTFBillNumber.setText(DBBillNumber);
                        JTFPatientId.setText(DBPatientId);
                        JTFPatientName.setText(DBPatientName);
                        JTFAdmitDays.setText(DBAdmitDays);
                        JTFRoomType.setText(DBRoomType);
                        JTFDoctorCharges.setText(DBDoctorCharges);
                        JTFMedicineCharges.setText(DBMedicineCharges);
                        JTFOperationCharges.setText(DBOperationCharges);
                        JTFLabCharges.setText(DBLabCharges);
                        JTFHospitalCharges.setText(DBHospitalCharges);
                        JTFDiscount.setText(DBDiscount);
                        JTFTotalAmount.setText(DBTotalAmt);

                    }
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }

        else if(evtBill.getSource()==JBMainPage)
        {
            this.dispose();
            //setVisible(false);
            new MainPage();
        }


        else if(evtBill.getSource()==JBClear)
        {
            JTFBillNumber.setText("");
            JTFPatientId.setText("");
            JTFPatientName.setText("");
            JTFAdmitDays.setText("");
            JTFRoomType.setText("");
            JTFDoctorCharges.setText("");
            JTFMedicineCharges.setText("");
            JTFOperationCharges.setText("");
            JTFLabCharges.setText("");
            JTFHospitalCharges.setText("");
            JTFDiscount.setText("");
            JTFTotalAmount.setText("");
        }

        else if(evtBill.getSource()==JMIExitApplication)
        {
            System.exit(0);
        }

        else if(evtBill.getSource()==JBAddCalculator)
        {
            setSize(1100,740);
            setLayout(null);
            setLocationRelativeTo(null);
        }

        else if(evtBill.getSource()==JBCloseCalculator)
        {
            setSize(900,740);
            setLayout(null);
            setLocationRelativeTo(null);
        }

        else if(evtBill.getSource()==JMIAbout)
        {
            JOptionPane.showMessageDialog(null, "-This app is developed by Akshat Singhal. \n-BCA 5th sem (R.NO.08) \n-Minor project \n-HOSPITAL MANAGEMENT SYSTEM \n-In future this app is getting  updates as per requirements \n-©Copyright 2023 Akshat Singhal &Co. All Rights Reserved. \n-CONTACT US The Akshat Singhal &Co. is managed by Akshat Singhal, Inc. \n-Email us: akkisinghal2510@gmail.com  ","About",JOptionPane.PLAIN_MESSAGE);
            
        }

        else if(evtBill.getSource()==JMIAboutPage)
        {
            JOptionPane.showMessageDialog(null,"All fields are mandatory for Generate bill and Print bill \nOnly bill number is mandatory for get bill \nBill Number='0-9' \nPatient Id='0-9' \nPatient name='a-z , A-z , Space' \nAdmit days='0-9' \nDoctor charges='0-9' \nMedicine charges='0-9' \nOperation charges='0-9' \nLab charges='0-9' \nHospital charges='0-9' \nDiscount='0-9' \n\nIf any charges are not applicable please enter '00' ");

        }

        else if(evtBill.getSource()==JBAdd)
        {
            double a=Double.parseDouble(JTFResult.getText());
            double b=Double.parseDouble(JTFCalculator.getText());
            double c= a+b;
            String r=String.valueOf(c);
            JTFResult.setText(r);
            JTFCalculator.setText("");

        }

        else if(evtBill.getSource()==JBMinus)
        {
            double a=Double.parseDouble(JTFResult.getText());
            double b=Double.parseDouble(JTFCalculator.getText());
            double c= a-b;
            String r=String.valueOf(c);
            JTFResult.setText(r);
            JTFCalculator.setText("");
        }

        else if(evtBill.getSource()==JBMultiply)
        {
            double a=Double.parseDouble(JTFResult.getText());
            double b=Double.parseDouble(JTFCalculator.getText());
            double c= a*b;
            String r=String.valueOf(c);
            JTFResult.setText(r);
            JTFCalculator.setText("");
        }

        else if(evtBill.getSource()==JBDivide)
        {
            double a=Double.parseDouble(JTFResult.getText());
            double b=Double.parseDouble(JTFCalculator.getText());
            double c= a/b;
            String r=String.valueOf(c);
            JTFResult.setText(r);
            JTFCalculator.setText("");
        }

        else if(evtBill.getSource()==JBEquals)
        {
            double a=Double.parseDouble(JTFResult.getText());
            double b=Double.parseDouble(JTFCalculator.getText());
            double c= a+b;
            String r=String.valueOf(c);
            JTFResult.setText(r);
            JTFCalculator.setText("0");
        }

        else if(evtBill.getSource()==JBClearCalculator)
        {
                JTFCalculator.setText("0");
                JTFResult.setText("0");
        }

        else if (evtBill.getSource()==JBPrintBill)
        {
                String billNumber = "Bill Number:           " + String.valueOf(JTFBillNumber.getText());
                String patientId = "\n\nPatient Id:               " + String.valueOf(JTFPatientId.getText());
                String patientName = "\n\nPatient name:         " + JTFPatientName.getText();
                String admitDays = "\n\nAdmit days:            " + String.valueOf(JTFAdmitDays.getText());
                String roomType = "\n\nRoom type:             " + JTFRoomType.getText();
                String doctorCharges = "\n\nDoctor charges:      " + String.valueOf(JTFDoctorCharges.getText());
                String medicineCharges = "\n\nMedicine charges:   " + String.valueOf(JTFMedicineCharges.getText());
                String operationCharges = "\n\nOperation charges:  " + String.valueOf(JTFOperationCharges.getText());
                String labCharges = "\n\nLab charges:            " + String.valueOf(JTFLabCharges.getText());
                String hospitalCharges = "\n\nHospital charges:    " + String.valueOf(JTFHospitalCharges.getText());
                String discount = "\n\nDiscount:                " + String.valueOf(JTFDiscount.getText());
                String totalAmount = "\n\nTotal charges:         " + String.valueOf(JTFTotalAmount.getText());
                TAPrintBill.setText("");
                TAPrintBill.append("                        Vardhman Hospital\n\n");
                TAPrintBill.append("                        Reg. No.= VAR123456\n");
                TAPrintBill.append("                      Almaspur Road, Muzaffarnagar - 251002\n\n");
                TAPrintBill.append("                      Ph: 8126955XXX     Timing: 24hr Available\n\n");
                TAPrintBill.append("GST NO.- XXXXXXXXXXXXXXXXX\n\n\n\n");

                TAPrintBill.append(billNumber + patientId + patientName + admitDays + roomType + doctorCharges + medicineCharges + operationCharges + labCharges + hospitalCharges + discount + totalAmount);

                try {
                    TAPrintBill.print();
                }
                catch(PrinterException ex)
                {
                    Logger.getLogger(Bill.class.getName()).log(Level.SEVERE,null,ex);
                }
        }

    }
    


    public static void main(String[] args) 
    {
        new Bill();
    }
}
