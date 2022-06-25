package com.example.woop.post;

import com.example.woop.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Optional<Post> findByPostId(int post_id);
    List<Post> findByUserId(User user_id);
}
