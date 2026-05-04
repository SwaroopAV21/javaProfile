package com.profile.controller;

import com.profile.dto.ApiResponse;
import com.profile.dto.ProjectDTO;
import com.profile.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProjectDTO.Response>>> getAllProjects() {
        return ResponseEntity.ok(ApiResponse.ok(projectService.getAllProjects()));
    }

    @GetMapping("/featured")
    public ResponseEntity<ApiResponse<List<ProjectDTO.Response>>> getFeatured() {
        return ResponseEntity.ok(ApiResponse.ok(projectService.getFeaturedProjects()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectDTO.Response>> getProject(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(projectService.getProject(id)));
    }
}