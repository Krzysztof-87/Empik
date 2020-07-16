package Shop;

import Products.*;

import java.util.ArrayList;
import java.util.List;

public class CustomerBasket {

    private List<Product>basket= new ArrayList<>();
    private double totalPricesAfterAllDiscount=0;
    private StoreStock storeStock;


    /*
Product ambient = new CD(11, "Ambient", 300, 1999);
    Product jazz = new CD(23, "Jazz Cafe", 230, 2017);
    Product movie = new DVD(17, "Scary Movie", 414, 2001);
    Product movie2 = new DVD(9, "This Movie", 140, 2005);
    Product mug = new Mug(99, "The best one", 33);
    Product book1 = new Book(22, "Head First Java", 77, 670);
    Product book2 = new Book(127, "Java For Testers", 122, 340);
    Product book3 = new Book(34,"The brief History of Humankind",111, 288);
    Product poster = new Poster(174, "New Poster", 17);
    Product poster1 = new Poster(141, "Java poster", 14);
    Product poster2 = new Poster(342, "How to get This", 22);
    Product game = new Game(179, "FirstGame", 190, "SameProducer");
    Product game1 = new Game(222, "Second Game", 220, "SameProducer");
    Product game2 = new Game(333, "Third Game", 400, "SameProducer");
 */
    public CustomerBasket() {
        basket.add(new CD(11, "Ambient", 300, 1999));
        basket.add(new CD(23, "Jazz Cafe", 230, 2017));
        basket.add(new DVD(17, "Scary Movie", 414, 2001));
        basket.add(new DVD(9, "This Movie", 140, 2005));
        basket.add(new Mug(99, "The best one", 33));
        basket.add(new Book(22, "Head First Java", 77, 670));
        basket.add(new Book(127, "Java For Testers", 122, 340));
        basket.add(new Book(34,"The brief History of Humankind",111, 288));
        basket.add(new Poster(174, "New Poster", 17));
        basket.add(new Poster(141, "Java poster", 14));
        basket.add(new Poster(342, "How to get This", 22));
        basket.add(new Game(179, "FirstGame", 190, "SameProducer"));
        basket.add(new Game(222, "Second Game", 220, "SameProducer"));
        basket.add(new Game(333, "Third Game", 400, "SameProducer"));



    }

    public List<Product> getBasket() {
        return basket;
    }


    public void addProductToBasket(Product p) {
        basket.add(p);
        //calculateDiscountPrices();

    }
    public void removeProductFromBasket(Product product){
        basket.remove(product);
    }

    public void PrintAllItemsInsideBasket(){
        System.out.println("id   |           name                  | price     | price after discount   | additional information        ");
        for (Product product : basket) {
            System.out.println(product);
        }
    }

    public void printReceipt(){
        System.out.println("id   |           name                  | price     | price after discount   | additional information        ");
        for (Product product : basket) {
            System.out.println(product);
        }
        System.out.println("Price before discount:"+ totalPriceBeforeAllDiscounts()+"Price after discount: "+calculateTotalPriceAfterAllDiscount());
        System.out.println("Total discount sum is: "+(totalPriceBeforeAllDiscounts()-calculateTotalPriceAfterAllDiscount()));
        System.out.println("List of product you saved on today: ");
        listOfProductYouSavedOnToday();
    }


    private void listOfProductYouSavedOnToday(){
        System.out.println("id   |           name                  | price     | price after discount   | additional information        ");
        for (Product product : basket) {
            if (product.getPrice()!=product.getPriceAfterDiscount()){
                System.out.println(product);
            }
        }

    }

    public double totalPriceBeforeAllDiscounts(){
        double totalPrice=0;
        for (Product product : basket) {
            totalPrice+=product.getPrice();
        }
        return totalPrice;
    }

    public void calculateDiscountPrices(){
        for (int i=0; i<basket.size();i++) {
            if (basket.get(i) instanceof CD) {
                ((CD) basket.get(i)).calculateCdDiscount(basket.get(i));

            } else if (basket.get(i) instanceof DVD) {
                ((DVD) basket.get(i)).calculateDvdDiscount(basket.get(i));

            } else if (basket.get(i) instanceof Book) {
                ((Book) basket.get(i)).calculateBookDiscount(basket.get(i));
            } else if (basket.get(i) instanceof Poster) {
                ((Poster) basket.get(i)).calculatePosterDiscount(basket);

            } else if (basket.get(i) instanceof Mug) {
                addProductToBasket(new Newspaper(122, "Marketing Materials", 0));

            } else if (basket.get(i) instanceof Game) {
                ((Game) basket.get(i)).calculateGameDiscount(basket);

            }

        }
    }

    public double calculateTotalPriceAfterAllDiscount(){  // postaraj sie zrobic to ladniej
        double totalPriceBeforeAllDiscounts =totalPriceBeforeAllDiscounts();
        int reminderAfterDivideBy100= (int) (totalPricesAfterAllDiscount%100);
        int totalPriceDivideBy100= (int) (totalPriceBeforeAllDiscounts/100);
        double calculatedDiscountForEvery100zlSpent= (totalPriceDivideBy100*100)*0.95+reminderAfterDivideBy100;
        for (Product product : basket) {
            if (!(product.getPrice()==product.getPriceAfterDiscount())){
                calculatedDiscountForEvery100zlSpent-=product.getPrice()-product.getPriceAfterDiscount();
            }
        }
        return calculatedDiscountForEvery100zlSpent;
    }




}
