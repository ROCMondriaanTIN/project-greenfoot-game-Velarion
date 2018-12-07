import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level2 extends World {

    private CollisionEngine ce;
    public int character2;

    public Level2(int character) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("bg.png");
        this.character2 = character;
        
        int[][] map = {
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,12,27,14,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,117,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,12,27,14,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,27,-1,-1,27,27},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,10,-1,-1,-1,10},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,12,27,14,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,10,-1,-1,-1,10},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,12,27,14,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,10,10,-1,-1,10},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,10,10,10,10,10},
{-1,-1,-1,-1,-1,-1,-1,27,27,22,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,119,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,10,10,10,10,10},
{27,27,27,22,-1,-1,-1,-1,10,21,27,27,84,84,84,84,84,84,27,27,27,27,27,27,27,27,27,27,27,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,10,10,10,10,10},
{10,10,10,21,22,-1,-1,-1,-1,10,10,10,-1,-1,-1,-1,-1,-1,10,10,10,10,10,10,10,10,10,10,10,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,10,10,10,10,10},
{10,10,10,10,21,22,-1,-1,-1,-1,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
{10,141,141,141,141,142,143,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,10,10,10,10,10,-1,-1,-1,-1,-1,-1,-1,-1,-1,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
{10,141,141,141,141,141,142,143,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
{10,10,10,10,10,10,10,21,22,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,20,27,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
{10,10,10,10,10,10,10,10,21,22,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,20,23,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
{10,10,10,10,10,10,10,10,10,21,27,27,27,27,27,27,27,27,27,27,27,27,27,27,27,27,27,27,27,27,27,23,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},


        };
        
        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero(character2);

        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);
        
        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 0, 0);
    
        addObject(hero, 83, 1035);
        addObject(new CoinSilver(), 1290, 630); 
        addObject(new CoinSilver(), 1590, 750);
        addObject(new CoinSilver(), 510, 930);
        addObject(new CoinSilver(), 1649, 510);
        addObject(new CoinGold(), 1350, 1410); 
        addObject(new CoinGold(), 1672, 1410);
        addObject(new Fireball(), 950, 1415);
        addObject(new Key(), 2004, 1273); 
        addObject(new Gem(), 216, 1273);
        addObject(new Door3(),  2910, 811);
        addObject(new Door4(),  2910, 871);
        addObject(new MovingPlatform4(), 825, 905);
        addObject(new MovingPlatform5(), 882, 905);
        addObject(new MovingPlatform6(), 940, 905);
        addObject(new MovingPlatform4(), 1885, 553);
        addObject(new MovingPlatform5(), 1942, 553);
        addObject(new MovingPlatform6(), 1999, 553);
        addObject(new MovingPlatform4(), 2334, 493 );
        addObject(new MovingPlatform5(), 2391, 493);
        addObject(new MovingPlatform6(), 2448, 493);
        addObject(new Lava(), 750, 1110);
        addObject(new Lava(), 810, 1110);
        addObject(new Lava(), 870, 1110);
        addObject(new Lava(), 930, 1110);
        addObject(new Lava(), 990, 1110);
        addObject(new Lava(), 1050, 1110);
        addObject(new Lava(), 1770, 1110);
        addObject(new Lava(), 1830, 1110);
        addObject(new Lava(), 1890, 1110);
        addObject(new Lava(), 1950, 1110);
        addObject(new Lava(), 2010, 1110);
        addObject(new Lava(), 2070, 1110);
        addObject(new Lava(), 2130, 1110);
        addObject(new Lava(), 2190, 1110);
        addObject(new Lava(), 2250, 1110);
        addObject(new Lava(), 2310, 1110);
        addObject(new Lava(), 2370, 1110);
        addObject(new Lava(), 2430, 1110);
        addObject(new Lava(), 2490, 1110);
        addObject(new Lava(), 2550, 1110);
        addObject(new Lava(), 2610, 1110);
        addObject(new Lava(), 2670, 1110);
        addObject(new MovingWall(), 1229, 1313);
        addObject(new MovingWall(), 1229, 1253);
        addObject(new MovingWall(), 1229, 1193);
        addObject(new MovingWall(), 1469, 1313);
        addObject(new MovingWall(), 1469, 1253);
        addObject(new MovingWall(), 1469, 1193);
        
  
        
        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
    }
        
    @Override
    public void act() {
        ce.update();
    }
}