import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Groen1 extends Mover {
    private boolean onThis = false;
    public int character = 1;
    
    public Groen1(int character) {
        this.character = character;
    }
    public void act() {
        if (Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
        if (onThis)
            setImage("Groen2.png"); 
        else
            setImage("Groen1.png"); 
        if (Greenfoot.mouseClicked(this)){
            character = 1;
            MyWorld myworld = new MyWorld(character);
            //Blauw1 blauw = new Blauw1(character);
            Groen1 groen = new Groen1(character);
            Roze1 roze = new Roze1(character);
            Greenfoot.setWorld(new MyWorld(character));
            
        }
    } 
}


