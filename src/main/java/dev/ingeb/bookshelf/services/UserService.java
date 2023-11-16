package dev.ingeb.bookshelf.services;

import dev.ingeb.bookshelf.contracts.UserLogin;
import dev.ingeb.bookshelf.contracts.UserLoginResponse;
import dev.ingeb.bookshelf.contracts.UserResponse;
import dev.ingeb.bookshelf.models.User;

import java.util.List;

public interface UserService {
    void registerUser(User user);
    UserLoginResponse login(UserLogin userLogin);
    UserResponse getUser(Long userId);
    void updateUser(User user);
    void deleteUser(Long userId);
    List<UserResponse> getAllUsers();
}
