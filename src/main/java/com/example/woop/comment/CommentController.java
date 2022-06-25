package com.example.woop.comment;

import com.example.woop.comment.request.PostCommentReq;
import com.example.woop.common.utils.ApiUtils.ApiResult;
import javax.validation.Valid;
import static com.example.woop.common.utils.ApiUtils.success;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{postId}")
    public ApiResult<String> postComment(@RequestBody PostCommentReq postCommentReq, @PathVariable int postId){
        return success(commentService.postComment(postId, postCommentReq));
    }
}
