import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Roze1 extends Mover {
    private boolean onThis = false;
    
    public void act() {
        if(Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
        if(onThis)
            setImage("Roze2.png"); 
        else
            setImage("Roze1.png"); 
    }    
}