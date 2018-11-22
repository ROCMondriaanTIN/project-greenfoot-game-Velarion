import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Characterscreen extends World {
    public Characterscreen() {    
        super(1000, 800, 1); 
        setBackground("BackgroundCharacterscreen.png");
        
        addObject(new GreenHead(), 250, 400);
        addObject(new BlueHead(), 500, 400);
        addObject(new PinkHead(), 750, 400);
        addObject(new Groen1(), 186, 400);
        addObject(new Blauw1(), 499, 400);
        addObject(new Roze1(), 812, 400);
        setPaintOrder(GreenHead.class,Groen1.class, 
        BlueHead.class, Blauw1.class, PinkHead.class, Roze1.class);

        
}
}

