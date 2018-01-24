import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class Space extends World
{
    Counter counter = new Counter();
    public int level = 0;
    HealthBar healthbar = new HealthBar();
    HealthBar2 healthbar2 = new HealthBar2();
    int RandomEnemy;
    boolean level1Up = true;
    boolean level2Up = true;
    boolean level3Up = true;
    boolean level4Up = true;
    boolean monster1 = true;
    boolean monster2 = true;
    int RandomEnemy2;
    int rocks; 
    public void act(){
     
        
    if(level ==0)
    {
        if(getObjects(Enemies.class).size() == 0)
        {   
            populateEnemies();
        }
    }
    
    if(counter.getScore() == 10 && level1Up){
        level++;
        
        level1Up = false;
    }
    
    if(level ==1)
    {
        if(getObjects(Enemies2.class).size() == 0 && getObjects(Enemies.class).size() == 0)
        {   
            populateEnemies2();
        }
        rocks++;
        if(rocks%50 == 0)
        sendRocks();
    }
    
      if((counter.getScore() == 20 || counter.getScore()== 21) && level2Up){
        level++;
        level2Up = false;
        rocks = 0;
    }  
    
        if(level ==2)
    {
        if(monster1 && getObjects(Enemies2.class).size() == 0 && getObjects(Enemies.class).size() == 0)
        {   
            populateMonster();
            monster1 = false;
            addObject(healthbar, 300, 0);
        }
    }
    
    if(getObjects(Monster.class).size() == 0 && counter.getScore() >= 30 && level3Up)
    {
        level++;
        level3Up = false;
    }
    
    if(level == 3)
    {
        if(getObjects(Enemies.class).size() == 0 && getObjects(Enemies2.class).size() == 0 && getObjects(Enemies3.class).size() == 0)
        {
        populateEnemies3();
        rocks++;
        if(rocks%50 == 0)
        sendRocks();
        }
    }
    
    if((counter.getScore() >= 100) && level4Up){
        level++;
        level4Up = false;
    }
    
    if(level ==4)
    {
        if(monster2 && getObjects(Enemies2.class).size() == 0 && getObjects(Enemies.class).size() == 0 && getObjects(Enemies3.class).size() == 0)
        {   
            populateMonster2();
            monster2 = false;
            addObject(healthbar2, 300, 50);
        }
    }
    
    }
    
    public HealthBar getHealthBar()
    {
        return healthbar;
    }
        
    public HealthBar2 getHealthBar2()
    {
        return healthbar2;
    }
    
    public void sendRocks(){
        addObject(new Rock(), Greenfoot.getRandomNumber(550), -7);
    }
    
    public Counter getCounter(){
        return counter;
    }
    
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public void populateEnemies()
    {
        addObject(new Enemies(), 65, -40);
        addObject(new Enemies(), 180, -40);
        addObject(new Enemies(), 305, -40);
        addObject(new Enemies(), 420, -40);
        addObject(new Enemies(), 535, -40);
        addObject(counter,50,30);
        addObject(new Wall(), 5 , 580);
        addObject(new Wall(), 590 , 580);
    }
    
    public void populateEnemies2()
    {
        if( Greenfoot.getRandomNumber(2) == 1)
        addObject(new Enemies2(), 65, -40);
        else
        addObject(new Enemies(), 65, -40);
        if( Greenfoot.getRandomNumber(2) == 1)
        addObject(new Enemies2(), 180, -40);
        else
        addObject(new Enemies(), 180, -40);
        if( Greenfoot.getRandomNumber(2) == 1)
        addObject(new Enemies2(), 305, -40);
        else
        addObject(new Enemies(), 305, -40);
        if( Greenfoot.getRandomNumber(2) == 1)
        addObject(new Enemies2(), 420, -40);
        else
        addObject(new Enemies(), 420, -40);
        if( Greenfoot.getRandomNumber(2) == 1)
        addObject(new Enemies2(), 535, -40);
        else
        addObject(new Enemies(), 535, -40);
        addObject(counter,50,30);
    }
    
        public void populateEnemies3()
    {
        if( Greenfoot.getRandomNumber(100) < 2)
        addObject(new Enemies3(), 65, -40);
        else if(Greenfoot.getRandomNumber(100) < 30)
        addObject(new Enemies2(), 65, -40);
        else
        addObject(new Enemies(), 65, -40);
        
        if( Greenfoot.getRandomNumber(100) < 2)
        addObject(new Enemies3(), 180, -40);
        else if(Greenfoot.getRandomNumber(100) < 30)
        addObject(new Enemies2(), 180, -40);
        else
        addObject(new Enemies(), 180, -40);
        
        if( Greenfoot.getRandomNumber(100) < 2)
        addObject(new Enemies3(), 305, -40);
        else if(Greenfoot.getRandomNumber(100) < 30)
        addObject(new Enemies2(), 305, -40);
        else
        addObject(new Enemies(), 305, -40);
        
        if( Greenfoot.getRandomNumber(100) < 2)
        addObject(new Enemies3(), 420, -40);
        else if(Greenfoot.getRandomNumber(100) < 30)
        addObject(new Enemies2(), 420, -40);
        else
        addObject(new Enemies(), 420, -40);
        
        if( Greenfoot.getRandomNumber(100) < 2)
        addObject(new Enemies3(), 535, -40);
        else if(Greenfoot.getRandomNumber(100) < 30)
        addObject(new Enemies2(), 535, -40);
        else
        addObject(new Enemies(), 535, -40);
        addObject(counter,50,30);
    }
    
    public void populateMonster()
    {
       addObject(new Monster(), 320, -70); 
    }
    
    public void populateMonster2()
    {
       addObject(new Monster2(), 320, -70); 
    }
    
    public Space() 
    {
        super(600, 600, 1, false);
        addObject(new Rocket(),getWidth()/2, getHeight() - 70);
        if(level==0)
        {
        populateEnemies();  
        GreenfootImage img = new GreenfootImage(800,700);
        img.fill();
        setBackground(img);
        addStars(500);
        }
        

    }
    
    
    public void addStars(int howMany){
        for(int s=0 ; s<howMany ; s++){
            int x = Greenfoot.getRandomNumber( getWidth() );
            int y = Greenfoot.getRandomNumber( getHeight() );
            addObject(new Star(),x,y);
        }
    }
    
    public void addLevel()
    {
        level++;
    }

    
     
    
    
}
