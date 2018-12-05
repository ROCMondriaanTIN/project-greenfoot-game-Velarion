import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartSpel extends Actor {
    private boolean onThis = false;
    public int character;
    public StartSpel(int character) {
        this.character = character;
    }
    public void act() {
        if (Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
        if (onThis)
            setImage("startSpel2.png"); 
        else
            setImage("startSpel1.png"); 
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Characterscreen());
        }    
    }    
}
