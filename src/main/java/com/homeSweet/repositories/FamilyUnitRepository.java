package com.homeSweet.repositories;

import com.homeSweet.entities.FamilyUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyUnitRepository extends JpaRepository<FamilyUnit,Long> {
}
