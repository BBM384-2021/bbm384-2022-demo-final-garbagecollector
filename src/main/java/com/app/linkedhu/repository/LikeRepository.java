package com.app.linkedhu.repository;

import com.app.linkedhu.entitites.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    List<Likes> findByUserIdAndPostId(Long aLong, Long aLong1);

    List<Likes> findByUserId(Long aLong);

    List<Likes> findByPostId(Long aLong);
}
