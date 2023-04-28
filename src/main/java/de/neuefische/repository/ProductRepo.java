package de.neuefische.repository;

import de.neuefische.model.NoValidProductToOrderException;
import de.neuefische.model.Product;

import java.util.*;

public class ProductRepo {
    private Map<String,Product> productMap = new HashMap<>();

    public ProductRepo() {
    }

    public ProductRepo(Map<String, Product> productMap) {
        this.productMap = productMap;
    }

    public Product addProduct(Product product){
        this.productMap.put(product.getProductID(),product);
        return productMap.get(product.getProductID());
    }

    public Product getProduct(String productID) throws NoValidProductToOrderException{
        if(productMap.containsKey(productID)){
            return productMap.get(productID);
        }
        else {
            throw new NoValidProductToOrderException("False order. Product with ID: " + productID + " can't be ordered. Not in ProductRepository");
        }
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public List<Product> getProductList(){
        List <Product> pList = new ArrayList<>();
        for (Product products: productMap.values()) {
            pList.add(products);
        }
        return pList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(productMap, that.productMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productMap);
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "productMap=" + productMap +
                '}';
    }
}
