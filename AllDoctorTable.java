package HMSP;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class AllDoctorTable extends JPanel
{
    String url="jdbc:mysql://localhost:3306/HospitalMgtSystem";
    String Uname="root";
    String pass="@Tiger123";

    AllDoctorTable()
    {
        JTable Table= new JTable();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,Uname,pass);
            Statement st= con.createStatement();
            String query= "Select * from AllDoctor";
            ResultSet rs= st.executeQuery(query);
            ResultSetMetaData rsmd= rs.getMetaData();
            DefaultTableModel model= (DefaultTableModel) Table.getModel();
            int cols= rsmd.getColumnCount();
            String[] colName={"Id No", "Name", "Father Name", "Age", "Phone Number", "Gender", "Fees", "Address", "Department", "Qualification","Joining Date","Blood Group"};
            model.setColumnIdentifiers(colName);
            String id;
            String name;
            String fName;
            int ageI;
            long phoneNumberI;
            String gender;
            int feesI;
            String address;
            String department;
            String qualification;
            String joiningDate;
            String bloodGroup;

            while(rs.next())
            {
                id=rs.getString(1);
                name=rs.getString(2);
                fName=rs.getString(3);

                //ageI=rs.getInt(4);
                String age=String.valueOf(rs.getInt(4));
                //phoneNumberI=rs.getLong(5);
                String phoneNumber=String.valueOf(rs.getLong(5));
                gender=rs.getString(6);
                //feesI=rs.getInt(7);
                String fees=String.valueOf(rs.getInt(7));
                address=rs.getString(8);
                department=rs.getString(9);
                qualification=rs.getString(10);
                joiningDate=rs.getString(11);
                bloodGroup=rs.getString(12);

                String[] row={id,name,fName,age,phoneNumber,gender,fees,address,department,qualification,joiningDate,bloodGroup};
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
