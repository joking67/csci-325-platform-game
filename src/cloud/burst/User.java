package cloud.burst;

/**
 * Created by Team-CloudBurst on 11/12/2016.
 */
public class User {
    private String userName;
    private int score;

    // ----constructor -----//
    public User(){
        userName= "";
        score = 0;
    }
    //   ----end of constructor ---//

    // ----- Methods -----//
    public User(String n, int s){
        userName = n;
        score = s;
    }

    public String getName(){
        return userName;
    }

    public int getScore(){
        return score;
    }

    public void setName(String n){
        userName = n;
    }

    public void setScore(int s){
        score = s;
    }

    public String toString(){
        String userTotalScore = userName + " - " + score;

        return userTotalScore;
    }


    // ----- end of methods -----//
}

