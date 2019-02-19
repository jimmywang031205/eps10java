/**
 * I hate java :)
 * who wrote this stupid freaking question ???
 *
 * @author Max
 * @version 2019-02-14
 * @version 2019-02-15
 */
public class Model
{
    // instance variables - replace the example below with your own
    public static final int IN_PER_FOOT = 12;   
    public static final int BASE_RATE = 60;   
    public static final int TALL_INCHES = 67;   
    public static final double THIN_POUNDS = 140.0;   
    public static final int TALL_THIN_BONUS = 5;   
    public static final int TRAVEL_BONUS = 4;   
    public static final int SMOKER_DEDUCTION = 10;   
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

    public String convertHeightToFeetInches(int _height)
    {
        return String.format("%d feet %d inches",_height/IN_PER_FOOT,_height%IN_PER_FOOT);
    }
    public double calculatePayPerHour() 
    {
        double tmpRATE=BASE_RATE;
        if(Height>=TALL_INCHES&&Weight<=THIN_POUNDS)tmpRATE+=TALL_THIN_BONUS;
        if(Travel_ava==true)tmpRATE+= TRAVEL_BONUS ;
        if(Smooke_ava==true)tmpRATE-=SMOKER_DEDUCTION;
        return tmpRATE;
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
    public void displayModelDetails()
    {
        /*
         * EO:
         Name: Susan Smith 
         Height: 5 feet 10 inches 
         Weight: 120.0 pounds 
         Travels: true  
         Smokes: false 
         Hourly rate: $69    
         */
        System.out.println("Name: "+getFirstName()+" "+getLastName());
        System.out.println("Height: "+convertHeightToFeetInches(Height));
        System.out.println("Weight: "+getWeight()+" pound(s)");
        System.out.println("Travels: "+getTravel_ava()+"\n"+"Smokes: "+getSmooke_ava());
        System.out.println("Hourly rate: $"+calculatePayPerHour());     
    }
}
