import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    int health = 100;
    int healthBarWidth = 100;
    int healthBarHeight = 15;
    int pixelsPerHealthPoint = (int)healthBarWidth/health;
    int speed = 2;
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
    public HealthBar(){
        update();
    }
    
    public void act() 
    {
        update();
        setLocation(getX() , getY()+ speed);
        if(atMiddle())
        {
            speed=0;
        }
    }    
    
    public void update()
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.RED);
        myImage.fillRect(1,1, health*pixelsPerHealthPoint, healthBarHeight);
    }
    
    public void loseHealth()
    {
        health--;
    }
    
    public boolean atMiddle()
    {
        if(getY() >= 300){
            return true;
        }
        return false;
    }
}
