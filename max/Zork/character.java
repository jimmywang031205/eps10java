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
    private input myInput;

    /**
     * Constructor for objects of class Character
     */
    public character()
    {
        myInput = new input();
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
        System.out.print("Enter your Class!");
        Class = myInput.getString();
        
    }

    public void setAttributes()
    {
        System.out.print("What is your health level (1 - 300): ");
        health = myInput.getInt();
        System.out.print("What is your mana level (0 - 300): ");
        mana = myInput.getInt();
        System.out.print("What is your strength level (0 - 300): ");
        strength = myInput.getInt();  
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getStrength()
    {
        return strength;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public int getMana()
    {
        return mana;
    }
}
