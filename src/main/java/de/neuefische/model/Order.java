package de.neuefische.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Order {

    private String orderID;
    private Map<String,Product> orderMap;


    public Order(String orderID, Map<String, Product> orderMap) {
        this.orderID = orderID;
        this.orderMap = orderMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderID, order.orderID) && Objects.equals(orderMap, order.orderMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, orderMap);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
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
}
