import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreBoard extends Actor {
    private int goldPosition = 40;
    private int silverPosition = 40;
    private int lifePosition = 150;
    private int lifePosition2 = 95;
    public static int score = 0;
    public static int life = 4;
    public int character;
    private boolean start = false;
    private boolean lost = true;
        
    public void act() {
        beginHealth(character);
        lifeCounter(character);
        setImage(new GreenfootImage("Score: " + score, 24, Color.BLACK, null));
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
    public boolean beginHealth(int character) {
        this.character = character;
        if (start == false) {
            getWorld().addObject(new LifeCoin(character), 40, 50);
            getWorld().addObject(new LifeCoin(character), 95, 50);
            getWorld().addObject(new GoldenKey(), 40, 120);
        }
        return start = true;
    }
    public int healthRemove() {
        life -= 1;

        if (life == 3 && lost == true) {
            getWorld().removeObject(getWorld()
            .getObjectsAt(lifePosition2, 50, LifeCoin.class).get(0));
        }
        else if (life == 4) {
            getWorld().removeObject(getWorld()
            .getObjectsAt(lifePosition2, 50, LifeCoin.class).get(0));
        }     
     
        else if (life == 2 && score == 0) {
            getWorld().removeObject(getWorld()
            .getObjectsAt(lifePosition2, 50, LifeCoin.class).get(0));
        }
        return lifePosition2 -= 55;
    }
    public void lifeCounter(int character) {
        this.character = character;
        if (score == 40 ) {
            lifePosition -= 55;
            getWorld().addObject(new LifeCoin(character), lifePosition, 50);
            score = 0;
            life += 1;
            lost = false;
            lifePosition2 += 55;
        }
        if (life == 0) {
            Greenfoot.setWorld(new GameOver());
            life = 4;
            score = 0;
            start = false;
        }
    } 
}
