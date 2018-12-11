import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreBoard extends Actor {
    private int lifePosition = 150;
    private int lifePosition2 = 95;
    public static int score = 0;
    public static int life = 4;
    private int goldPosition = 40;
    private int silverPosition = 40;
    public int character;
    private boolean start = false;
    private boolean lost = false;
     
    Victory vt;
    
    public void act() {
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
            if (life == 4) {
                getWorld().addObject(new LifeCoin(character), 40, 50);
                getWorld().addObject(new LifeCoin(character), 95, 50);
            }
            else if (life == 5) {
                getWorld().addObject(new LifeCoin(character), 40, 50);
                getWorld().addObject(new LifeCoin(character), 95, 50);
                getWorld().addObject(new LifeCoin(character), 150, 50);
            }
            else if (life == 3) {
                getWorld().addObject(new LifeCoin(character), 40, 50);
                getWorld().addObject(new LifeCoin(character), 95, 50);
                lost = true;
            }
            else if (life == 2) {
                getWorld().addObject(new LifeCoin(character), 40, 50);
            }
            else if (life == 1 && lost == true) {
                getWorld().addObject(new LifeCoin(character), 40, 50);
            }
        }
        return start = true;
    }
    public int healthRemove() {
        life -= 1;
        lifePosition -= 55;
        
        if (life == 3) {
            getWorld().removeObject(getWorld()
            .getObjectsAt(lifePosition2, 50, LifeCoin.class).get(0));
        }
        else if (life == 5) {
            getWorld().removeObject(getWorld()
            .getObjectsAt(lifePosition2, 50, LifeCoin.class).get(0));
        }     
        return lifePosition2 -= 55;
    }
    public void lifeCounter(int character) {
        this.character = character;
        if (score >= 20 && score <= 22) {
            life += 1;
            if (life == 3) {
                getWorld().addObject(new LifeCoin(character), 95, 50);
                lifePosition2 += 55;
            }
            else if (life == 5) {
                getWorld().addObject(new LifeCoin(character), 150, 50); 
                lifePosition2 += 55;
            }
            score = 0;
        }
        if (life == 0) {
            Greenfoot.setWorld(new GameOver());
            Greenfoot.playSound("gameOverSound.wav");
            reset();
            //vt.resetGems();
            start = false;
        }
    }
    public void reset() {
        score = 0;
        life = 4;
    }
}
