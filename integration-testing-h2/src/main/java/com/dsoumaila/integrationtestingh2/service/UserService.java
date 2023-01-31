package com.dsoumaila.integrationtestingh2.service;

import com.dsoumaila.integrationtestingh2.entity.User;
import com.dsoumaila.integrationtestingh2.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .sorted(Comparator.comparingLong(User::getId))
                .collect(toList());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
