package com.iwis.dao.repo;

import com.iwis.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}