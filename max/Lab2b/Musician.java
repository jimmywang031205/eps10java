public class Musician
{
    private String firstName;
    private String lastName;
    private String primaryInstrument;
    private String phoneNumber;
    private String email;
    private int numAwards,judge;
    private boolean underContract;
    private String isUnderContract;
    private Input myInput;
    public Musician()//init
    {
        // initialise instance variables
        myInput= new Input();
        System.out.print("Enter the first name: ");
        firstName=myInput.getString();
        System.out.print("Enter the last name: ");
        lastName=myInput.getString();
        System.out.print("Enter the primary instrument: ");
        primaryInstrument=myInput.getString();
        System.out.print("Enter the phone number: ");
        phoneNumber=myInput.getString();
        System.out.print("Enter the email: ");
        email=myInput.getString();
        System.out.print("number of awards: ");
        numAwards=myInput.getInt();
        System.out.print("under contract statement (1/2): ");
        judge=myInput.getInt();
        if(judge==1) underContract=true;
        else underContract=false;
        
        display();
    }
    
    public void Musician(String _firstName,String _lastName,String _primaryInstrument,String _phoneNumber,String _email,String _isUnderContract,int _numAwards,boolean _underContract)
    {
        firstName=_firstName;
        lastName= _lastName;
        primaryInstrument=_primaryInstrument;
        phoneNumber=_phoneNumber;
        email=_email;
        numAwards=_numAwards;
        underContract=_underContract;
        isUnderContract=_isUnderContract;
    }
    
    public String getfirstName()
    {
        return firstName;   
    }
    public String getlastName()
    {
        return lastName;   
    }
    public String getprimaryInstrument()
    {
        return primaryInstrument;   
    }
    public String getphoneNumber()
    {
        return phoneNumber;   
    }
    public String getemail()
    {
        return email;   
    }
    public int getnumAwards()
    {
        return numAwards;   
    }
    public boolean underContract()
    {
        return underContract;   
    }
    public String isUnderContract()
    {
        return isUnderContract;   
    }
    
    public void setFirstName(String _firstName)
    {
        firstName = _firstName;
    }
    public void setLastName(String _lastName)
    {
        lastName = _lastName;
    }
    public void setPrimaryInstrument(String _primaryInstrument)
    {
        primaryInstrument = _primaryInstrument;
    }
    public void setPhoneNumber(String _phoneNumber)
    {
        phoneNumber = _phoneNumber;
    }
    public void setEmail(String _email)
    {
        email = _email;
    }
    public void setNumAwards(int _numAwards)
    {
        numAwards = _numAwards;
    }
    public void setUnderContract(boolean _underContract)
    {
        underContract = _underContract;
    }
    public void setIsUnderContract(String _isUnderContract)
    {
        isUnderContract = _isUnderContract;
    }
    public void display()
    {
        System.out.println("First name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Primary Instrument: " + primaryInstrument);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Awards: " + numAwards);
        System.out.println("Under contract? "+underContract);

    }
    
}
