import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelSelect extends World { 
    public int character;
    private boolean keyObtained;
    
    public LevelSelect(int character) {   
        super(1000, 800, 1); 
        this.character = character;
        this.keyObtained = keyObtained;
        
        setBackground("bg.png");
        
        addObject(new SelecteerJeLevel(), 500, 100);
        addObject(new Level1Picture(character), 300, 330);
        addObject(new Level2Picture(character), 700, 330);
        addObject(new Level3Picture(character), 300, 630);
        addObject(new Level4Picture(character), 700, 630);
        
    }
}
