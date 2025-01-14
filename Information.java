package HMSP;

import javax.swing.*;

public class Information {

    JFrame jf1;
    JLabel j1;
    public Information(){
    try
    {
        Thread.sleep(500);
    }

    catch (InterruptedException e)
    {
        throw new RuntimeException(e);
    }

    jf1 = new JFrame();
    jf1.setUndecorated(true);
    ImageIcon img1 = new ImageIcon(getClass().getResource("/Images/Information.gif"));
    j1 = new JLabel(img1);
        jf1.setLayout(null);
        j1.setBounds(0,0,940,788);
        jf1.add(j1);
        jf1.setSize(940,788);
        jf1.setLocationRelativeTo(null);
        jf1.setVisible(true);
        jf1.setResizable(false);
        try
        {
            Thread.sleep(5500);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        jf1.setVisible(false);

}

    public static void main(String[] args) {
        new Information();
    }
}
