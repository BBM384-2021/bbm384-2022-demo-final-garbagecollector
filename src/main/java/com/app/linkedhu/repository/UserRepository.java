package com.app.linkedhu.repository;

import com.app.linkedhu.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByUserName(String userName);

    User getByEmail(String email);
}
