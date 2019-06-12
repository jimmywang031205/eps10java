import java.util.*;

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
    
    public game()
    {
        Monster_Generator(20);
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
                    find(1,myX,myY);
                    zorkMap.setEvent(0);
                    monsterComba();
                }
                else if(zorkMap.getEvent()==-1)
                {
                    //treasure
                    find(-1,myX,myY);
                    zorkMap.setEvent(0);
                    treasureFound();   
                }
            }
        }
        System.out.println("▓█████▄ ▓█████ ▄▄▄     ▄▄▄█████▓ ██░ ██ ");
        System.out.println("▒██▀ ██▌▓█   ▀▒████▄   ▓  ██▒ ▓▒▓██░ ██▒");
        System.out.println("░██   █▌▒███  ▒██  ▀█▄ ▒ ▓██░ ▒░▒██▀▀██░");
        System.out.println("░▓█▄   ▌▒▓█  ▄░██▄▄▄▄██░ ▓██▓ ░ ░▓█ ░██ ");
        System.out.println("░▒████▓ ░▒████▒▓█   ▓██▒ ▒██▒ ░ ░▓█▒░██▓");
        System.out.println(" ▒▒▓  ▒ ░░ ▒░ ░▒▒   ▓▒█░ ▒ ░░    ▒ ░░▒░▒");
        System.out.println(" ░ ▒  ▒  ░ ░  ░ ▒   ▒▒ ░   ░     ▒ ░▒░ ░");
        System.out.println(" ░ ░  ░    ░    ░   ▒    ░       ░  ░░ ░");
        System.out.println("   ░       ░  ░     ░  ░         ░  ░  ░");
        System.out.println(" ░                                      ");
        System.out.println("宮崎_英高 de 诅咒 ..... W~D~N~M~D~ 犹.豫.就.会.白.给.");
        System.out.println("You're dead. Game over");
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
                    System.out.println("description: "+item.getDescription());
                    System.out.println("level: "+item.getLevel());
                    System.out.println("health: "+item.getHealth());
                    System.out.println("mana: "+item.getMana());
                    System.out.println("strength: "+item.getStrength());
                    System.out.println("-------------------------------------------");
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
                    System.out.println("description: "+item.getDescription());
                    System.out.println("level: "+item.getLevel());
                    System.out.println("health: "+item.getHealth());
                    System.out.println("mana: "+item.getMana());
                    System.out.println("strength: "+item.getStrength());
                    System.out.println("-------------------------------------------");
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
        System.out.println("You want fight(0) or get you ass out of here(1) ?");
        int judge=myInput.getInt();
        if(judge==0)
        {
            combat=new combat(monster,player);
            int code=combat.getRespond();
            if(code==1)
            {
                remove(1,monster.getX(),monster.getY());
                player.setLevel(player.getLevel()+1);
                
            }
            else if(code==-1)
            {
                player.setHealth(0);
            }
            else
            {
                player.setHealth(combat.getCharacter_health());
                player.setStrength(combat.getCharacter_strength());
                player.setMana(combat.getCharacter_Mana());
                chageMonster(monster.getX(),monster.getY(),combat.getMonster_health(),combat.getMonster_strength(),combat.getMonster_Mana());
            }
            
            System.out.println(player.getHealth());
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
            System.out.println("Your HP went from "+player.getHealth()+" to "+(player.getHealth()+treasure.getHealth()));
            System.out.println("Your Strength went from "+player.getStrength()+" to "+(player.getStrength()+treasure.getStrength()));
            System.out.println("Your Mana went from "+player.getMana()+" to "+(player.getMana()+treasure.getMana()));
            System.out.println("Your Level went from "+player.getLevel()+" to "+(player.getLevel()+treasure.getLevel()));
            player.setHealth(player.getHealth()+treasure.getHealth());
            player.setStrength(player.getStrength()+treasure.getStrength());
            player.setMana(player.getMana()+treasure.getMana());
            player.setLevel(player.getLevel()+treasure.getLevel());
            remove(-1,treasure.getX(),treasure.getY());
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
    
    public void chageMonster(int x,int y,int health,int strength,int mana)
    {
        for(int i = 0; i < monsterList.size(); i++)
        {
            if(monsterList.get(i).getX()==x && monsterList.get(i).getY()==y)
            {
                monsterList.get(i).setHealth(health);
                monsterList.get(i).setStrength(strength);
                monsterList.get(i).setMana(mana);
            }
        }   
    }
}