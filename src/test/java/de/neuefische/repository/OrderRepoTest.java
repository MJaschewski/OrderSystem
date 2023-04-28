package de.neuefische.repository;

import de.neuefische.model.Order;
import de.neuefische.model.Product;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    @Test
    void getOrder_returns_Order_when_found(){
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        Order newOrder = new Order("1234", new HashMap<String, Product>());
        Order adding = testOrderRepo.addOrder(newOrder);

        //When
        Order actual = testOrderRepo.getOrder(newOrder.getOrderID());

        //Then
        assertEquals(adding,actual);
    }
    @Test
    void addOrder_returns_Order(){
        //Given
        OrderRepo testOrderRepo = new OrderRepo();
        Order newOrder = new Order("1234", new HashMap<String, Product>());

        //When
        Order actual = testOrderRepo.addOrder(newOrder);

        //Then
        assertEquals(newOrder,actual);
    }
}