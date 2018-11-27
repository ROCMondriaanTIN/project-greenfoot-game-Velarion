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
    private int animationCounter = 0; 
    private int lifeAmount = 4;
    private int scoreCounter = 0;
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
        handleInput(character);
        key();
        door();
        enemy();
        fireball();
        coin();
        animationCounter ++;
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        if(isTouching(WaterTopMid.class)) {
            velocityY = 0;
        }
        if (isTouching(MovingPlatform1.class) || 
            isTouching(MovingPlatform2.class) || 
            isTouching(MovingPlatform3.class)) {
            velocityY = 0;
        }
        applyVelocity();
    }
    public void key() {
        if (isTouching(Key.class)) { 
           keyObtained = true;
        }
    }
    public void door() {
        if (isTouching(Door1.class) && isTouching(Door2.class) 
        && keyObtained == true) {
            Greenfoot.setWorld(new Level2());
        }
    }
    public void enemy() {
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (this.isTouching(Enemy.class)) {
                setLocation(83, 1035);
                lifeCounter();
                break;
            }
        }  
    }
    public void fireball() {
        for (Actor fireball : getIntersectingObjects(Fireball.class)) {
            if (fireball != null) {
                setLocation(83, 1035);
                lifeCounter();
                break;
            }
        }  
    }    
    public void lifeCounter() {
        lifeAmount -= 1;
        Actor lifeCoin = getOneIntersectingObject(LifeCoin.class);  
        getWorld().removeObject(lifeCoin);
        if (lifeAmount == 0) {
            Greenfoot.setWorld(new GameOver());
        }
    }

    public void coin() {
        for (Actor coin : getIntersectingObjects(Coins.class)) {
            if (coin != null) {
                if (this.isTouching(CoinGold.class)) {
                    Actor coinGold = getOneIntersectingObject(CoinGold.class);  
                    getWorld().removeObject(coinGold);
                    scoreGold();
                    break;
                }
                else if (this.isTouching(CoinSilver.class)){
                    Actor coinSilver = getOneIntersectingObject(CoinSilver.class);  
                    getWorld().removeObject(coinSilver);
                    scoreSilver();
                    break;
                }
            }
        }
    }
    public void scoreGold() {
        scoreCounter += 2;
    }
    public void scoreSilver() {
        scoreCounter += 1;
    }
    public void animateRight(int character) {
        this.character = character;
        lookingRight = true;
        
        if (frame == 1) {
            setImage("p"+ character +"_walk1.png");
        }
        else if (frame == 2) {
            setImage("p"+ character +"_walk2.png");
        }
        else if (frame == 3) {
            setImage("p"+ character +"_walk3.png");
        }  
        else if (frame == 4) {
            setImage("p"+ character +"_walk4.png");
        }
        else if (frame == 5) {
            setImage("p"+ character +"_walk5.png");
        }  
        else if (frame == 6) {
            setImage("p"+ character +"_walk6.png");
        }
        else if (frame == 7) {
            setImage("p"+ character +"_walk7.png");
        }  
        else if (frame == 8) {
            setImage("p"+ character +"_walk8.png");
        }
        else if (frame == 9) {
            setImage("p"+ character +"_walk9.png");
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
                    inAir =! false;
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
        if (Greenfoot.isKeyDown("a")) {
            if(animationCounter % -4 == 0)
            velocityX = -8; 
            animateLeft(character);
        } 
        else if (Greenfoot.isKeyDown("d")) {
            if(animationCounter % 4 == 0)
            velocityX = 8;
            animateRight(character);
        }
        else if (lookingRight == true && Greenfoot.isKeyDown("s")) {
            setImage("p" + character + "_duck.png");
            lookingRight = false;
        }
        else if (lookingLeft == false && Greenfoot.isKeyDown("s")) {
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
