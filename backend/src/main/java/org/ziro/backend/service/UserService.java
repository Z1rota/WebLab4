package org.ziro.backend.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.ziro.backend.repository.UserRepository;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void login(String username, String password) {
        userRepository.findByUsername(username);
    }

}
