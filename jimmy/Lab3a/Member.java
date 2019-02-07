
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
    private int yearBirth, yearJoined;
    
    public Member()
    {

    }
    
    public void member(String _firstName, String _lastName, int _yearBirth, int _yearJoined)
    {
        firstName = _firstName;
        lastName = _lastName;
        yearBirth = _yearBirth;
        yearJoined = _yearJoined;
    }
}
