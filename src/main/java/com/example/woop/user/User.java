package com.example.woop.user;

import com.example.woop.building.Building;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class User {

    @Id
    private int userId;

    private int dong;
    private int ho;
    private String nickName;

    @ManyToOne
    private Building buildingId;
}
