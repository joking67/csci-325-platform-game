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
        dewey = new MainCharacter(60,60);

        //new water
        w = new Water(-200,500);

        xAxis = 288;
        yAxis = 355;

        // 200 platforms in array of platforms
        p = new Platforms[10];
        p[0] = new Platforms(388,410);


        //////// pass platforms only height //////////////////////////////
        for(int i = 1; i<p.length;i++){
            yAxis = yAxis - 50;
            System.out.println("y-axis:" + yAxis);
            xAxis = (Math.random() * (1000)) + 50;
            p[i] = new Platforms((int)xAxis,(int)yAxis);
        }
        /////// for loop //////////////////////////////
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
        g.drawImage(mBackground,0,0,1010,9896,null);

        //draw water
        w.draw(g);

        dewey.draw(g);
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
