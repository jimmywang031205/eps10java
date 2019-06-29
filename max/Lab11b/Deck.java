import java.util.*;
/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Deck
{
    // instance variables - replace the example below with your own
    private ArrayList<Card> CardList;
    /**
     * Constructor for objects of class Deck
     */
    public Deck()
    {
        // initialise instance variables
       CardList=new ArrayList<Card>();
    }
    
    public void addCard(Card cardToAdd)
    {
        CardList.add(cardToAdd);
    }
    
    public Card takeCard()
    {
        if(CardList.isEmpty())return null;
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
