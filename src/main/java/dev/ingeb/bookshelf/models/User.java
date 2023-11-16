package dev.ingeb.bookshelf.models;

import dev.ingeb.bookshelf.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long userId;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    public UserRole userRole;

    public User(String username, String email, String password, String firstName, String lastName, UserRole userRole) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
    }

    private User() {}

    private User(User.UserBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.userRole = builder.userRole;
    }


    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public static class UserBuilder
    {
        private final String username;
        private final String password;
        private String email;
        private String firstName;
        private String lastName;
        private UserRole userRole;
        public UserBuilder(String username, String password) {
            this.username = username;
            this.password = password;
        }
        public User.UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        public User.UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public User.UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public User.UserBuilder userRole(UserRole userRole) {
            this.userRole = userRole;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
