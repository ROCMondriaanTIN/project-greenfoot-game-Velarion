import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GoldenKey extends Mover {
    public GoldenKey() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth(), image.getHeight());
        setImage(image);
    } 
    public void change() {
        setImage("goldFullKey.png");
    }
    public void act() {
        // Add your action code here.
    }    
}
