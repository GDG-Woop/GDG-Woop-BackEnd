package com.example.woop.post;

import com.example.woop.common.utils.ApiUtils;
import com.example.woop.post.request.PostBoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

//    @GetMapping("/{type}")
//    public ApiResult<Post> getPost(@PathVariable int type){
//        return success();
//    }
}
