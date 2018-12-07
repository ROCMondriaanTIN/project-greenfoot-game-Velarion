import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level2Picture extends Actor {
    private boolean onThis = false;
    public int character;
    
    ScoreBoard sb;
    
    public Level2Picture(int character) {
        this.character = character;
        GreenfootImage image = getImage();
        image.scale(image.getWidth() + 20, image.getHeight() + 20);
        setImage(image);
    }
    public void act() {
        sb = new ScoreBoard();
        if (Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
        if (onThis)
            setImage("Level2Picture2.png"); 
        else
            setImage("Level2Picture1.png"); 
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Level2(character));
            sb.reset();
        }
    }    
}
