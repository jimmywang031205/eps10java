
/**
 * Write a description of class PurchaseDat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PurchaseDate
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class PurchaseDat
     */
    public PurchaseDate()
    {
        // initialise instance variables
    }
    public String PurchaseDate(int theYear, int theMonth, int theDay)
    {
        String Default="2019-01-01",_theDay,_theMonth;
        if(theYear>0 && theYear<=2019)
        {
            if(theMonth>=1&&theMonth<=12)
            {
                if(theMonth<10)_theMonth="0"+Integer.toString(theMonth);
                else _theMonth=Integer.toString(theMonth);
                if(theDay>0&&theDay<31)
                {
                    if(theDay<10)_theDay="0"+Integer.toString(theDay);
                    else _theDay=Integer.toString(theDay);
                    Default=Integer.toString(theYear)+"-"+_theMonth+"-"+_theDay;
                }
            }
        }
        return Default;
    }

   
}
