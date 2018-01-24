import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mushroom extends Actor
{
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    boolean gone; 
    private int speed = 5;
    private boolean moved = false;
    public Mushroom()
    {
        GreenfootImage mushroomImg = new GreenfootImage("mushroom.png");
        mushroomImg.scale(20,20);
        setImage(mushroomImg);
    }
    
    public void act() 
    {
     setLocation(getX() , getY()+speed);
     gone = false;
     if(!moved)
     {
     move(4);
     moved= true;
     }
     if (isOffScreen())
     {
         getWorld().removeObject(this);
         gone = true;
     }
     /**
     if(!gone){
         getEaten();
     }
     */
    }    
    
    public void moveRandomly()
    {
        for(int i = 0 ; i < Greenfoot.getRandomNumber(10)+6 ; i++)
        {
            this.setLocation(getX()+2 , getY());
        }
    }
    /**
    public void getEaten()
    {
        Actor a = getOneIntersectingObject(Rocket.class);
        if (a != null) 
        {
            Space space = (Space) getWorld();
            space.removeObject(this);
        }   
        
    }*/
    
    public boolean isOffScreen()
    {
     if (getX() < 0 - getImage().getWidth()/2 || 
     getX() > getWorld().getWidth() + getImage().getWidth()/2 ||
     getY() < 0 - getImage().getHeight()/2 ||
     getY() > getWorld().getHeight() + getImage().getHeight()/2)
     {
          return true;
     }
     return false;
    }
    
}
