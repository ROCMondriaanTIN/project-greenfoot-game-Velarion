import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class ReturnButton2 extends Actor {
    private boolean onThis = false;
    
    public ReturnButton2() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 50, image.getHeight() - 50);
        setImage(image);
    }
    public void act() {
        if(Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
        if(onThis)
            setImage("ReturnButton4.png"); 
        else
            setImage("ReturnButton3.png"); 
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Titlescreen());
        }
    }
}    

