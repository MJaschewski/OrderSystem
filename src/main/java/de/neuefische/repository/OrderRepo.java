package de.neuefische.repository;

import de.neuefische.model.Order;
import de.neuefische.model.Product;

import java.util.*;

public class OrderRepo {
    private Map<String, Order> orderMap = new HashMap<>();

    public OrderRepo(Map<String, Order> orderMap) {
        this.orderMap = orderMap;
    }

    public OrderRepo() {
    }

    @Override
    public String toString() {
        return "OrderRepo{" +
                "orderMap=" + orderMap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRepo orderRepo = (OrderRepo) o;
        return Objects.equals(orderMap, orderRepo.orderMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderMap);
    }

    public Order addOrder(Order order){
        this.orderMap.put(order.getOrderID(),order);
        return orderMap.get(order.getOrderID());
    }
    public Order getOrder(String orderID) throws NoSuchElementException{
        if (orderMap.containsKey(orderID)) {
            return orderMap.get(orderID);
        }
        else {
            throw new NoSuchElementException();
        }
    }

    public List<Order> orderList(){
        List <Order> oList = new ArrayList<>();
        for (Order orders: orderMap.values()) {
            oList.add(orders);
        }
        return oList;
    }

    public Map<String, Order> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<String, Order> orderMap) {
        this.orderMap = orderMap;
    }
}
