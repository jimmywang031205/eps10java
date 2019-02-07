
/**
 * Write a description of class Member here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Member
{
    public static final int CURRENT_YEAR = 2019;
    private String firstName, lastName;
    private int yearBorn, yearJoined;
    
    public Member()
    {

    }
    
    public void member(String _firstName, String _lastName, int _yearBorn, int _yearJoined)
    {
        setFirstName(_firstName);
        setLastName(_lastName);
        setYearBorn(_yearBorn);
        setYearJoined(_yearJoined);
    }
    
    public void setFirstName(String _firstName)
    {
        firstName = _firstName;
    }
    
    public void setLastName(String _lastName)
    {
        lastName = _lastName;
    }
    
    public void setYearBorn(int _yearBorn)
    {
        if (_yearBorn < 0)  {
            yearBorn = (-1*_yearBorn);
        } else {
            yearBorn = _yearBorn;
        }
    }
    
    public void setYearJoined(int _yearJoined)
    {
        if (_yearJoined < 0)  {
            yearJoined = (-1*_yearJoined);
        } else {
            yearJoined = _yearJoined;
        }
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public int getYearBorn()
    {
        return yearBorn;
    }
    
    public int getYearJoined()
    {
        return yearJoined;
    }
    
    public String returnFullName()
    {
        return (firstName+" "+lastName);
    }
    
    public int calculate(int i)
    {
        int temp = CURRENT_YEAR - i;
        return temp;
    }
    
    public boolean qualifiesForDiscount()
    {
        if(calculate(yearBorn) < 12 && calculate(yearJoined) >= 2)  {
            return true;
        } else if (calculate(yearBorn) >= 65)   {
            return true;
        } else if (calculate(yearJoined) >= 10) {
            return true;
        } else  {
            return false;
        }
    }

    public void display()
    {
        System.out.println("Full Name: "+returnFullName());
        System.out.println("Discount: "+qualifiesForDiscount());
    }
}
