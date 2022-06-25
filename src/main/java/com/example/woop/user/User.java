package com.example.woop.user;

import com.example.woop.building.Building;
import com.example.woop.comment.Comment;

import lombok.Getter;
import lombok.Setter;

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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    private int dong;
    private int ho;
    private String nickName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building buildingId;

    @OneToMany(mappedBy = "user")
    private List<Comment> commentList;

    public int getFloor() {
        return (int) (ho / 100);
    }
}
