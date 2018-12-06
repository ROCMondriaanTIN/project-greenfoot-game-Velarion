import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level3Picture extends Actor {
    private boolean onThis = false;
    private boolean levelDone = false;
    public int character;
    
    public Level3Picture(int character) {
        this.character = character;
        GreenfootImage image = getImage();
        image.scale(image.getWidth() + 20, image.getHeight() + 20);
        setImage(image);
    }
    public void act() {
        if (levelDone == true) {
            if (Greenfoot.mouseMoved(null))
                onThis = Greenfoot.mouseMoved(this);
            if (onThis)
                setImage("Level1Picture2.png"); 
            else
                setImage("Level1Picture1.png"); 
            if (Greenfoot.mouseClicked(this)){
                Greenfoot.setWorld(new Level3(character));
            }
        }
    }    
}
