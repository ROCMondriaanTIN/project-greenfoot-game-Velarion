import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreBoard extends Mover {
    private int goldPosition = 40;
    private int silverPosition = 40;
    private int lifePosition = 40;
    private int score = 0;
    private int life = 2;
    public int character;

    public void act() {
        healthAdd(character);
    } 
    public void addSilver() {
        score += 1;
        getWorld().addObject(new Silver(), silverPosition, 190);
        silverPosition += 25;
    }
    public void addGold() {
        score += 2;
        getWorld().addObject(new Gold(), goldPosition, 230);
        goldPosition += 25;
    }
    public void healthAdd(int character) {
        this.character = character;
        getWorld().addObject(new LifeCoin(character), lifePosition, 50);
        getWorld().addObject(new LifeCoin(character), 100, 50);
        if (score == 20) {
            life += 1;
            getWorld().addObject(new LifeCoin(character), lifePosition, 50);
            lifePosition += 50;
            score = 0;
        }
    }
    public void healthRemove() {
        Actor lifeCoin = getOneIntersectingObject(LifeCoin.class);  
        getWorld().removeObject(lifeCoin);
    }
}
