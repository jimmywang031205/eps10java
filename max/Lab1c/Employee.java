public class Employee
{
    // instance variables - replace the example below with your own
    private String firstName;
    private String lastName;
    private String email;
    private String id;
    private double hourpay;
    private double hour;
    private boolean full;
    
    public void employee(String _firstName,String _lastName,String _email,String _id,float _hourpay,float _hour,boolean _full)
    {
    firstName=_firstName;
    lastName=_lastName;
    email=_email;
    id=_id;
    hourpay=_hourpay;
    hour=_hour;
    full=_full;
    }
    
    
    

    public void setFirstName(String _firstName)
    {
        firstName=_firstName;
    }

    //accessor method allow us to access the data
    public String getFirstName()
    {
        return firstName;   
    }
    
    public void setLastName(String _lastName)
    {
        lastName=_lastName;
    }

    //accessor method allow us to access the data
    public String getLastName()
    {
        return lastName;   
    }
    
    public void setemail(String _email)
    {
        email=_email;
    }

    //accessor method allow us to access the data
    public String getemail()
    {
        return email;   
    }
    
    public void setid(String _id)
    {
        id=_id;
    }

    //accessor method allow us to access the data
    public String getid()
    {
        return id;   
    }
    
    public void sethourpay(double _hourpay)
    {
        hourpay= _hourpay;
    }

    //accessor method allow us to access the data
    public double gethourpay()
    {
        return hourpay;   
    }
    
    public void sethour(double _hour)
    {
        hour= _hour;
    }

    //accessor method allow us to access the data
    public double gethour()
    {
        return hour;   
    }
    
    public void setfull(boolean _full)
    {
        full= _full;
    }

    //accessor method allow us to access the data
    public boolean getfull()
    {
        return full;   
    }
    
    
    public void display()
    {
        System.out.println("first name:"+ getFirstName());
        System.out.println("last name:"+getLastName());
        System.out.println("employee number:"+getid());
        System.out.println("email:"+getemail());
        System.out.println("number of hours worked:"+gethour()+"h");
        System.out.println("pay per hour:"+gethourpay()+"$");
        System.out.println("is the employee full time? "+getfull());
    }
}
