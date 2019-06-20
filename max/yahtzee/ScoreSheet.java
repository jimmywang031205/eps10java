import java.util.ArrayList;
public class ScoreSheet
{
    private ArrayList<Score> score_paper=new ArrayList();
    private String name;
    private input myInput=new input();
    public static final String[] DESCRIPTIONS = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Sum", "Bonus", "Three of a Kind", "Four of a Kind", "Full House", "Small Straight", "Large Straight", "Chance", "Yahtzee", "Total Score"};
    public boolean gameFinished=false;
    public int[] counter=new int[6];
    public int result=0,sum=0;
    public ScoreSheet()
    {
        init();
    }
    
    public void init()
    {
        System.out.print("Please enter your name: ");
        name=myInput.getString();
        for(int i=0;i<16;++i)
        {
            Score temp=new Score(DESCRIPTIONS[i]);
            score_paper.add(temp);
        }
        display(true);
    }
    
    public void display(boolean firstTime)
    {
        int count=0;//use count to replace swicher(int type)
        System.out.println(name+"'s Score Sheet:");
        for(Score item:score_paper)
        {
            if(item.getDescription()=="Total Score")System.out.println(item.getDescription()+" "+item.getScore());
            else
            {
                String marked;
                if(item.getUsed()==1)
                {
                    marked="☑";
                    System.out.println(marked+" "+item.getDescription()+" "+item.getScore());
                }
                else
                {
                    marked="☐";
                    if(firstTime)System.out.println(marked+" "+item.getDescription()+" "+item.getScore());
                    else
                    {
                        if(count==8)count-=2;//bypass sum and bouns
                        swicher(count);
                        System.out.println(marked+" "+item.getDescription()+" "+sum);
                    }
                }
            }
            count++;
        }
    }
    
    public boolean game_finished()
    {
        gameFinished=true;
        for(Score item:score_paper)
        {
            if(item.getUsed()==0)gameFinished=false;
            break;
        }
        return gameFinished;
    }
    
    public void counter(int[] dice,int[] preserve)
    {
        for(int i=0;i<5;++i)
        {
            if(dice[i]!=0)counter[dice[i]-1]++;
            if(preserve[i]!=0)counter[preserve[i]-1]++;
        }
    }
    
    public void swicher(int type)
    {
        if(0<=type&&type<=5)sum=counter[type]*(type+1);//Ones~Sixes
        else if(type==6)//Three of a kind
        {
            for(int i=0;i<5;++i)
            {
                boolean statment=false;
                sum+=counter[i]*(i+1);
                if(counter[i]==3)
                {
                    statment=true;
                    break;
                }
                if(!statment)sum=0;
            }
        }
        else if(type==7)//Four of a kind
        {
            for(int i=0;i<5;++i)
            {
                boolean statment=false;
                sum+=counter[i]*(i+1);
                if(counter[i]==4)
                {
                    statment=true;
                    break;
                }
                if(!statment)sum=0;
            }
        }
        else if(type==8)//Full house
        {
            boolean two=false,three=false;
            for(int i=0;i<5;++i)
            {
                sum+=counter[i]*(i+1);
                if(counter[i]==2)two=true;
                if(counter[i]==3)three=true;
            }
            if(!(two&&three))sum=0;
        }
        else if(type==9)//Small straight
        {
            for(int i=0;i<5;++i)sum+=counter[i]*(i+1);
            boolean case1=true,case2=true,case3=true;
            for(int i=0;i<3;++i)
            {
                if(!(counter[i]>0&&counter[i+1]>0))case1=false;
                if(!(counter[i+1]>0&&counter[i+2]>0))case2=false;
                if(!(counter[i+2]>0&&counter[i+3]>0))case3=false;
            }
            if(!(case1||case2||case3))sum=0;
        }
        else if(type==10)//Large straight
        {
            boolean statement=true;
            for(int i=0;i<5;++i)
            {
                sum+=counter[i]*(i+1);
                if(counter[i]!=1)statement=false;
            }
            if(!statement)sum=0;
        }
        else if(type==11)//Chance
        {
            for(int i=0;i<5;++i)
            {
                sum+=counter[i]*(i+1);
            }
        }
        else if(type==12)//YAHTZEE
        {
            for(int i=0;i<5;++i)
            {
                if(counter[i]==5)sum=50;
            }
        }
    }
    public int getSum()
    {
        return sum;
    }
    
    public void player_action(String action)
    {
        
    }
}
