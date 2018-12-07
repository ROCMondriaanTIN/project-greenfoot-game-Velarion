import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MovingWall extends Mover {
    private int walkRange;
    private int yMin;
    private int yMax;
    private boolean firstAct;
    private double speed;
    private boolean isSolid;
    
    public MovingWall() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);

        walkRange = 190;
        firstAct = true;
        speed = 1.8;
        isSolid = true;
    }   
    
    public void act() {
        int x = getX();
        int y = getY();
 
        if (firstAct) {
            firstAct = false;
            yMin = y - walkRange / 2;
            yMax = y + walkRange / 2;
        }
        velocityY = speed;
        applyVelocity();
        if (getY() >= yMax) {
            speed *= -1;
            y = yMax;
        } 
        else if (getY() <= yMin) {
            speed *= -1;
            y = yMin;
        }    
}
}
