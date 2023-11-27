
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
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        //create the frog actor
        Frog frog = new Frog();
        addObject (frog, 300, 350);
        
        scoreLabel = new Label(score, 100);
        addObject(scoreLabel, 50, 50);
        
        //create a falling plane
        createPlane();
    }
    
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score); //set the score to the new score
    }
    
    public void createPlane()
    {
        Plane plane = new Plane();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(plane, x, y);
    }
}
