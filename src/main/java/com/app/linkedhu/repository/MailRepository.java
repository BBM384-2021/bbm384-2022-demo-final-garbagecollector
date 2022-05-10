package com.app.linkedhu.repository;

import com.app.linkedhu.entitites.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailRepository extends JpaRepository<Mail, Long> {
    List<Mail> findBySenderUserId(Long userId);

    List<Mail> findByReceiverUserId(Long userId);
}
