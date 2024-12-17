package edu._3.dawl_romero_diana.repository;

import edu._3.dawl_romero_diana.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
