package Shop;

import Products.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StoreStockControl {

    Scanner input = new Scanner(System.in);
    private StoreStock storeStock;
    private String name;
    private int id;
    private double price;
    private int numberOfPages;
    private int productionYear;
    private String producerName;
    int option=0;


    public StoreStockControl(StoreStock storeStock) {
        this.storeStock = storeStock;
    }

    public void storeStockControl(){
        do {
            printOption();
            option = option();
            try {
                validateOption(option);
            }catch (ShopException e){
                System.out.println(e.getMessage());
            }
        }while (option!=6);
    }

    private void printOption() {
        System.out.println("1-add product to store");
        System.out.println("2- remove product from store");
        System.out.println("3-edit product price");
        System.out.println("4-edit product name");
        System.out.println("5-print all products in store");
        System.out.println("6-exit from shop edition panel");
    }

    private int option() {
        try {
            return option = input.nextInt();
        }catch (InputMismatchException e){
            System.err.println("You've entered wrong data");
        }
        return 0;
    }

    private void validateOption(int option) throws ShopException {
        switch (option){
            case 1:
                addProductToStore();
                break;
            case 2:
                removeProductFromStore();
                break;
            case 3:
                editProductPrice();
                break;
            case 4:
                editProductName();
                break;
            case 5:
                printProductsList();
                break;
            case 6:
                break;
            default:
                System.out.println("Option doesn't exist");

        }
    }

    private void printProductsList() {
        storeStock.printListOfAvailableProducts();
    }

    private void addProductToStore() {
        try {
            printProductOptions();
            int option = input.nextInt();
            input.nextLine();
            System.out.println("Give product id:");
            id = input.nextInt();
            input.nextLine();
            System.out.println("Give product name:");
            name = input.nextLine();
            System.out.println("Give product price:");
            price = input.nextInt();
            input.nextLine();
            Product product = confirmOption(option);
            storeStock.addNewProduct(product);
        } catch (InputMismatchException e) {

            System.err.println("You've entered wrong type of data");
        }
    }


    private void printProductOptions() {
        System.out.println("1_add Book");
        System.out.println(("2-add CD"));
        System.out.println("3-add DVD");
        System.out.println("4-add Game");
        System.out.println("5-add Mug");
        System.out.println("6-add Newspaper");
        System.out.println("7-add Poster");
        System.out.println("8-add Vinyl");
    }

    private Product confirmOption(int option) {
        switch(option){
            case 1:
                 return addBook();
            case 2:
                 return addCd();
            case 3:
               return addDvd();
            case 4:
                 return addGame();
            case 5:
                return new Mug(id, name, price);
            case 6:
                return new Newspaper(id, name,price );
            case 7:
                return new Poster(id, name,price );
            case 8:
                return new Vinyl(id, name, price);
            default:
                System.out.println("Product category doesn't exist");
        }
        return null;
    }


    private Product addBook() {
        System.out.println("Give number of pages:");
        numberOfPages=input.nextInt();
        input.nextLine();
        return new Book(id, name, price, numberOfPages);
    }

    private Product addCd() {
        System.out.println("Give production year:");
        productionYear=input.nextInt();
        input.nextLine();
        return new CD(id, name, price, productionYear);
    }
    private Product addDvd() {
        System.out.println("Give production year:");
        productionYear=input.nextInt();
        input.nextLine();
        return new DVD(id, name, price, productionYear);
    }

    private Game addGame() {
        System.out.println("Give game producer:");
        producerName=input.nextLine();
        return new Game(id, name, price, producerName);
    }



    private void removeProductFromStore() throws ShopException {
        List<Product> products=new ArrayList<>(storeStock.getProductList());
        System.out.println("Give product id:");
        int id=0;
        try {
            id = input.nextInt();
        }catch (InputMismatchException e){
            System.err.println("You've entered wrong type of data");
        }
        input.nextLine();
        for (Product product1 : products) {
            if (product1.getId() == id) {
                storeStock.removeProduct(product1);
                return;
            }
        }
        throw new ShopException("Product doesn't exist");
    }

    private void editProductPrice() throws ShopException {
        ArrayList<Product>copyOfProducts=new ArrayList<>(storeStock.getProductList());
        try {
            System.out.println("Give product id:");
            id = input.nextInt();
            input.nextLine();
            System.out.println("Give new product price:");
            price = input.nextDouble();
            input.nextLine();
            for (Product copyOfProduct : copyOfProducts) {
                if (copyOfProduct.getId()==id){
                    storeStock.editProductPrice(copyOfProduct, price);
                    return;
                }
            }
            throw new  ShopException("Product doesn't exist");
        }catch (InputMismatchException e){
            System.err.println("You've entered wrong type of data");
        }
    }

    private void editProductName() throws ShopException {
        ArrayList<Product>copyOfProducts=new ArrayList<>(storeStock.getProductList());
        try {
            System.out.println("Give product id:");
            id = input.nextInt();
            input.nextLine();
            System.out.println("Give new product name:");
            name = input.nextLine();
            for (Product copyOfProduct : copyOfProducts) {
                if (copyOfProduct.getId()==id){
                    storeStock.editProductName(copyOfProduct, name);
                }
            }

        }catch (InputMismatchException e){
            System.err.println("You've entered wrong type of data");
        }
    }

}
