package com.java.assign;

public class Product
{
    private String id;
    private String name;
    private int quantity;
    private int threshold;

    public Product(String id, String name, int quantity, int threshold) 
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.threshold = threshold;
    }

    public String getId() 
    { 
    	return id; 
    }
    public String getName() 
    {
    	return name;
    }
    public int getQuantity()
    {
    	return quantity; 
    }
    public int getThreshold() 
    { 
    	return threshold; 
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }
}
