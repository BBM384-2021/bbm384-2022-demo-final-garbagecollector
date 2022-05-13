package com.app.linkedhu.repository;

import com.app.linkedhu.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByUserName(String userName);
    List<User> getAllByActiveFalse();
    User getByEmail(String email);
}
