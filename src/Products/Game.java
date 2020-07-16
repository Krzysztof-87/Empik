package Products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game extends Product {

    private String producerName;
    private int numberOfSameProducerGamesInBasket;
    private String producerWithTheLargestNUmberOfGamesInsideBasket;
    private double cheapestGamePrice;
    private Map<String, Integer> checkIfMoreThan3GamesOfSameProducerInABasket=new HashMap<>();

    public Game(int id, String name, double price, String producerName) {
        super(id, name, price);
        this.producerName = producerName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void calculateGameDiscount(List<Product>copyOfCustomerBasket) {
        calculateMaximumQuantityOFOneProducerGameInsideBasket(copyOfCustomerBasket);
        if (numberOfSameProducerGamesInBasket>=3){
            cheapestGamePrice=Double.MAX_VALUE;
            findCheapestGamePrice(copyOfCustomerBasket);
            setTheCheapestGamePriceTo0(copyOfCustomerBasket);

        }
    }

    private void calculateMaximumQuantityOFOneProducerGameInsideBasket(List<Product>copyOfCustomerBasket) {
        for (int i=0; i<copyOfCustomerBasket.size();i++) {
            if (copyOfCustomerBasket.get(i) instanceof Game) {
                String gameProducer = ((Game) copyOfCustomerBasket.get(i)).getProducerName();
                if (checkIfMoreThan3GamesOfSameProducerInABasket.get(gameProducer) == null) {
                    checkIfMoreThan3GamesOfSameProducerInABasket.put(gameProducer, 1);
                } else {
                    checkIfMoreThan3GamesOfSameProducerInABasket.put(gameProducer, checkIfMoreThan3GamesOfSameProducerInABasket.get(gameProducer) + 1);
                }
            }
        }
      findProducerWithTheBiggestNumberOfGamesInsideBasket();
    }


    private void findProducerWithTheBiggestNumberOfGamesInsideBasket() {
        numberOfSameProducerGamesInBasket=0;
        producerWithTheLargestNUmberOfGamesInsideBasket="";
        for (Map.Entry<String, Integer> entry:checkIfMoreThan3GamesOfSameProducerInABasket.entrySet()){
            if (numberOfSameProducerGamesInBasket<entry.getValue()){
                numberOfSameProducerGamesInBasket=entry.getValue();
                producerWithTheLargestNUmberOfGamesInsideBasket=entry.getKey();
            }
        }

    }

    private void findCheapestGamePrice(List<Product>copyOfCustomerBasket) {
        for (Product product1 : copyOfCustomerBasket) {
            if (product1 instanceof Game) {
                if (((Game) product1).getProducerName().equals(producerWithTheLargestNUmberOfGamesInsideBasket)) {
                    if (product1.getPrice() < cheapestGamePrice) {
                        cheapestGamePrice = product1.getPrice();
                    }
                }
            }
        }
    }

    private void setTheCheapestGamePriceTo0(List<Product>copyOfCustomerBasket) {
        for (Product product1 : copyOfCustomerBasket) {
            if (product1.getPrice()==cheapestGamePrice){
                product1.setPriceAfterDiscount(0);
            }
        }
    }


    @Override
    public String toString() {
        return super.toString() + "producer name: "+producerName;
    }
}
