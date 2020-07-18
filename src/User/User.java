package User;

import java.util.Objects;
import java.util.Scanner;


public class User {

        private String name;
        private String email;
        private String password;
        private UserType userType;
        private boolean login;

    public User(String name, String email, String password, UserType userType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.login = false;
    }

    public User() {
    }



    public UserType getUserType() {
        return userType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public boolean isLogin() {
        return login;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
        public String toString() {
            String temp = String.format(": %-20s |: %-20s|: %-10s\n", name,email,login);
            return temp;
        }



}
