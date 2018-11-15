
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Gem extends Mover {
    private int transparency = 255;
    
    public Gem() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);
        getImage().setTransparency(transparency);
    }   
    public void act() {
        if(isTouching(Hero.class)) {
            getWorld().removeObject(this);
        }   
        applyVelocity();
    }
}

