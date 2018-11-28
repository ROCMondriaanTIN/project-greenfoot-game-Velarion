
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Gem extends Mover {
    private int transparency = 0;
    
    public Gem() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        getImage().setTransparency(transparency);
    }   
    public void act() {
        if(isTouching(Hero.class)) {
            getWorld().removeObject(this);
        }   
        applyVelocity();
    }
    public void inRange() {
        if(!getObjectsInRange(200, Hero.class).isEmpty()) {
            transparency = 255;
        }
    }
}

