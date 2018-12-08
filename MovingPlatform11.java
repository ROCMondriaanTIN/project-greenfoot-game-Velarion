import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MovingPlatform11 extends Mover {
    private int walkRange;
    private int yMin;
    private int yMax;
    private boolean firstAct;
    private int speed;
    private boolean isSolid;
    
    public MovingPlatform11() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 10, image.getHeight() - 10);
        setImage(image);

        walkRange = 192;
        firstAct = true;
        speed = 1;
        isSolid = true;
    }   
    
    public void act() {
        int x = getX();
        int y = getY();
        
        setLocation(getX(), getY()-1);
        Actor p = getOneIntersectingObject(Hero.class);
        setLocation(getX(), getY()+1); 
        
        int ox = getX();
        int oy = getY();
        int dx = getX() - ox;
        int dy = getY() - oy;
 
        if (p != null)
        {
            p.setLocation(p.getX(), p.getY() + speed);
        }
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
