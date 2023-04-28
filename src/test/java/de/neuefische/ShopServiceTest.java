package de.neuefische;

import de.neuefische.model.NoValidProductToOrderException;
import de.neuefische.model.Order;
import de.neuefische.model.Product;
import de.neuefische.repository.ProductRepo;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void Shop_Service_addOrder_returns_empty_Order_invalid_OrderProductList() {
        //Given
        Map<String, Product> productMap = new HashMap<>();
        ProductRepo newProducts = new ProductRepo(productMap);

        ShopService newService = new ShopService(newProducts);


        Map<String, Product> orderMap = new HashMap<>();
        Product Lappy = new Product("Laptop","1001",1500.00);
        Product Mouse = new Product("Mouse","1002",30.00);
        Product Keyboard = new Product("Keyboard","1003",50.00);
        orderMap.put(Lappy.getProductID(), Lappy);
        orderMap.put(Mouse.getProductID(), Mouse);
        orderMap.put(Keyboard.getProductID(), Keyboard);

        Order newOrder = new Order("1235",orderMap);


        //Then
        try{newService.addOrder(newOrder);} catch (NoValidProductToOrderException e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    void ShopService_listOrders_returns_String_of_Orders(){
        //Given
        Map<String, Product> productMap = new HashMap<>();
        Product Lappy = new Product("Laptop","1001",1500.00);
        productMap.put(Lappy.getProductID(), Lappy);
        ProductRepo newProducts = new ProductRepo(productMap);
        ShopService newService = new ShopService(newProducts);
        Order newOrder2 = new Order("Order2",productMap);
        try{newService.addOrder(newOrder2);} catch (NoValidProductToOrderException e){
            System.out.println(e.getMessage());
        }

        String expected = "Order{orderID='Order2', orderMap={1001=Product{name='Laptop', productID='1001', price=1500.0}}}\n";
        //When
        String actual = newService.listOrders();
        //Then
        assertEquals(expected,actual);

    }

    @Test
    void ShopService_listOrders_returns_Empty_String_for_noOrders(){
        //Given
        Map<String, Product> productMap = new HashMap<>();
        ProductRepo newProducts = new ProductRepo(productMap);
        ShopService newService = new ShopService(newProducts);
        //When
        String actual = newService.listOrders();

        //Then
        assertEquals("", actual);

    }

    @Test
    void ShopService_getOrder_returns_empty_Order_for_no_match(){
        //Given
        Map<String, Product> productMap = new HashMap<>();
        ProductRepo newProducts = new ProductRepo(productMap);
        ShopService newService = new ShopService(newProducts);

        Order expected = new Order();

        //When
        Order actual = newService.getOrder("asdf");

        //Then
        assertEquals(expected,actual);

    }
    @Test
    void ShopService_getOrder_returns_Order(){
        //Given
        Map<String, Product> productMap = new HashMap<>();
        Product Lappy = new Product("Laptop","1001",1500.00);
        productMap.put(Lappy.getProductID(), Lappy);
        ProductRepo newProducts = new ProductRepo(productMap);
        ShopService newService = new ShopService(newProducts);

        Order newOrder = new Order("testOrder",productMap);

        try{newService.addOrder(newOrder);} catch (NoValidProductToOrderException e) {
            System.out.println(e.getMessage());
        }
            //When
        Order actual = newService.getOrder(newOrder.getOrderID());

        //Then
        assertEquals(newOrder,actual);

    }

    @Test
    void ShopService_addOrder_returns_Order(){
        //Given
        Map<String, Product> productMap = new HashMap<>();
        Product Lappy = new Product("Laptop","1001",1500.00);
        productMap.put(Lappy.getProductID(), Lappy);
        ProductRepo newProducts = new ProductRepo(productMap);
        ShopService newService = new ShopService(newProducts);

        Order newOrder = new Order("testOrder",productMap);

        //When
        Order actual = new Order();
        try{actual = newService.addOrder(newOrder);
        } catch (NoValidProductToOrderException e) {
            System.out.println(e.getMessage());
        }

        //Then
       assertEquals(newOrder,actual);

    }
    @Test
    void ShopService_listProducts_returns_Empty_for_no_Product_repo(){
        //Given
        ProductRepo emptyProducts = new ProductRepo();
        ShopService newService = new ShopService(emptyProducts);
        String expect = "";

        //When & Then
        assertTrue(newService.listProducts().equals(expect));

    }

    @Test
    void ShopService_listProducts_returns_String_with_Products(){
        //Given
        Map<String, Product> productMap = new HashMap<>();
        Product Lappy = new Product("Laptop","1001",1500.00);
        Product Mouse = new Product("Mouse","1002",30.00);
        Product Keyboard = new Product("Keyboard","1003",50.00);
        productMap.put(Lappy.getProductID(), Lappy);
        productMap.put(Mouse.getProductID(), Mouse);
        productMap.put(Keyboard.getProductID(), Keyboard);

        ProductRepo newProducts = new ProductRepo(productMap);
        String expect = "Name: Keyboard ID: 1003\n" +"Name: Mouse ID: 1002\n" +"Name: Laptop ID: 1001\n";

        //When
        ShopService newService = new ShopService(newProducts);

        //Then
        assertTrue(newService.listProducts().equals(expect));

    }
    @Test
    void ShopService_getProduct_returns_Empty_Product_Id_no_match(){
        //Given
        Map<String, Product> productMap = new HashMap<>();
        Product Lappy = new Product("Laptop","1001",1500.00);
        productMap.put(Lappy.getProductID(), Lappy);
        ProductRepo newProducts = new ProductRepo(productMap);
        ShopService newService = new ShopService(newProducts);

        Product expected = new Product();

        //When
        Product actual = newService.getProduct("testFalse");

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void ShopService_getProduct_returns_Product_right_Id(){
        //Given
        Map<String, Product> productMap = new HashMap<>();
        Product Lappy = new Product("Laptop","1001",1500.00);
        productMap.put(Lappy.getProductID(), Lappy);
        ProductRepo newProducts = new ProductRepo(productMap);
        ShopService newService = new ShopService(newProducts);

        //When
        Product actual = newService.getProduct(Lappy.getProductID());

        //Then
        assertEquals(Lappy,actual);
    }


}