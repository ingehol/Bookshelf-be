package dev.ingeb.bookshelf.stores;

import dev.ingeb.bookshelf.contracts.UserLogin;
import dev.ingeb.bookshelf.contracts.UserLoginResponse;
import dev.ingeb.bookshelf.contracts.UserResponse;
import dev.ingeb.bookshelf.enums.UserRole;
import dev.ingeb.bookshelf.models.User;
import org.dalesbred.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

public class UserStore {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final Database database;

    public UserStore(Database database) {
        this.database = database;
    }

    public void registerUser(User user) {
        database.update("""
                 INSERT INTO Users
                 (username, password, email, firstname, lastname, userRole)
                 VALUES (?, ?, ?, ?, ?, ?)
                 """, user.getUsername(), passwordEncoder.encode(user.getPassword()),
                user.getEmail(), user.getFirstname(), user.getLastname(),
                user.getUserRole() != null ? user.getUserRole() : UserRole.USER);
    }

    public Optional<UserLoginResponse> login(UserLogin userLogin) {
        return database.findOptional(UserLoginResponse.class, """
                SELECT * FROM Users
                WHERE username = ?
                """, userLogin.getUsername()
        );
    }

    public Optional<UserResponse> getUser(Long userId) {
        return database.findOptional(UserResponse.class, """
                SELECT username, email, firstName, lastName,
                FROM Users
                WHERE userId = ?
                """, userId
        );
    }

    public void updateUser(User user) {
        database.update("""
                UPDATE Users
                SET username = COALESCE(?, username), password = COALESCE(?, password),
                email = COALESCE(?, email), firstname = COALESCE(?, firstname), lastname = COALESCE(?, lastname),
                userRole = COALESCE(?, userRole)
                WHERE userId = ?
                """,
                user.getUsername(),
                passwordEncoder.encode(user.getPassword()),
                user.getEmail(), user.getFirstname(),
                user.getLastname(), user.getUserRole(),
                user.getUserId()
        );
    }

    public void deleteUser(Long userId) {
        database.update("""
                DELETE FROM Users WHERE userId = ?
                """,
                userId
        );
    }

    public List<UserResponse> getAllUsers() {
        return database.findAll(UserResponse.class, """
                SELECT userId, username, email, firstname, lastname, userRole
                FROM Users
                """
        );
    }
}
