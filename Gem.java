import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Gem extends Mover {
    private int transparency = 0;
    
    public Gem() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        getImage().setTransparency(transparency);
    }   
    public void act() {
        inRange();
        applyVelocity();
    }
    public void inRange() {
        List<Hero> heroes = (List<Hero>)getObjectsInRange(170, Hero.class);
        if (!heroes.isEmpty()) {
           getImage().setTransparency(255);
        }
    }
}

