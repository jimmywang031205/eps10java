
/**
 * Write a description of class treasure here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class treasure
{
    // instance variables - replace the example below with your own
    //i havent decided what should goes with T so .....
    private int x,y;

    /**
     * Constructor for objects of class treasure
     */
    public treasure(int _x,int _y)
    {
        // initialise instance variables
        setX(_x);
        setY(_y);
    }
    
    public void setX(int _x)
    {
        x=_x;
    }
    
    public int getX()
    {
        return x;
    }
    
    public void setY(int _y)
    {
        y=_y;
    }
    
    public int getY()
    {
        return y;
    }
    
}
