package HMSP;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class AllPatientTable extends JPanel
{
    String url="jdbc:mysql://localhost:3306/HospitalMgtSystem";
    String Uname="root";
    String pass="@Tiger123";

    AllPatientTable()
    {
        JTable Table= new JTable();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,Uname,pass);
            Statement st= con.createStatement();
            String query= "Select * from AllPatient  ";
            ResultSet rs= st.executeQuery(query);
            ResultSetMetaData rsmd= rs.getMetaData();
            DefaultTableModel model= (DefaultTableModel) Table.getModel();
            int cols= rsmd.getColumnCount();
            String[] colName={"Id No", "Name", "Address","Age" , "PhoneNumber" , "Gender" , "Disease" , "BloodGroup" , "AdmitDate" , "DischargeDate" , "Nurse" , "RoomNumber" , "RoomType", "Doctor"};
            model.setColumnIdentifiers(colName);
            String Id;
            String Name;
            String Address;
            String Age;
            String PhoneNumber;
            String Gender;
            String Disease;
            String BloodGroup;
            String AdmitDate;
            String DischargeDate;
            String Nurse;
            String RoomNumber;
            String RoomType;
            String Doctor;


            while(rs.next())
            {
                Id=rs.getString(1);
                Name=rs.getString(2);
                Address=rs.getString(3);
                Age=String.valueOf(rs.getInt(4));
                PhoneNumber=String.valueOf(rs.getLong(5));
                Gender=rs.getString(6);
                Disease=rs.getString(7);
                BloodGroup=rs.getString(8);
                AdmitDate=rs.getString(9);
                DischargeDate=rs.getString(10);
                Nurse=rs.getString(11);
                RoomNumber=rs.getString(12);
                RoomType=rs.getString(13);
                Doctor=rs.getString(14);
                String[] row={Id,Name,Address,Age,PhoneNumber,Gender,Disease,BloodGroup,AdmitDate,DischargeDate,Nurse,RoomNumber,RoomType,Doctor};
                model.addRow(row);

            }
            st.close();
            rs.close();
            con.close();
        }

        catch(Exception e)
        {

        }

        Table.setPreferredScrollableViewportSize(new Dimension(1400,500));
        Table.setFillsViewportHeight(true);
        JScrollPane js=new JScrollPane(Table);
        js.setVisible(true);
        add(js);
    }
}
