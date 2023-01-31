package com.dsoumaila.integrationtestingh2.controller;

import com.dsoumaila.integrationtestingh2.service.UserService;
import com.dsoumaila.integrationtestingh2.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    @ResponseStatus(CREATED)
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public User retrieveUser(@PathVariable Long id) {
        return userService.findUser(id);
    }

    @GetMapping("/fetch-all")
    @ResponseStatus(OK)
    public List<User> retrieveUsers() {
        return userService.findAllUsers();
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(NO_CONTENT)
    public void deleteOneUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
    }
}
