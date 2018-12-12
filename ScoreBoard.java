import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class ScoreBoard extends Actor {
    public static int score = 0;
    public static int life = 4;
    private int goldPosition = 40;
    private int silverPosition = 40;
    public int character;
    private boolean start = false;
    private boolean lost = false;
    
    ArrayList<LifeCoin> heart =new ArrayList<LifeCoin>();
    
    Victory vt;
    
    public void act() {
        dead();
        gainLife();
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
    public void showGem() {
        getWorld().addObject(new SubGem(), 100, 120);
    }
    public void healthRemove() {
        Hero.life --;
        show(character);
    }
    public void show(int character) {
        this.character = character;
        
        for (int i =0; i < heart.size();i++){
            getWorld().removeObject(heart.get(i));
        }
        heart.clear();
        
        for (int i =0; i< Hero.life; i++){
            LifeCoin life = new LifeCoin(character);
            life.setImage("hud_p" + character + ".png");
            getWorld().addObject(life, 40+(i*60), 50);
            heart.add(life);
        }
    }
    public void gainLife() {
        if (score >= 20 && score <= 22) {
            Hero.life ++;
            score = 0;
            show(character);
        }
    }
    public void dead() {
        if (Hero.life == 0) {
            Greenfoot.setWorld(new GameOver());
            Greenfoot.playSound("gameOverSound.wav");
            Victory.gem = 0;
            Level2Picture.keyObtained1 = false;
            Level3Picture.keyObtained2 = false;
            Level4Picture.keyObtained3 = false;
            reset(); 
        }
    }
    public void reset() {
        score = 0;
        Hero.life = 2;
    }
}
