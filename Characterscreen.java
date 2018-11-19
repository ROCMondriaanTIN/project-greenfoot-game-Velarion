import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Characterscreen extends World {
    public Characterscreen() {    
        super(1000, 800, 1); 
        
        addObject(new Player("p1.png", 1), 300, 400);
        addObject(new Player("p2.png", 2), 500, 400);
        addObject(new Player("p3.png", 3), 700, 400);
        
        
}
}

