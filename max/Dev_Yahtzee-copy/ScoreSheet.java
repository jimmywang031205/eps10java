import java.util.ArrayList;
public class ScoreSheet
{
    private ArrayList<Score> score_paper=new ArrayList();
    private String name;
    private input myInput=new input();
    public static final String[] DESCRIPTIONS = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Sum", "Bonus", "Three of a Kind", "Four of a Kind", "Full House", "Small Straight", "Large Straight", "Chance", "Yahtzee", "Total Score"};
    public int[] counter=new int[7];
    public int result=0,sum=0;
    public ScoreSheet()
    {
        init();
    }
    
    public void init()
    {
        System.out.print("Please enter your name:");
        name=myInput.getString();
        boolean bypass=false;
        int count=0;//id for each item
        for(int i=0;i<16;++i)
        {
            Score temp=new Score(DESCRIPTIONS[i],count);
            score_paper.add(temp);
            count++;
        }
        display();//init display
    }
    
    public void display()
    {
        System.out.println(name+"'s Score Sheet:");
        for(Score item:score_paper)
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
                if(item.getNum()==-1)System.out.println(marked+" "+item.getDescription()+" "+item.getScore());
                else
                {
                    swicher(item.getNum());
                    System.out.println(marked+" "+item.getDescription()+" "+sum);
                }
            }
        }
    }
    
    public void counter(int[] dice,int[] preserve)
    {
        for(int i=0;i<6;++i)
        {
            counter[i]=0;
        }
        System.out.print("Dice:");
        for(int i=0;i<5;++i)
        {
            System.out.print(dice[i]+" ");
        }
        System.out.print("\nPreserve:");
        for(int i=0;i<5;++i)
        {
            System.out.print(preserve[i]+" ");
        }
        System.out.println();
        for(int i=0;i<6;++i)
        {
            if(dice[i]!=0)counter[dice[i]-1]++;
            if(preserve[i]!=0)counter[preserve[i]-1]++;
        }
        System.out.print("Counter:");
        for(int i=0;i<6;++i)
        {
            System.out.print(counter[i]+" ");
        }
        System.out.println();
    }
    
    public void swicher(int type)
    {
        sum=0;//reset sum
        if(0<=type&&type<=5)sum=counter[type]*(type+1);//Ones~Sixes
        else if(type==6)//Sum
        {
            for(int i=0;i<=5;++i)
            {
                sum+=score_paper.get(i).getScore();
            }
            score_paper.get(6).setScore(sum);
        }
        else if(type==7)//Bonus
        {
            if(score_paper.get(6).getScore()>=63)score_paper.get(7).setScore(35);
        }
        else if(type==8)//Three of a kind
        {
            boolean statment=false;
            for(int i=0;i<6;++i)
            {
                sum+=counter[i]*(i+1);
                if(counter[i]==3)
                {
                    statment=true;
                }
            }
            if(!statment)sum=0;
        }
        else if(type==9)//Four of a kind
        {
            boolean statment=false;
            for(int i=0;i<6;++i)
            {
                sum+=counter[i]*(i+1);
                if(counter[i]==4)
                {
                    statment=true;
                }
            }
            if(!statment)sum=0;
        }
        else if(type==10)//Full house
        {
            boolean two=false,three=false;
            for(int i=0;i<6;++i)
            {
                sum+=counter[i]*(i+1);
                if(counter[i]==2)two=true;
                if(counter[i]==3)three=true;
            }
            if(!(two&&three))sum=0;
        }
        else if(type==11)//Small straight
        {
            for(int i=0;i<6;++i)
            {
                sum+=counter[i]*(i+1);
            }
            boolean case1=true,case2=true,case3=true;
            for(int i=0;i<3;++i)
            {
                if(!(counter[i]>0&&counter[i+1]>0))case1=false;
                if(!(counter[i+1]>0&&counter[i+2]>0))case2=false;
                if(!(counter[i+2]>0&&counter[i+3]>0))case3=false;
            }
            if(!(case1||case2||case3))sum=0;
        }
        else if(type==12)//Large straight
        {
            boolean statement=true;
            for(int i=0;i<6;++i)
            {
                sum+=counter[i]*(i+1);
                if(counter[i]!=1)statement=false;
            }
            if(!statement)sum=0;
        }
        else if(type==13)//Chance
        {
            for(int i=0;i<6;++i)
            {
                sum+=counter[i]*(i+1);
            }
        }
        else if(type==14)//YAHTZEE
        {
            for(int i=0;i<6;++i)
            {
                if(counter[i]==5)sum=50;
            }
            if(sum!=50)sum=0;
        }
        else if(type==15)//Total Score
        {
            for(int i=6;i<=14;++i)//from sum to YAHTZEE
            {
                sum+=score_paper.get(i).getScore();
            }
            score_paper.get(15).setScore(sum);
        }
    }
    
    public void player_action()
    {
        System.out.print("Enter the option you want to mark this round.");
        String action=myInput.getString();
        for(Score item:score_paper)
        {
            if(action.equals(item.getDescription()))
            {
                swicher(item.getNum());
                item.setScore(sum);
                item.setUsed(item.getUsed()+1);
            }
        }
    }
    
    public boolean game_finished()
    {
        boolean gameFinished1=true,gameFinished2=true,gameFinished=false;
        for(int i=0;i<=5;++i)
        {
            if(score_paper.get(i).getUsed()==0)
            {
                gameFinished1=false;
                break;
            }
        }
        for(int i=8;i<=14;++i)
        {
            if(score_paper.get(i).getUsed()==0)
            {
                gameFinished2=false;
                break;
            }
        }
        if(gameFinished1&&gameFinished2)gameFinished=true;
        return gameFinished;
    }
}
