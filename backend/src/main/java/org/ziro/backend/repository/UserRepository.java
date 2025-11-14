package org.ziro.backend.repository;


import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.ziro.backend.models.Users;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    String getPassword(String username);






}
