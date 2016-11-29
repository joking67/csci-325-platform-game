package cloud.burst;

import java.awt.*;
/**
 * Created by Team-CloudBurst on 11/17/2016.
 */
public class isTouchingPlatform {



    /*
        Point d represents a point on dewey (feet)
        Point (Platforms) p represents any part of the platform that dewey jumps on

        if point d is inside point p at any point then this method will return true
        else false.
     */
    public static boolean deweyOnPlatform (Point d, Platforms p){
        return p.contains(d);
    }

}
