import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartSpel extends Mover {
    public int character;
    
    public StartSpel(int character) {
        this.character = character;
    }
    public void act() {
         if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Characterscreen(character));
        }
    }    
}
