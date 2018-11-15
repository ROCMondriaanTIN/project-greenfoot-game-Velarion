import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Block extends Mover{
    public Block() {
       GreenfootImage image = getImage();
       image.scale(image.getWidth() - 10, image.getHeight() - 10);
       setImage(image);
    }
    public void act() {
       for (Actor hero : getIntersectingObjects(Hero.class)) {
           if (isTouching(Block.class)) {
               getImage().setTransparency(0);   
           }    
       }
       applyVelocity();
    }
    public void mijnMethode() {
        for (Actor gem : getIntersectingObjects(Gem.class)) {
            getImage().setTransparency(0);   
    }
}
}

