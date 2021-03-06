import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level3Picture extends Actor {
    private boolean onThis = false;
    public static boolean keyObtained2;
    public int character;
    
    ScoreBoard sb;
    
    public Level3Picture(int character) {
        this.character = character;
        GreenfootImage image = getImage();
        image.scale(image.getWidth() + 20, image.getHeight() + 20);
        setImage(image);
    }
    public void act() {
        sb = new ScoreBoard();
        mouseMovement(keyObtained2);
    }    
    public void mouseMovement(boolean keyObtained2) {
        if (keyObtained2 == true) {
            if(Greenfoot.mouseMoved(null))
                onThis = Greenfoot.mouseMoved(this);
            if(onThis)
                setImage("Level3Picture2.png"); 
            else
                setImage("Level3Picture1.png"); 
            if (Greenfoot.mouseClicked(this)){
                Greenfoot.setWorld(new Level3(character));
                sb.reset();
            }
        }
    }
    }

