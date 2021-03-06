import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level1Picture extends Actor {
    private boolean onThis = false;
    public int character;
    
    ScoreBoard sb;
    
    public Level1Picture(int character) {
        this.character = character;
        GreenfootImage image = getImage();
        image.scale(image.getWidth() + 20, image.getHeight() + 20);
        setImage(image);
    }
    public void act() {
        sb = new ScoreBoard();
        mouseMovement();
    }    
    public void mouseMovement() {
        if(Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
        if(onThis)
            setImage("Level1Picture2.png"); 
        else
            setImage("Level1Picture1.png"); 
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Level1(character));
            sb.reset();
        }
    }
}
