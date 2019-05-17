import java.util.*;
public class map
{
    private int map[][]=new int[20][20];
    private input myInput=new input();
    private int myX,myY;
    
    public map()
    {
        //init grid
        for(int x=0;x<20;++x)
        {
            for(int y=0;y<20;++y)
            {
                map[x][y]=0;
            }
        }
        myX=9;myY=9;
    }
    
    public void grid()//draw grid
    {
        System.out.print('\u000C');
        
        for(int x=0;x<20;++x)
        {
            for(int y=0;y<20;++y)
            {
                if(x==myX && y==myY)System.out.print("@ ");
                else if(Math.sqrt((myX-x)*(myX-x)+(myY-y)*(myY-y))<4)//war shadow system, length=4
                {
                    if(map[x][y]==0)System.out.print("_ ");//nothing
                    else if(map[x][y]>0) System.out.print("M ");//monster
                    else if(map[x][y]<0) System.out.print("T ");//treasure
                }
                else System.out.print("# ");
                if(y==19)System.out.print("\n");
            }
        }
    }
    
    public void play()
    {
        while(true)//test func.
        {
            grid();
            getCommand();
        }
        
        /*grid(); //API for game();
        getCommand();*/
    }
    
    //if out_of_range happened, redo movement.
    public void getCommand()
    {
            String command=myInput.getString();
            if(command.equals("w")||command.equals("W"))
            {   
                myX-=1;
                if(myX>19||myX<0)
                {
                    myX+=1;//REdo movement
                    System.out.println("------------ERROR:OUT_OF_RANGE---------");
                    System.out.println("please try again :(");
                    getCommand();
                }
            }
            else if(command.equals("a")||command.equals("A"))
            {
                myY-=1;
                if(myY>19||myY<0)
                {
                    myY+=1;
                    System.out.println("------------ERROR:OUT_OF_RANGE---------");
                    System.out.println("please try again :(");
                    getCommand();
                }
                
            }
            else if(command.equals("s")||command.equals("S"))
            {
                myX+=1;
                if(myX>19||myX<0)
                {
                    myX-=1;
                    System.out.println("------------ERROR:OUT_OF_RANGE---------");
                    System.out.println("please try again :(");
                    getCommand();
                }
            }
            else if(command.equals("d")||command.equals("D"))
            {
                myY+=1;
                if(myY>19||myY<0)
                {
                    myY-=1;
                    System.out.println("------------ERROR:OUT_OF_RANGE---------");
                    System.out.println("please try again :(");
                    getCommand();
                }    
            }
    }
    
    public void event_postion(int type,int id,int x,int y)
    {
        if(type>0)//monster
        {
            map[x][y]=999-id;
            int idf=999-id;
            System.out.println("monster has added, id:"+idf+" ,postion:"+x+" ,"+y+" ,map[x][y]="+map[x][y]);
        }
        else if(type<0)//tearsure
        {
            map[x][y]=-999+id;
            int idf=-999+id;
            System.out.println("treasure has added, id:"+idf+" ,postion:"+x+" ,"+y+" ,map[x][y]="+map[x][y]);
        }
    }
}