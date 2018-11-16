import greenfoot.*;

public class Hero extends Mover {
    private final double gravity;
    private final double acc;
    private final double drag;
    private boolean inAir;
    private boolean onGround;
    private boolean keyObtained;
    private boolean lookingLeft;
    private boolean lookingRight;
    
    private int animationCounter = 0; 
    
    private GreenfootImage p1right1 = new GreenfootImage("p1_walk1.png");
    private GreenfootImage p1right2 = new GreenfootImage("p1_walk2.png");
    private GreenfootImage p1right3 = new GreenfootImage("p1_walk3.png");
    private GreenfootImage p1right4 = new GreenfootImage("p1_walk4.png");
    private GreenfootImage p1right5 = new GreenfootImage("p1_walk5.png");
    private GreenfootImage p1right6 = new GreenfootImage("p1_walk6.png");
    private GreenfootImage p1right7 = new GreenfootImage("p1_walk7.png");
    private GreenfootImage p1right8 = new GreenfootImage("p1_walk8.png");
    private GreenfootImage p1right9 = new GreenfootImage("p1_walk9.png");
    
    private GreenfootImage p1left1 = new GreenfootImage("p1_walk1mirrored.png");
    private GreenfootImage p1left2 = new GreenfootImage("p1_walk2mirrored.png");
    private GreenfootImage p1left3 = new GreenfootImage("p1_walk3mirrored.png");
    private GreenfootImage p1left4 = new GreenfootImage("p1_walk4mirrored.png");
    private GreenfootImage p1left5 = new GreenfootImage("p1_walk5mirrored.png");
    private GreenfootImage p1left6 = new GreenfootImage("p1_walk6mirrored.png");
    private GreenfootImage p1left7 = new GreenfootImage("p1_walk7mirrored.png");
    private GreenfootImage p1left8 = new GreenfootImage("p1_walk8mirrored.png");
    private GreenfootImage p1left9 = new GreenfootImage("p1_walk9mirrored.png");
    
    private GreenfootImage p1jump1 = new GreenfootImage("p1_jump1.png");
    private GreenfootImage p1jump2 = new GreenfootImage("p1_jump2.png");
    private GreenfootImage p1duck1 = new GreenfootImage("p1_duck1.png");
    private GreenfootImage p1duck2 = new GreenfootImage("p1_duck2.png");
    private int frame = 1;
    private String name;
    public Hero(String name) {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        this.name = name;
        setImage("p1.png");
    }

    @Override
    public void act() {
        handleInput();
        animationCounter ++;
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                break;
            }
        }  
        if(isTouching(MovingPlatform1.class) || isTouching(MovingPlatform2.class)
        || isTouching(MovingPlatform3.class)) {
            velocityY = 0;
        }
        if(isTouching(WaterTopMid.class)) {
            velocityY = 0;
        }
        if (isTouching(Key.class)) {
            keyObtained = true;
        }
        if (isTouching(Door1.class) && isTouching(Door2.class) 
        && keyObtained == true) {
            Greenfoot.setWorld(new Characterscreen());
        }
        applyVelocity();
}

     
    public void animateRight() {
        lookingRight = true;
        if (frame == 1) {
            setImage(p1right1);
        }
        else if (frame == 2) {
            setImage(p1right2);
            }
        else if (frame == 3) {
            setImage(p1right3);
        }  
        else if (frame == 4) {
            setImage(p1right4);
            }
        else if (frame == 5) {
            setImage(p1right5);
        }  
        else if (frame == 6) {
            setImage(p1right6);
            }
        else if (frame == 7) {
            setImage(p1right7);
        }  
        else if (frame == 8) {
            setImage(p1right8);
            }
        else if (frame == 9) {
            setImage(p1right9);
            frame = 1;
            return;
        }  
        frame ++;
}
    public void animateLeft() {
        lookingLeft = false;
        if (frame == 1) {
            setImage(p1left1);
        }
        else if (frame == 2) {
            setImage(p1left2);
            }
        else if (frame == 3) {
            setImage(p1left3);
        }  
        else if (frame == 4) {
            setImage(p1left4);
            }
        else if (frame == 5) {
            setImage(p1left5);
        }  
        else if (frame == 6) {
            setImage(p1left6);
            }
        else if (frame == 7) {
            setImage(p1left7);
        }  
        else if (frame == 8) {
            setImage(p1left8);
            }
        else if (frame == 9) {
            setImage(p1left9);
            frame = 1;
            return;
        }  
        frame ++;
}
    public void handleInput() {
        if (Greenfoot.isKeyDown("space")) {
            for (Tile tile : getIntersectingObjects(Tile.class)) {
                if (tile != null) {
                    inAir = false;
                    velocityY = -15; 
                }
                if (lookingRight == true) {
                    setImage(p1jump1);
                    lookingRight = false;
                }
                else if (lookingLeft == false) {
                    setImage(p1jump2);
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
            animateLeft();
} 
        else if (Greenfoot.isKeyDown("d")) {
            if(animationCounter % 4 == 0)
            velocityX = 8;
            animateRight();
}
        else if (lookingRight == true && Greenfoot.isKeyDown("s")) {
            setImage(p1duck1);
            lookingRight = false;
}
        else if (lookingLeft == false && Greenfoot.isKeyDown("s")) {
            setImage(p1duck2);
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
