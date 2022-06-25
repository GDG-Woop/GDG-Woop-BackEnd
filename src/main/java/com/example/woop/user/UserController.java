package com.example.woop.user;

import com.example.woop.common.utils.ApiUtils.ApiResult;

import com.example.woop.user.request.PostLoginReq;
import com.example.woop.user.request.PostUserReq;
import com.example.woop.user.response.GetUserRes;
import lombok.*;

import static com.example.woop.common.utils.ApiUtils.success;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/token")
    public ApiResult<String> setUserFCMtoken(@RequestParam(name = "token") String token,
            @RequestParam(name = "user_id") int userId) {
        userService.setUserFCMtoken(userId, token);
        return success("토큰 저장 완료");
    }

    public ApiResult<String> createUser(PostUserReq postUserReq){
        return success(userService.createUser(postUserReq));
    }

//    public ApiResult<GetUserRes> login(@Valid @RequestBody PostLoginReq postLoginReq){
//
//    }
}
