package com.profile.controller;

import com.profile.dto.ApiResponse;
import com.profile.model.Skill;
import com.profile.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Skill>>> getAllSkills() {
        return ResponseEntity.ok(ApiResponse.ok(skillService.getAllSkills()));
    }

    @GetMapping("/grouped")
    public ResponseEntity<ApiResponse<Map<String, List<Skill>>>> getGrouped() {
        return ResponseEntity.ok(ApiResponse.ok(skillService.getSkillsGrouped()));
    }
}