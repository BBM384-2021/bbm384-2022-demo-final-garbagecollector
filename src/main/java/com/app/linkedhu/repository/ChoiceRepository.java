package com.app.linkedhu.repository;

import com.app.linkedhu.entitites.Choice;
import com.app.linkedhu.entitites.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {
    List<Choice> findAllByPollId(Long poll);
}
