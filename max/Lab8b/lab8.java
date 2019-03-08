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
        
        for(int first=0;first<=9;first++) 
        {
            for(int second=0;second<=9;second++)
            {
                int num,count=0,num1=first,num2=second;
                System.out.print(first+" "+second+"---");
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
    }
}
