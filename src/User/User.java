package User;

import java.util.Objects;

public class User {



        private String name;
        private String email;
        private String password;
        private boolean admin;

        public User(String name, String email, String password, boolean admin) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.admin = admin;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return admin == user.admin &&
                    Objects.equals(name, user.name) &&
                    Objects.equals(email, user.email) &&
                    Objects.equals(password, user.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, email, password, admin);
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", admin=" + admin +
                    '}';
        }


}
