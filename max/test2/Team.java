import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Iterator;

/**
 * Write a description of class Team here.
 * 
 * @author 
 * @version 
 */
public class Team
{
    // instance variables - replace the example below with your own
    private Input MyInput;
    private String teamName;
    ArrayList<HockeyPlayer> thePlayers;
    //ArrayList<HockeyPlayer> demotedPlayers;    

    /**
     * Constructor for objects of class Team
     */
    public Team()
    {
       MyInput=new Input();
       thePlayers=new ArrayList<HockeyPlayer>();
       setTeamName();       
    }
    
    //Create set and get methods for the Team name
    public void setTeamName()
    {
        System.out.print("Team Name: ");
        teamName=MyInput.getString();
    }
    public String getTeamName()
    {
        return teamName;
    }
    
    
    public void addPlayer(HockeyPlayer player)
    {
        thePlayers.add(player);
        //if else statement
    }
        
    
    public void displayHighPointGetters()
    {
        System.out.println("Players that got 100 or more points");
        //use a for loop to get the highest point getter 
        for(HockeyPlayer Player:thePlayers)
        {
            if(Player.getTotalPoints()>=100)System.out.println(Player.getFullName());
        }
    }
    
    public double calculateAverageSalary()
    {
        double counter=0,count=0;
        for(HockeyPlayer Player:thePlayers)
        {
            counter+=Player.getSalary();
            count++;
        }
        return counter/count;         
    }
    
    public void displayTeamDetails()
    {
        System.out.println(teamName+"\n");
        DecimalFormat formatter = new DecimalFormat("$0.00");
        //Display Team details
        for(HockeyPlayer Player:thePlayers)
        {
            Player.displayPlayerDetails();
        }
        
        System.out.println("Average team salary:$"+calculateAverageSalary()+"\n");
        displayHighPointGetters();
        
    }
    
}