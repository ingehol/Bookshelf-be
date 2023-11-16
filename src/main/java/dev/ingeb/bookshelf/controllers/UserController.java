package dev.ingeb.bookshelf.controllers;

import dev.ingeb.bookshelf.contracts.UserLogin;
import dev.ingeb.bookshelf.contracts.UserLoginResponse;
import dev.ingeb.bookshelf.contracts.UserResponse;
import dev.ingeb.bookshelf.models.User;
import dev.ingeb.bookshelf.services.UserService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }

    @PostMapping("/login")
    public @NotNull UserLoginResponse login(@RequestBody UserLogin userLogin) {
        return userService.login(userLogin);
    }

    @GetMapping("/user")
    public UserResponse getUser(@RequestParam String userId) {
        return userService.getUser(Long.parseLong(userId));
    }

    @PutMapping("/update")
    public void updateUser(
            @RequestBody User user
    ) {
        userService.updateUser(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam String userId) {
        userService.deleteUser(Long.parseLong(userId));
    }

    @GetMapping("/all")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }
}
