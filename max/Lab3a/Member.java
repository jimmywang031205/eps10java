/**
 * Write a description of class Member here.
 *
 * @author Max
 * @version 2019-02-07
 */
public class Member
{
    public static final int CURRENT_YEAR = 2019; 
    private String firstName;
    private String lastName;
    private int birthYear;
    private int joinYear;
    /**
     * Constructor for objects of class Member
     */
    public Member()//init
    {
        // initialise instance variables
    }

    
    public void Kember(String _firstName,String _lastName, int _birthYear, int _joinYear)
    {
        setFirstName(_firstName);
        ///firstName=_firstName;
        setLastName(_lastName);
        //lastName=_lastName;
        //if(_birthYear<0) birthYear=-1*_birthYear;
        //birthYear=Math.abs(_birthYear);//I can use if....else, i just dont want ~
        if(joinYear<0)joinYear=-1*_joinYear;//just proof that i know how to use if...else 
        joinYear=_joinYear;
    }
    
    public void setFirstName(String _firstName)
    {
        firstName = _firstName;
    }
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setLastName(String _lastName)
    {
        lastName = _lastName;
    }
    public String getLastName()
    {
        return lastName;
    }
    
    public void setbirthYear(int _birthYear)
    {
        birthYear=Math.abs(_birthYear);
    }
    public int getbirthYear()
    {
        return birthYear;
    }
    
    public String returnFullname()
    {
        return getFirstName()+" "+getLastName();
    }
    
    public boolean qualifiesForDiscount()
    {
        int age=CURRENT_YEAR-birthYear;
        int joined=CURRENT_YEAR-joinYear;
        if(((age<12)&&(joined>=2))||((age>=65)||(joined>=10)))
        {
            return true;
        }
        
        return false;
    }
    
    public void display()
    {
        System.out.println(returnFullname());
        System.out.println(qualifiesForDiscount());
    }
}
