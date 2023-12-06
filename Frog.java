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
    GreenfootImage[] idleLeft = new GreenfootImage[6];
    GreenfootImage[] idleRight = new GreenfootImage[6];
    SimpleTimer animationTimer = new SimpleTimer();
    //direction the frog is facing
    boolean facingRight = false;
    /*
     * Constructor - The code that gets run one time when object is created
     */
    public Frog(){
        for(int i = 0; i < idleLeft.length; i++){
            idleLeft[i] = new GreenfootImage("images/frog_idle/frog" + (i + 1) + ".png");
        }
        
        for(int i = 0; i < idleRight.length; i++){
            idleRight[i] = new GreenfootImage("images/frog_idle/frog" + (i + 1) + ".png");
            idleRight[i].mirrorHorizontally();
        }
        animationTimer.mark();
        setImage(idleLeft[0]);
    }
    
    /*
     * Animate the frawg
     */
    int imageIndex = 0;
    public void animateFrog(){
        MyWorld world = (MyWorld) getWorld();
        if(animationTimer.millisElapsed() < 100){
            return;
        }
        animationTimer.mark();
        if(facingRight){
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
            if(imageIndex == 1 && world.equals(MyWorld)){
                move(100);
            }
        } else{
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
            if(imageIndex == 1 && world.equals(MyWorld)){
                move(-100);
            }
        }
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("d")){
            facingRight = true;
            move(5);
        }else if(Greenfoot.isKeyDown("a")){
            facingRight = false;
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

