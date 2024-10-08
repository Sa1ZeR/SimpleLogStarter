package com.sa1zer.webapp.service;

import com.sa1zer.webapp.exeption.EntityNotFoundException;
import com.sa1zer.webapp.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class UserServiceTest {

    @Autowired
    UserRepo userRepo;
    @Autowired
    UserService userService;

    @BeforeEach
    void onInit() {
        userRepo.deleteAll();
    }

    @Test()
    void findById() {
        assertThrows(EntityNotFoundException.class, () -> userService.findById(1L));
    }
}