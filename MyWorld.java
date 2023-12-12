
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    GreenfootImage background = new GreenfootImage("images/shrekSwamp.jpg");
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        background.scale(super.getWidth(), super.getHeight());
        super.setBackground(background);
        Heart hearts = new Heart();
        //create the frog actor
        Frog frog = new Frog();
        addObject (frog, 300, 350);
        
        scoreLabel = new Label(score, 80);
        addObject(scoreLabel, 50, 50);
        
        //create a falling plane
        createPlane();
    }
    
    public void gameOver(){
        Label gameOverLabel = new Label ("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
        gameOverLabel.setFillColor(Color.RED);
    }
    
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score); //set the score to the new score
        if(score % 5 == 0){
            level += 1;
        }
    }
    
    public void createPlane()
    {
        Plane plane = new Plane();
        GreenfootImage planeImage = plane.getImage();
        planeImage.rotate(90);
        planeImage.scale(100,100);
        plane.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(plane, x, y);
    }
}
