
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
        firstName = _firstName;
        lastName = _lastName;
        if (_yearBorn < 0)  {
            yearBorn = (-1*_yearBorn);
        } else {
            yearBorn = _yearBorn;
        }
        if (_yearJoined < 0)  {
            yearJoined = (-1*_yearJoined);
        } else {
            yearJoined = _yearJoined;
        }
    }
    
    public void 
}
