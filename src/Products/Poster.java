package Products;

import java.util.List;

public class Poster extends Product {

    private int quantityOFPostersInBasket;
    private double minPosterPrice=Double.MAX_VALUE;

    public int getQuantityOFPostersInBasket() {
        return quantityOFPostersInBasket;
    }

    public Poster(int id, String name, double price) {
        super(id, name, price);
    }

    public void calculatePosterDiscount(List<Product>copyOfCustomerBasket) {
        quantityOFPostersInsideBasket(copyOfCustomerBasket);
        if (quantityOFPostersInBasket>=3){
                findSmalestPosterPrice(copyOfCustomerBasket);
          setTheSmalestPosterPriceFor1(copyOfCustomerBasket);
        }
    }

    private void findSmalestPosterPrice(List<Product>copyOfCustomerBasket) {
        for (Product product1 : copyOfCustomerBasket) {
            if (product1 instanceof Poster){
                if (product1.getPrice()<minPosterPrice){
                    minPosterPrice=product1.getPrice();
                }
            }
        }
    }
    private void quantityOFPostersInsideBasket(List<Product>copyOfCustomerBasket){
        for (Product product : copyOfCustomerBasket) {
            if (product instanceof Poster){
                quantityOFPostersInBasket++;
            }
        }
    }

    private void setTheSmalestPosterPriceFor1(List<Product>copyOfCustomerBasket) {
        for (Product product1 : copyOfCustomerBasket) {
            if (product1.getPrice()==minPosterPrice){
                product1.setPriceAfterDiscount(1);
            }
        }
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
