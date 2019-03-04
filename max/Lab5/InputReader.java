import java.util.Scanner;
/**
* Class InputReader reads user input from the keyboard.
* @version 2009.10.25
* @author Colleen Penrowley
*/
public class InputReader
{
    private Scanner scanner;
    /**
      * Create a new InputReader to read user input.
      */
    public InputReader()
    {
           scanner = new Scanner(System.in); // for keyboard input
    }
    /**
      * @return the user's input as a String
      */
    public String getInput()
    {
        return scanner.nextLine();
    }
}