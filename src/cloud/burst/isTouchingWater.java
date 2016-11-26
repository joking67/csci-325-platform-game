package cloud.burst;

import java.awt.*;

/**
 * Created by Team-CloudBurst on 11/22/2016.
 */
public class isTouchingWater {



    /*
        Point d represents a point on dewey (feet)
        Point (Waters) w represents any part of the water that dewey jumps on

        if point d is inside point w at any point then this method will return true
        else false.
     */
    public static boolean deweyOnWater (Point d, Water w){
        return w.contains(d);
    }
}