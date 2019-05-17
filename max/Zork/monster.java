
/**
 * Write a description of class monster here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class monster
{
    // instance variables - replace the example below with your own
    private int health, mana, strength,x,y;// total values not greater than 300,0<= x/y <= 20 

    /**
     * Constructor for objects of class monster
     */
    public monster(int _health,int _mana,int _strength,int _x,int _y)
    {
        setHealth(_health);
        setMana(_mana);
        setStrength(_strength);
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
}
