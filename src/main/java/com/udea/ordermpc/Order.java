package com.udea.ordermpc;

public class Order {
    private int id;
    private String product;
    private Double price;

    public Order(int id, String product, Double price) {
        this.id = id;
        this.product = product;
        this.price = price;
    }
    public Order() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
