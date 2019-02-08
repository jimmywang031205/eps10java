
/**
 * Write a description of class Book here.
 *
 * @author Max
 * @version 2019-02-08
 */
public class Book
{
    // instance variables
    private String title,author,ISBN;
    private int pages=0;
    private boolean paperback_ava;
    private double price=0;
    /**
     * Constructor for objects of class Book
     */
    public Book()//init
    {
        // initialise instance variables

    }
    public void Book(String _title,String _author,String _ISBN, int _pages,boolean _paperback_ava,double _price)
    {
        settitle(_title);
        setauthor(_author);
        setISBN(_ISBN);
        setpages(_pages);
        setpaperback_ava(_paperback_ava);
        setprice(_price);
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
    
    public void setpages(int _pages)
    {
        //pages>0?pages=_pages:pages=0;
        if(_pages>0) pages=_pages;
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
    
    public void setprice(double _price)
    {
        if(_price>0)price = _price;
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
