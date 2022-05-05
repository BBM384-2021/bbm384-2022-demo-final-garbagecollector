package com.app.linkedhu.repository;

import com.app.linkedhu.entitites.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Long> {
}
