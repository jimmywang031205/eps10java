/**
 * I hate java :)
 *
 * @author Max
 * @version 2019-02-14
 */
public class Model
{
    // instance variables - replace the example below with your own
    private String firstName;
    private String lastName;
    private int Height;
    private double Weight;
    private boolean Travel_ava;
    private boolean Smooke_ava;
    private Input myInput;
    /**
     * Constructor for objects of class Model
     */
    public Model() //init
    {
        myInput=new Input();
        // initialise instance variables
    }

    public void setFirstName(String _firstName)
    {
        firstName=_firstName;
    }
    public String getFirstName()
    {
        return firstName;   
    }
    
    public void setLastName(String _lastName)
    {
        lastName=_lastName;
    }
    public String getLastName()
    {
        return lastName;   
    }
    
    public void setHeight()
    {
        System.out.print("Enter the height (inches): ");
        int _height=myInput.getInt();
        if(_height>0)Height=_height;
        else
        {
            System.out.println("Invalid input value, please try again!");
            setHeight();
        }
    }
    public int getHeight()
    {
        return Height;
    }
    
    public void setWeight()
    {
        System.out.print("Enter the weight (pounds): ");
        double _weight=myInput.getDouble();
        if(_weight>0)Weight=_weight;
        else
        {
            System.out.println("Invalid input value, please try again!");
            setWeight();
        }
    }
    public double getWeight()
    {
        return Weight;
    }
    
    public void setTravel_ava(boolean _travel_ava)
    {
        Travel_ava=_travel_ava;
    }
    public boolean getTravel_ava()
    {
        return Travel_ava;
    }
    
    public void setSmooke_ava(boolean _smook_ava)
    {
        Smooke_ava=_smook_ava;
    }
    public boolean getSmooke_ava()
    {
        return Smooke_ava;
    }
    public void Model(String _firstName, String _lastName, boolean _travel_ava,boolean _smooke_ava)
    {
        setFirstName(_firstName);
        setLastName(_lastName);
        setHeight();
        setWeight();
        setTravel_ava(_travel_ava);
        setSmooke_ava(_smooke_ava);
    }
    public void display()
    {
        /* 
         * EO:
         * Name: Susan Smith 
         * Height: 70 inches 
         * Weight: 120.0 pounds 
         * Travels: true  Smokes: false
         */
        System.out.println("Name: "+getFirstName()+" "+getLastName());
        System.out.println("Height: "+getHeight()+" inche(s)");
        System.out.println("Weight: "+getWeight()+" pound(s)");
        System.out.println("Travels: "+getTravel_ava()+"  Smokes: "+getSmooke_ava());
    }
}
