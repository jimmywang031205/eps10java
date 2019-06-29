
/**
 * Write a description of class Students here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Students
{
    // instance variables - replace the example below with your own
    private String firstName;
    private String lastName;
    private String Student_Number;
    private int Grade;
    private char Gender;
    private boolean Programming_12_Student;
    /**
     * Constructor for objects of class Students
     */
    public Students()
    {
        // initialise instance variables
    }
    
    public void Students(String _firstName,String _lastName,String _Student_Number,int _Grade,char _Gender,boolean _Programming_12_Student)
    {
        setFirstName(_firstName);
        setLastName(_lastName);
        setStudent_Number(_Student_Number);
        setGrade(_Grade);
        setGender(_Gender);
        setProgramming_12_Student(_Programming_12_Student);
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
    
    public void setStudent_Number(String _Student_Number)
    {
        Student_Number=_Student_Number;
    }
    public String getStudent_Number()
    {
        return Student_Number;
    }
    
    public void setGrade(int _Grade)
    {
        Grade=_Grade;
    }
    public int getGrade()
    {
        return Grade;
    }
    
    public void setGender(char _Gender)
    {
        Gender=_Gender;
    }
    public char getGender()
    {
        return Gender;
    }
    
    public void setProgramming_12_Student(boolean _Programming_12_Student)
    {
        Programming_12_Student=_Programming_12_Student;
    }
    public boolean getProgramming_12_Student()
    {
        return Programming_12_Student;
    }
}
