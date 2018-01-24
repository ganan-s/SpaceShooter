import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int fireDelay = 0;
    public int gunDelay = 7;
    boolean gone = false;
    boolean check = false;
    Mushroom mushroom = new Mushroom();
    int gunDelayCount = 1;
    boolean startTimer = false;
    int timer = 0;
    
    /**
     * Act - do whatever the rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Rocket()
    {
      
        
        image1 = new GreenfootImage("rocket1.png");
        image2 = new GreenfootImage("rocket2.png");

        
        image1.scale(110 , 120);
        image2.scale(110 , 120);
        setImage(image1);
    }
    
        public void act()
    {
        checkKeypress();
        if(!gone)
        checkCollision();
        fireDelay++;
        if(!gone)
        eatMushroom();
        if(startTimer)
        {
        timer++;
            if(timer >= 600)
            {
                timer = 0;
                startTimer = false;
                gunDelayCount = 10;
            }
        }
    }   
    
        public void checkKeypress()
    {
        if (Greenfoot.isKeyDown("left")) 
        {
            move(-12);
            setImage(image2);
        }
        
        if (Greenfoot.isKeyDown("right")) 
        {
            move(12);
            setImage(image1);
        }
        
        if (Greenfoot.isKeyDown("space")) 
        {
                fire();
        }
    }
    
        private void checkCollision() 
    {
        Actor a = getOneIntersectingObject(Enemies.class);
        Actor b = getOneIntersectingObject(Enemies2.class);
        Actor c = getOneIntersectingObject(Rock.class);
        Actor d = getOneIntersectingObject(MonsterBullet.class);
        if (a != null) 
        {
            Space space = (Space) getWorld();
            space.addObject(new Explosion(), getX(), getY());
            space.removeObject(this);
            gone = true;
            //space.gameOver();
        }
        if (b != null) 
        {
            Space space = (Space) getWorld();
            space.addObject(new Explosion(), getX(), getY());
            space.removeObject(this);
            gone = true;
            //space.gameOver();
        }
        
        if (c != null) 
        {
            Space space = (Space) getWorld();
            space.addObject(new Explosion(), getX(), getY());
            space.removeObject(this);
            gone = true;
            //space.gameOver();
        }
        
        if (d != null) 
        {
            Space space = (Space) getWorld();
            space.addObject(new Explosion(), getX(), getY());
            space.removeObject(this);
            gone = true;
            //space.gameOver();
        }
    }
    
    public void eatMushroom()
    {
        Actor e = getOneIntersectingObject(Mushroom.class);
        if (e != null) 
        {
            gunDelayCount = 3;
            startTimer = true;
        }   
    }
    
    public void fire()
    {    
        if (fireDelay >= gunDelayCount) 
        {
            getWorld().addObject(new Bullet(), getX(), getY()-50);
            fireDelay = 0;
        }
    }
    
    public void fireFast(){
        if(fireDelay >= 3)
        {
            getWorld().addObject(new Bullet(), getX(), getY()-50);
            fireDelay = 0;
        }
    }
    
    
}


