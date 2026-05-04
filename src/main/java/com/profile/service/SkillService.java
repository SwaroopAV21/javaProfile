package com.profile.service;

import com.profile.model.Skill;
import com.profile.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAllByOrderBySortOrderAsc();
    }

    // Returns skills grouped by category
    public Map<String, List<Skill>> getSkillsGrouped() {
        return skillRepository.findAllByOrderBySortOrderAsc()
                .stream()
                .collect(Collectors.groupingBy(Skill::getCategory,
                        LinkedHashMap::new, Collectors.toList()));
    }
}