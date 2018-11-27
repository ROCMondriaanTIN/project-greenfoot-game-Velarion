import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LifeCoin extends Mover {
    public int character;
    
    public LifeCoin(int character) {
        this.character = character;
        setImage("hud_p" + character + ".png");
    }
    public void act()  {
    }   
}
