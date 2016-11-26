package cloud.burst;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Team-CloudBurst on 11/16/2016.
 */
public class CloudBurstPanel extends JPanel implements Runnable, KeyListener{

    public static final int WIDTH = 1004;
    public static final int HEIGHT = 669;

    private Thread thread;
    // is the game still running. set to false when game is over
    private boolean isRunning = false;
    //sets frames per second to 60 (playable frame rate)
    // this caps the frame rate to maintain frame control
    private int FPS = 60;
    private long tartgetTime = 1000/FPS;
    private GameState gs;



    public CloudBurstPanel(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        //uses key listener for user keyboard input
        // for as long as panel is open
        addKeyListener(this);
        setFocusable(true);


        //start game
        start();
    }

    private void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public void run(){
        //time variables
        long start;
        long elapsed;
        long wait;

        //instantiating game state
        gs = new GameState(gs);



        //checks if game is still running
        //  if game isRunning is false (game is over)
        // game has ended
        while (isRunning){
            start = System.nanoTime();

            tick();
            repaint();

            elapsed = System.nanoTime() - start;
            wait = tartgetTime - elapsed / 100000000;

            if (wait <= 0){
                wait = 5;
            }

            try {
                Thread.sleep(wait);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void tick(){
        gs.tick();
    }

    //draws the objects and images
    public void paintComponent(Graphics g){
        super.paintComponent(g);


        //clears the screen
        g.clearRect(0,0,WIDTH,HEIGHT);
        //draws whatever image is apart of the game state at that moment
        gs.draw(g);
    }

    //user is not going to type during gameplay
    //  required as required methods by implementing keylistener
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        gs.keyPressed(e.getKeyCode());
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        gs.keyReleased(e.getKeyCode());
    }
}
