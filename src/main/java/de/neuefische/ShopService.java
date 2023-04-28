package de.neuefische;

import de.neuefische.model.Order;
import de.neuefische.model.Product;
import de.neuefische.repository.OrderRepo;
import de.neuefische.repository.ProductRepo;

import java.util.List;
import java.util.NoSuchElementException;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepo orderRepo = new OrderRepo();

    public ShopService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public boolean commitOrders(){
        for(Order orders : orderRepo.orderList()){
            for(Product products : orders.getOrderMap().values()){
                try{
                    productRepo.getProduct(products.getProductID());
                } catch (NoSuchElementException e){
                    System.out.println("False order. Product " + products.getName() + " ID: " + products.getProductID() + "can't be ordered");
                    return false;
                }
            }
        }
        return true;
    }

    public Product getProduct(String productID){
        try{
            return productRepo.getProduct(productID);
        } catch (NoSuchElementException e){
            System.out.println("No such product in product repo");
            return new Product();
        }
    }

    public String listProducts(){
        String output = "";
        for (Product products : productRepo.getProductList()) {
            output = output + "Name: " + products.getName() + " ID: " + products.getProductID() + "\n";
        }
        return output;
    }

    public Order addOrder(Order order){
        for(Product products : order.getOrderMap().values()){
                try{
                    productRepo.getProduct(products.getProductID());
                } catch (NoSuchElementException e){
                    System.out.println("False order. Product " + products.getName() + " ID: " + products.getProductID() + " can't be ordered");
                    return new Order();
                }
        }

        orderRepo.addOrder(order);
        return  orderRepo.getOrder(order.getOrderID());
    }

    public Order getOrder(String orderID){
        try {
            return orderRepo.getOrder(orderID);
        } catch (NoSuchElementException e){
            System.out.println("No such order found");
            return new Order();
        }
    }

    public String listOrders(){
        String output = "";
        for (Order orders : orderRepo.orderList()) {
            output = output + orders.toString() +"\n";
        }
        return output;
    }
}
