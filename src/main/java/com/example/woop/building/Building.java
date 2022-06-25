package com.example.woop.building;

import com.example.woop.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Building {

    @Id @GeneratedValue
    private int buildingId;

    private int buildingType;
    private String buildingName;

    private String adminCode;
    private int floor; // 층
    private int roomNumber; //호

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<User> userId;

}
