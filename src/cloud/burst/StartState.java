package cloud.burst;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by bradl on 11/22/2016.
 */
public class StartState extends CurrentGameState {

    // -------------IMAGES-------//
    // background image variable set to start screen image
    private Image bkgImg = Toolkit.getDefaultToolkit().createImage("images/startScreen.png");
    // --------- end of images ---------//



    //start state is set to one of the game states
    public StartState(GameState gs){
        super(gs);
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

        //GAME STARTS when user presses "F2" key
        if (n == KeyEvent.VK_F2){
            gs.states.push(new LevelBeginState(gs));
        }
        //if user presses "escape" key, PROGRAM ENDS
        else if (n == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }

    public void keyReleased(int n){

    }

}
