import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Key extends Mover {
     public Key() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);
    } 
    public void act() {
        applyVelocity();
        if(isTouching(Hero.class)) {
            getWorld().removeObject(this);
        }     
    }
}
