package com.example.woop.user;

import com.example.woop.building.Building;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {

    @Id @GeneratedValue @Column(name = "user_id")
    private int userId;

    private int dong;
    private int ho;
    private String nickName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building buildingId;
}
