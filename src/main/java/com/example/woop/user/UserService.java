package com.example.woop.user;

import com.example.woop.common.utils.JwtService;
import com.example.woop.post.Post;
import com.example.woop.user.request.PostLoginReq;
import com.example.woop.user.request.PostUserReq;
import com.example.woop.user.response.GetUserRes;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    public void setUserFCMtoken(int userId, String token) {
        User userFound = userRepository.findByUserId(userId).get();
        userFound.setFcmToken(token);
    }

    public String createUser(PostUserReq postUserReq){
        User user = new User(postUserReq);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }

//    public GetUserRes login(PostLoginReq postLoginReq){
//        String userIdOne = postLoginReq.getUserIdOne();
//        String password = postLoginReq.getPassword();
//
//    }

}
