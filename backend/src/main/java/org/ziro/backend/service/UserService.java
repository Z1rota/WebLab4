package org.ziro.backend.service;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.ziro.backend.exceptions.UserAlreadyExistsException;
import org.ziro.backend.exceptions.UserNotFoundException;
import org.ziro.backend.models.Users;
import org.ziro.backend.repository.UserRepository;
import org.ziro.backend.util.PasswordHasher;

import java.util.Optional;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;

    public UserService() {
        this.userRepository = null;
        this.passwordHasher = null;
    }

    @Inject
    public UserService(UserRepository userRepository, PasswordHasher passwordHasher) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
    }


    public boolean login(String username, String password) {
        var userOptional = userRepository.findByUsername(username);


        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            return passwordHasher.verifyPassword(password, user.getPassword());
        }

        return false;
    }

    public boolean register(String username, String password) {
        boolean user = userRepository.existsByUsername(username);
        if (!user) {
            return false;
        }
        String hashed = passwordHasher.hashPassword(password);
        userRepository.save(new Users(username, hashed));
        return true;
    }

}
