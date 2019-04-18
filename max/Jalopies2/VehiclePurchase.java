
/**
 * Write a description of class VehiclePurchase here.
 *
 * @author Max
 * @version 1.2
 */

public class VehiclePurchase {
    private Customer customer;
    private PurchaseDate purchaseDate;
    private Vehicle vehiclePurchased;
    private boolean servicePackage;
    public static final double SERVICE_FEE = 500.00;

    public VehiclePurchase()
    {

    }

    public VehiclePurchase(Customer renter, PurchaseDate purchaseDate, Vehicle vehiclePurchased, boolean servicePackage) {
        this.customer = renter;
        this.purchaseDate = purchaseDate;
        this.vehiclePurchased = vehiclePurchased;
        this.servicePackage = servicePackage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public PurchaseDate getPurchaseDate() {
        return purchaseDate;
    }

    public Vehicle getVehiclePurchased() {
        return vehiclePurchased;
    }

    public boolean hasServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(boolean servicePackage) {
        this.servicePackage = servicePackage;
    }

	
    public void calculatePurchasePrice(double purchasePrice) {
        if (servicePackage == true) {
            vehiclePurchased.setSellingPrice(vehiclePurchased.getSellingPrice() + SERVICE_FEE);
            
        }
    }
    

    public void display() {
        System.out.println("Customer: " + customer.getFullName());
        System.out.println("Purchase Date: " + purchaseDate.PurchaseDate(2019,1,1));
        System.out.println("Vehicle Description: Jalopies Are Us Vehicle Summary:");
        System.out.println("Vehicle: " + vehiclePurchased.getYear() + " " + vehiclePurchased.getMake() + " " + vehiclePurchased.getModel()); // which one comes first? make or model
        System.out.println("Stock Code: " + vehiclePurchased.getStockCode());
        System.out.println("Dealer Cost: $" + String.format("%.2f", vehiclePurchased.getDealerCost()));
        System.out.println("Selling Price: $" + String.format("%.2f", vehiclePurchased.getSellingPrice()));
        vehiclePurchased.calculateProfitMargin();
        System.out.println("Profit Margin: " + vehiclePurchased.calculateProfitMargin()+ "%");
        System.out.println("Dollar Profit: " + vehiclePurchased.displayProfit());
        if(servicePackage == true) {
            System.out.println("SERVICE PACKAGE INCLUDED");
        } else {
            System.out.println("SERVICE PACKAGE NOT INCLUDED");
        }
    }
}
