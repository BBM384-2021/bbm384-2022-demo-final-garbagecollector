package com.app.linkedhu.repository;

import com.app.linkedhu.entitites.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderUserId(Long userId);

    List<Message> findByReceiverUserId(Long aLong);
}
