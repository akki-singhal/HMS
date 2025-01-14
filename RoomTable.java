package HMSP;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class RoomTable extends JPanel
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

        Table.setPreferredScrollableViewportSize(new Dimension(600,370));
        Table.setFillsViewportHeight(true);
        JScrollPane js=new JScrollPane(Table);
        js.setVisible(true);
        add(js);
    }


}
