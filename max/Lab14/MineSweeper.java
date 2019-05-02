import java.util.*;
/**
 * Write a description of class MineSweeper here.
 *
 * @author Max
 * @version 1.0
 */
public class MineSweeper
{
    // instance variables - replace the example below with your own
    private int map[][]=new int[10][10];
    private int secretX,secretY,guessX,guessY,count=0;
    private Input MyInput=new Input();
    private double length;
    /**
     * Constructor for objects of class MineSweeper
     */
    public MineSweeper()
    {
        // initialise instance variables
        for(int x=0;x<10;++x)
        {
            for(int y=0;y<10;++y)
            {
                map[x][y]=0;
            }
        }
        //randomly gernerate secretX and secretY 1~20
        Random randomGenerator=new Random();
        secretX=(randomGenerator.nextInt(9)+1);
        secretY=(randomGenerator.nextInt(9)+1);
        map[secretX][secretY]=1;
        
    }
    
    public void play()
    {
        do
        {
            System.out.print('\u000C');
            if(count!=0&&count<10)
            {
                System.out.println("You are "+length+" away");
                System.out.println((10-count)+" chance remain");
            }
            if(count>10)
            {
                System.out.println("------------GAME_OVER:RUN_OUT_TIMES------------");
                System.out.println("Secret X:"+secretX);
                System.out.println("Secret Y:"+secretY);
                
                System.out.println("--------------------DISPLAY--------------------");
                
                for(int x=0;x<10;++x)
                {
                    for(int y=0;y<10;++y)
                    {
                        if(map[x][y]==9)System.out.print("X"+" ");
                        else if(map[x][y]==0)System.out.print("_"+" ");
                        else System.out.print("@"+" ");
                        if(y==9)System.out.print("\n");
                    }
                }
                
                break;
            }
            System.out.println("------------Enter -1 and -1 to quit------------");
            grid();
            System.out.println("---------------------------------------------");
            System.out.print("Enter an X-coordinate: ");
            guessX=MyInput.getInt();
            System.out.print("Enter an Y-coordinate: ");
            guessY=MyInput.getInt();
            if(guessX==-1 && guessY==-1)
            {
                System.out.print("-------------------QUIT---------------------");
                break;
            }
            length=Math.sqrt((secretX-guessX)*(secretX-guessX)+(secretY-guessY)*(secretY-guessY));
            if(length==0)System.out.println("Hit. You sank my Battleship");
            else
            {
                System.out.println("Miss. You are "+length+" away");
                map[guessX][guessY]=9;
            }
            count++;
        }while(!((guessX==secretX)&&(guessY==secretY)));
    }
    
    public void grid()
    {
        for(int x=0;x<11;++x)
        {
            if((x-1)!=-1)System.out.print(x-1+" ");
            else System.out.print("  ");
        }
        System.out.print("\n");
        for(int x=0;x<10;++x)
        {
            System.out.print(x+" ");
            for(int y=0;y<10;++y)
            {
                
                if((Math.sqrt((guessX-x)*(guessX-x)+(guessY-y)*(guessY-y))==length)&&count!=0)
                {
                    if(map[x][y]!=9)System.out.print("R ");
                    else System.out.print("_ ");
                    if(y==9)System.out.print("\n");
                    continue;
                }
                
                if(map[x][y]==9)System.out.print("X ");
                else if(map[x][y]==0)System.out.print("_ ");
                else System.out.print("_ ");
                if(y==9)System.out.print("\n");
            }
        }
    }
   
}
