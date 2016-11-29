package cloud.burst;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Team-CloudBurst on 11/22/2016.
 *
 * ***NOTE: this class ended up not being required. Last minute decision.
 */
public class GameOver {

    //new Background Image
    private Image bkgImg;
    // --------- end of images ---------//



//    start state is set to one of the game states
    public GameOver(){
        bkgImg = Toolkit.getDefaultToolkit().createImage("images/GameOver.png");
    }

    //intentionally unused
    public void init(){

    }
    //intentionally unused
    public void tick(){

    }

    //gets background image
    public Image getBkgImg(){
        return bkgImg;
    }

    //draws background image onscreen
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
