import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartSpel extends Actor {
    public StartSpel() {

    }
    public void act() {
         if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new LevelSelect());
        }
    }    
}
