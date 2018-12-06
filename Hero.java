 import greenfoot.*;

public class Hero extends Mover {
    private final double gravity;
    private final double acc;
    private final double drag;
    private boolean inAir;
    private boolean onGround;
    private boolean keyObtained = false;
    private boolean lookingLeft;
    private boolean lookingRight;
    private boolean touching = false;
    private int animationCounter = 0; 
    private int lifeAmount = 4;
    int character;
    private int frame = 1;
    
    ScoreBoard sb;

    public Hero(int character) {         
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p" + character + ".png");
        this.character = character;
    }

    @Override
    public void act() {
        if (sb == null) {
            sb = new ScoreBoard();
            getWorld().addObject(sb, + 900, + 50);
        }
        sb.beginHealth(character);
        handleInput(character);
        key();
        gem();
        door();
        enemy();
        fireball();
        coin();
        movingWall();
        animationCounter ++;
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        if (isTouching(MovingPlatform1.class) || 
            isTouching(MovingPlatform2.class) || 
            isTouching(MovingPlatform3.class) ||
            isTouching(MovingPlatform4.class) ||
            isTouching(MovingPlatform5.class) ||
            isTouching(MovingPlatform6.class)) {
            velocityY = 0;
            if (Greenfoot.isKeyDown("space")) {
                velocityY = -15;
            }
        }
        for (Actor wall : getIntersectingObjects(MovingWall.class)) {
            if (isTouching(MovingWall.class) && !touching) {
                velocityX = -1;
            }
            break;
        }
        if (isTouching(Water.class)) {
            velocityY = 0;
        }
        if (isTouching(Lava.class)) {
            setLocation(83, 973);
            sb.healthRemove();
        } 
        applyVelocity();
    }
    public void key() {
        if (isTouching(Key.class)) { 
           keyObtained = true;
        }
    }
    public void gem() {
        if (isTouching(Gem.class)) {
            Actor gem = getOneIntersectingObject(Gem.class);  
            getWorld().removeObject(gem);
        }
    }
    public void door() {
        if (isTouching(Door1.class) && isTouching(Door2.class) 
        && keyObtained == true) {
            Greenfoot.setWorld(new Level2(character));
        }
        if (isTouching(Door3.class) && isTouching(Door4.class) 
        && keyObtained == true) {
            Greenfoot.setWorld(new Level3(character));
        }
    }
    public void enemy() {
        if (isTouching(Enemy.class)) {
            setLocation(83, 1035);
            sb.healthRemove();
        }
    }
    public void fireball() {
        if (isTouching(Fireball.class)) {
            setLocation(83, 973);
            sb.healthRemove();
        } 
    }    
    public void coin() {
        if (isTouching(CoinGold.class)) {
            Actor coinGold = getOneIntersectingObject(CoinGold.class);  
            getWorld().removeObject(coinGold);
            sb.addGold();
        }   
        if (isTouching(CoinSilver.class)){
            Actor coinSilver = getOneIntersectingObject(CoinSilver.class);  
            getWorld().removeObject(coinSilver);
            sb.addSilver();
        }
    }       
    public void movingWall() {
        if (getOneObjectAtOffset(-19, -10, MovingWall.class) != null 
            || getOneObjectAtOffset(19, -10, MovingWall.class) != null) {  
           setLocation(83, 973);
           sb.healthRemove();
        } 
    }
    public void animateRight(int character) {
        this.character = character;
        lookingRight = true;
        
        if (frame == 1) {
            setImage("p" + character +"_walk1.png");
        }
        else if (frame == 2) {
            setImage("p" + character + "_walk2.png");
        }
        else if (frame == 3) {
            setImage("p" + character + "_walk3.png");
        }  
        else if (frame == 4) {
            setImage("p" + character + "_walk4.png");
        }
        else if (frame == 5) {
            setImage("p" + character + "_walk5.png");
        }  
        else if (frame == 6) {
            setImage("p" + character + "_walk6.png");
        }
        else if (frame == 7) {
            setImage("p" + character + "_walk7.png");
        }  
        else if (frame == 8) {
            setImage("p" + character + "_walk8.png");
        }
        else if (frame == 9) {
            setImage("p" + character + "_walk9.png");
            frame = 1;
            return;
        }  
        frame ++;
    }
    public void animateLeft(int character) {
        this.character = character;
        lookingLeft = false;
        
        if (frame == 1) {
            setImage("p" + character + "_walk1mirrored.png");
        }
        else if (frame == 2) {
            setImage("p" + character + "_walk2mirrored.png");
        }
        else if (frame == 3) {
            setImage("p" + character + "_walk3mirrored.png");
        }  
        else if (frame == 4) {
            setImage("p" + character + "_walk4mirrored.png");
        }
        else if (frame == 5) {
            setImage("p" + character + "_walk5mirrored.png");
        }  
        else if (frame == 6) {
            setImage("p" + character + "_walk6mirrored.png");
        }
        else if (frame == 7) {
            setImage("p" + character + "_walk7mirrored.png");
        }  
        else if (frame == 8) {
            setImage("p" + character + "_walk8mirrored.png");
        }
        else if (frame == 9) {
            setImage("p" + character + "_walk9mirrored.png");
            frame = 1;
            return;
        }  
        frame ++;
    }
    public void handleInput(int character) {
        this.character = character;
        if (Greenfoot.isKeyDown("space")) {
            for (Tile tile : getIntersectingObjects(Tile.class)) {
                if (tile != null) {
                    inAir = false;
                    velocityY = -15; 
                }
                if (lookingRight == true) {
                    setImage("p" + character + "_jump.png");
                    lookingRight = false;
                }
                else if (lookingLeft == false) {
                    setImage("p" + character + "_jumpmirrored.png");
                    lookingLeft = true;
                }
                else  {
                    inAir = true;
                } 
            }
        }
        if (Greenfoot.isKeyDown("left")) {
            if(animationCounter % -4 == 0)
            velocityX = -9; 
            animateLeft(character);
        } 
        else if (Greenfoot.isKeyDown("right")) {
            if(animationCounter % 4 == 0)
            velocityX = 9;
            animateRight(character);
        }
        else if (lookingRight == true && Greenfoot.isKeyDown("down")) {
            setImage("p" + character + "_duck.png");
            lookingRight = false;
        }
        else if (lookingLeft == false && Greenfoot.isKeyDown("down")) {
            setImage("p" + character + "_duckmirrored.png");
            lookingLeft = true;
        }
    }
    public int getWidth() {
        return getImage().getWidth();
    }
    public int getHeight() {
        return getImage().getHeight();
    }  
}
