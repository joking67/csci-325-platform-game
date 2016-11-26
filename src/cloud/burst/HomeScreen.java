package cloud.burst;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mahaleykaelynkeen on 11/11/16.
 */
public class HomeScreen extends JPanel {

    private ImageIcon startImg;

    public HomeScreen(){

        super();
        startImg = new ImageIcon("Imgs/resized2.jpg");
        startImg.setImage(startImg.getImage().getScaledInstance(1004, 669, Image.SCALE_DEFAULT));
    }

    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        startImg.paintIcon(this, page, 0, 0);
    }

}
