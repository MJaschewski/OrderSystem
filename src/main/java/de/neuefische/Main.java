package de.neuefische;

import de.neuefische.model.NoValidProductToOrderException;
import de.neuefische.model.Order;
import de.neuefische.model.Product;
import de.neuefische.repository.ProductRepo;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //Full System
            Map<String, Product> productMap = new HashMap<>();
            Product Lappy = new Product("Laptop","1001",1500.00);
            Product Mouse = new Product("Mouse","1002",30.00);
            Product Keyboard = new Product("Keyboard","1003",50.00);
            productMap.put(Lappy.getProductID(), Lappy);
            productMap.put(Mouse.getProductID(), Mouse);
            productMap.put(Keyboard.getProductID(), Keyboard);

            ProductRepo newProducts = new ProductRepo(productMap);

            ShopService newService = new ShopService(newProducts);

            Map<String, Product> orderMap1 = new HashMap<>();
            orderMap1.put(Mouse.getProductID(), Mouse);
            orderMap1.put(Keyboard.getProductID(), Keyboard);

            Order newOrder = new Order("Order1",orderMap1);

            try{newService.addOrder(newOrder);} catch (NoValidProductToOrderException e){
                    System.out.println(e.getMessage());
            }
        //Usages
            System.out.println(newService.listProducts());
            System.out.println(newService.listOrders());

            Order get = newService.getOrder(newOrder.getOrderID());
            System.out.println("Get order Id. Order Id of Order 1: " + get.getOrderID());

            System.out.println("Get Product 1002 : " + newService.getProduct("1002").getName());
    }
}
