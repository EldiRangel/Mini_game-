package model;

public class Player {
    private String name;
    private int score;
    private int lives;
    
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.lives = 3;
    }
    
    public String getName() { return name; }
    public int getScore() { return score; }
    public int getLives() { return lives; }
    
    public void addScore(int points) { 
        this.score += points; 
    }
    
    public void loseLife() { 
        this.lives--; 
    }
    
    public boolean isAlive() { 
        return lives > 0; 
    }
    
    public void reset() {
        this.score = 0;
        this.lives = 3;
    }
}
