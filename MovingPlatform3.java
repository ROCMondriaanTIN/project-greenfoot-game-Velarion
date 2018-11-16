import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MovingPlatform3 extends Mover {
    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed;
    private boolean isSolid;
    
    public MovingPlatform3() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);

        walkRange = 140;
        firstAct = true;
        speed = 1;
        isSolid = true;
    }   
    
    public void act() {
        int x = getX();
        int y = getY();

        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }
        velocityX = speed;
        applyVelocity();
        if (getX() >= xMax) {
            speed *= -1;
            x = xMax;
        } 
        else if (getX() <= xMin) {
            speed *= -1;
            x = xMin;
        }    
}
}
