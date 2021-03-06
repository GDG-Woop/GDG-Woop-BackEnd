package com.example.woop.post;

import com.example.woop.building.Building;
import com.example.woop.comment.Comment;
import com.example.woop.comment.CommentRepository;
import com.example.woop.common.exception.NotFoundException;
import com.example.woop.post.request.PostBoardRequest;
import com.example.woop.post.response.GetBoardResponse;
import com.example.woop.post.response.GetMeBoardRes;
import com.example.woop.user.User;
import com.example.woop.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public int createPost(PostBoardRequest postBoardRequest) {
        int user_id = 1;

        User byUserId = userRepository.findByUserId(user_id)
                .orElseThrow(() -> new NotFoundException("회원이 존재하지 않습니다."));

        System.out.println(byUserId.getUserId());

        Post post = new Post(postBoardRequest, byUserId);
        Post postNew = postRepository.save(post);

        return postNew.getPostId();
    }

    public GetBoardResponse getOnePost(int post_id) {
        Post post = postRepository.findByPostId(post_id).orElseThrow(() -> new NotFoundException("게시글이 존재하지 않습니다."));
        List<Comment> byPostId = commentRepository.findByPostId(post);

        GetBoardResponse getBoardResponse;
        if (byPostId.isEmpty()) {
            getBoardResponse = new GetBoardResponse(post.getTitle(), post.getContent(), post.getTag(), post.getUserId(),
                    null);
        } else {
            List<PostComment> postComments = new ArrayList<>();
            for (Comment comment : byPostId) {
                String userName = comment.getUserId().getDong() + "동 " + comment.getUserId().getHo() + "호 " + comment.getUserId().getNickName();
                PostComment postComment = new PostComment(comment.getContent(), userName);
                postComments.add(postComment);
            }
            getBoardResponse = new GetBoardResponse(post.getTitle(), post.getContent(), post.getTag(), post.getUserId(),
                    postComments);
        }

        return getBoardResponse;
    }

    public List<Post> getPost() {
        List<Post> list = postRepository.findAll();
        return list;
    }

    public List<GetMeBoardRes> getMeBoard(){
        int userId = 1;
        User user = userRepository.findByUserId(userId).orElseThrow(
                ()-> new NotFoundException("사용자가 없습니다.")
        );

        List<Post> postList = postRepository.findByUserId(user);
        List<GetMeBoardRes> getMeBoardResList = new ArrayList<>();

        for(Post post : postList){
            User userIdOne = post.getUserId();
            GetMeBoardRes getMeBoardRes = new GetMeBoardRes(userIdOne.getDong(), userIdOne.getHo(), userIdOne.getNickName(), post.getTitle(), post.getContent(), post.getTag());
            getMeBoardResList.add(getMeBoardRes);
        }
        return getMeBoardResList;
    }
}
