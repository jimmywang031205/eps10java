
/**
 * Write a description of class Employee here.
 *
 * @author Jimmy Wang
 * @version (January 31, 2019)
 */
public class Employee   //name of the class
{
    // instance variables
    // They can be number or letter or words
    private String firstName;
    private String lastName;    // Any word or sentence
    private String employeeNumber;  // variable that takes age as interger
    private String email;
    private double hoursWork;
    private double payH;
    private boolean fullTime;
    
    public void Employee(String _firstName, String _lastName, String _employeeNumber, String _email, double _hoursWork, double _payH, boolean _fullTime)
    {
        firstName = _firstName;
        lastName = _lastName;
        employeeNumber = _employeeNumber;
        email = _email;
        hoursWork = _hoursWork;
        payH = _payH;
        fullTime = _fullTime;
    }
    
    public void setFirstName(String _firstName)
    {
        firstName = _firstName;
    }
    
    public void setLastName(String _lastName)
    {
        lastName = _lastName;
    }
    
    public void setEmployeeNumber(String _employeeNumber)
    {
        employeeNumber = _employeeNumber;
    }
    
    public void setEmailAddress(String _email)
    {
        email = _email;
    }
    
    public void setHoursWorked(double _hoursWork)
    {
        hoursWork = _hoursWork;
    }
    
    public void setPayH(double _payH)
    {
        payH = _payH;
    }
    
    public void setFullTime(boolean _fullTime)
    {
        fullTime = _fullTime;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getEmployeeNumber()
    {
        return employeeNumber;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public double getHoursWorked()
    {
        return hoursWork;
    }
    
    public double getPayPerHour()
    {
        return payH;
    }
    
    public boolean getFullTime()
    {
        return fullTime;
    }
    
    public void display()
    {

        System.out.println("Name : "+getFirstName()+" "+getLastName());
        System.out.println("Employee Number : "+getEmployeeNumber());
        System.out.println("Email Address : "+getEmail());
        System.out.println(getHoursWorked()+" hours worked");
        System.out.println("Pay/Hr : "+getPayPerHour());
        System.out.println("Is the employee full time? "+getFullTime());
        
    }
}