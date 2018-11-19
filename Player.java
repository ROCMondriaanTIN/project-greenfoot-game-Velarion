import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Hero {
    public Player(String image, int number) {
        setImage(image);
}
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld());
    }   
}
}

