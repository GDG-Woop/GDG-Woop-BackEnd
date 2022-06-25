package com.example.woop.building.response;

import java.util.List;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BuildingGetAllEmptyRes {
    List<Boolean> empty_rooms;
    private int building_number;
    private int building_floor;
    private int building_room_number;
    private int user_floor; // 층
    private int user_room_number; // 호수
}
