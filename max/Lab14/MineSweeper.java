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
    private int map[][]=new int[21][21];
    private int secretX,secretY,guessX,guessY,count=0;
    private Input MyInput=new Input();
    private double length;
    /**
     * Constructor for objects of class MineSweeper
     */
    public MineSweeper()
    {
        // initialise instance variables
        for(int x=0;x<20;++x)
        {
            for(int y=0;y<20;++y)
            {
                map[x][y]=0;
            }
        }
        //randomly gernerate secretX and secretY 1~20
        Random randomGenerator=new Random();
        secretX=(randomGenerator.nextInt(20)+1);
        secretY=(randomGenerator.nextInt(20)+1);
        map[secretX][secretY]=1;
        
    }
    
    public void play()
    {
        do
        {
            System.out.print('\u000C');
            if(count!=0)System.out.println("You are "+length+" away");
            System.out.println("------------Enter 0 and 0 to quit------------");
            grid();
            System.out.println("---------------------------------------------");
            System.out.print("Enter an X-coordinate: ");
            guessX=MyInput.getInt();
            System.out.print("Enter an Y-coordinate: ");
            guessY=MyInput.getInt();
            length=Math.sqrt((secretX-guessX)*(secretX-guessX)+(secretY-guessY)*(secretY-guessY));
            if(length==0)System.out.println("Hit. You san my Battleship");
            else
            {
                System.out.println("Miss. You are "+length+" away");
                map[guessX][guessY]=-1;
            }
            count++;
        }while(!((guessX==secretX)&&(guessY==secretY)));
    }
    
    public void grid()
    {
        for(int x=0;x<20;++x)
        {
            for(int y=0;y<20;++y)
            {
                if(map[x][y]==0)System.out.print("*");
                else if(map[x][y]==-1)System.out.print("@");
                if(y==19)System.out.print("\n");
            }
        }
    }
}
