package Products;

import java.time.LocalDate;

public class DVD extends Product {

    private int productionYear;

    public DVD(int id, String name, double price, int productionYear) {
        super(id, name, price);
        this.productionYear = Math.max(productionYear, 1995);

    }

    public int getProductionYear() {
        return productionYear;
    }

    public void calculateDvdDiscount(Product product) {
        int year= LocalDate.now().getYear();
        float dvdAge=year- ((DVD) product).getProductionYear();
        product.setPriceAfterDiscount(product.getPrice()*(1-(dvdAge/100)));
    }

    @Override
    public String toString() {
        return super.toString()+"production year: "+productionYear;
    }
}
