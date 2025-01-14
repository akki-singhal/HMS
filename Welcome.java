package HMSP;

import javax.swing.*;
import java.util.Objects;

public class Welcome extends Thread
{
    JFrame jf1;
    JLabel j1;
    public Welcome ()
    {
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        jf1 = new JFrame();
        jf1.setUndecorated(true);
        ImageIcon img1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/WelcomeMessage.gif")));
        j1 = new JLabel(img1);
        jf1.setLayout(null);
        j1.setBounds(0,0,600,50);
        jf1.add(j1);
        jf1.setSize(600,50);
        jf1.setLocationRelativeTo(null);
        jf1.setVisible(true);
        jf1.setResizable(false);
        try
        {
            Thread.sleep(5000);
        }

        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        jf1.setVisible(false);

    }

    public static void main(String[] args) {
        new Welcome();
    }
}
