import java.util.*;
public class Yatzhee
{
    private input myInput=new input();
    Random randomGenerator=new Random();
    private int[] dice=new int[5];
    private int[] preserve=new int[5];
    private int pickOut=0;
    private ScoreSheet player=new ScoreSheet();//init display
    public Yatzhee()
    {
        while(!player.game_finished())
        {
            round();
        }
    }
    
    public void round()
    {
        boolean finished=false;//after player_action(); return 0
        for(int i=1;i<=3;++i)//each round has 3 tern
        {
            System.out.print('\u000C');//clear
            player.display(false); //display new sheet
            dice(5-pickOut);
            pick_out();
            player.counter(dice,preserve);
            System.out.print('\u000C');
            player.display(false);
            if(i<3)
            {
               System.out.println("Do you want to use the score paper now? (0/1)");
               int statment=myInput.getInt(); 
               if(statment==1)
               {
                   player.player_action();
                   break;
               }
            }
            else if(i==3)
            {
                player.player_action();
            }
            player.display(false);
        }
    }
    
    private void pressAnyKeyToContinue()
    { 
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
    }

    public void dice(int number)
    {
        System.out.print("Your dices:");
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
        System.out.println("Enter 0 to end the pick_out operation when you finished.");
        int pick=-1;
        while(pick!=0)
        {
            System.out.print("Input:");
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