package com.example.woop.user;

import com.example.woop.user.request.PostUserReq;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void setUserFCMtoken(int userId, String token) {
        User userFound = userRepository.findByUserId(userId).get();
        userFound.setFcmToken(token);
    }

//    public String createUser(PostUserReq postUserReq){
//        User user = new User(postUserReq);
//    }

}
