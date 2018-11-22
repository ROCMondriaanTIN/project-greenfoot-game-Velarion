import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class ReturnButton extends Mover {
    private boolean onThis = false;
    public int character;
    
    public ReturnButton(int character) {
        this.character = character;
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 50, image.getHeight() - 50);
        setImage(image);
    }
    public void act() {
        if(Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
        if(onThis)
            setImage("ReturnButton2.png"); 
        else
            setImage("ReturnButton1.png"); 
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld(character));
        }
    }
}    

