import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreBoard extends Mover {
    private int goldPosition = 30;
    private int silverPosition = 30;
    private int lifePosition = 30;
    private int score = 0;
    private int life = 2;
    int character;

    public void act() {
        applyVelocity();
    } 
    public void addSilver() {
        score += 1;
       
        silverPosition += 15;
        
    }
    public void addGold() {
        score += 2;
       
        goldPosition += 15;
       
    }
    public void healthAdd() {
        if (score == 20) {
            life += 1;
            
            lifePosition += 50;
            score = 0;
        }
    }
}
