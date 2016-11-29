package cloud.burst;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Team-CloudBurst on 11/15/2016.
 */
public class Platforms extends Rectangle{
    //variables
    int max = 200;
    int min = 1;
    public double random;

    public static final int platformHeight = 60;
    public double platformWidth = randomCheck();
    Image cloudPlatform;

    //CONSTRUCTOR
    public Platforms(int x, int y){
        setBounds(x, y, (int)platformWidth, platformHeight);
    }

    // checks to make sure width of platform is not less than width of dewey (causes collision issues)
    private double randomCheck(){
        random = Math.random() * max + min;
        if(random < 61){
            random = random + 200;
        }
        return random;
    }

    public void tick(){

    }

    //DRAW
    public void draw(Graphics g) {
        ImageIcon i = new ImageIcon("images/cloud/cloudPlatform-03.png");
        cloudPlatform = i.getImage();
        //come up with random assignment for x-axis
        g.drawImage(cloudPlatform, x - (int) CurrentGameState.xOffset, y - (int) CurrentGameState.yOffset, (int) platformWidth, platformHeight, null);
    }
}