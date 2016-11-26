package cloud.burst;

import javax.swing.*;

/**
 * Created by mahaleykaelynkeen on 11/15/16.
 */
public class StartFrame extends JFrame {

    public StartFrame (){
    }

    public static void main (String[] args) {
        JFrame jf = new JFrame ("Final Project: Platform Game");

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.add(new HomeScreen());
        jf.pack();
        jf.setSize(1004, 669);
        jf.setVisible(true);


    }
}
