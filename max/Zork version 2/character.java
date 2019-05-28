import java.util.*;
/**
 * Write a description of class Character here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class character
{
    // instance variables - replace the example below with your own
    private String name;
    private String Class; // warrior, dwarves, elves, magician
    private int health, mana, strength;// total values not greater than 300
    private input myInput=new input();

    /**
     * Constructor for objects of class Character
     */
    public character()
    { 
        setName();
        setClass();
        setAttributes();
    }
    
    public void setName()
    {
        System.out.print("Enter your name player:");
        name = myInput.getString();
    }
        
    public void setClass()
    {
        System.out.print("Enter your Class!(berserker/magician/USMC/slavs/KGB/???)");
        Class = myInput.getString();
        
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getStrength()
    {
        return strength;
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
        _mana=mana;
    }
    
    public int getMana()
    {
        return mana;
    }
    
    public void setStrength(int _strength)
    {
        _strength=strength;
    }
    
    public void setAttributes()
    {
        if(Class.equals("berserker"))
        {
            System.out.println("Your class is - berserker");
            System.out.println("Comparable to the destructive power of 8th grade freshmen\n- An unknown developer");
            setHealth(300);
            setStrength(300);
            setMana(200);
        }
        else if(Class.equals("magician"))
        {
            System.out.println("Your class is - Magician");
            System.out.println("-1s.....Run faster than Hong Kong reporters.....");
            setHealth(100);
            setStrength(100);
            setMana(500);
        }
        else if(Class.equals("USMC"))
        {
            System.out.println("Your class is - General purpose multi-purpose combat animals");
            System.out.println("If the Army and the Navy \nEver look on Heaven's scenes,\nThey will find the streets are guarded \nBy United States Marines.");
            setHealth(500);
            setStrength(0);
            setMana(50);
        }
        else if(Class.equals("slavs"))
        {
            System.out.println("Your class is - cuka blyat man");
            System.out.println("An unknown creature with extremely powerful combat power and magic, extremely dangerous");
            setHealth(550);
            setStrength(0);
            setMana(0);
        }
        else if(Class.equals("KGB"))
        {
            System.out.println("Your class is -You were arrested....");
            System.out.println("Comrade Stalin, please believe that I am not guilty..... Ah, ah.aaaaaaaaaa");
            setHealth(300);
            setStrength(300);
            setMana(-1);
        }
        else if(Class.equals("???"))
        {
            System.out.println("Your class is -Tankman");
            System.out.println("If our iron ride continues.......");
            setHealth(50);
            setStrength(1000);
            setMana(500);
        }
        else if(Class.equals("admin"))
        {
            System.out.println("Welcome,Mr.Stark :)");
            setHealth(9999);
            setStrength(9999);
            setMana(9999);
        }
        else
        {
            System.out.println("o.....k? you are "+Class+" now.....");
            System.out.print("Want to customize? Too young too simple my friend");
            Random randomGenerator=new Random();
            setHealth(randomGenerator.nextInt(500)+1);
            setStrength(randomGenerator.nextInt(500)+1);
            setMana(randomGenerator.nextInt(500)+1);
        }
    }
}
