package Products;
/*
Każdy przedmiot posiada identyfikator, nazwę oraz cenę; dodatkowo:
 */

import java.util.Objects;

public class Product implements Comparable<Product> {

    private int id;
    private String name;
    private double price;
    private double priceAfterDiscount;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.priceAfterDiscount=price;
    }

    public double getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setPriceAfterDiscount(double priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



    @Override
    public String toString() {
        String temp=String.format("%-5d|  %-31s| %-10.2f| %-23.2f| ",id, name, price,priceAfterDiscount);
        return temp;
    }


    @Override
    public int compareTo(Product product) {
        int compareByName=name.compareTo(product.getName());
        if (id>product.getId()){
            return 1;
        }else if(id<product.getId()){
            return -1;
        }else if (price>product.getPrice()){
            return 1;
        }else if (price<product.getPrice())
            return -1;
        else return compareByName;

    }
}
