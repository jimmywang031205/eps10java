
/**
 * Write a description of class Cat here.
 *
 * @author Max
 * @version 2019-03-11
 */
public class Cat
{
    // instance variables - replace the example below with your own
    private String name,birth;
    private int year;
    private double weight;
    /**
     * Constructor for objects of class Cat
     */
    public Cat()
    {
        // initialise instance variables
        
    }
    public void Cat(String _name, int _year, double _weight)
    {
        setName(_name);
        setYear(_year);
        setWeight(_weight);
    }
    
    public void setName(String _name)
    {
        if(_name!=null&&_name.length()>0)name=_name;
        else System.out.println("Bad Input");
    }
    public String getName()
    {
        return name;
    }
    
    public void setYear(int _year)
    {
        if(_year>0)year=_year;
        else System.out.println("Bad Input!");
    }
    public int getYear()
    {
        return year;
    }
    
    public void setWeight(double _weight)
    {
        if(_weight>0)weight=_weight;
        else System.out.println("Bad Input!");
    }
    public double getWeight()
    {
        return weight;
    }
}
