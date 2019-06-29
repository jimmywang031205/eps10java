
/**
 * Write a description of class monster here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class treasure
{
    // instance variables - replace the example below with your own
    private int level,type,health, mana, strength,x,y;// total values not greater than 300,0<= x/y <= 20
    private String description;

    /**
     * Constructor for objects of class monster
     */
    public treasure(int type,int level,int _x,int _y)
    {
        setType(type);
        setLevel(level);
        setTreasure(type);
        setX(_x);
        setY(_y); 
    }
        
    public void setHealth(int _health)
    {
        health=_health;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setMana(int _mana)
    {
        mana=_mana;
    }
    
    public int getMana()
    {
        return mana;
    }
    
    public void setStrength(int _strength)
    {
        strength=_strength;
    }
    
    public int getStrength()
    {
        return strength;
    }
    
    public void setDescription(String _description)
    {
        description=_description;
    }
    public String getDescription()
    {
        return description;
    }
    
    public void setX(int _x)
    {
        x=_x;
    }
    
    public int getX()
    {
        return x;
    }
    
    public void setY(int _y)
    {
        y=_y;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setType(int _type)
    {
        type=_type;
    }
    public int getType()
    {
        return type;
    }
    
    public void setLevel(int _level)
    {
        level=_level;
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public int rand(int min,int max)
    {
        return min+(int)(Math.random()*(max-min+1));
    }
    
    public void setTreasure(int type)
    {
        if(type==1)
        {
            setDescription("Small medical kit");
            setHealth(rand(1,200)+getLevel()*rand(1,5));
            setStrength(rand(1,20)+getLevel()*rand(1,5));
            setMana(rand(1,100)+getLevel()*rand(1,15));
        }
        else if(type==2)
        {
            setDescription("Large medical kit"); 
            setHealth(rand(200,800)+getLevel()*rand(5,15));
            setStrength(rand(20,70)+getLevel()*rand(5,50));
            setMana(rand(1,10)+getLevel()*rand(1,15));
        }
        else if(type==3)
        {
            setDescription("Anti-tank plastic bag,,,");
            setHealth(rand(100,500)+getLevel()*rand(10,20));
            setStrength(rand(200,500)+getLevel()*rand(200,500));
            setMana(rand(100,200)+getLevel()*rand(20,50));
        }
        else if(type==4)
        {
            setDescription("Black glasses that let you '+1s'");
            setHealth(rand(50,600)+getLevel()*rand(20,50));
            setStrength(rand(20,50)+getLevel()*rand(20,50));
            setMana(rand(500,1000)+getLevel()*rand(100,500));
        }
        else if(type==5)
        {
            setDescription("Vodka bottle");
            setHealth(rand(50,100)+getLevel()*rand(5,15));
            setStrength(rand(50,100)+getLevel()*rand(5,15));
            setMana(rand(50,100)+getLevel()*rand(1,15));
        }
        else if(type==5)
        {
            setDescription("Part of the body of the Marine Corps");
            setHealth(rand(500,1000)+getLevel()*rand(30,80));
            setStrength(rand(200,500)+getLevel()*rand(200,500));
            setMana(rand(100,200)+getLevel()*rand(20,50));
        }
        else if(type==6)
        {
            setDescription("BlueJ");
            setHealth(rand(50,600)+getLevel()*rand(20,50));
            setStrength(rand(20,50)+getLevel()*rand(20,50));
            setMana(rand(500,1000)+getLevel()*rand(100,500));
        }
    }
}
