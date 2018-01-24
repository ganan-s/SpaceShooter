import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int fireDelay = 0;
    private int speed = 3;
   public Bullet()
   {
       GreenfootImage image = new GreenfootImage("bullet.png");
       image.scale(10,10);
       setImage(image);
   } 
    
   public void act()
   {
       fireDelay++;
       setLocation(getX(), getY()-speed);
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


      
