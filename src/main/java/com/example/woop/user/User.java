package com.example.woop.user;

import com.example.woop.building.Building;
import com.example.woop.comment.Comment;

import com.example.woop.user.request.PostUserReq;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    private String userIdOne;
    private String password;

    private int dong;
    private int ho;
    private String nickName;

    private String fcmToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building buildingId;

    @OneToMany
    private List<Comment> commentList;

    public int getFloor() {
        return (int) (ho / 100);
    }

    public int getRoomNumber() {
        return (int) (ho % 100);
    }

    public User(PostUserReq postUserReq) {
        this.dong = postUserReq.getDong();
        this.ho = postUserReq.getHo();
        this.userIdOne = postUserReq.getUserIdOne();
        this.password = postUserReq.getPassword();
        this.nickName = postUserReq.getNickName();
        this.fcmToken = postUserReq.getFcmToken();
    }
}
