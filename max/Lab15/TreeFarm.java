import java.util.*;
/**
 * Write a description of class TreeFarm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TreeFarm
{
    // instance variables - replace the example below with your own
    ArrayList<Tree> treeFarm;

    /**
     * Constructor for objects of class TreeFarm
     */
    public TreeFarm()
    {
        // initialise instance variables
        treeFarm=new ArrayList<Tree>();
    }
    
    public void addTree(Tree treeToAdd)
    {
        treeFarm.add(treeToAdd);
    }
    
    public void showAllTrees()
    {
        for(Tree element:treeFarm)
        {
            System.out.println("Species: "+element.getSpecies()+"  Age: "+element.getAge());
        }
    }
    
    public void logOldTrees(int age)
    {
        int count=0;
        for(Tree element:treeFarm)
        {
            if(element.getAge()>age)
            {
                treeFarm.remove(count);
                continue;
            }
            count++;
        }
    }
    
    public void swap(int a,int b)
    {
        if(a<0||b<0||a>=treeFarm.size()||b>=treeFarm.size())System.out.println("------------ERROR------------");
        Tree temp = treeFarm.get(a);
        treeFarm.set(a,treeFarm.get(b));
        treeFarm.set(b,temp);
    }
    
    public void listAllTrees()
    {
    Iterator<Tree> it = treeFarm.iterator();
    while(it.hasNext()) 
    {
        Tree tk = it.next();
        System.out.println("Species: "+tk.getSpecies()+"  Age: "+tk.getAge());
    }
    } 

}
