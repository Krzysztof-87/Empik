package Launch;

import Shop.*;
import User.User;
import User.UserController;
import User.UserService;

public class ConnectAllObjects {

    UserService userService =new UserService();
    UserController userController = new UserController(userService);
    CustomerBasket customerBasket = new CustomerBasket();
    StoreStock storeStock= new StoreStock();
    StoreStockControl storeStockControl=new StoreStockControl(storeStock);
    BrowseProducts browseProducts= new BrowseProducts(storeStock);
    ShopController shopController= new ShopController(userService, userController, customerBasket, storeStock, browseProducts, storeStockControl);


    public void run(){
        shopController.run();
    }



}
