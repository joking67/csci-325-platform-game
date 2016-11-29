package cloud.burst;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Team-CloudBurst on 11/26/2016.
 */
public class Water extends Rectangle{
    public static int waterWidth = 3000;
    public static int waterHeight = 400;
    public static int x;
    public static int y;

    //collision detection
    public boolean gameOver = false;




    //set water image
    Image mWater;


    public Water(int x, int y){
        this.x = x;
        this.y = y;
        setBounds(x,y,waterWidth,waterHeight);
    }


    public void draw(Graphics g){
        if(!gameOver) {
            ImageIcon water = new ImageIcon("images/water.png");
            mWater = water.getImage();
            g.drawImage(mWater, (x - (int) CurrentGameState.xOffset), (y - (int) CurrentGameState.yOffset), waterWidth, waterHeight, null);
        }
    }

}
