package com.example.woop.user;

import com.example.woop.common.utils.ApiUtils.ApiResult;

import lombok.*;

import static com.example.woop.common.utils.ApiUtils.success;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ApiResult<String> setUserFCMtoken(@RequestParam(name = "token") String token,
            @RequestParam(name = "user_id") int userId) {
        userService.setUserFCMtoken(userId, token);
        return success("토큰 저장 완료");
    }

    @RequestMapping(value = "/qooq", method = RequestMethod.POST)
    public ApiResult<String> pickUser(@RequestParam(name = "dong") int dong,
            @RequestParam(name = "ho") int ho, @RequestParam(name = "user_id") int userId) {
        userService.pickUser(dong, ho, userId);
        return success("유저 찌르기 완료");
    }
}
