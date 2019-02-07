
/**
 * Write a description of class Tablet here.
 *
 * @author Jimmy Wang
 * @version (January 31, 2019)
 */
public class Tablet
{
    // instance variables - replace the example below with your own
    private String brand;
    private String model;
    private double lcd;
    private int storage;
    private String cpuModel;
    private int memory;
    private String OS;
    private boolean usbPort;
    private boolean keyboardDock;
    private boolean chargeCord;

    /**
     * Constructor for objects of class Tablet
     */
    public Tablet()
    {
        System.out.println("Tablet");
    }

    public void Name(String _brand, String _model, double _lcd, int _storage, String _cpuModel, int _memory, String _OS, boolean _usbPort, boolean _keyboardDock, boolean _chargeCord)
    {
        brand = _brand;
        model = _model;
        lcd = _lcd;
        storage = _storage;
        cpuModel = _cpuModel;
        memory = _memory;
        OS = _OS;
        usbPort = _usbPort;
        keyboardDock = _keyboardDock;
        chargeCord = _chargeCord;
    }
    
    public void setBrand(String _brand)
    {
     brand = _brand;
    }
    
    public void setModel(String _model)
    {
     model = _model;
    }
    
    public void setLCD(double _lcd)
    {
     lcd = _lcd;
    }
    
    public void setStorage(int _storage)
    {
     storage = _storage;
    }
    
    public void setCPUModel(String _cpuModel)
    {
     cpuModel = _cpuModel;
    }
    
    public void setMemory(int _memory)
    {
     memory = _memory;
    }
    
    public void setOS(String _OS)
    {
     OS = _OS;
    }
    
    public void setUSBPort(boolean _usbPort)
    {
     usbPort = _usbPort;
    }
    
    public void setKBDock(boolean _keyboardDock)
    {
     keyboardDock = _keyboardDock;
    }
    
    public void setChargeCord(boolean _chargeCord)
    {
     chargeCord = _chargeCord;
    }
    
    public String getBrand()
    {
        return brand;
    }
    
    public String getModel()
    {
        return model;
    }
    
    public double getLCD()
    {
        return lcd;
    }
    
    public int getStorage()
    {
        return storage;
    }
    
    public String getCPUModel()
    {
        return cpuModel;
    }
    
    public int getMemory()
    {
        return memory;
    }
    
    public String getOS()
    {
        return OS;
    }
    
    public boolean getUSBPort()
    {
        return usbPort;
    }
    
    public boolean getKBDock()
    {
        return keyboardDock;
    }
    
    public boolean getChargeCord()
    {
        return chargeCord;
    }
    
    public void display()
    {
        System.out.println(getBrand()+" Model "+getModel());
        System.out.println("LCD Size: "+getLCD()+"“");
        System.out.println("Storage: "+getStorage()+"GB"+"  Memory: "+getMemory()+"GB");
        System.out.println("CPU: "+getCPUModel());
        System.out.println("Operating System: "+getOS());
        System.out.println("Does it have an USB port? "+getUSBPort());
        System.out.println("Does it have a keyboard dock? "+getKBDock());
        System.out.println("Does it come with charging cord? "+getChargeCord());
    }
}
