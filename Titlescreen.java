import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Titlescreen extends World {
    public int character;
    
    public Titlescreen() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        this.setBackground("bg.png");
        this.character = character;
        
        addObject(new StartSpel(character), 500, 400);
    }
}
