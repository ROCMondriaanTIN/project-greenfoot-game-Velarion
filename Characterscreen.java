import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Characterscreen extends World {
    int characterGR = 1;
    int characterBL = 2;
    int characterPI = 3;
    
    public Characterscreen() {    
        super(1000, 800, 1); 
        setBackground("BackgroundCharacterScreen.png");
        
        
        addObject(new GreenHead(), 180, 400);
        addObject(new BlueHead(), 500, 400);
        addObject(new PinkHead(), 800, 400);
        addObject(new Groen1(characterGR), 186, 400);
        addObject(new Blauw1(characterBL), 499, 400);
        addObject(new Roze1(characterPI), 812, 400);
        setPaintOrder(GreenHead.class,Groen1.class, 
        BlueHead.class, Blauw1.class, PinkHead.class, Roze1.class);

        
}
}

