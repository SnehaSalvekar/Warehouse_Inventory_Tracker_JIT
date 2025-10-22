package com.java.assign;

public class Main 
{
    public static void main(String[] args)
    {
        AlertService alert = new AlertService() 
        {
            @Override
            public void onLowStock(Product product) 
            {
                System.out.println("ALERT: Low stock for " + product.getName() + 
                                   "only " + product.getQuantity() + " left!");
            }
        };

        Warehouse warehouse = new Warehouse(alert);

        
        Product laptop = new Product("P101", "Laptop", 0, 5);
        warehouse.addProduct(laptop);

      
        warehouse.receiveShipment("P101", 10); 

  
        warehouse.fulfillOrder("P101", 6);
    }
}
