import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Blauw1 extends Actor {
    private boolean onThis = false;
    public int character;
    
    public Blauw1(int character) {
        this.character = character;
    }
    public void act() {
        if(Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
        if(onThis)
            setImage("Blauw2.png"); 
        else
            setImage("Blauw1.png"); 
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MyWorld(character));
        }
    }    
}
