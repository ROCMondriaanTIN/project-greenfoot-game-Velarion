import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ScoreBoard extends Actor {
    private int goldPosition = 40;
    private int silverPosition = 40;
    private int lifePosition = 150;
    private int lifePosition2 = 95;
    private int score = 0;
    protected int life = 4;
    public int character;
    private boolean start = false;
    private boolean lost = true;
    
    public void act() {
        healthAdd(character);
        beginHealth();
        lifeCounter();
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
    public void healthAdd(int character) {
       this.character = character;
       
       if (score == 4 ) {
            getWorld().addObject(new LifeCoin(character), lifePosition, 50);
            score = 0;
            life += 1;
            lost = false;
       }
    }
    public boolean beginHealth() {
        if (start == false) {
            getWorld().addObject(new LifeCoin(character), 40, 50);
            getWorld().addObject(new LifeCoin(character), 95, 50);
        }
        return start = true;
    }
    public void healthRemove() {
        life -= 1;
        
        if (life == 3 && lost == true) {
            lifePosition = 95;
            getWorld().removeObject(getWorld()
            .getObjectsAt(95, 50, LifeCoin.class).get(0));
        }
        else if (life == 4) {
            getWorld().removeObject(getWorld()
            .getObjectsAt(150, 50, LifeCoin.class).get(0));
        }     
     
        else if (life == 2 && score == 0) {
             getWorld().removeObject(getWorld()
            .getObjectsAt(lifePosition2, 50, LifeCoin.class).get(0));
        }
    }
    public void lifeCounter() {
        if (life == 0) {
            Greenfoot.setWorld(new GameOver());
        }
    } 
}
