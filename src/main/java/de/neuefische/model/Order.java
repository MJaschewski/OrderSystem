package de.neuefische.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Order {

    private String orderID;
    private double orderPrice = 0;
    private Map<String,Product> orderMap;


    public Order(String orderID, Map<String, Product> orderMap) {
        this.orderID = orderID;
        this.orderMap = orderMap;
        for (Product products : this.orderMap.values()){
            this.orderPrice += products.getPrice();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.orderPrice, orderPrice) == 0 && Objects.equals(orderID, order.orderID) && Objects.equals(orderMap, order.orderMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, orderPrice, orderMap);
    }

    @Override
    public String toString() {
        for (Product products : this.orderMap.values()){
            this.orderPrice += products.getPrice();
        }
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderMap=" + orderMap +
                '}';
    }

    public Map<String, Product> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<String, Product> orderMap) {
        this.orderMap = orderMap;
    }

    public Order() {
    }


    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getOrderPrice() {
        for (Product products : this.orderMap.values()){
            this.orderPrice += products.getPrice();
        }
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }


}
