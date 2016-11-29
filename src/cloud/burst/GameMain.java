package cloud.burst;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Team-CloudBurst on 11/15/2016.
 */
public class GameMain {

    //Set frame Data - All
    public static void main (String[] args){
        JFrame frame = new JFrame("CloudBurst");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(new CloudBurstPanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
