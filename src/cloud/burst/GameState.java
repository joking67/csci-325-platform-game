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

    // -----------------------//
    public void tick(){
        states.peek().tick();
    }
    //---------------------------------//
    public void draw(Graphics g){
        states.peek().draw(g);

    }
    //---------------------//
    public void keyPressed(int n){
        states.peek().keyPressed(n);
    }

    public void keyReleased(int n){
        states.peek().keyReleased(n);
    }
}
