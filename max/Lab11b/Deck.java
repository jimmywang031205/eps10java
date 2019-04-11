import java.util.*;
/**
 * Write a description of class Deck here.
 *
 * @author Max
 * @version 1.41
 * @log:
 * 1.0 creat class
 * 1.01 add loadDeck and shuffle(contain swap),turnoff swapme func
 * 1.1 update loadDeck
 * 1.11 rewrite loadDeck,change date type of hit(int->string)
 * 1.20 beta creat Dealer AI 
 * 1.21 creat AceCheck
 * 1.22 update AceCheck
 * 1.22 AceCheck finish
 * 1.30 beta creat betting_system
 * 1.31 creat bet_check
 * 1.32 betting system finish
 * 1.40 beta creat take
 * 1.41 take finish
 * 1.41 working version compliete
 */
public class Deck
{
    private boolean blackjacked=false;
    private int pTotal,dTotal,money=500,Check_Code,bet;
    private String hit;
    private ArrayList<Card> CardList;
    private Input MyInput;
    private Card tempCard;
    public static final int SHUFFLE = 1000;
    public static final String[] SUITS={"Heart","Diamonds","Spades","Clubs"};
    public static final String[] DESC={"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    public static final int[] VALUE={1,2,3,4,5,6,7,8,9,10,10,10,10};
    

    public Deck()
    {
       MyInput=new Input();
       CardList=new ArrayList<Card>();
       tempCard=new Card();
       
       Play();
    }
    
    public void Play()
    {
       System.out.println("------------GAME START------------");
       while(money>0)
       {
          bet= Betting();
          loadDeck();
          shuffle();
          Deal();  
          CheckOut();
       }
       System.out.println("You're out of money dunbass!");
       System.out.println("------------GAME OVER------------");
    }
    
    
    public int Betting()
    {
        System.out.println("===================================");
        System.out.println("Balance:"+money);
        System.out.print("Please enter your bet:");
        int bet=MyInput.getInt();
        System.out.println("===================================");
        if(bet>money)
        {
            System.out.println("Now you only have "+money+"$, try other number!");
            Betting();
        }
        return bet;
    }
    
    public void CheckOut()
    {
        if(Check_Code==1)
        {
            money+=bet;
        }
        else if(Check_Code==0)
        {
            money-=bet;
        }
        else if(Check_Code==2)
        {
            money+=bet*2;
        }
        
    }
    
    public void loadDeck()
    {
        for(int s=0;s<4;s++)
            for(int d=0;d<13;d++)
            {
                Card tempCard = new Card();
                tempCard.setSuit(SUITS[s]);
                tempCard.setDescription(DESC[d]);
                tempCard.setValue(VALUE[d]);
                addCard(tempCard);
            }
    }
    
    /*
    public void swapME()
    {
        swap(0,1);
    }
    */
    public void swap(int num1,int num2)
    {
        Card tempCard=CardList.get(num1);
        CardList.set(num1,CardList.get(num2));
        CardList.set(num2,tempCard);
        
    }
    
    public void shuffle()
    {
        int num1,num2;
        Random randomGenerator = new Random();
        
        for (int x = 1; x<=SHUFFLE;x++){
            do {
                num1 = (randomGenerator.nextInt(52));// number from 0-51
                num2 = (randomGenerator.nextInt(52));// 1 number less than value
            } while( num1 == num2);
            swap(num1,num2);
        }
    }
    
    /*
    public void deal()
    {
        Card downCard=new Card();
        downCard=CardList.get(0);
        tempCard=CardList.get(0);
        System.out.println("Down Card");
        dTotal=tempCard.getValue();
        takeCard();
        tempCard=CardList.get(0);
        System.out.println(tempCard.getDescription()+" of "+tempCard.getSuit());
        dTotal+=tempCard.getValue();
        System.out.println("Dealer Total="+dTotal);
        
        tempCard=CardList.get(0);
        System.out.println(tempCard.getDescription()+" of "+tempCard.getSuit());
        pTotal=tempCard.getValue();
        takeCard();
        tempCard=CardList.get(0);
        System.out.println(tempCard.getDescription()+" of "+tempCard.getSuit());
        pTotal+=tempCard.getValue();
        System.out.println("Play total="+ pTotal);
        pTotal=0;
        System.out.print("Would you like a hit?(1=yes/2=no)");
        hit=MyInput.getInt();
        while(pTotal <=21 && hit == 1)
        {
            takeCard();
            tempCard=CardList.get(0);
            System.out.println(tempCard.getDescription()+" of "+tempCard.getSuit());
            pTotal+=tempCard.getValue();
            System.out.println("Player Total="+pTotal);
            
            System.out.println("Woluld you like a hit ?(1=yes/2=no)");
            hit=MyInput.getInt();
        }
        System.out.println();
        System.out.println("Dealer had"+downCard.getDescription()+" of "+downCard.getSuit());
        System.out.println("Dealer Total="+dTotal);
        System.out.println("Woluld you like a hit ?(1=yes/2=no)");
        hit=MyInput.getInt();
        while(pTotal <=21 && hit == 1)
        {
            takeCard();
            tempCard=CardList.get(0);
            System.out.println(tempCard.getDescription()+" of "+tempCard.getSuit());
            pTotal+=tempCard.getValue();
            System.out.println("Player Total="+pTotal);
            
            System.out.println("Woluld you like a hit ?(1=yes/2=no)");
            hit=MyInput.getInt();
        }
        if(dTotal>pTotal)System.out.println("Dealer Wins!");
        else if(pTotal>dTotal)System.out.println("Player Wins!");
        pTotal=0;
        dTotal=0;
        
    }
    */
   
    public void Deal()
    {
        
        System.out.println("Dealer's hand:");
        tempCard = CardList.get(0);
        System.out.println("Down Card");
        Card downCard = tempCard;
        takeCard();//up carrd
        tempCard = CardList.get(0);
        System.out.println(tempCard.getDescription()+" of "+tempCard.getSuit());
        AceCheck(1);
        dTotal+=tempCard.getValue();
        System.out.println("Dealer total= "+dTotal);
        
        System.out.println();
        
        System.out.println("Your hand:");
        tempCard = CardList.get(0);
        System.out.println(tempCard.getDescription()+" of "+tempCard.getSuit());
        AceCheck(0);
        Black_Jack();
        pTotal+=tempCard.getValue();
        takeCard();
        tempCard = CardList.get(0);
        System.out.println(tempCard.getDescription()+" of "+tempCard.getSuit());
        AceCheck(0);
        pTotal+=tempCard.getValue();
        takeCard();
        System.out.println("Player total= "+pTotal);
        Black_Jack();
        if(blackjacked==false)
        {
        System.out.println("Would you like a hit? (yes/no)");
        hit = MyInput.getString();
        while (pTotal < 21 && hit.equals("yes")){
            tempCard = CardList.get(0);
            System.out.println(tempCard.getDescription()+" of "+tempCard.getSuit());
            AceCheck(0);
            pTotal+=tempCard.getValue();
            takeCard();
            System.out.println("Player total= "+pTotal);
            if (pTotal < 21){
                System.out.println("Would you like a hit? (yes/no)");
                hit = MyInput.getString();
            }
        }
        
        if (pTotal < 21 && hit.equals("no"))stand();
        
        if (pTotal >= 21){
            System.out.println("Down Card: "+ downCard.getDescription()+" of "+downCard.getSuit());
            if(downCard.getValue()+10+dTotal<21)dTotal+=10;
            dTotal += downCard.getValue();
            System.out.println("Dealer total= "+dTotal);
            stand();
        }
        Judge();
    }
        System.out.println("------------CHECK POINT:DEAL_FUNCTION_END------------");
        //if blackjack Check_Code=2;
        pTotal=0;
        dTotal=0;
        blackjacked=false;
    
    } 
    
    public void stand()
    {
        while (dTotal < 17){
            tempCard = CardList.get(0);
            System.out.println(tempCard.getDescription()+" of "+tempCard.getSuit());
            AceCheck(1);
            dTotal+=tempCard.getValue();
            takeCard();
            System.out.println("Dealer total= "+dTotal);
        }
    }
    /*
    public int AceCheck(Card _tempCard,int tempTotal)
    {
        if(tempTotal+11>21)
        {
            if(pTotal+1>21)
            {
                System.out.println("YOU LOSE");
                return 0;
            }
            else tempTotal+=1;    
        }
        else tempTotal+=11;
            
        return tempTotal;
    }
    */
   
    public void AceCheck(int i)
    {
        if(tempCard.getValue()==1)
        {
            if(i==0)
            {
                if(tempCard.getValue()+pTotal+10<21)pTotal+=10;
            }
            else
            {
                if(tempCard.getValue()+dTotal+10<21)dTotal+=10;
            }
        }
        
    }
    
    public void Judge()
    {
        System.out.println("------------CHECK POINT:CHECK_OUT------------");
        if (pTotal > 21){
            System.out.println("YOU LOSE");
            Check_Code=0;
        } else if (dTotal > 21 || pTotal > dTotal){
            System.out.println("YOU WIN");
            Check_Code=1;
        } else if (pTotal == dTotal){
            System.out.println("PUSH");
            Check_Code=3;
        } else if (dTotal <= 21 && pTotal < 21 && pTotal < dTotal){
            System.out.println("YOU LOSE");
            Check_Code=0;
        }
    }
    
    public void Black_Jack()
    {
        int count=0,total=0,flag=0;
        count++;
        if(flag==0&&count==1)
        {
            if(tempCard.getSuit().equals("Ace")||tempCard.getSuit().equals("Jack"))
            {
               flag++;
            }
            }
        if(flag==1&&count==2)
        {
            if(tempCard.getSuit().equals("Ace")||tempCard.getSuit().equals("Jack"))
            {
                flag++;
            }
        }
        if(flag==2&count==2)
        {
            System.out.println("------------BLACK JACK------------");
            System.out.println("YOU WIN");
            Check_Code=2; 
            blackjacked=true;
            money+=bet;
        }
        
    }
    
    public void addCard(Card cardToAdd)
    {
        CardList.add(cardToAdd);
    }
    
    public void takeCard()
    {
        if(CardList.isEmpty())
        {
            System.out.println("------------ERROR:THERE_IS_NO_CARD_REMAIN------------");
            System.out.println("Play again? (yes/no)");
            String temp=MyInput.getString();
            if(temp.equals("yes"))
            {
                Play();
            }
        }
        else take();
        
    }
    
    public Card take()
    {
        Card temp=CardList.get(0);
        CardList.remove(0);
        return temp;   
    }
    
    public void  showDeck()
    {   
        for(Card element:CardList){
            System.out.println(element.getDescription()+" of "+element.getSuit());
        }
    }
}
