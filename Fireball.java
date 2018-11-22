import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

    public class Fireball extends Mover {
        public Fireball() {
        super();
        GreenfootImage image = getImage();
        image.scale(image.getWidth() + 30, image.getHeight() + 30);
        setImage(image);
    }
    public void act() {
        velocityX = 0;
        velocityY = 0;
        applyVelocity();
        turn(15);
    }    
}
