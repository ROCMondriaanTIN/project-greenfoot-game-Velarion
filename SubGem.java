import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class SubGem extends Gem {
    private int transparency = 255;
    
    public SubGem() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth(), image.getHeight());
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

