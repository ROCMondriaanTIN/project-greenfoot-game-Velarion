import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends World {
    public GameOver() {    
        super(1000, 800, 1); 
        this.setBackground("GameOver.png");
        
        addObject(new GameOverHero(), 800, 600);
        addObject(new ReturnButton(), 300, 600);
    }
}
