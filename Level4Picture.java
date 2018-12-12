import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level4Picture extends Actor {
    private boolean onThis = false;
    public static boolean keyObtained3;
    public int character;
    
    ScoreBoard sb;
    
    public Level4Picture(int character) {
        this.character = character;
        GreenfootImage image = getImage();
        image.scale(image.getWidth() + 20, image.getHeight() + 20);
        setImage(image);
    }
    public void act() {
        sb = new ScoreBoard();
        mouseMovement(keyObtained3);
    }    
    public void mouseMovement(boolean keyObtained3) {
        if (keyObtained3 == true) {
            if(Greenfoot.mouseMoved(null))
                onThis = Greenfoot.mouseMoved(this);
            if(onThis)
                setImage("Level4Picture2.png"); 
            else
                setImage("Level4Picture1.png"); 
            if (Greenfoot.mouseClicked(this)){
                Greenfoot.setWorld(new Level4(character));
                sb.reset();
            }
        }
    }
}
