import java.text.DecimalFormat;

/**
 * Write a description of class HockeyPlayer here.
 * 
 * @author 
 * @version 
 */
public class HockeyPlayer
{
    // instance variables - replace the example below with your own
    private String firstName;
    private String lastName;
    private double salary;
    private int goals=0;
    private int assists=0;
    private Input input;

    /**
     * Only call the set methods name info and salary,
     * initialize goals and assists to zero.
     */
    public HockeyPlayer()
    {
        input=new Input();
        setFirstName();
        setLastName();
        setSalary();
        setAssists();
        setGoals();
        //displayPlayerDetails();
    }
    
    
    /**
     * Create set and get methods here for 5 fields
     * use input for each set method to ask for information and set them
     * do not pass parameters
     */
    
    public void setFirstName()  //and so on and so on for all 5 fields
    {
        System.out.print("First Name: ");
        firstName=input.getString();
    }
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setLastName()
    {
        System.out.print("Last Name: ");
        lastName=input.getString();
    }
    public String getLastName()
    {
        return lastName;
    }
    
    public String getFullName()
    {
       return firstName+" "+lastName;
    }
    
    public void setSalary()
    {
        System.out.print("salary: ");
        salary=input.getDouble();
    }
    public double getSalary()
    {
        return salary;
        
    }
    
    public void setAssists()
    {
        System.out.print("assists: ");
        assists=input.getInt();
    }
    public int getAssists()
    {
        return assists;
    }
    
    public void setGoals()
    {
       System.out.print("goals: ");
       goals=input.getInt(); 
    }
    public int getGoals()
    {
       return goals; 
    }
    
    public int getTotalPoints()
    {
        return goals+assists;
    }
    
    public void displayPlayerDetails()
    {
        DecimalFormat formatter = new DecimalFormat("$0.00");
        System.out.println("Player Name:"+getFullName());
        System.out.println("Regular season Goals: "+getGoals());
        System.out.println("Regular season Assists: "+getAssists());
        System.out.println("Player salary: $"+getSalary()+"\n");
    }   
}
