package Products;

import java.time.LocalDate;

public class CD extends Product {

    private int productionYear;

    public CD(int id, String name, double price, int productionYear) {
        super(id, name, price);
        this.productionYear = Math.max(productionYear, 1982);

    }

    public int getProductionYear() {
        return productionYear;
    }

    public void calculateCdDiscount(Product product) {
        int year= LocalDate.now().getYear();
        float cdAge=year- ((CD) product).getProductionYear();
        product.setPriceAfterDiscount(product.getPrice()*(1-(cdAge/100)));
    }

    @Override
    public String toString() {
        return super.toString()+"production year: "+productionYear;
    }

}


