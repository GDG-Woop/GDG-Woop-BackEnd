package com.example.woop.building;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Integer> {
    Optional<Building> findByBuildingId(int building_id);
}
