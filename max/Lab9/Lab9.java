
/**
 * Write a description of class Lab9 here.
 *
 * @author Max
 * @version 2019-03-06
 */
public class Lab9
{
    // instance variables - replace the example below with your own
    private int n;
    private Input MyInput;
    /**
     * Constructor for objects of class Lab9
     */
    public Lab9()
    {
        // initialise instance variables
        MyInput=new Input();
        if(isPrime(n=MyInput.getInt()))System.out.println("Prime");
        else System.out.println("Not prime");
    }
    
    public static boolean isPrime(int n) 
    {
        if (n <= 3) return n > 1;
        for (int i = 2; i <=(int)Math.sqrt(n) ; i++)if(n % i == 0)return false;
        return true;
    }
}
