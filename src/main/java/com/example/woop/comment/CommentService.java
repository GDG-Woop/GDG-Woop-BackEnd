package com.example.woop.comment;

import com.example.woop.comment.request.PostCommentReq;
import com.example.woop.common.exception.NotFoundException;
import com.example.woop.post.Post;
import com.example.woop.post.PostRepository;
import com.example.woop.user.User;
import com.example.woop.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public String postComment(int postId, PostCommentReq postCommentReq){
        User user = userRepository.findByUserId(postCommentReq.getUserId()).orElseThrow(
                ()-> new NotFoundException("회원이 존재하지 않습니다.")
        );
        Post post = postRepository.findByPostId(postId).orElseThrow(() -> new NotFoundException("게시글이 존재하지 않습니다."));

        Comment comment = new Comment(postCommentReq, user, post);
        commentRepository.save(comment);

        return "댓글이 등록되었습니다.";
    }
}
