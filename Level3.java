import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level3 extends World {

    private CollisionEngine ce;
    public int character2;

    public Level3(int character) {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("bg.png");
        this.character2 = character;
        
        int[][] map = {
            {122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122},
{122,122,122,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,122},
{122,122,122,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,122},
{122,122,122,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,122},
{122,122,122,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,122},
{122,122,122,-1,-1,117,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,132,139,134,-1,-1,-1,132,139,134,-1,-1,118,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,122},
{122,122,122,-1,-1,139,139,139,139,139,139,139,139,139,139,-1,-1,139,139,139,139,139,139,139,139,139,139,133,122,135,139,139,139,133,122,135,139,139,139,139,139,139,139,-1,-1,-1,-1,-1,-1,122},
{122,122,122,-1,-1,122,-1,-1,-1,-1,-1,122,135,134,-1,-1,-1,-1,-1,-1,-1,-1,132,133,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,-1,-1,-1,-1,-1,-1,122},
{-1,-1,-1,-1,-1,122,-1,-1,-1,-1,-1,122,122,135,134,-1,-1,-1,-1,-1,-1,132,133,122,122,122,122,122,-1,-1,-1,-1,-1,-1,-1,-1,-1,122,122,122,122,122,122,-1,-1,-1,-1,-1,-1,122},
{-1,-1,-1,-1,-1,122,-1,-1,-1,-1,-1,122,122,122,135,134,118,-1,-1,-1,132,133,122,122,122,122,122,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,122,122,122,122,122,-1,-1,-1,-1,-1,-1,122},
{139,139,139,139,139,122,-1,-1,139,139,139,122,122,122,122,135,139,139,139,139,133,122,122,122,122,122,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,122,122,122,122,-1,-1,-1,-1,-1,-1,122},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,122,122,122,-1,-1,-1,-1,-1,-1,122},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,132,139,139,139,139,139,139,139,134,-1,-1,-1,-1,122,122,-1,-1,-1,-1,-1,-1,122},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,132,133,122,122,122,122,122,122,122,135,134,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,122},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,132,133,122,122,122,122,122,122,146,146,146,145,144,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,122},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,128,-1,-1,-1,-1,-1,-1,-1,128,-1,-1,-1,-1,-1,132,133,122,122,122,122,122,122,122,146,146,146,146,145,144,-1,-1,-1,-1,-1,-1,-1,-1,-1,122},
{-1,-1,-1,-1,-1,139,139,139,139,87,87,87,87,87,139,139,139,87,87,87,87,87,139,139,139,133,122,122,122,122,122,122,122,122,122,122,122,122,122,135,134,-1,-1,-1,-1,-1,-1,-1,-1,122},
{139,139,139,139,139,122,122,122,122,85,85,85,85,85,122,122,122,85,85,85,85,85,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,135,139,139,139,139,139,139,139,139,122},
{122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122},
{122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122},
{122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122},
{122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122},
{122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122},
{122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122},
{122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122,122},


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
        addObject(new CoinSilver(), 690, 869); 
        addObject(new CoinSilver(), 1170, 869); 
        addObject(new CoinSilver(), 1950, 569);
        addObject(new CoinSilver(), 510, 270);
        addObject(new CoinGold(), 2070, 269);
        addObject(new CoinGold(), 1710, 269);
        addObject(new Enemy(), 1934, 695); 
        addObject(new Enemy(), 622, 337); 
        addObject(new Gem(), 2111, 913);
        addObject(new Key(), 510, 569); 
        addObject(new MovingPlatform7(), 2610, 678); 
        addObject(new MovingPlatform7(), 2670, 678);
        addObject(new MovingPlatform7(), 2730, 678);
        addObject(new MovingPlatform7(), 2790, 678);
        addObject(new MovingPlatform7(), 2850, 678);
        addObject(new MovingPlatform7(), 2910, 678);
        addObject(new TeleportObject(), 1169, 569);
        addObject(new Door5(), 29, 510);
        addObject(new Door6(), 29, 570);
        
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