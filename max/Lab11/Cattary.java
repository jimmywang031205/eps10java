
import java.util.*;
/**
 * Write a description of class Cattary here.
 *
 * @author Max
 * @version 2019-03-11
 */
public class Cattary
{
    // instance variables - replace the example below with your own
    private ArrayList<Cat> catList;
    private String companyName;
    /**
     * Constructor for objects of class Cattary
     */
    public Cattary(String _companyName)
    {
        // initialise instance variables
        catList=new ArrayList<Cat>();
        setCompanyName(_companyName);
        traversal();
    }
    
    public void setCompanyName(String _companyName)
    {
        if(_companyName!=null && _companyName.length()>0)
            companyName=_companyName;
        else System.out.println("Bad Input!");  
    }
    
    public void addCat(Cat newCat)
    {
        catList.add(newCat);
    }
    
    public void listCat(int index)
    {
        if(index>=0&&index<catList.size())
        {
            Cat tempCat=catList.get(index);
            System.out.println(tempCat.getName());
        }
    }
    
    public void traversal()
    {   
        for(Cat element:catList){
            System.out.println(element.getName());
        }
    }
    
    public void takeCat(int index)
    {
        if(index>=0&&index<catList.size())
        {
            catList.remove(index);
        }
    }
    
    public void displayMyCats()
    {
        for(int i=0;i<=catList.size();i++)
        {
            System.out.println(catList.get(i).getName());
        }
    }
}
