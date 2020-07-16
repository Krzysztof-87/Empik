package Shop;

import Products.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StoreStock {

    private List<Product> productList = new ArrayList<>();

    public StoreStock() {
        productList.add(new CD(11, "Ambient", 300, 1999));
        productList.add(new CD(23, "Jazz Cafe", 230, 2017));
        productList.add(new DVD(17, "Scary Movie", 414, 2001));
        productList.add(new DVD(9, "This Movie", 140, 2005));
        productList.add(new Mug(99, "The best one", 33));
        productList.add(new Book(22, "Head First Java", 77, 670));
        productList.add(new Book(127, "Java For Testers", 122, 340));
        productList.add(new Book(34,"The brief History of Humankind",111, 288));
        productList.add(new Poster(174, "New Poster", 17));
        productList.add(new Poster(141, "Java poster", 14));
        productList.add(new Poster(342, "How to get This", 22));
        productList.add(new Game(179, "FirstGame", 190, "SameProducer"));
        productList.add(new Game(222, "Second Game", 220, "SameProducer"));
        productList.add(new Game(333, "Third Game", 400, "SameProducer"));

    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addNewProduct(Product product){
        productList.add(product);
    }

    public void removeProduct(Product product){
        productList.remove(product);
    }


    public void printListOfAvailableProducts(){
        System.out.println("id   |           name                  | price     | price after discount   | additional information        ");
        for (Product product : productList) {
            System.out.println(product);
        }

    }
    public void sortByNaturalOrder(){
        System.out.println("id   |           name                  | price     | price after discount   | additional information        ");
        Collections.sort(productList);
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void sortByPrize(SortType sortType){
        System.out.println("id   |           name                  | price     | price after discount   | additional information        ");
        List<Product>productSortedByPrize=compareByPrice(sortType);
        for (Product product : productSortedByPrize) {
            System.out.println(product);
        }

    }

    private List<Product> compareByPrice(SortType sortType) {
         List<Product>productsSortedByPrize=new ArrayList<>(productList);
        if (sortType == SortType.ASC) {
            sortByPriceAscending(productsSortedByPrize);
        }
        else if (sortType==SortType.DESC){
            sortByPriceDescending(productsSortedByPrize);
        }
        return productsSortedByPrize;
    }

    private void sortByPriceAscending(List<Product> productsSortedByPrize){
        productsSortedByPrize.sort(new Comparator<Product>() {
            @Override
            public int compare(Product product, Product product1) {
                return Double.compare(product.getPrice(), product1.getPrice());

            }
        });

    }

    private void sortByPriceDescending(List<Product> productsSortedByPrize){
        productsSortedByPrize.sort(new Comparator<Product>() {
            @Override
            public int compare(Product product, Product product1) {
                return -Double.compare(product.getPrice(), product1.getPrice());
            }
        });
    }




    /*
    wstaw sortowanie i opcje wydruku tylko z danej kategorii
     */

}
