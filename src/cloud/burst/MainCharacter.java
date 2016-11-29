package cloud.burst;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

/**
 * Created by Team-CloudBurst on 11/13/2016.
 */
public class MainCharacter {

    //--------- Character Image --------//
    Image deweyImg;
    ImageIcon i;
    // ---------- end of character image -----------//

    //Game over
    GameOver GO;
    Image bkgImg;
    public boolean isOver=false;


    //------Movement--------//
    private boolean right = false;
    private boolean left = false;
    private boolean jumping = false;
    private boolean falling = false;
    private boolean topCollision = false;

    //----- Bounds -------//
    private double x;
    private double y;
    private int width;
    private int height;

    //MOVEMENT SPEED
    private double moveSpeed = 6;

    //jumping and jumping speed
    private double jumpSpeed = 7;
    private double currentJumpSpeed = jumpSpeed;

    //falling and falling speed
    // "Gravity" effects
    private double maxFallSpeed = 7;
    private double currentFallSpeed = 0.3;

    //------ end of movement -------//


    //-------- CONSTRUCTOR -------//
    //Dewey doesn't move; instead the map moves around him (redrawn around him)
    public MainCharacter(int width, int height){
        //Dewey's Starting Position
        x = 388;
        y = 400;
        this.width = width;
        this.height = height;
        i = new ImageIcon("images/deweyRightFace.png");
        deweyImg = i.getImage();
        bkgImg = Toolkit.getDefaultToolkit().createImage("images/GameOver.png");
    }
    //------- END OF CONSTRUCTOR ---------//

    // when user presses arrow keys (left or right)
    // the coordinate is increased or decreased
    public void tick(Platforms[] p){

        //casting x and y to int to be used with new Point (point does not accept doubles)
        int iX = (int)this.x;
        int iY = (int)this.y;

        // ---------------- COLLISION CHECKING LOOP --------------//
        /*
            every time dewey comes in contact with a platform, this loop checks to see
            if he is actually touching the platform (top, bottom, right, left) and therefor
            keeps him from falling through it or any further if he lands on it.
         */
        for(int i = 0; i <p.length; i++) {
                // right side collision
                if (isTouchingPlatform.deweyOnPlatform(new Point(iX + width + (int) CurrentGameState.xOffset,
                        iY + (int) CurrentGameState.yOffset + 2), p[i])
                        || isTouchingPlatform.deweyOnPlatform(new Point(iX + width + (int) CurrentGameState.xOffset,
                        iY + height + (int) CurrentGameState.yOffset - 1), p[i])) {
                    right = false;
                }

                //left collision
                if (isTouchingPlatform.deweyOnPlatform(new Point(iX + (int) CurrentGameState.xOffset - 1,
                        iY + (int) CurrentGameState.yOffset + 2), p[i]) || isTouchingPlatform.deweyOnPlatform(new Point(
                        iX + (int) CurrentGameState.xOffset - 1, iY + height + (int) CurrentGameState.yOffset - 1), p[i])) {
                    left = false;
                }

                //top collision
                /*if (isTouchingPlatform.deweyOnPlatform(new Point(iX + (int) CurrentGameState.xOffset + 1,
                        iY + (int) CurrentGameState.yOffset), p[i]) ||
                        isTouchingPlatform.deweyOnPlatform(new Point(iX + width + (int) CurrentGameState.xOffset - 1,
                                iY + (int) CurrentGameState.yOffset), p[i])) {
                    jumping = false;
                    falling = true;
                }*/
                //bottom collision

                if (isTouchingPlatform.deweyOnPlatform(new Point(iX + (int) CurrentGameState.xOffset + 2,
                        iY + height + (int) CurrentGameState.yOffset), p[i]) ||
                        isTouchingPlatform.deweyOnPlatform(new Point(iX + width + (int) CurrentGameState.xOffset - 1,
                                iY + height + (int) CurrentGameState.yOffset), p[i])) {
                    y = p[i].getY() - height - CurrentGameState.yOffset;
                    falling = false;
                    topCollision = true;
                }

                //------ WATER COLLISION CHECK ---------//
                //-------GAME OVER!!!!! ---------------//
                if(isTouchingWater.deweyOnWater((int)(iY + height + CurrentGameState.yOffset))){
                    //Game over update image and set size
                    deweyImg = bkgImg;
                    falling = false;
                    this.x = 0;
                    this.y = 0;
                    width = 1004;
                    height = 669;
                }
                //------ GAME IS OVER WHEN WATER IS TOUCHED --------//
                else {
                    if (!topCollision ) {
                            falling = true;
                        }
                    }
                }
    // --------- END OF FOR PLATFORM COLLISION LOOP --------//



        //-------------END OF COLLISIONS LOOP-------------//

        //resetting topCollision
        topCollision = false;


        //---MOVE RIGHT----//
        if (right){
            i = new ImageIcon("images/deweyRightFace.png");
            deweyImg = i.getImage();
            CurrentGameState.xOffset += moveSpeed;
        }

        //---MOVE LEFT ----//
        if (left){
            i = new ImageIcon("images/deweyLeftFace.png");
            deweyImg = i.getImage();
            CurrentGameState.xOffset -= moveSpeed;
        }

        //----- JUMPING ----//
        if (jumping){
            //jumping
            CurrentGameState.yOffset -= currentJumpSpeed;

            // slows down by .1 tick every tick
            // represents gravity
            currentJumpSpeed -= .1;

            if(currentJumpSpeed <= 0){
                currentJumpSpeed = jumpSpeed;
                jumping = false;
                falling = true;
            }
        }

        //------- FALLING -----------//
        if (falling){
            CurrentGameState.yOffset += currentFallSpeed;

            if(currentFallSpeed < maxFallSpeed){
                currentFallSpeed += .1;
            }
        }
        //reset fall speed so its not falling super fast
        if (!falling){
            currentFallSpeed = .1;
        }
    }


    public void draw(Graphics g){
        g.drawImage(deweyImg,(int)x,(int)y,width,height, null);
    }

    //when the user presses either right or left arrow key,
    // movement begins
    public void keyPressed(int n){
        if(n == KeyEvent.VK_RIGHT){
            right = true;
        }
        if(n == KeyEvent.VK_LEFT){
            left = true;
        }
        //by making sure the player isn't jumping or already falling
        //  prevents abnormal events where player is able to jump in mid air while falling
        if(n == KeyEvent.VK_SPACE && !jumping && !falling){
            jumping = true;
        }
    }

    //when user lets go of the left or right key the movement will
    // stop
    public void keyReleased(int n){
        if(n == KeyEvent.VK_RIGHT){
            right = false;
        }
        if(n == KeyEvent.VK_LEFT){
            left = false;
        }
    }
}
