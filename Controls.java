import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Controls extends Actor {
    private boolean onThis = false;
    
    public void act() {
        if (Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
        if (onThis)
            setImage("controls2.png"); 
        else
            setImage("controls1.png"); 
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new ControlsScherm());
        }    
    }    
}
