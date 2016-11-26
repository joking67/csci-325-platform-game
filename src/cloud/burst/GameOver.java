package cloud.burst;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Team-CloudBurst on 11/20/2016.
 */
public class GameOver{

    private Image bkgImg = Toolkit.getDefaultToolkit().createImage("images/Game Over Image.png");
    // --------- end of images ---------//



    //start state is set to one of the game states
    public GameOver(){

    }


    public void init(){

    }

    public void tick(){

    }

    public void draw(Graphics g){
        //draws the start background image
        g.drawImage(bkgImg, 0,0, null);
    }

    // Listener for user input key press
    public void keyPressed(int n){

        if (n == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }

    public void keyReleased(int n){

    }

}
