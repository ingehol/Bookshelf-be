package dev.ingeb.bookshelf.services;

import dev.ingeb.bookshelf.contracts.UserLogin;
import dev.ingeb.bookshelf.contracts.UserLoginResponse;
import dev.ingeb.bookshelf.contracts.UserResponse;
import dev.ingeb.bookshelf.models.User;
import dev.ingeb.bookshelf.stores.UserStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final UserStore userStore;

    public UserServiceImplementation(UserStore userStore) {
        this.userStore = userStore;
    }

    @Override
    public void registerUser(User user) {
        userStore.registerUser(user);
    }

    @Override
    public UserLoginResponse login(UserLogin userLogin) {
        var user = userStore.login(userLogin);
        if (user.isEmpty()) {
            throw new RuntimeException("Wrong username or password");
        }
        if(passwordEncoder.matches(userLogin.getPassword(), user.get().password())) {
            return user.get();
        }
        return null;
    }

    @Override
    public UserResponse getUser(Long userId) {
        if(userStore.getUser(userId).isPresent()) {
            return userStore.getUser(userId).get();
        }
        return null;
    }

    @Override
    public void updateUser(User user) {
        if(userStore.getUser(user.getUserId()).isPresent()) {
            userStore.updateUser(user);
        } else {
            log.error(String.format("User does not exist for userId %s", user.getUserId()));
        }
    }

    @Override
    public void deleteUser(Long userId) {
        if(userStore.getUser(userId).isPresent()) {
            userStore.deleteUser(userId);
        } else {
            log.error(String.format("User does not exist for userId %s", userId));
        }
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userStore.getAllUsers();
    }
}
