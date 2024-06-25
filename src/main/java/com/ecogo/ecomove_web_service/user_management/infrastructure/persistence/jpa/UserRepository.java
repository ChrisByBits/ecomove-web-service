package com.ecogo.ecomove_web_service.user_management.infrastructure.persistence.jpa;

import com.ecogo.ecomove_web_service.user_management.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/**
 * Repository for the user entity
 */
public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);


}
