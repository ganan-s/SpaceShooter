import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    int speed = 5;
    GreenfootImage imgg = new GreenfootImage("rock.png");
    public Rock(){
        imgg.scale(20,20);
        setImage(imgg);
    }
    
    public void act() 
    {
     setLocation(getX() , getY()+speed);
     if (isOffScreen())
     {
         getWorld().removeObject(this);
     }
    } 
    
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
