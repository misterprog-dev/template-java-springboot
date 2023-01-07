package com.dsoumaila.sendmail.controller;

import com.dsoumaila.sendmail.dto.UserDto;
import com.dsoumaila.sendmail.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create book
     *
     * @param user the user information
     */
    @PostMapping()
    public void createUser(@RequestBody @Valid UserDto user) {
        userService.createUser(user);
    }
}
