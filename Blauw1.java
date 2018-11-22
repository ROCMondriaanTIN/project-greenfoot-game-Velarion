import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Blauw1 extends Mover {
    private boolean onThis = false;
    
    public void act() {
        if(Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
        if(onThis)
            setImage("Blauw2.png"); 
        else
            setImage("Blauw1.png"); 
    }    
}
