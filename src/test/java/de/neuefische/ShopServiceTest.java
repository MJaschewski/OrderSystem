package de.neuefische;

import de.neuefische.model.Product;
import de.neuefische.repository.ProductRepo;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {
    @Test
    void ShopService_created_with_productRepo_empty_OrderRepo(){
        Map<String, Product> productMap = new HashMap<>();
        Product Lappy = new Product("Laptop","1001",1500.00);
        Product Mouse = new Product("Mouse","1002",30.00);
        Product Keyboard = new Product("Keyboard","1003",50.00);

        ProductRepo newProducts = new ProductRepo(productMap);
    }

}