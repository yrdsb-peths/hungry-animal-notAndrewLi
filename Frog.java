import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frog here.
 * 
 * @author Andrew Li
 * @version new version
 */
public class Frog extends Actor
{
    /**
     * Act - do whatever the Frog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound bite = new GreenfootSound("sounds/bite.mp3");
    GreenfootImage[] idle = new GreenfootImage[6];
    SimpleTimer animationTimer = new SimpleTimer();
    /*
     * Constructor - The code that gets run one time when object is created
     */
    public Frog(){
        for(int i = 0; i < idle.length; i++){
            idle[i] = new GreenfootImage("images/frog_idle/frog" + (i + 1) + ".png");
        }
        
        animationTimer.mark();
        setImage(idle[0]);
    }
    
    /*
     * Animate the frawg
     */
    int imageIndex = 0;
    public void animateFrog(){
        if(animationTimer.millisElapsed() < 100){
            return;
        }
        animationTimer.mark();
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("d")){

            move(5);
        }else if(Greenfoot.isKeyDown("a")){
            move(-5);
        } 
        eat();
        
        animateFrog();
    }
    public void eat()
    {
        if (isTouching(Plane.class)){ //detects if the frog is touching plane
            removeTouching(Plane.class);
            MyWorld world = (MyWorld) getWorld();
            world.createPlane();
            world.increaseScore();
            bite.play();
        }
    }
}

