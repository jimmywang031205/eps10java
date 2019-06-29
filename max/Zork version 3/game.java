import java.util.*;

/**
 * Main func for game:Zork
 *
 * @author Max
 * @version 1.01 dev
 */
public class game
{
    private int myX,myY;
    private input myInput= new input();
    private character player=new character(); 
    private map zorkMap=new map();
    private ArrayList<monster> monsterList=new ArrayList();
    private ArrayList<treasure> treasureList=new ArrayList();
    private monster monster;
    private treasure treasure;
    private combat combat;
    /**
     * Constructor for objects of class Game
     */
    public game()//init
    {
        Monster_Generator(15);
        Treauser_Generator(15);
        play();
    }
    
    public void Monster_Generator(int num)// creat [num] monsters
    {
        Random randomGenerator=new Random();
        for(int i=0;i<num;++i)
        {
            int x=randomGenerator.nextInt(19)+1,y=randomGenerator.nextInt(19)+1;
            monster temp=new monster(randomGenerator.nextInt(6)+1,randomGenerator.nextInt(10),x,y);//set health,strength and mana between 1~10
            monsterList.add(temp); 
            zorkMap.event_postion(1,i,x,y);
        }  
    }
    
    public void Treauser_Generator(int num)// creat [num] monsters
    {
        Random randomGenerator=new Random();
        for(int i=0;i<num;++i)
        {
            int x=randomGenerator.nextInt(19)+1,y=randomGenerator.nextInt(19)+1;
            treasure temp=new treasure(randomGenerator.nextInt(6)+1,randomGenerator.nextInt(10),x,y);//set health,strength and mana between 1~10
            treasureList.add(temp);  
            zorkMap.event_postion(-1,i,x,y);
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
        {
            //pass
        }  
    }
    
    public void play()
    {
        while(player.getHealth()>0)
        {
            zorkMap.play();
            myX=zorkMap.getX();
            myY=zorkMap.getY();
            if(zorkMap.getEvent()!=0)
            {
                if(zorkMap.getEvent()==1)
                {
                    //monster
                    //System.out.println("You find a  monster!");
                    //System.out.println("My poition:"+myX+","+myY);
                    //System.out.println("-------------------------------------------");
                    find(1,myX,myY);
                    zorkMap.setEvent(0);
                    monsterComba();
                }
                else if(zorkMap.getEvent()==-1)
                {
                    //treasure
                    //System.out.println("You find a  treasure!");
                    find(-1,myX,myY);
                    zorkMap.setEvent(0);
                    treasureFound();
                }
            }
        }
    }
    
    public void find(int type,int x,int y)//model 1 based on position to find object,model 2 based on id 
    {
        if(type==1)//monster
        {
            for(monster item : monsterList)
            {
                if(item.getX()==x && item.getY()==y)
                {
                    monster=item;
                    System.out.println("monster object fond!");
                    System.out.println("monsters X: "+item.getX());
                    System.out.println("monsters Y: "+item.getY());
                    System.out.println("description: "+item.getDescription());
                    System.out.println("level: "+item.getLevel());
                    System.out.println("health: "+item.getHealth());
                    System.out.println("mana: "+item.getMana());
                    System.out.println("strength: "+item.getStrength());
                    System.out.println("-------------------------------------------");
                    pressAnyKeyToContinue();
                }
            }
        }
        else if(type==-1)//treasure
        {
            for(treasure item : treasureList)
            {
                if(item.getX()==x && item.getY()==y)
                {
                    treasure=item;
                    System.out.println("treasure object fond!");
                    System.out.println("monsters X: "+item.getX());
                    System.out.println("monsters Y: "+item.getY());
                    System.out.println("description: "+item.getDescription());
                    System.out.println("level: "+item.getLevel());
                    System.out.println("health: "+item.getHealth());
                    System.out.println("mana: "+item.getMana());
                    System.out.println("strength: "+item.getStrength());
                    System.out.println("-------------------------------------------");
                    pressAnyKeyToContinue();
                }
            }
        }
    }
    
    public int rand(int min,int max)
    {
        return min+(int)(Math.random()*(max-min+1));
    }
    
    public void monsterComba()
    {
        System.out.println("You want fright(0) or get you ass out of here(1) ?");
        int judge=myInput.getInt();
        if(judge==0)
        {
            combat=new combat(monster,player);
            int code=combat.getRespond();
            if(code==1)
            {
                remove(1,monster.getX(),monster.getY());
            }
        }
        else if(judge==1)//random movement
        {
            zorkMap.redo_movement();
        }
    }
    
    public void treasureFound()
    {
        System.out.println("You can choose to get the treasure now(0), or come back later(1)");
        int judge=myInput.getInt();
        if(judge==0)
        {
            player.setHealth(player.getHealth()+treasure.getHealth());
            player.setStrength(player.getStrength()+treasure.getStrength());
            player.setMana(player.getMana()+treasure.getMana());
            remove(-1,treasure.getX(),treasure.getY());
            
            System.out.print("");
        }
        else if(judge==1)//random movement
        {
            zorkMap.redo_movement();
        }
    }
    
    public void remove(int type,int x,int y)
    {
        if(type==1)//monster
        {
            zorkMap.remove_obejct(x,y); 
            Iterator<monster> mListIterator = monsterList.iterator();
            while(mListIterator.hasNext())
            {
                monster item = mListIterator.next();
                if(item.getX()==x && item.getY()==y)
                {
                    mListIterator.remove();
                }
            }      
        }
        else if(type==-1)
        {
            zorkMap.remove_obejct(x,y); 
            Iterator<treasure> sListIterator = treasureList.iterator();
            while(sListIterator.hasNext())
            {
                treasure item = sListIterator.next();
                if(item.getX()==x && item.getY()==y)
                {
                    sListIterator.remove();
                }
            }
        }
    }
    
    /*
    public void initPlayer()
    {
        System.out.println("Welcome to Zork \n\n");  
        System.out.println("Hello "+player.getName()+"\n");
        System.out.println("Strength: "+player.getStrength());
        System.out.println("Health  : "+player.getHealth());
        System.out.println("Mana    : "+player.getMana()+"\n");   
    }
    */
}