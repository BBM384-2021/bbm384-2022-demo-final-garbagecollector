package com.app.linkedhu.repository;

import com.app.linkedhu.entitites.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
