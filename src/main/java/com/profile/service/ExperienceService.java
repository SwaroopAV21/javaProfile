package com.profile.service;

import com.profile.model.Experience;
import com.profile.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public List<Experience> getAllExperiences() {
        return experienceRepository.findAllByOrderBySortOrderAsc();
    }

    // Split techUsed comma-string into array helper used by controller
    public String[] splitTech(String techUsed) {
        if (techUsed == null || techUsed.isBlank()) return new String[]{};
        return Arrays.stream(techUsed.split(",")).map(String::trim).toArray(String[]::new);
    }
}