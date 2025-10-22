package com.java.assign;

import java.util.*;

public class Warehouse
{
    private Map<String, Product> inventory = new HashMap<>();
    private AlertService alertService;

    public Warehouse(AlertService alertService)
    {
        this.alertService = alertService;
    }

    public void addProduct(Product product) 
    {
        inventory.put(product.getId(), product);
        System.out.println("Product added: " + product.getName());
    }

    public void receiveShipment(String id, int qty)
    {
        Product p = inventory.get(id);
        if (p != null)
        {
            p.setQuantity(p.getQuantity() + qty);
            System.out.println("Shipment received: " + qty + " units of " + p.getName());
        }
        else 
        {
            System.out.println("Product not found!");
        }
    }

    public void fulfillOrder(String id, int qty) 
    {
        Product p = inventory.get(id);
        if (p != null)
        {
            if (p.getQuantity() >= qty)
            {
                p.setQuantity(p.getQuantity() - qty);
                System.out.println("Order fulfilled: " + qty + " units of " + p.getName());

                if (p.getQuantity() < p.getThreshold()) 
                {
                    alertService.onLowStock(p);
                }
            }
            else
            {
                System.out.println("Not enough stock for " + p.getName());
            }
        } 
        else 
        {
            System.out.println("Product not found!");
        }
    }
}
