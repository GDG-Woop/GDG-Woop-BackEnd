package com.example.woop.post;

import com.example.woop.firebase.FirebaseCloudMessageService;
import com.example.woop.firebase.RequestDto;
import com.example.woop.post.request.PostBoardRequest;
import com.example.woop.post.response.GetBoardResponse;
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
    public ApiResult<String> createPost(@Valid @RequestBody PostBoardRequest postBoardRequest){
        String post = postService.createPost(postBoardRequest);
        return success(post);
    }

    @GetMapping("/{postId}")
    public ApiResult<GetBoardResponse> getPost(@PathVariable int postId, @RequestBody RequestDto requestDTO) throws IOException {

        firebaseCloudMessageService.sendMessageTo(
                requestDTO.getTargetToken(),
                requestDTO.getTitle(),
                requestDTO.getBody());

        return success(postService.getOnePost(postId));
    }


}
