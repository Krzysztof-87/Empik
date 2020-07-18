package User;

import Shop.ShopException;

import java.util.Scanner;
public class UserController {

    Scanner input = new Scanner(System.in);
    private UserService userService;
    int option =0;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void userPanel(User user){
        welcomeInUserPanel(user);

        do {
            printOption(user);
            option=choice();
            try {
                validateOptions(option);
            }catch (ShopException e){
                System.err.println(e.getMessage());
            }
        }while(option!=6);
    }

    private void welcomeInUserPanel(User user){
        System.out.println("Welcome "+user.getName()+" How is your day going?");
    }

    private void printOption(User user){
            System.out.println("1-change your password");
            System.out.println("2-Change your email");
            System.out.println("3-change your name");
            System.out.println("4-delete account");
        if (user.getUserType()==UserType.Admin){
            System.out.println("5-Print all users");
        }
        System.out.println("6-exit user panel");

    }

    private int choice(){
         int choice= input.nextInt();
         input.nextLine();
         return choice;
    }

    private void validateOptions(int option) throws ShopException {
        switch (option){
            case 1:
                changePassword();
                break;
            case 2:
                changeYourEmail();
                break;
            case 3:
                changeYourName();
                break;
            case 4:
                deleteYourAccount();
                break;
            case 5:
                userService.printAllUsers();
                break;
            case 6:
                System.out.println("You are leaving user edit");
                break;
            default:
                System.out.println("Option doesn't exist, try again");
        }

    }

    private void changePassword() throws ShopException {
            System.out.println("Give your email address:");
            String email = input.nextLine();
            System.out.println("Give your current password");
            String oldPassword = input.nextLine();
            System.out.println("Give new Password");
            String passwordNew = input.nextLine();
            userService.changeUserPassword(email, oldPassword, passwordNew);


    }
    private void changeYourEmail() throws ShopException {
            System.out.println("Give your current email address");
            String email = input.nextLine();
            System.out.println("Give your new email address");
            String emailNew = input.nextLine();
        userService.changeEmailAddress(email, emailNew);

    }

    private void changeYourName() throws ShopException {
            System.out.println("Give your email");
            String email = input.nextLine();
            System.out.println("Give your new name");
            String name = input.nextLine();

        userService.changeUserName(email, name);
    }

    private void deleteYourAccount() throws ShopException {
            System.out.println("Give your email");
            String email = input.nextLine();
            userService.deleteAccount(email);
            option=6;
    }

}
