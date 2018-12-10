import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreBoard extends Actor {
    private int goldPosition = 40;
    private int silverPosition = 40;
    private int lifePosition = 150;
    private int lifePosition2 = 95;
    private int lifeCount = 1;
    public static int score = 0;
    public static int gem = 0;
    public static int life = 4;
    public int character;
    private boolean start = false;
    private boolean gained = false;
    private boolean test = true;
        
    public void act() {
        lifeCounter(character);
        setImage(new GreenfootImage("Score: " + life, 24, Color.BLACK, null));
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
    public void addGem() {
        gem += 1;
    }
    public boolean beginHealth(int character) {
        this.character = character;
        if (start == false) {
            getWorld().addObject(new LifeCoin(character), 40, 50);
            getWorld().addObject(new LifeCoin(character), 95, 50);
        }
        return start = true;
    }
    public int healthRemove() {
        life -= 1;
        lifePosition -= 55;
        
        if (life == 3 && test == true) {
            getWorld().removeObject(getWorld()
            .getObjectsAt(lifePosition2, 50, LifeCoin.class).get(0));
            test = false;
        }
        else if (life == 4) {
            getWorld().removeObject(getWorld()
            .getObjectsAt(lifePosition2, 50, LifeCoin.class).get(0));
        }     
        else if (life == 5 && gained == true) {
            getWorld().removeObject(getWorld().
            getObjectsAt(lifePosition2, 50, LifeCoin.class).get(0));
            gained = false;
        }
        
        return lifePosition2 -= 55;
    }
    public void lifeCounter(int character) {
        this.character = character;
        if (score >= 20 ) {
            getWorld().addObject(new LifeCoin(character), lifePosition, 50);
            lifeCount += 1;
            score = 0;
            life += 1;
            gained = true;
            lifePosition2 += 55;
        }
        if (life == 0) {
            Greenfoot.setWorld(new GameOver());
            Greenfoot.playSound("gameOverSound.wav");
            life = 4;
            score = 0;
            start = false;
        }
    }
    public void reset() {
        score = 0;
    }
    /* public void check() {
        if (life == 2) {
            Actor life = getOneIntersectingObject(LifeCoin.class);
            getWorld().removeObject(life);
        }
    }
    */
}
