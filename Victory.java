import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Victory extends Actor {
    private static int gem;
    
    Victory vt;
  
    public void act() {
        if (vt == null) {
            vt = new Victory();
        }
        setImage(new GreenfootImage("x  " + gem, 40, Color.BLACK, null));
    }    
    public void addGem() {
        gem += 1;
    }
    public void resetGems() {
        gem = 0;
    }
}
