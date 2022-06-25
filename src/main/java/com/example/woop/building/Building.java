package com.example.woop.building;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Building {

    @Id
    private int buildingId;

    private int buildingType;
    private String buildingName;

    private String adminCode;
    private int floor; // 층
    private int roomNumber; // 호
}
