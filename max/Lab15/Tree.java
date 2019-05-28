import java.util.*;
/**
 * Write a description of class Tree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tree
{
    // instance variables - replace the example below with your own
    private String species;
    private int age;
    /**
     * Constructor for objects of class Tree
     */
    public Tree(String _species,int _age)
    {
        // initialise instance variables
        setSpecies(_species);
        setAge(_age);
    }

    public void setSpecies(String _species)
    {
        species=_species;
    }
    public String getSpecies()
    {
        return species;
    }
    
    public void setAge(int _age)
    {
        age=_age;
    }
    public int getAge()
    {
        return age;
    }
    
}
