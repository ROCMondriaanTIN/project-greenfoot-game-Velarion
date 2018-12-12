import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Victory extends Actor {
    public static int gem = 0;
    
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
        if (gem >= 1) {
        if (gem == 1) {
            gem -= 1;
        }
        else if (gem == 2) {
            gem -=2 ;
        }
        else if (gem == 3) {
            gem -= 3;
        }
        else {
            gem -= 4;
        }
    }
    }
}
