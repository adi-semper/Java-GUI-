package model;

public class Player {

    private int score;
   
    public Player() {
    
        score = 0;
    
    }
    
    public int getScore() {
    
        return score;
    
    }
    
    public void clear() {
    
        score = 0;
    
    }
    
    public void won() {
    
        score++;
    
    }

}
