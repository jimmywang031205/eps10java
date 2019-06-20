import java.util.*;
public class Yatzhee
{
    private input myInput=new input();
    Random randomGenerator=new Random();
    private int[] dice=new int[5];
    private int[] preserve=new int[5];
    private int pickOut=0;
    public Yatzhee()
    {
        ScoreSheet player=new ScoreSheet();
        dice(5-pickOut);
        pick_out();
        player.counter(dice,preserve);
        player.display(false);
    }

    public void dice(int number)
    {
        System.out.print("Your nephew:");
        for(int i=0;i<number;++i)
        {
            dice[i]=randomGenerator.nextInt(6)+1;
            System.out.print(dice[i]+" ");
        }
        System.out.println("");
    }

    public void pick_out()
    {
        System.out.println("Enter a number to select a dice you want to save.");
        System.out.println("And select 0 to end the operation.");
        int pick=-1;
        while(pick!=0)
        {
            System.out.print("input:");
            pick=myInput.getInt();
            if(pick!=0)
            {
                for(int i=0;i<5;++i)
                {
                    if(dice[i]==pick)
                    {
                        preserve[pickOut]=dice[i];
                        dice[i]=0;
                        pickOut++;
                        break;
                    }
                }   
            }
        } 
    }
    
}
