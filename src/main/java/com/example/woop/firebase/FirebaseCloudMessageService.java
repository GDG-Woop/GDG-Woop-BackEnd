package com.example.woop.firebase;

import com.example.woop.building.Building;
import com.example.woop.post.request.PostBoardRequest;
import com.example.woop.user.User;
import com.example.woop.user.UserRepository;
import com.example.woop.user.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import static okhttp3.MediaType.*;

@Component
@RequiredArgsConstructor
public class FirebaseCloudMessageService {

    private final String API_URL = "https://fcm.googleapis.com/v1/projects/android-****/messages:send";
    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;

    public void findBuildingAndSendMessageTo(int userId, int postId) throws IOException {
        User userFound = userRepository.findByUserId(userId).get();

        String message = makeMessage(userFound.getFcmToken(),
                Integer.toString(userFound.getDong()) + "-" + Integer.toString(userFound.getHo()),
                Integer.toString(postId));

        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(message,
                MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(API_URL)
                .post(requestBody)
                .addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())
                .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; UTF-8")
                .build();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }

    public void findUserByDongHoAndSendMessageTo(int dong, int ho, int userId) throws IOException {
        Building buildingFound = userRepository.findByUserId(userId).get().getBuildingId();

        List<User> userFound = userRepository.findByBuildingId(buildingFound);

        for (User user : userFound) {
            if (user.getDong() == dong && user.getHo() == ho) {
                String message = makeMessage(user.getFcmToken(),
                        "조금만 조용히 부탁드려요🙏",
                        "콕 찌르기 요청이 도착했어요!");

                OkHttpClient client = new OkHttpClient();
                RequestBody requestBody = RequestBody.create(message,
                        MediaType.get("application/json; charset=utf-8"));
                Request request = new Request.Builder()
                        .url(API_URL)
                        .post(requestBody)
                        .addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())
                        .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; UTF-8")
                        .build();

                Response response = client.newCall(request).execute();

                System.out.println(response.body().string());
            }
        }

    }

    private String makeMessage(String targetToken, String title, String body)
            throws JsonParseException, JsonProcessingException {
        FcmMessage fcmMessage = FcmMessage.builder()
                .message(FcmMessage.Message.builder()
                        .token(targetToken)
                        .notification(FcmMessage.Notification.builder()
                                .title(title)
                                .body(body)
                                .image(null)
                                .build())
                        .build())
                .validateOnly(false).build();

        return objectMapper.writeValueAsString(fcmMessage);
    }

    private String getAccessToken() throws IOException {
        String firebaseConfigPath = "firebase/firebase_service_key.json";

        GoogleCredentials googleCredentials = GoogleCredentials
                .fromStream(new ClassPathResource(firebaseConfigPath).getInputStream())
                .createScoped(List.of("https://www.googleapis.com/auth/cloud-platform"));

        googleCredentials.refreshIfExpired();
        return googleCredentials.getAccessToken().getTokenValue();
    }
}