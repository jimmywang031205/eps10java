/**
 * Write a description of class lab8 here.
 *
 * @author Max
 * @version 2019-03-07
 */
public class lab8
{
    private Input myInput;
    public lab8()
    {
        myInput = new Input();
        main();
    }
    public void main(){
        System.out.print("Enter first number:");
        int first = myInput.getInt(),num1=first;
        System.out.print("Enter second number:");
        int second = myInput.getInt(),count=0,num2=second,num;
        System.out.print(first + " "+second+" ");
        do{
            num =(first+second)%10;
            System.out.print(num+" ");
            first=second;
            second=num;
            count++;
        }while(!(num1 == first && num2 == second));
        System.out.println("\nYour numbers required "+count+" steps.");
    }
}
