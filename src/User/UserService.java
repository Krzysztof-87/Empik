package User;

import java.util.HashMap;
import java.util.Map;

public class UserService {


    private Map<String, User> users= new HashMap<>();

    public void addUser(User user){
        users.put(user.getEmail(), user);

    }

    public boolean doesContainUserWithEmail(String email){
        return users.containsKey(email);
    }

    public User getUserWithEmail(String email){
        return users.get(email);
    }
}
