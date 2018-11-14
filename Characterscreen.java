import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Characterscreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Characterscreen extends World
{

    public Characterscreen()
    {    
        super(1000, 800, 1); 
        
        addObject(new Hero1(), 200, 600);
        addObject(new Hero2(), 300, 600);
        addObject(new Hero3(), 400, 600);
        
    }
}
