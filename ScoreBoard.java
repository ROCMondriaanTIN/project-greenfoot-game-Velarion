import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreBoard extends Mover {
    private int goldPosition = 40;
    private int silverPosition = 40;
    private int lifePosition = 40;
    private int score = 0;
    private int life = 2;
    int character;

    public void act() {
        healthAdd();
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
    public void healthAdd() {
        for (Actor health : getIntersectingObjects(LifeCoin.class)) {
            getWorld().addObject(new LifeCoin(character), lifePosition, 120);
            getWorld().addObject(new LifeCoin(character), lifePosition, 50);
            break;
        }
        if (score == 20) {
            life += 1;
            getWorld().addObject(new LifeCoin(character), lifePosition, 50);
            lifePosition += 50;
            score = 0;
        }
    }
}
