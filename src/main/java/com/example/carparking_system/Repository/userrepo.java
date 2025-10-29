package com.example.carparking_system.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carparking_system.Model.user;

public interface userrepo extends JpaRepository<user, Long> {
    Optional<user> findByEmail(String email);
}
