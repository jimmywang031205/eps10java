public class combat
{
    int count=1,code=0,character_health,character_strength,character_mana,monster_health,monster_strength,monster_mana;
    int continue_fighting=1;
    /**
     * Constructor for objects of class combat
     */
    public combat(monster monster,character character)
    {
        System.out.println("combat");
        while(code==0 && continue_fighting==1)
        {
            if(monster.getLevel()>character.getLevel())
            {
                System.out.println("------------Enemy first-----------");
                second_combat(monster,character);
                if(code==0)
                {
                    first_combat(monster,character);
                }
                
            }
            else 
            {
                System.out.println("------------Player first------------");
                first_combat(monster,character);
                if(code==0)
                {
                    second_combat(monster,character);
                }
                
            }
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
    
    public void first_combat(monster monster,character character)
    {
        int player_attack=character.getStrength()*character.getLevel()+character.getMana()*character.getLevel();
        //System.out.println(character.getStrength()+" "+character.getLevel()+" "+character.getMana());
        int player_denfence=character.getStrength()*character.getLevel()+character.getMana()*character.getLevel()+(int)(character.getHealth()*(character.getStrength()* 0.25));
        int monster_attack=monster.getStrength()*monster.getLevel()+monster.getMana()*monster.getLevel();
        int monster_denfence=monster.getStrength()*monster.getLevel()+monster.getMana()*monster.getLevel();
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
            System.out.println("公!!!   鸡!!!   大!!!   鱼!!!   怪!!! 2147483647+1% attack!!!");
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println(character.getName()+" killed the "+monster.getDescription());
            System.out.println("level++");
            System.out.println("plz press any key to continue......");
            code=1;
        }
        else if(monster.getStrength()<=0)
        {
                System.out.println(" ▄▄·     ▄▄▄      ▪      ▄▄▄▄▄");
                System.out.println("▐█ ▌▪    ▀▄ █·    ██     •██  ");
                System.out.println("██ ▄▄    ▐▀▀▄     ▐█·     ▐█.▪");
                System.out.println("▐███▌    ▐█•█▌    ▐█▌     ▐█▌·");
                System.out.println("·▀▀▀     .▀  ▀    ▀▀▀     ▀▀▀ ");
                System.out.println("Sir, we broke through the enemy's armor!");
                System.out.println("200% attack!");
                System.out.println("Enemy armor changed from "+monster.getStrength()+" to "+(monster.getStrength()-(int)(player_attack*2)));
                System.out.println("Enemy's HP changed from "+monster.getHealth()+" to "+(monster.getHealth()-(int)(player_attack*2)));
                monster.setStrength(monster.getStrength()-(int)(player_attack*2));
                monster.setHealth(monster.getHealth()-(int)(player_attack*2));
        }
        else 
        {
            System.out.println("We failed to penetrate their armor!");
            if(player_attack==monster_denfence && (monster.getStrength()>=0))
            {
                System.out.println("The enemy just blocked your attack!");
                System.out.println("Enemy armor changed from "+monster.getStrength()+" to "+(monster.getStrength()-player_attack));
                monster.setStrength(monster.getStrength()-player_attack);
            }
            else if(player_attack>monster_denfence*0.75 &&(monster.getStrength()>=0))
            {
                System.out.println("Caused serious damage to enemy armor");
                System.out.println("75% attack!");
                System.out.println("Enemy armor changed from "+monster.getStrength()+" to "+(monster.getStrength()-(int)(player_attack*0.75)));
                System.out.println("Enemy's HP changed from "+monster.getHealth()+" to "+(monster.getHealth()-(int)(player_attack*0.75)));
                monster.setStrength(monster.getStrength()-(int)(player_attack*0.75));
                monster.setHealth(monster.getHealth()-(int)(player_attack*0.75));
                
            }
            else if(player_attack>monster_denfence*0.5 &&(monster.getStrength()>=0))
            {
                System.out.println("Caused medium damage to enemy armor");
                System.out.println("50% attack!");
                System.out.println("Enemy armor changed from "+monster.getStrength()+" to "+(monster.getStrength()-(int)(player_attack*0.5)));
                System.out.println("Enemy's HP changed from "+monster.getHealth()+" to "+(monster.getHealth()-(int)(player_attack*0.5)));
                monster.setStrength(monster.getStrength()-(int)(player_attack*0.5));
                monster.setHealth(monster.getHealth()-(int)(player_attack*0.5));
            }
            else if(player_attack>monster_denfence*0.25 &&(monster.getStrength()>=0))
            {
                System.out.println("Caused minor damage to enemy armor");
                System.out.println("25% attack!");
                System.out.println("Enemy armor changed from "+monster.getStrength()+" to "+(monster.getStrength()-(int)(player_attack*0.25)));
                System.out.println("Enemy's HP changed from "+monster.getHealth()+" to "+(monster.getHealth()-(int)(player_attack*0.25)));
                monster.setStrength(monster.getStrength()-(int)(player_attack*0.25));
                monster.setHealth(monster.getHealth()-(int)(player_attack*0.25));
            }            
        } 
        count++;
    }
    
    public void second_combat(monster monster,character character)
    {
        int player_attack=character.getStrength()*character.getLevel()+character.getMana()*character.getLevel();
        int player_denfence=player_attack;
        int monster_attack=monster.getStrength()*monster.getLevel()+monster.getMana()*monster.getLevel();
        int monster_denfence=monster.getStrength()*monster.getLevel()+monster.getMana()*monster.getLevel();
        System.out.println("Round "+count+": "+monster.getDescription()+" attacked "+character.getName());
        System.out.println("The damage "+monster.getDescription()+" can do is: "+monster_attack);
        System.out.println(character.getName()+"'s armor: "+player_denfence);
        pressAnyKeyToContinue();
        if(monster_attack>player_denfence)
        {
            //System.out.println(" ██████╗     ██╗     ██╗    ███████╗    ██████╗     ██╗  ██╗   ██╗    ██╗         ██╗     ");
            //System.out.println("██╔═══██╗    ██║    ██║    ██╔════╝    ██╔══██╗    ██║ ██╔╝   ██║    ██║         ██║     ");
            //System.out.println("██║    ██║    ██║   ██║    █████╗      ██████╔╝    █████╔╝     ██║    ██║         ██║     ");
            //System.out.println("██║    ██║    ╚██╗ ██╔╝    ██╔══╝      ██╔══██╗    ██╔═██╗     ██║    ██║         ██║     ");
            //System.out.println("╚██████╔╝     ╚████╔╝     ███████╗    ██║  ██║    ██║  ██╗     ██║    ███████╗   ███████╗");
            //System.out.println(" ╚═════╝       ╚═══╝       ╚══════╝    ╚═╝  ╚═╝    ╚═╝  ╚═╝     ╚═╝   ╚══════╝   ╚══════╝");
            //System.out.println("公!!!   鸡!!!   大!!!   鱼!!!   怪!!! 2147483647+1% attack!!!");
            code=-1;
        }
        else if(character.getStrength()<=0)
        {
                System.out.println("The enemy penetrated our armor!");
                System.out.println("200% attack!");
                System.out.println("Player armor changed from "+character.getStrength()+" to "+(character.getStrength()-(int)(monster_attack*2)));
                System.out.println("Player's HP changed from "+character.getHealth()+" to "+(character.getHealth()-(int)(monster_attack*2)));
                character.setStrength(character.getStrength()-(int)(monster_attack*2));
                character.setHealth(character.getHealth()-(int)(monster_attack*2));
        }
        else 
        {
            System.out.println("Monster failed to penetrate our armor!");
            if(monster_attack==player_denfence && (character.getStrength()>=0))
            {
                System.out.println("Player just blocked your attack!");
                System.out.println("Player armor changed from "+character.getStrength()+" to "+(character.getStrength()-monster_attack));
                character.setStrength(character.getStrength()-monster_attack);
            }
            else if(monster_attack>player_denfence*0.75 &&(character.getStrength()>=0))
            {
                System.out.println("Caused serious damage to our armor");
                System.out.println("75% attack!");
                System.out.println("Player armor changed from "+character.getStrength()+" to "+(character.getStrength()-(int)(monster_attack*0.75)));
                System.out.println("Player's HP changed from "+character.getHealth()+" to "+(character.getHealth()-(int)(monster_attack*0.75)));
                character.setStrength(character.getStrength()-(int)(monster_attack*0.75));
                character.setHealth(character.getHealth()-(int)(monster_attack*0.75)); 
            }
            else if(monster_attack>player_denfence*0.5 &&(character.getStrength()>=0))
            {
                System.out.println("Caused serious damage to our armor");
                System.out.println("50% attack!");
                System.out.println("Player armor changed from "+character.getStrength()+" to "+(character.getStrength()-(int)(monster_attack*0.5)));
                System.out.println("Player's HP changed from "+character.getHealth()+" to "+(character.getHealth()-(int)(monster_attack*0.5)));
                character.setStrength(character.getStrength()-(int)(monster_attack*0.5));
                character.setHealth(character.getHealth()-(int)(monster_attack*0.5));    
            }
            else if(monster_attack>player_denfence*0.25 &&(character.getStrength()>=0))
            {
                System.out.println("Caused serious damage to our armor");
                System.out.println("25% attack!");
                System.out.println("Player armor changed from "+character.getStrength()+" to "+(character.getStrength()-(int)(monster_attack*0.25)));
                System.out.println("Player's HP changed from "+character.getHealth()+" to "+(character.getHealth()-(int)(monster_attack*0.25)));
                character.setStrength(character.getStrength()-(int)(monster_attack*0.25));
                character.setHealth(character.getHealth()-(int)(monster_attack*0.25)); 
            }           
        } 
        count++;
    }    
    public int getRespond()
    {
        return code;
    }
    
    public int getCharacter_health()
    {
        return character_health;
    }
    
    public int getCharacter_strength()
    {
        return character_strength;
    }
    
    public int getCharacter_Mana()
    {
        return character_mana;
    }
    
    public int getMonster_health()
    {
        return monster_health;
    }
    
    public int getMonster_strength()
    {
        return monster_strength;
    }
    
    public int getMonster_Mana()
    {
        return monster_mana;
    }
}
