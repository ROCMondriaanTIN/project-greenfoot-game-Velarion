import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Titlescreen extends World {
    public Titlescreen() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        this.setBackground("Background.png");
        
        addObject(new StartSpel(), 460, 275);
        addObject(new Controls(), 460, 375);
        addObject(new Informatie(), 460, 475);
    }
}
