package com.example.woop.post;

import com.example.woop.firebase.FirebaseCloudMessageService;
import com.example.woop.firebase.RequestDto;
import com.example.woop.post.request.PostBoardRequest;
import com.example.woop.post.response.GetBoardResponse;
import com.example.woop.user.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.woop.common.utils.ApiUtils.ApiResult;
import javax.validation.Valid;
import java.io.IOException;

import static com.example.woop.common.utils.ApiUtils.success;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final FirebaseCloudMessageService firebaseCloudMessageService;

    @PostMapping
    public ApiResult<String> createPost(@Valid @RequestBody PostBoardRequest postBoardRequest) {
        int postId = postService.createPost(postBoardRequest);
        int userId = 1;
        try {
            firebaseCloudMessageService.findBuildingAndSendMessageTo(userId, postId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return success("게시글이 생성되었습니다.");
    }

    @GetMapping("/{postId}")
    public ApiResult<GetBoardResponse> getPost(@PathVariable int postId, @RequestBody RequestDto requestDTO)
            throws IOException {

        return success(postService.getOnePost(postId));
    }

}
