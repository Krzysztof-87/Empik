package Products;

public class Book extends Product {

    private int numberOfPages;

    public Book(int id, String name, double price, int numberOfPages) {
        super(id, name, price);
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void calculateBookDiscount(Product product) {
        if (((Book) product).getNumberOfPages()>=100&&((Book) product).getNumberOfPages()<200){
            product.setPriceAfterDiscount(product.getPrice()*0.9);
        }else if (((Book) product).getNumberOfPages()>=200&&((Book) product).getNumberOfPages()<299){
            product.setPriceAfterDiscount(product.getPrice()*0.8);
        }else if (((Book) product).getNumberOfPages()>=300&&((Book) product).getNumberOfPages()<399){
            product.setPriceAfterDiscount(product.getPrice()*0.7);
        }else if (((Book) product).getNumberOfPages()>=400){
            product.setPriceAfterDiscount(product.getPrice()*0.6);
        }
    }

    @Override
    public String toString() {
        return super.toString()+
                "number of pages: " + numberOfPages;
    }
}
