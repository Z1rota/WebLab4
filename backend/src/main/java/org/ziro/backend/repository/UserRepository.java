package org.ziro.backend.repository;


import org.ziro.backend.models.Users;

import java.util.Optional;

public interface UserRepository {
    Optional<Users> findByUsername(String username);





}
