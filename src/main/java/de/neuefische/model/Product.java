package de.neuefische.model;

import java.util.Objects;

public class Product {

    private String name;

    private String productID;

    private double price;
    public Product() {
    }

    public Product(String name, String productID, double price) {
        this.name = name;
        this.productID = productID;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productID='" + productID + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(productID, product.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, productID, price);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
}
