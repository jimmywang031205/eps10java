
/**
 * Write a description of class Math here.
 *
 * @author Jimmy Wang
 * @version (April 1, 2019)
 */
public class Math
{
    // instance variables - replace the example below with your own
    private int num1, num2;
    public Input myInput;
    
    public Math()
    {
        System.out.println("Math");
        myInput = new Input();
    }
    
    public void Math(int _num1, int _num2)
    {
        num1 = _num1;
        num2 = _num2;
    }
    
    public void mathInput()
    {
        System.out.print("Enter the first number ");
        num1 = myInput.getInt();
        System.out.print("Enter the second number ");
        num2 = myInput.getInt();
        display();
    }
    
    public void setNum1(int _num1)
    {
        num1 = _num1;
    }
    
    public void setNum2(int _num2)
    {
        num2 = _num2;
    }
    
    public int getNum1()
    {
        return num1;
    }
    
    public int getNum2()
    {
        return num2;
    }
    
    public int addition()
    {
        return (num1+num2);
    }
    
    public int subtraction()
    {
        return (num1-num2);
    }
    
    public int multiplication()
    {
        return (num1*num2);
    }
    
    public double divide()
    {
        //return (1.0*num1/num2);
        // order of operations so to do what's in the brakets first
        // type casting
        return ((double)num1/num2);
    }
    
    public void display()
    {
        System.out.println(num1+" + "+num2+" = "+addition());
        System.out.println(num1+" - "+num2+" = "+subtraction());
        System.out.println(num1+" * "+num2+" = "+multiplication());
        System.out.println(num1+" / "+num2+" = "+divide());
    
    }
}
