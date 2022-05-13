package com.app.linkedhu.repository;

import com.app.linkedhu.entitites.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll,Long> {
}
