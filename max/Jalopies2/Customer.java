/**
 * Write a description of class Customer here.
 *
 * @author Max
 * @version 1.01
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private String firstName; 
    private String lastName;
    private String driversLicense;  
    private String address;  
    private String phoneNumber; 
    private Input MyInput;

    public Customer()
    {
        // initialise instance variables
        MyInput=new Input();
    }
    
    public Customer(String firstName, String lastName, String driversLicense, String address, String phoneNumber)
    {
        setFirstName();
        setLastName();
        setDriversLicense();
        setAddress();
        setPhoneNumber();
    }

    public void setFirstName() 
    {
        System.out.print("First Name: ");
        String _firstName=MyInput.getString();
        if (_firstName.length() >= 1) {
            firstName = _firstName.substring(0,1).toUpperCase() + _firstName.substring(1).toLowerCase();
        } 
        else 
        {
            System.out.println("Error, missing first name!");
            setFirstName();
        }
    }
    public String getFirstName() 
    {
        return firstName;
    }

    public void setLastName() 
    {
        System.out.print("Last Name: ");
        String _lastName=MyInput.getString();
        if (_lastName.length() >= 1) {
            lastName = _lastName.substring(0,1).toUpperCase() + _lastName.substring(1).toLowerCase();
            _lastName = lastName;
        } else {
            System.out.println("Error, missing last name!");
            setLastName();
        }
    }
    public String getLastName() 
    {
        return lastName;
    }

    public void setDriversLicense() 
    {
        System.out.print("Drivers License: ");
        String _driversLicense=MyInput.getString();
        if (_driversLicense.length() >= 1) {
            _driversLicense = driversLicense;
        } else {
            System.out.println("Error, missing drivers license!");
            setDriversLicense();
        }
    }
    public String getDriversLicense() 
    {
        return driversLicense;
    }

    public void setAddress() 
    {
        System.out.print("Address: ");
        String _address=MyInput.getString();
        if (_address.length() >= 1) {
            _address = address;
        } else {
            System.out.println("Error, missing address!");
            setAddress();
        }
    }
    public String getAddress() 
    {
        return address;
    }
    
    public void setPhoneNumber() 
    {
        System.out.print("Phone Number: ");
        String _phoneNumber=MyInput.getString();
        if(_phoneNumber.length()>=1)_phoneNumber = phoneNumber;
        else
        {
            System.out.println("Error, missing phone number!");
        }
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
