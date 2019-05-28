
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
    public treasure(int _x,int _y)
    {
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
        //
    }
}
