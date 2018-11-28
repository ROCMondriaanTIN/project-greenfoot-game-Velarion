import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GreenHead extends Actor {
    public GreenHead() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() + 70, image.getHeight() + 70);
        setImage(image);
    }
    public void act() {
    }    
}
