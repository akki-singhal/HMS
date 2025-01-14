package HMSP;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class PatientTable extends JPanel
{
    String url="jdbc:mysql://localhost:3306/HospitalMgtSystem";
    String Uname="root";
    String pass="@Tiger123";

    PatientTable()
    {
        JTable Table= new JTable();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,Uname,pass);
            Statement st= con.createStatement();
            String query= "Select * from Patient  ";
            ResultSet rs= st.executeQuery(query);
            ResultSetMetaData rsmd= rs.getMetaData();
            DefaultTableModel model= (DefaultTableModel) Table.getModel();
            int cols= rsmd.getColumnCount();
            String[] colName={"Id No", "Name", "Address"};
            model.setColumnIdentifiers(colName);
            String Id;
            String Name;
            String Address;

            while(rs.next())
            {
                Id=rs.getString(1);
                Name=rs.getString(2);
                Address=rs.getString(3);
                String[] row={Id,Name,Address};
                model.addRow(row);

            }
            st.close();
            rs.close();
            con.close();
        }

        catch(Exception e)
        {

        }

        Table.setPreferredScrollableViewportSize(new Dimension(400,500));
        Table.setFillsViewportHeight(true);
        JScrollPane js=new JScrollPane(Table);
        js.setVisible(true);
        add(js);
    }
}
