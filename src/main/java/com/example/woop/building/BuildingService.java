package com.example.woop.building;

import org.springframework.stereotype.Service;

import com.example.woop.building.response.BuildingGetOverallRes;
import com.example.woop.user.User;
import com.example.woop.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuildingService {

    private final UserRepository userRepository;

    public BuildingGetOverallRes getBuildingOverall(int userId) {
        User userFound = userRepository.findByUserId(userId).get();
        Building buildingFound = userFound.getBuildingId();
        return new BuildingGetOverallRes(
                buildingFound.getBuildingName(),
                buildingFound.getFloor(),
                buildingFound.getRoomNumber(),
                userFound.getFloor(),
                userFound.getHo());
    }
}
