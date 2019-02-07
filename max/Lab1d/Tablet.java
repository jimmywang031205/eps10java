public class Tablet
{
    private String brand;
    private String model;
    private double lcd;
    private int drive_size;
    private String cpu;
    private int memory;
    private String os;
    private boolean usb_ava;
    private boolean key_ava;
    private boolean cord_ava;
    
    public void Tablet(String _brand, String _model, double _lcd, int _drive_size, String _cpu, int _memory, String _os, boolean _usb_ava, boolean _key_ava, boolean _cord_ava)
    {
        // initialise instance variables
        brand=_brand;
        model=_model;
        lcd=_lcd;
        drive_size=_drive_size;
        cpu=_cpu;
        memory=_memory;
        os=_os;
        usb_ava=_usb_ava;
        key_ava=_key_ava;
        cord_ava=_cord_ava;
    }
    
    
    public void setbrand(String _brand)
    {
        brand=_brand;
    }

    //accessor method allow us to access the data
    public String getbrand()
    {
        return brand;   
    }
    
    public void setmodel(String _model)
    {
        model=_model;
    }

    //accessor method allow us to access the data
    public String getmodel()
    {
        return model;   
    }

    public void setlcd(double _lcd)
    {
        lcd=_lcd;
    }

    //accessor method allow us to access the data
    public double getlcd()
    {
        return lcd;   
    }
    
    public void setdrive_size(int _drive_size)
    {
        drive_size=_drive_size;
    }

    //accessor method allow us to access the data
    public int getdrive_size()
    {
        return drive_size;   
    }
    
    public void setcpu(String _cpu)
    {
        cpu=_cpu;
    }

    //accessor method allow us to access the data
    public String getcpu()
    {
        return cpu;   
    }
    
    public void setmemory(int _memory)
    {
        memory=_memory;
    }

    //accessor method allow us to access the data
    public int getmemory()
    {
        return memory;   
    }
    
    public void setos(String _os)
    {
        os=_os;
    }

    //accessor method allow us to access the data
    public String getos()
    {
        return os;   
    }
    
    public void setusb_ava(boolean _usb_ava)
    {
        usb_ava=_usb_ava;
    }

    //accessor method allow us to access the data
    public boolean getusb_ava()
    {
        return usb_ava;   
    }
    
    public void setkey_ava(boolean _key_ava)
    {
        key_ava=_key_ava;
    }

    //accessor method allow us to access the data
    public boolean getkey_ava()
    {
        return key_ava;   
    }
    
    public void setcord_ava(boolean _cord_ava)
    {
        cord_ava=_cord_ava;
    }

    //accessor method allow us to access the data
    public boolean getcord_ava()
    {
        return cord_ava;   
    }
    
    public void display()
    {
        System.out.println("brand:"+getbrand());
        System.out.println("model:"+getmodel());
        System.out.println("lcd size:"+getlcd());
        System.out.println("hard drive size:"+getdrive_size()+"G");
        System.out.println("cpu:"+getcpu());
        System.out.println("memory:"+getmemory()+"G");
        System.out.println("operating system:"+getos());
        System.out.println("does it have an usb port?  "+getusb_ava());
        System.out.println("does it have a keyboard dock? "+getkey_ava());
        System.out.println("does it come with charging cord? "+getcord_ava());
    }
    
}
