package com.example.woop.building;

import com.example.woop.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Getter
@Setter
@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buildingId;

    private int buildingType;
    private String buildingName;

    private String adminCode;
    private int floor; // 층
    private int roomNumber; // 호

    @OneToMany(fetch = FetchType.LAZY)
    private List<User> userId;

    public List<Boolean> getEmptyRoom(int queryFloor) {
        List<Boolean> emptyRooms = new ArrayList<Boolean>(Arrays.asList(new Boolean[floor]));
        Collections.fill(emptyRooms, Boolean.FALSE);
        for (User user : userId) {
            if (user.getFloor() == queryFloor) {
                emptyRooms.set(user.getRoomNumber() - 1, Boolean.TRUE);
            }
        }

        return emptyRooms;
    }
}
