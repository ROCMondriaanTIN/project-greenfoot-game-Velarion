import greenfoot.*;

public class Hero extends Mover {
    private final double gravity;
    private final double acc;
    private final double drag;
    private boolean inAir;
    public boolean keyObtained;
    private boolean lookingLeft;
    private boolean lookingRight;
    private int animationCounter = 0; 
    int character;
    private int frame = 1;
    private boolean goldenKey1;
    public static int life = 2;
    
    ScoreBoard sb;
    GoldenKey gk;
    Victory vt;
    
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
        if (vt == null) {
            vt = new Victory();
        }
        if (gk == null) {
            gk = new GoldenKey();
            getWorld().addObject(gk, + 40, + 120);
        }
        if (sb == null) {
            sb = new ScoreBoard();
            getWorld().addObject(sb, + 900, + 50);
        }
        sb.show(character);
        handleInput(character);
        key();
        gem();
        door(character);
        enemy();
        fireball();
        coin();
        movingWall();
        teleportBlock();
        water();
        lava();
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
            isTouching(MovingPlatform6.class) ||
            isTouching(MovingPlatform8.class) ||
            isTouching(MovingPlatform9.class) ||
            isTouching(MovingPlatform10.class)) {
            velocityY = 0;
            if (Greenfoot.isKeyDown("space")) {
                velocityY = -15;
            }
        }
        if (isTouching(MovingPlatform7.class) || isTouching(MovingPlatform11.class)) {
            velocityY = 0;
            if (Greenfoot.isKeyDown("space")) {
                velocityY = -15;
            }
        }    
        if (isTouching(MovingWall.class)) {
            velocityX = -1;
        }
        applyVelocity();
    }
    public boolean key() {
        if (isTouching(Key.class)) { 
           keyObtained = true;
           gk.change();
           Greenfoot.playSound("keySound.wav");
        }
        return keyObtained;
    }
    public void gem() {
        if (isTouching(Gem.class)) {
            Actor gem = getOneIntersectingObject(Gem.class);  
            getWorld().removeObject(gem);
            vt.addGem();
            sb.showGem();
            Greenfoot.playSound("gemSound.wav");
        }
    }
    public void door(int character) {
        this.character = character;
        
        if (isTouching(Door1.class) && isTouching(Door2.class) 
        && keyObtained == true) {
            Greenfoot.setWorld(new Level2(character));
            Greenfoot.playSound("levelWinSound.wav");
            Level2Picture.keyObtained1 = true;
        }
        if (isTouching(Door3.class) && isTouching(Door4.class) 
        && keyObtained == true) {
            Greenfoot.setWorld(new Level3(character));
            Greenfoot.playSound("levelWinSound.wav");
            Level3Picture.keyObtained2 = true;
        }
        if (isTouching(Door5.class) && isTouching(Door6.class) 
        && keyObtained == true) {
            Greenfoot.setWorld(new Level4(character));
            Greenfoot.playSound("levelWinSound.wav");
            Level4Picture.keyObtained3 = true;
        }
        if (isTouching(Door7.class) && isTouching(Door8.class) 
        && keyObtained == true) {
            Greenfoot.setWorld(new VictoryScreen());
        }
    }
    public void keyActivate1(boolean goldenKey1) {
        this.goldenKey1 = goldenKey1;
    }
    public void enemy() {
        if (isTouching(Enemy.class)) {
            removeTouching(Enemy.class);
            setLocation(83, 1035);
            sb.healthRemove();
        }
    }
    public void fireball() {
        if (isTouching(Fireball.class)) {
            removeTouching(Fireball.class);
            setLocation(83, 973);
            sb.healthRemove();
        } 
    }    
    public void coin() {
        if (isTouching(CoinGold.class)) {
            Actor coinGold = getOneIntersectingObject(CoinGold.class);  
            getWorld().removeObject(coinGold);
            sb.addGold();
            Greenfoot.playSound("coinSound.wav");
        }   
        if (isTouching(CoinSilver.class)){
            Actor coinSilver = getOneIntersectingObject(CoinSilver.class);  
            getWorld().removeObject(coinSilver);
            sb.addSilver();
            Greenfoot.playSound("coinSound.wav");
        }
    }       
    public void movingWall() {
        if (getOneObjectAtOffset(-19, -10, MovingWall.class) != null 
            || getOneObjectAtOffset(19, -10, MovingWall.class) != null) {  
           setLocation(83, 973);
           sb.healthRemove();
        } 
    }
    public void teleportBlock() {
        if (isTouching(TeleportObject.class)) {
            setLocation(624, 553);
        }
    }
    public void water() {
        for (Actor water : getIntersectingObjects(WaterTile.class)) {
            if (water != null) {
                setLocation(83, 1035);
                sb.healthRemove();
            }
            break;
        }
    }
    public void lava() {
        for (Actor lava : getIntersectingObjects(LavaTile.class)) {
            if (lava != null) {
                setLocation(83, 973);
                sb.healthRemove();
            }
            break;
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
