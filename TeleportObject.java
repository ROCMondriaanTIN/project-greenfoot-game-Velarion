import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TeleportObject extends Mover {
    public TeleportObject() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);
    }   
    public void act() {
        applyVelocity();
    }    
}
