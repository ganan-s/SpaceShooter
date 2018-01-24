import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    private int score = 0;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Score: " + score, 24,Color.GREEN, new Color(0,0,0)) );
    } 
    
    public void addScore()
    {
        score++;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void updateScore()
    {
        score+= 2;
    }
    
    public void addScore(int howMany)
    {
        score+= howMany;
    }
}


