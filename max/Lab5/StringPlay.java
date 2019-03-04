/**
 * Write a description of class StringPlay here.
 *
 * @author Max
 * @version 03.04.2019
 */
public class StringPlay
{
    // instance variables - replace the example below with your own
    private InputReader MyInput;

    /**
     * Constructor for objects of class StringPlay
     */
    public StringPlay()
    {
        // initialise instance variables
        MyInput=new InputReader();
    }
    
    public void playWithString()
    {
        System.out.print("Please enter a string: ");
        String play=MyInput.getInput();
        System.out.println(play.toUpperCase());
        System.out.println(play.toLowerCase());
        System.out.println(play.length());
    }
    public void compareStrings()
    {
        System.out.print("Please enter your first string: ");
        String play1=MyInput.getInput();
        System.out.print("Please enter your first string: ");
        String play2=MyInput.getInput();
        if(play1.toUpperCase().equals(play2.toUpperCase()))//return true;
        System.out.println("same");
        else System.out.println("not the same");
        //return false;
    }
}
