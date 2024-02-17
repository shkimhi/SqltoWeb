package com.sh.sqltoweb.repository;


import com.sh.sqltoweb.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
