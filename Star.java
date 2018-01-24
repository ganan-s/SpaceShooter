import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Actor
{
    private static final int SIZE=3;
    private int speed;
    
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Star(){
        GreenfootImage img = new GreenfootImage(SIZE, SIZE);
        int colour = Greenfoot.getRandomNumber(256);
        img.setColor(new Color(colour, colour, colour));
        img.fillOval(0,0,SIZE,SIZE);
        setImage(img);
        
        speed = Greenfoot.getRandomNumber(3)+1;
    }
    
    public void act() 
    {
        setLocation(getX() , getY()+speed);
        if(getY()+SIZE > getWorld().getHeight()){
          int y = 3;
            int x = Greenfoot.getRandomNumber(getWorld().getWidth());
            setLocation(x,y);
        }
    }    
}
