package com.profile.repository;

import com.profile.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findAllByOrderBySortOrderAsc();
    List<Skill> findByCategoryOrderBySortOrderAsc(String category);
}