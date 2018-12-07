import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

    public class Fireball extends Mover {
    public Fireball() {
        super();
        setImage("fireball.png");
        GreenfootImage image = getImage();
        image.scale(image.getWidth() + 20, image.getHeight() + 20);
    }
    public void act() {
        applyVelocity();
        turn(15);
    }    
}
