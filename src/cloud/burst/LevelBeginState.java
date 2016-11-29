package cloud.burst;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Team-CloudBurst on 11/17/2016.
 */
public class LevelBeginState extends CurrentGameState {

    // new Main Character
    private MainCharacter dewey;

    //creating platforms
    private Platforms[] p;
    private Water w;

    // x axis
    public double xAxis;
    // y axis
    public double yAxis;

    //background image
    Image mBackground;



    //Constructor
    public LevelBeginState(GameState gs){
        super(gs);
    }
    // -- END OF CONSTRUCTOR----//



    //INIT (initialize level data)
    public void init() {
            //size of dewey 60 x 60
            //new character
            dewey = new MainCharacter(60, 60);

            //new water
            w = new Water(-500, 500);

            xAxis = 288;
            yAxis = 400;

            // 200 platforms in array of platforms
            p = new Platforms[100];
            p[0] = new Platforms(388, 410);

            xAxis = (Math.random() * (800));
            //////// pass platforms only height //////////////////////////////


            for (int i = 1; i < p.length; i++) {
                yAxis = yAxis - 90;

                if (xAxis < 1000 && xAxis > 20) {
                    if (xAxis > 19 && xAxis < 201) {
                        double ranTop;
                        ranTop = Math.random() * 500;
                        xAxis += ranTop;
                    } else if (xAxis > 200 && xAxis < 401) {
                        double ranMiddle;
                        ranMiddle = Math.random() * 500;

                        xAxis += (int) ranMiddle;
                    } else {
                        xAxis = 22;
                    }

                }
                p[i] = new Platforms((int) xAxis, (int) yAxis);
            }
            /////// END of for loop //////////////////////////////
    }

    // TICK
    public void tick() {

        for(int i=0; i < p.length;i++){
            p[i].tick();
        }
        dewey.tick(p);

    }

    public void draw(Graphics g) {
        //set background image
        ImageIcon ic = new ImageIcon("images/mainBackground.png");
        mBackground = ic.getImage();

        //begin drawing images
        //positions                 x,  y,   width, height
        g.drawImage(mBackground,(0),(-6780 - (int)CurrentGameState.yOffset),1004,7324,null);

        //draw water
        w.draw(g);

        //drawing dewey
        dewey.draw(g);

        //drawing cloud platforms
        for (int i=0; i < p.length; i++){
            p[i].draw(g);
        }
    }

    public void keyPressed(int n) {
        dewey.keyPressed(n);

        // pressing ESCAPE takes you back to START SCREEN
        if(n == KeyEvent.VK_ESCAPE){
            gs.states.push(new StartState(gs));
        }
    }

    public void keyReleased(int n) {
        dewey.keyReleased(n);

        // key Release listener for back to Start SCREEN
        if(n == KeyEvent.VK_ESCAPE){
            gs.states.push(new StartState(gs));
        }
    }
}
