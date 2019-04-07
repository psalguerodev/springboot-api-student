package me.psalguero.student.repositories;

import me.psalguero.student.entities.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Integer> {
}
