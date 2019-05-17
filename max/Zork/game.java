import java.util.*;

/**
 * Main func for game:Zork
 *
 * @author Max
 * @version 1.01 dev
 */
public class game
{
    // instance variables - replace the example below with your own
    private input myInput= new input();
    private character player=new character(); 
    private map zorkMap=new map();
    private ArrayList<monster> monsterList=new ArrayList<monster>();
    private ArrayList<treasure> treasureList=new ArrayList<treasure>();

    /**
     * Constructor for objects of class Game
     */
    public game()//init
    {
        
       
    }
    
    public void Monster_Generator(int num)// creat [num] monsters
    {
        Random randomGenerator=new Random();
        for(int i=0;i<num;++i)
        {
            int x=randomGenerator.nextInt(19)+1,y=randomGenerator.nextInt(19)+1;
            monster temp=new monster(randomGenerator.nextInt(9)+1,randomGenerator.nextInt(9)+1,randomGenerator.nextInt(9)+1,x,y);//set health,strength and mana between 1~10
            monsterList.add(temp);
            zorkMap.event_postion(1,i,x,y);
            
        } 
        
        
    }
    
    public void Treasure_Generator(int num)// creat [num] monsters
    {
        Random randomGenerator=new Random();
        for(int i=0;i<num;++i)
        {
            int x=randomGenerator.nextInt(19)+1,y=randomGenerator.nextInt(19)+1;
            monster temp=new monster(randomGenerator.nextInt(9)+1,randomGenerator.nextInt(9)+1,randomGenerator.nextInt(9)+1,x,y);//set health,strength and mana between 1~10
            monsterList.add(temp);
            zorkMap.event_postion(-1,i,x,y);
        } 
        
        
    }
    
    
    
    public void combat()
    {
    }   
    
    public void map()
    {
        
    }
    
    public void play()
    {
        zorkMap.play();
    }
    
    public void initPlayer()
    {
        /*System.out.println("Welcome to Zork \n\n");  
        System.out.println("Hello "+player.getName()+"\n");
        System.out.println("Strength: "+player.getStrength());
        System.out.println("Health  : "+player.getHealth());
        System.out.println("Mana    : "+player.getMana()+"\n");   */
    }
    
    
}