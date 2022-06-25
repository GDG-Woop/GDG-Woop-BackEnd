package com.example.woop.post;

import com.example.woop.common.utils.ApiUtils;
import com.example.woop.post.request.PostBoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.woop.common.utils.ApiUtils.ApiResult;
import javax.validation.Valid;
import static com.example.woop.common.utils.ApiUtils.success;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ApiResult<String> createPost(@Valid @RequestBody PostBoardRequest postBoardRequest){
        String post = postService.createPost(postBoardRequest);
        return success(post);
    }

}
