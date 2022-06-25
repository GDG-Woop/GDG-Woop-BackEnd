package com.example.woop.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.woop.building.Building;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserId(int user_id);

    List<User> findByBuildingId(Building buildingId);
}
