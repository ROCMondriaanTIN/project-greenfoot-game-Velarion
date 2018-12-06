import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GoldenKey extends Key {
    public GoldenKey() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() + 10, image.getHeight() + 10);
        setImage("goldKey.png");
    } 
    public void change() {
    }
    public void act() {
        // Add your action code here.
    }    
}
