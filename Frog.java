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
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("d")){

            move(5);
        }else if(Greenfoot.isKeyDown("a")){
            move(-5);
        } 
        eat();
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

