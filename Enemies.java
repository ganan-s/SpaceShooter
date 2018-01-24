import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class Enemies extends Actor
{

    boolean gone;
    int i = 0;
    private String[] health= new String[4];
    private int health1 = 4;
    GreenfootImage image1;
    GreenfootImage image2;
    GreenfootImage image3;
    GreenfootImage image4;
    int speed;  
    
    public void act() 
    {
     setLocation(getX() , getY()+speed);
     gone = false;
     if (isOffScreen())
     {
         getWorld().removeObject(this);
         gone = true;
     }
     if(!gone) destroyEnemies();
    }  

    public Enemies() {
        speed = 3;
        for(int i = 0 ; i < health.length; i++){
            health[i] = "enemy1"+i+".png";
        }
        image1 = new GreenfootImage(health[0]);
        image2 = new GreenfootImage(health[1]);
        image3 = new GreenfootImage(health[2]);
        image4 = new GreenfootImage(health[3]);
        image1.scale(100,100);
        image2.scale(100,100);
        image3.scale(100,100);
        image4.scale(100,100);
        setImage(image1);
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

    
    public void destroyEnemies()
    {
        Actor Bullet = getOneIntersectingObject(Bullet.class);
        
        if (Bullet != null){
            if(i<health.length-1)
            i++;
            health1--;
            getWorld().removeObject(Bullet);
        }
           if(i==0)
            setImage(image1);
            else if(i==2)
            setImage(image2);
            else if(i==3)
            setImage(image3);
            else if(i==4)
            setImage(image4);
            if(health1 <= 0){
            Space space = (Space)getWorld();
            Counter counter = space.getCounter();
            counter.addScore();
            getWorld().removeObject(this);
           }
        } 
     
    }

    