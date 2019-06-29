/**
 * Write a description of class combat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class combat
{
    // instance variables - replace the example below with your own
    int count=1,code=0;
    
    /**
     * Constructor for objects of class combat
     */
    public combat(monster monster,character character)
    {
        // initialise instance variables
        System.out.println("combat");
        while(code==0)
        {
            System.out.println("looping");
            if(monster.getLevel()>character.getLevel())
            {
                second_combat(monster,character);
                System.out.println("------------Enemy first-----------");
                break;
            }
            else 
            {
                first_combat(monster,character);
                System.out.println("------------Player first------------");
            }
        }
        if(code==404)
        {
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
            
        }
        
    }
    
    public int getRespond()
    {
        return code;
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
    
    public void first_combat(monster monster,character character)
    {
        double player_attack=character.getStrength()*character.getLevel()+character.getMana()*character.getLevel();
        //System.out.println(character.getStrength()+" "+character.getLevel()+" "+character.getMana());
        double player_defence=character.getStrength()*character.getLevel()+character.getMana()*character.getLevel()+character.getHealth()*(character.getStrength()* 0.25);
        double monster_attack=monster.getStrength()*monster.getLevel()+monster.getMana()*monster.getLevel();
        double monster_denfence=monster.getStrength()*monster.getLevel()+monster.getMana()*monster.getLevel();
        //System.out.println(monster.getStrength()+" "+monster.getLevel()+" "+monster.getMana());
        System.out.println("Round "+count+": "+character.getName()+" attacked "+monster.getDescription());
        System.out.println("The damage "+character.getName()+" can do is: "+player_attack);
        System.out.println(monster.getDescription()+"'s armor: "+monster_denfence);
        pressAnyKeyToContinue();
        if(player_attack>monster_denfence)
        {
            System.out.println(" ██████╗     ██╗     ██╗    ███████╗    ██████╗     ██╗  ██╗   ██╗    ██╗         ██╗     ");
            System.out.println("██╔═══██╗    ██║    ██║    ██╔════╝    ██╔══██╗    ██║ ██╔╝   ██║    ██║         ██║     ");
            System.out.println("██║    ██║    ██║   ██║    █████╗      ██████╔╝    █████╔╝     ██║    ██║         ██║     ");
            System.out.println("██║    ██║    ╚██╗ ██╔╝    ██╔══╝      ██╔══██╗    ██╔═██╗     ██║    ██║         ██║     ");
            System.out.println("╚██████╔╝     ╚████╔╝     ███████╗    ██║  ██║    ██║  ██╗     ██║    ███████╗   ███████╗");
            System.out.println(" ╚═════╝       ╚═══╝       ╚══════╝    ╚═╝  ╚═╝    ╚═╝  ╚═╝     ╚═╝   ╚══════╝   ╚══════╝");
            System.out.println("公!!!   鸡!!!   大!!!   鱼!!!   怪!!!");
            code=1;
            
        }
        else 
        {
            System.out.println("We failed to penetrate the enemy's armor!");
            if(player_attack==monster_denfence && (monster.getStrength()!=0))
            {
                System.out.println("The enemy just blocked your attack!");
                System.out.println("Causes minor damage to enemy armor.");
                monster.setStrength(monster.getStrength()-double(player_attack));
            }
            else if(player_attack>monster_denfence*0.75 &&(monster.getStrength()!=0))
            {
                
            }
            else if(player_attack>monster_denfence*0.5 &&(monster.getStrength()!=0))
            {
                
            }
            else if(player_attack>monster_denfence*0.25 &&(monster.getStrength()!=0))
            {
                
            }
        }
        
        count++;
    }
    
    public void second_combat(monster monster,character character)
    {
        int player_attack=character.getStrength()*character.getLevel()+character.getMana()*character.getLevel();
        int player_defence=player_attack;
        int monster_attack=monster.getStrength()*monster.getLevel()+monster.getMana()*monster.getLevel();
        int monster_denfence=monster.getStrength()*monster.getLevel()+monster.getMana()*monster.getLevel();
        
        
    }
    
    
    
}
