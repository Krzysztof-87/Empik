package User;



import Shop.ShopException;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String, User> users = new HashMap<>();

    public UserService() {
        users.put("nowy.uzytkownik@gmail.com", new User("Karol", "nowy.uzytkownik@gmail.com", "1234", UserType.Client));
        users.put("adresAdmin@empik.pl", new User("Admin", "adresAdmin@empik.pl", "111", UserType.Admin));

    }

    public void createNewAccount(User user) throws ShopException {
        if (!users.containsKey(user.getEmail())) {
            users.put(user.getEmail(), user);
            return;
        }
        throw new ShopException(user.getEmail() + " already exist");

    }

    public void changeUserName(String email, String nameNew) throws ShopException {
        if (users.containsKey(email)) {
            users.get(email).setName(nameNew);
            return;
        }
        throw new ShopException("User doesn't exist");

    }

    public void changeEmailAddress(String email, String emailNew) throws ShopException {
        if (users.containsKey(email)) {
            users.get(email).setEmail(emailNew);
            return;
        }
        throw new ShopException("Wrong email");
    }

    public void changeUserPassword(String email, String currentPassword, String passwordNEw)  {
        try {

            if (users.get(email).getPassword().equals(currentPassword)) {
                users.get(email).setPassword(passwordNEw);
                return;
            }
        }catch (NullPointerException e){
            System.err.println("Email or password incorrect");
        }

    }

    public void deleteAccount(String email) throws ShopException {
       String keyEmail=getKey(email);
        if (users.containsKey(keyEmail)) {
            users.get(keyEmail).setLogin(false);
            users.remove(keyEmail);
            return;
        }throw new ShopException("Email doesn't exist");
    }

    private String getKey(String email) {
        String keyEmail = "";
        for (Map.Entry<String, User> stringUserEntry : users.entrySet()) {
            if (stringUserEntry.getValue().getEmail().equals(email)) {
                keyEmail = stringUserEntry.getKey();
            }
        }
        return keyEmail;
    }


    public User loginToYourAccount(String login, String password) throws ShopException {
            if (users.containsKey(login) && users.get(login).getPassword().equals(password)) {
                users.get(login).setLogin(true);
                return users.get(login);
            }throw new ShopException("User doesn't exist");

    }

    public void printAllUsers(){
        for (Map.Entry<String, User> stringUserEntry : users.entrySet()) {
            System.out.println(stringUserEntry);
        }
    }
}
