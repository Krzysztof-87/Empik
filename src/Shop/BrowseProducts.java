package Shop;

import Products.SortType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BrowseProducts {

    Scanner input = new Scanner(System.in);
    private StoreStock storeStock;
    String option="";

    public BrowseProducts(StoreStock storeStock) {
        this.storeStock = storeStock;
    }

    public void browseProducts(){
        printOptions();
        option=option();
        validateOption(option);

    }

    private void printOptions(){
        System.out.println("P-Show products");
        System.out.println("N-List of products sorted by natural order");
        System.out.println("A-List of products sorted ascending");
        System.out.println("D-List of products sorted descending");
    }

    private String option() {
        try {
            return input.nextLine();
        }catch (InputMismatchException e){
            System.out.println("You've entered wrong type of data");
        }
        return null;
    }

    private void validateOption(String option) {
        switch (option){
            case "P":
                storeStock.printListOfAvailableProducts();
                break;
            case "N":
                storeStock.sortByNaturalOrder();
                break;
            case "A":
                storeStock.sortByPrize(SortType.ASC);
                break;
            case "D":
                storeStock.sortByPrize(SortType.DESC);
                break;
            default:
                System.out.println("option doesn't exist");
        }

    }
}
