
/**
 * Write a description of class name here.
 *
 * @author Max Zhang
 * @version Jun 30,2019
 */
public class name //name of the class 
{
    // instance variables
    // they can be numbers or letters or words 
    private String firstName;
    private String lastName;//any word or sentence
    private int age;//try 2^31 lol
    private float salary; //double is not enough!!!
    private boolean employed;
    private char gender;
    //private int a[]=new int[10];
    
    

    /**
     * Default constructor for objects of class name
     */
    public name()//init 
    {
        System.out.print("My profile \n");
        System.out.print("Test enter \n");
        // initialise instance variables
        //x = 0;
    }
    //_firstName is called a temp field
    // it is a parameter or way of trans data 
    public void name(String _firstName,String _lastName,int _age, float _salary, boolean _employed, char _gender)
    {
        firstName=_firstName;
        lastName=_lastName;
        age=_age;
        salary=_salary;
        employed =_employed;
        gender=_gender;
        
        
    }

    public void display()
    {
        System.out.print(firstName+" "+lastName+" is "+age+"\n"+"Am i employed? "+employed+"\n"+"My average salary:"+salary+"\n"+"My gender:"+gender+"\n");
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   /* public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }*/
}
