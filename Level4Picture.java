import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level4Picture extends Actor {
    private boolean onThis = false;
    public int character;
    
    public Level4Picture(int character) {
        this.character = character;
        GreenfootImage image = getImage();
        image.scale(image.getWidth() + 20, image.getHeight() + 20);
        setImage(image);
    }
    public void act() {
        if(Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
        if(onThis)
            setImage("Level1Picture2.png"); 
        else
            setImage("Level1Picture1.png"); 
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Level4());
        }
    }    
}
