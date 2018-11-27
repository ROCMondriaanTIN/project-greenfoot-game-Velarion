import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LifeCoin extends Mover {
    public int character;
    
    public LifeCoin(int character) {
        this.character = character;
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage("hud_p" + character + ".png");
    }
    public void act()  {
        applyVelocity();
    }   
}
