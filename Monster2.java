import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster2 extends Actor
{
    /**
     * Act - do whatever the Monster2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GifImage myGif = new GifImage("monster2.gif");
    private int speed = 2;
    private int fireDelay = 0;
    
    public void act() 
    {
        resizeGif();
        setImage( myGif.getCurrentImage() );
        setLocation(getX() , getY()+speed);
        if(atMiddle())
        speed=0;
        move(3);
        if(atWorldEdge())
        {
            turn(180);
        }
        getHit();
        fire();
        fireDelay++;
        
    }    
    
        public void getHit()
    {
        World myWorld = getWorld();
        Space space = (Space)myWorld;
        HealthBar2 healthbar2 = space.getHealthBar2();
        Actor Bullet = getOneIntersectingObject(Bullet.class);
        
        if (Bullet != null){
            healthbar2.loseHealth();
            getWorld().removeObject(Bullet);

            if(healthbar2.health <= 0){
                getWorld().addObject(new Coin() , Greenfoot.getRandomNumber(250)+250, 0);
                getWorld().addObject(new Coin() , Greenfoot.getRandomNumber(250)+250, 0);
                getWorld().addObject(new Coin() , Greenfoot.getRandomNumber(250)+250, 0);
                getWorld().addObject(new Coin() , Greenfoot.getRandomNumber(250)+250, 0);
                getWorld().addObject(new Coin() , Greenfoot.getRandomNumber(250)+250, 0);
                getWorld().addObject(new Coin() , Greenfoot.getRandomNumber(250)+250, 0);
                getWorld().addObject(new Coin() , Greenfoot.getRandomNumber(250)+250, 0);
                getWorld().addObject(new Coin() , Greenfoot.getRandomNumber(250)+250, 0);
                Space space1 = (Space)getWorld();
                Counter counter = space1.getCounter();              
                getWorld().removeObject(this);
                counter.addScore(30);
  
            }
        }
        
        
    }
    
        public void fire(){
        
        if (fireDelay >= 50) 
        {
            getWorld().addObject(new MonsterBullet(), getX(), getY());
            fireDelay = 0;
        }
    }
    
    public boolean atMiddle(){
        if(getY() >= 200){
            return true;
        }
        return false;
    }
    
        public boolean atWorldEdge()
    {
        if(getX() < 10 || getX() > getWorld().getWidth() - 10)
            return true;
        if(getY() < 10 || getY() > getWorld().getHeight() - 10)
            return true;
        else
            return false;
    }
    
        public void resizeGif()
    {
        for(GreenfootImage image1 : myGif.getImages())
        {
            image1.scale(200, 200);
        }
    }
}
