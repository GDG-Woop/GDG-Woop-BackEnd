package com.example.woop.building.response;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BuildingGetOverallRes {
    private String building_name;
    private int building_floor;
    private int building_room_number;
    private int user_floor;
    private int user_room_number;
}
