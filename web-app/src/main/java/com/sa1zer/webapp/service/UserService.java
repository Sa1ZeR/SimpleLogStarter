package com.sa1zer.webapp.service;

import com.sa1zer.webapp.entity.User;
import com.sa1zer.webapp.exeption.EntityNotFoundException;
import com.sa1zer.webapp.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("User with %s not found", id)));
    }

    @Transactional
    public User save(User user) {
        return userRepo.save(user);
    }

    @Transactional
    public void delete(User user) {
        userRepo.delete(user);
    }

    @Transactional
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }
}
