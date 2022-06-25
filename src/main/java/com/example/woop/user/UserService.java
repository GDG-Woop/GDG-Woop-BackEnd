package com.example.woop.user;

import com.example.woop.building.Building;
import com.example.woop.firebase.FirebaseCloudMessageService;

import java.io.IOException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final FirebaseCloudMessageService firebaseCloudMessageService;

    public void setUserFCMtoken(int userId, String token) {
        User userFound = userRepository.findByUserId(userId).get();
        userFound.setFcmToken(token);
    }

    public void pickUser(int dong, int ho, int userId) {
        try {
            firebaseCloudMessageService.findUserByDongHoAndSendMessageTo(dong, ho, userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
