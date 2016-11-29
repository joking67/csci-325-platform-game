package cloud.burst;

import java.awt.*;
import java.util.Stack;

/**
 * Created by Team-CloudBurst on 11/15/2016.
 */
public class GameState {
    //variables

    //stack
    public Stack<CurrentGameState> states;

    // ----------- CONSTRUCTOR ----------//
    public GameState(GameState gs){
        states = new Stack<CurrentGameState>();

        //start game
        states.push(new StartState(this));

    }

    // ---------- TICK - Updating Game Logic - (each class may or may not use) ----------//
    public void tick(){
        states.peek().tick();
    }

    //------------ DRAWS IMAGES ON SCREEN ------------------//
    public void draw(Graphics g){
        states.peek().draw(g);

    }
    //------- LISTENERS ---------//
    public void keyPressed(int n){
        states.peek().keyPressed(n);
    }

    public void keyReleased(int n){
        states.peek().keyReleased(n);
    }
}
