package me.psalguero.student.repositories;

import me.psalguero.student.entities.FamilyMembers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyMemberRepository extends JpaRepository<FamilyMembers, Integer> {
}
