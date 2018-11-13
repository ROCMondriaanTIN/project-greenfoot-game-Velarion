import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Coin extends Actor{
    int transparency = 0;
    
    public void act() {
        if(isTouching(Hero.class)) {
            getImage().setTransparency(0);
        }     
}
}
