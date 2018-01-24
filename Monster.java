import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Actor
{
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 2;
    private int fireDelay = 0;
    GreenfootImage imageMonster = new GreenfootImage("monster.png");
    boolean touchingBullet = false;
    boolean moved = true;
    Coin coin = new Coin();
    public Monster()
    {
       imageMonster.scale(200,200);
       setImage(imageMonster);
    }
    
    public void act() 
    {
        setLocation(getX() , getY()+speed);
        if(atMiddle())
        speed=0;
        getHit();
        fire();
        fireDelay++;
    }
    
    public boolean atMiddle(){
        if(getY() >= 200){
            return true;
        }
        return false;
    }
    
    
    public void getHit()
    {
        World myWorld = getWorld();
        Space space = (Space)myWorld;
        HealthBar healthbar = space.getHealthBar();
        Actor Bullet = getOneIntersectingObject(Bullet.class);
        
        if (Bullet != null){
            healthbar.loseHealth();
            getWorld().removeObject(Bullet);

            if(healthbar.health <= 0){
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
                counter.addScore(10);
  
            }
        }
    }
    
        public void fire(){
        
        if (fireDelay >= 150) 
        {
            getWorld().addObject(new MonsterBullet(), getX(), getY());
            fireDelay = 0;
        }
    }
}
