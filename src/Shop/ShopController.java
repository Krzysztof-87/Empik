package Shop;

import Products.Product;
import User.User;
import User.UserController;
import User.UserService;
import User.UserType;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ShopController {

    private UserService userService;
    private UserController userController;
    private CustomerBasket customerBasket;
    private StoreStock storeStock;
    private BrowseProducts browseProducts;
    private StoreStockControl storeStockControl;
    Scanner input = new Scanner(System.in);
    int option = 10;
    User user = new User();

    public ShopController(UserService userService, UserController userController, CustomerBasket customerBasket, StoreStock storeStock,
                          BrowseProducts browseProducts, StoreStockControl storeStockControl) {
        this.userService = userService;
        this.userController = userController;
        this.customerBasket = customerBasket;
        this.storeStock = storeStock;
        ;
        this.browseProducts = browseProducts;
        this.storeStockControl = storeStockControl;
    }

    public void run() {
        welcomeMessage();
        do {
            printOptions();
            option();
            try {
                validateOption(option);
            } catch (ShopException e) {
                System.err.println(e.getMessage());
            }

        } while (option != 0);

    }

    private void welcomeMessage() {
        System.out.println("Welcome in Empik online store");
    }

    private void printOptions() {
        if (!user.isLogin()) {

            System.out.println("1_Create new account");
            System.out.println("2-Login into your account");
        }
        System.out.println("3-Browse Products");
        System.out.println("4-add product into you basket");
        System.out.println("5-remove product from basket");
        System.out.println("6-check products inside basket");
        if (user.isLogin()){
            System.out.println("7-confirm Transaction");
            System.out.println("8-go to User Settings");
            if (user.getUserType()== UserType.Admin){
                System.out.println("9-shop edition");
            }
            System.out.println("10-log out");
        }
        System.out.println("0-exit");

    }

    private void option(){
        try {
            option = input.nextInt();
            input.nextLine();
        }catch (InputMismatchException e){
            System.err.println("You've entered wrong type of data");

        }

    }
    private void validateOption(int option) throws ShopException {
        switch (option){
            case 1:
                createNewAccount();
                break;
            case 2:
                loginIntoYourAccount();
                break;
            case 3:
                browseProducts.browseProducts();
                break;
            case 4:
                addProductToYourBasket();
                break;
            case 5:
                removeProductFromBasket();
                break;
            case 6:
                customerBasket.printAllItemsInsideBasket();
                break;
            case 7:
                customerBasket.confirmTransaction();
                break;
            case 8:
                userController.userPanel(user);
                break;
            case 9:
                storeStockControl.storeStockControl();
                break;
            case 10:
                logOut();
                break;
            case 0:
                endMessage();
                break;
            default:
                System.out.println("option doesn't exist");

        }
    }


    private void createNewAccount() throws ShopException {
        String name = null;
        String email = null;
        String password = null;
        try {
            System.out.println("Give your name:");
            name = input.nextLine();
            System.out.println("Give your email address:");
            email = input.nextLine();
            System.out.println("Give your password:");
            password = input.nextLine();
        }catch (InputMismatchException e){
            System.out.println("You've entered wrong type of data");
        }
            User user = new User(name, email, password, UserType.Client);
            userService.createNewAccount(user);
    }

    private User loginIntoYourAccount() throws ShopException {
        String email=null;
        String password=null;
        try {
            System.out.println("Give your email address:");
            email = input.nextLine();
            System.out.println("Give your password:");
            password = input.nextLine();
        }catch (InputMismatchException e){
            System.out.println("You've entered wrong type of data");
        }
            user = userService.loginToYourAccount(email, password);

        return user;
    }

    private void addProductToYourBasket() throws ShopException {
        List<Product> products = new ArrayList<>(storeStock.getProductList());
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
                customerBasket.addProductToBasket(product1);
                return;
            }
        }


        throw new ShopException("Product doesn't exist, pls choose another product");
    }

    private void removeProductFromBasket() throws ShopException {
        List<Product>products=new ArrayList<>(customerBasket.getBasket());
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
                    customerBasket.removeProductFromBasket(product1);
                    return;
                }
            }

        throw new ShopException("Product with provided id doesn't appear inside basket");
    }

    private void logOut() {
        user.setLogin(false);
    }

    private void endMessage() {
        System.out.println("Thank you for visiting our store, see you soon");
    }

}
