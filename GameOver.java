import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends World {
    public int character;
    
    public GameOver() {    
        super(1000, 800, 1); 
        this.setBackground("GameOver.png");
        this.character = character;
        
        addObject(new GameOverHero(), 800, 600);
        addObject(new ReturnButton(), 150, 700);
    }
}
