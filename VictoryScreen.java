import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class VictoryScreen extends World {
    Victory vt;
    
    public VictoryScreen() {    
        super(1000, 800, 1);
        setBackground("VictoryBackground.png");
        vt = new Victory();
        
        addObject(new Victory(), 550, 400);
        addObject(new ReturnButton2(), 500, 650);
    }
}
