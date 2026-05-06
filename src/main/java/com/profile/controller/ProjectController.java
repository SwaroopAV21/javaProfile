package com.profile.controller;

import com.profile.dto.ApiResponse;
import com.profile.dto.ProjectDTO;
import com.profile.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
     @Operation(summary = "Get all projects", description = "Returns all projects ordered by sort order")
    public ResponseEntity<ApiResponse<List<ProjectDTO.Response>>> getAllProjects() {
        return ResponseEntity.ok(ApiResponse.ok(projectService.getAllProjects()));
    }

    @GetMapping("/featured")
     @Operation(summary = "Get featured projects", description = "Returns all featured projects ordered by sort order")
    public ResponseEntity<ApiResponse<List<ProjectDTO.Response>>> getFeatured() {
        return ResponseEntity.ok(ApiResponse.ok(projectService.getFeaturedProjects()));
    }

    @GetMapping("/{id}")
     @Operation(summary = "Get project by ID", description = "Returns a project by its ID")
    public ResponseEntity<ApiResponse<ProjectDTO.Response>> getProject(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(projectService.getProject(id)));
    }
}