import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Informatie extends Actor {
    private boolean onThis = false;
    
    public void act() {
        if (Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
        if (onThis)
            setImage("informatie2.png"); 
        else
            setImage("informatie1.png"); 
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Level2());
        }    
    }    
}
