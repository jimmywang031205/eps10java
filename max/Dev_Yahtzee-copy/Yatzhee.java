import java.util.*;
public class Yatzhee
{
    private input myInput=new input();
    Random randomGenerator=new Random();
    private int[] dice=new int[6];
    private int[] preserve=new int[6];
    private int pickOut=0;
    private ScoreSheet player=new ScoreSheet();
    
    public Yatzhee()
    {
        while(!player.game_finished())
        {
            round();
        }
        System.out.println("Game Over.");
        System.out.println("Powered by: MaxSama ˋ( ° ▽、° )");
    }
    
    public void round()
    {
        for(int i=1;i<=3;++i)//each round has 3 turn
        {
            System.out.print('\u000C');
            System.out.println("This is "+i+" turn for this round.");
            player.display(); //display new sheet
            dice(5-pickOut);
            if(i<3)pick_out();
            player.counter(dice,preserve);
            System.out.print('\u000C');//clear
            System.out.println(i+" turn");
            player.display();
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
            player.display();
        }
    }

    public void dice(int number)
    {
        for(int i=0;i<6;++i)///reset
        {
            dice[i]=0;
        }
        System.out.print("Your dices:");
        for(int i=0;i<number;++i)
        {
            dice[i]=randomGenerator.nextInt(6)+1;
            System.out.print(dice[i]+" ");
        }
        System.out.println();
    }

    public void pick_out()
    {
        System.out.println("Enter a number to select the number that you want to save.");
        System.out.println("Enter 0 to end the pick_out operation when you finished.");
        int pick=-1;
        while(pick!=0)//keep pick_out until user input equals 0
        {
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