import greenfoot.*;
import java.util.*;

public class Enemy extends Mover {

    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed;

    public Enemy() {
        super();
        setImage("snailWalk1.png");
        getImage().mirrorHorizontally();
        walkRange = 140;
        firstAct = true;
        speed = 1;
        GreenfootImage image = getImage();
        image.scale(image.getWidth() + 20, image.getHeight() + 20);
        setImage(image);
    }

    @Override
    public void act() {
        int x = getX();
        int y = getY();

        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }
        velocityX = speed;
        applyVelocity();
        if (getX() >= xMax) {
            speed *= -1;
            x = xMax;
            getImage().mirrorHorizontally();
        } 
        else if (getX() <= xMin) {
            speed *= -1;
            x = xMin;
            getImage().mirrorHorizontally();
        }
        if (getOneObjectAtOffset(-19, -45, Hero.class) != null 
            || getOneObjectAtOffset(19, -45, Hero.class) != null) {  
           getWorld().removeObject(this);  
        } 
    }
}
