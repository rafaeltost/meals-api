package com.topinformation.MealsAPI.repository;

import com.topinformation.MealsAPI.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealsRepository extends JpaRepository<Meal, Long> {
}
