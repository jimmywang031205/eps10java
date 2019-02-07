
/**
 * Write a description of class Name here.
 *
 * @author Jimmy Wang
 * @version (January 29, 2019)
 */
public class Name   //name of the class
{
    // instance variables
    // They can be number or letter or words
    private String firstName;
    private String lastName;    // Any word or sentence
    private int age, num1, num2;  // variable that takes age as interger
    private double salary;
    private boolean employeed;
    private char gender;

    /**
     * Constructor for objects of class Name
     */
    public Name()
    {
        //System.out.println("My profile");
    }
    // _firstName is called a temporary field
    // it is a parameter or way of transfering data
    // This constructor is called the overloaded constructor
    public void Name(String _firstName, String _lastName, int _age, double _salary, boolean _employeed, char _gender)
    {
        firstName = _firstName;
        lastName = _lastName;
        age = _age;
        salary = _salary;
        employeed = _employeed;
        gender = _gender;
    }
    
    public void numbers(int _num1, int _num2)
    {
        num1 = _num2;
        num2 = _num2;
    }
    
    // mutator method lets me change data in the variable
    public void setFirstName(String _firstName)
    {
        firstName = _firstName;
    }
    
    public void setLastName(String _lastName)
    {
        lastName = _lastName;
    }
    
    public void setAge(int _age)
    {
        age = _age;
    }
    
    public void setSalary(double _salary)
    {
        salary = _salary;
    }
    
    public void setEmployeed(boolean _employeed)
    {
        employeed = _employeed;
    }
    
    public void setGender(char _gender)
    {
        gender = _gender;
    }
    
    //accessor method allow us to acess the data
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public double getSalary()
    {
        return salary;
    }
    
    public boolean getEmployeed()
    {
        return employeed;
    }
    
    public char getGender()
    {
        return gender;
    }
    
    public void display()
    {
        System.out.println(getFirstName()+" "+getLastName()+" is "+getAge());
        System.out.println("Average salary: " +getSalary());
        System.out.println("Am I employeed? "+getEmployeed());
        System.out.println("Gender: " +getGender());
    }
    
    public int answer()
    {
        return num1+num2;
    }
    
    public void displayMath()
    {
        System.out.println(num1+" + "+num2+" = "+answer());
    }
}
