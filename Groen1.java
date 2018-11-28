import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Groen1 extends Actor {
    private boolean onThis = false;
    public int character;
    
    public Groen1(int character) {
        this.character = character;
    }
    public void act() {
        if (Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
        if (onThis)
            setImage("Groen2.png"); 
        else
            setImage("Groen1.png"); 
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MyWorld(character));
        }
    } 
}


