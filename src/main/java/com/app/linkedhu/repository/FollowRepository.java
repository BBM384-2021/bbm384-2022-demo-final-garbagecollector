package com.app.linkedhu.repository;

import com.app.linkedhu.entitites.Follow;
import com.app.linkedhu.entitites.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findBySenderUserId(Long userId);

    List<Follow> findByReceiverUserId(Long userId);
    Follow findBySenderUserIdAndReceiverUserId(Long senderUserId, Long receiverUserID);
}
