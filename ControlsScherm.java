import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ControlsScherm extends World {
    public ControlsScherm() {    
       super(1000, 800, 1); 
       setBackground("ControlsScherm.png");
       
       addObject(new ReturnButton2(), 150, 700); 
    }
}
