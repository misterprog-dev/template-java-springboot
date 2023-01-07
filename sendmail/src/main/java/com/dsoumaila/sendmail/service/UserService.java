package com.dsoumaila.sendmail.service;

import com.dsoumaila.sendmail.dto.UserDto;
import com.dsoumaila.sendmail.entity.User;
import com.dsoumaila.sendmail.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EmailService emailService;

    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    /**
     * Create a user
     * @param userDto user information for saving
     */
    @Transactional
    public void createUser(@NotNull UserDto userDto) {
        User user = new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        userRepository.save(user);

        // We send email to user
        emailService.sendMessage(
                user.getEmail(),
                "Subscription User",
                Map.of("userName",userDto.getFirstName() + " " + userDto.getLastName(), "mailContent", " Thanks for your registration, I wish the better !!!")
        );
    }
}
