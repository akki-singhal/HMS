package HMSP;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class DoctorTable extends JPanel
{
    String url="jdbc:mysql://localhost:3306/HospitalMgtSystem";
    String Uname="root";
    String pass="@Tiger123";

    DoctorTable()
    {
        JTable Table= new JTable();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,Uname,pass);
            Statement st= con.createStatement();
            String query= "Select * from Doctor  ";
            ResultSet rs= st.executeQuery(query);
            ResultSetMetaData rsmd= rs.getMetaData();
            DefaultTableModel model= (DefaultTableModel) Table.getModel();
            int cols= rsmd.getColumnCount();
            String[] colName={"Id No", "Name", "Father Name"};
            model.setColumnIdentifiers(colName);
            String Id;
            String Name;
            String FName;

            while(rs.next())
            {
                Id=rs.getString(1);
                Name=rs.getString(2);
                FName=rs.getString(3);
                String[] row={Id,Name,FName};
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
