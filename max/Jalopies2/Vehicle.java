/**
 * @author Max
 * @version 1.0 beta
 */
public class Vehicle
{
    // instance variables - replace the example below with your own
    private int year;
    private double dealerCost,sellingPrice,profitMargin;
    private String stockCode,make,model;
    private Input myInput;
    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle()
    {
        // initialise instance variables
        myInput=new Input();
    }
    public void Vehicle(String _stockCode,String _make,String _model,double _sellingPrice)
    {
        setYear();
        setStockCode(_stockCode);
        setMake(_make);
        setModel(_model);
        setDealerCost();
        setSellingPrice(_sellingPrice);
    }
    public void setYear()
    {
        System.out.print("Please input the year: ");
        int _year=myInput.getInt();
        if(_year>=1950 && _year<=2019)year=_year;
        else
        {
            //System.out.print("Illegal input!");
            //setYear();
            year=2019;
        }
    }
    public int getYear()
    {
        return year;
    }
    
    public void setStockCode(String _stockCode)
    {
        if(_stockCode!=null)stockCode=_stockCode;
        else stockCode="@@@@@";
    }
    public String getStockCode()
    {
        return stockCode;
    }
    
    public void setMake(String _make)
    {
        if(_make!=null)make=_make;
        else make="@@@@@";
    }
    public String getMake()
    {
        return make;
    }
    
    public void setModel(String _model)
    {
        if(_model!=null)model=_model;
        else model="@@@@@";
    }
    public String getModel()
    {
        return model;
    }
    
    public void setDealerCost()
    {
        System.out.print("Please input the dealer cost: ");
        double _dealerCost=myInput.getDouble();
        if(_dealerCost>=0)dealerCost=_dealerCost;
        else
        {
            System.out.println("The can't be negative!");
            setDealerCost();
        }
    }
    public double getDealerCost()
    {
        return dealerCost;
    }
    
    public void setSellingPrice(double _sellingPrice)
    {
        //System.out.print("Please input the Selling Price: ");
       // double _sellingPrice=myInput.getDouble();
        if(_sellingPrice>0)sellingPrice=_sellingPrice;
        else
        {
            System.out.println("selling price should not less than 0!");
            //setSellingPrice();
        }
        checkStandardSellingPrice();
    }
    public double getSellingPrice()
    {
        return sellingPrice;
    }
    
    public double calculateProfitMargin()
    {
        return (sellingPrice-dealerCost)/sellingPrice;
    }
    
    public void checkStandardSellingPrice()
    {
        double percent=(sellingPrice-dealerCost)/dealerCost;
        if(percent<=0.25)
        {
            System.out.println("$"+sellingPrice+" is only "+percent*100+" % higher than $"+dealerCost);
            
            //setSellingPrice();
        }
    }
    public double displayProfit()
    {
        return sellingPrice-dealerCost;
    }
    public void  printDetails()
    {
        /*
         *  Jalopies Are Us Vehicle Summary:       
         *  Vehicle: 1974 Chevrolet Monte Carlo    
         *  Stock Code: 1974ChevMC    
         *  Dealer Cost: $250.00    
         *  Selling Price: $395.95    
         *  Profit Margin: 37%    
         *  Dollar Profit: $145.95
         */
        System.out.println("Jalopies Are Us Vehicle Summary:");
        System.out.println("Vehicle: "+getYear()+" "+getMake()+" "+getModel());
        System.out.println("Stock Code: "+getStockCode());
        System.out.println("Dealer Cost: $"+getDealerCost());
        System.out.println("Selling Price: $"+getSellingPrice());
        System.out.println("Profit Margin: "+calculateProfitMargin()+"%");
        System.out.println("Dollar Profit: $"+displayProfit());
    }
}

