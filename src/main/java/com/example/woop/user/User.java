package com.example.woop.user;

import com.example.woop.building.Building;
import com.example.woop.comment.Comment;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private int dong;
    private int ho;
    private String nickName;

    @ManyToOne
    private Building buildingId;

    @OneToMany(mappedBy = "user")
    private List<Comment> commentList;
}
