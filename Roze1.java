import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Roze1 extends Mover {
    private boolean onThis = false;
    int character;
    
    public Roze1(int character) {
        this.character = character;
    }
    public void act() {
        if(Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
        if(onThis)
            setImage("Roze2.png"); 
        else
            setImage("Roze1.png"); 
        if (Greenfoot.mouseClicked(this)){
            character = 3;
            Greenfoot.setWorld(new MyWorld(character));
        }
    }    
}