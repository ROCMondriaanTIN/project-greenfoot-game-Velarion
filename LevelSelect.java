import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelSelect extends World {  
    public LevelSelect() {   
        super(1000, 800, 1); 

        setBackground("bg.png");
        
        addObject(new SelecteerJeLevel(), 500, 100);
        addObject(new Level1Picture(), 300, 330);
    }
}
