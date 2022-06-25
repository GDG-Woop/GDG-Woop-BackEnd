package com.example.woop.post;

import com.example.woop.building.Building;
import com.example.woop.comment.Comment;
import com.example.woop.comment.CommentRepository;
import com.example.woop.common.exception.NotFoundException;
import com.example.woop.post.request.PostBoardRequest;
import com.example.woop.post.response.GetBoardResponse;
import com.example.woop.user.User;
import com.example.woop.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public String createPost(PostBoardRequest postBoardRequest){
        int user_id = 1;


        User byUserId = userRepository.findByUserId(user_id)
                .orElseThrow(() -> new NotFoundException("회원이 존재하지 않습니다."));

        System.out.println(byUserId.getUserId());

        Post post = new Post(postBoardRequest, byUserId);
        postRepository.save(post);
        return "게시글이 생성되었습니다.";
   }

   public GetBoardResponse getOnePost(int post_id){
        int user_id = 1;

       Post post = postRepository.findByPostId(post_id).orElseThrow(() -> new NotFoundException("게시글이 존재하지 않습니다."));
       List<Comment> byPostId = commentRepository.findByPost(post);

       GetBoardResponse getBoardResponse = new GetBoardResponse(post, byPostId);

       return getBoardResponse;
   }
}
