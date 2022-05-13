package com.app.linkedhu.repository;

import com.app.linkedhu.entitites.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {
    List<Likes> findByUserIdAndPostId(Long aLong, Long aLong1);

    List<Likes> findByUserId(Long aLong);

    List<Likes> findByPostId(Long aLong);

    Likes getByUserIdAndPostId(Long aLong, Long aLong1);
}
