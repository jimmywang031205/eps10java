import java.util.Scanner;
/**
 * Write a description of class Book here.
 *
 * @author Max
 * @version 2019-02-08
 * @version 2019-02-13
 */
public class Book
{
    // instance variables
    private String title,author,ISBN;
    private int pages=0;
    private boolean paperback_ava;
    private double price=0;
    private Input myInput;
    /**
     * Constructor for objects of class Book
     */
    public Book()//init
    {
        // initialise instance variables
        myInput= new Input();
    }
    public void Book(String _title,String _author,String _ISBN, boolean _paperback_ava)
    {
        settitle(_title);
        setauthor(_author);
        setISBN(_ISBN);
        setpages();
        setpaperback_ava(_paperback_ava);
        setprice();
    }
    
    public void settitle(String _title)
    {
        title = _title;
    }
    public String gettitle()
    {
        return title;
    }
    
    public void setauthor(String _author)
    {
        author = _author;
    }
    public String getauthor()
    {
        return author;
    }
    
    public void setISBN(String _ISBN)
    {
        ISBN = _ISBN;
    }
    public String getISBN()
    {
        return ISBN;
    }
    
    public void setpages()
    {
        System.out.print("Input the number of the pages: ");
        int _pages;
        _pages=myInput.getInt();
        if(_pages>0) pages=_pages;
        else
        {
           System.out.println("Invalid Input");
           setpages();
        }
        //pages>0?pages=_pages:pages=0;
    }
    public int getpages()
    {
        return pages;
    }
    
    public void setpaperback_ava(boolean _paperback_ava)
    {
        paperback_ava = _paperback_ava;
    }
    public boolean getpaperback_ava()
    {
        return paperback_ava;
    }
    
    public void setprice()
    {
        System.out.println("Input the price: ");
        double _price;
        _price=myInput.getDouble();
        if((_price>=0.01)&&(_price<=0.99))
        {
            System.out.println("too low");
            setprice();
        }
        else if((_price>10))
        {
            System.out.println("too high");
            setprice();
        }
        else if((_price>0)&&(_price<=10))
        {
            _price=price;
        }
        else
        {
            System.out.println("Invalid Input");
            setprice();
        }

       
    }
    public double getprice()
    {
        return price;
    }
    
    public void displayBook()
    {
        System.out.println("Title : "+gettitle());
        System.out.println("Author : "+getauthor());
        System.out.println("ISBN : "+getISBN());
        System.out.println("Pages : "+getpages());
        System.out.print("Paperback : ");
        if(getpaperback_ava()==true)System.out.println("yes");
        else System.out.println("no");
        System.out.println("Suggested price : $"+getprice());
        /*
        Title : Ghost Stories of British Columbia  
        Author : Jo-Anne Christensen  
        ISBB : 0-88882-191-3  
        Pages : 192 
        Paperback : yes 
        Suggested price : $17.99   
        */
    }
}
