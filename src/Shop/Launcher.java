package Shop;

import Products.*;

import java.util.Objects;

public class Launcher {

    public static void main(String[] args) {

        StoreStock storeStock = new StoreStock();

        CustomerBasket customerBasket = new CustomerBasket();

        double totalPrice=customerBasket.totalPriceBeforeAllDiscounts();


        storeStock.printListOfAvailableProducts();
        System.out.println(" -------");

        storeStock.sortByPrize(SortType.ASC);


        customerBasket.calculateDiscountPrices();
        double price=customerBasket.calculateTotalPriceAfterAllDiscount();
        System.out.println("       ");

        customerBasket.printReceipt();






    }
}
