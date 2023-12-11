import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (Andrew Li) 
 * @version December 25
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Frog", 100);
    Label instructions = new Label("Press Space to Play", 30);
    GreenfootImage bg = new GreenfootImage("images/titleScreen.png");

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        bg.scale(600,400);
        this.setBackground(bg);
        prepare();
    }

    /*
     * the main world act loop
     */
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label label = new Label("Use \"a\" and \"d\" to Move", 60);
        addObject(titleLabel, getWidth()/2, 100);        
        addObject(label,300,237);
        addObject(instructions, 300,337);
        Frog frog = new Frog();
        addObject(frog,285,180);
    }
}
