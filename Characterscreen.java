import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Characterscreen extends World {
    public Characterscreen() {    
        super(1000, 800, 1); 
        setBackground("bg.png");
        
        addObject(new GreenHead(), 250, 400);
        addObject(new BlueHead(), 500, 400);
        addObject(new PinkHead(), 750, 400);
        
     
        
}
}

