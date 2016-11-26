package cloud.burst;

import java.awt.*;

/**
 * Created by Team-CloudBurst on 11/22/2016.
 */
public abstract class CurrentGameState {
    //variables

    protected GameState gs;
    public static double xOffset;
    public static double yOffset;

    public CurrentGameState(GameState gs){
        this.gs = gs;

        xOffset = 0;
        yOffset = 0;

        init();
    }


    public abstract void init();
    public abstract void tick();
    public abstract void draw(Graphics g);
    public abstract void keyPressed(int e);
    public abstract void keyReleased(int e);


}
