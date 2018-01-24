import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    GifImage myGif = new GifImage("wall.gif");
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        resizeGif();
        setImage( myGif.getCurrentImage() );
    }    
    
    public void resizeGif()
    {

        for(GreenfootImage image1 : myGif.getImages())
        {
            image1.scale(50, 50);
        }
    }
}
