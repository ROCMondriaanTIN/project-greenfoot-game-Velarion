import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Characterscreen extends World {
    int character = 1;
    
    public Characterscreen(int character) {    
        super(1000, 800, 1); 
        setBackground("BackgroundCharacterscreen.png");
        this.character = character;
        
        addObject(new GreenHead(), 180, 400);
        addObject(new BlueHead(), 500, 400);
        addObject(new PinkHead(), 800, 400);
        addObject(new Groen1(character), 186, 400);
        addObject(new Blauw1(character), 499, 400);
        addObject(new Roze1(character), 812, 400);
        setPaintOrder(GreenHead.class,Groen1.class, 
        BlueHead.class, Blauw1.class, PinkHead.class, Roze1.class);

        
}
}

