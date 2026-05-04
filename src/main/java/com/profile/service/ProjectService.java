package com.profile.service;

import com.profile.dto.ProjectDTO;
import com.profile.model.Project;
import com.profile.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<ProjectDTO.Response> getAllProjects() {
        return projectRepository.findAllByOrderBySortOrderAsc()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<ProjectDTO.Response> getFeaturedProjects() {
        return projectRepository.findByFeaturedTrueOrderBySortOrderAsc()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ProjectDTO.Response getProject(Long id) {
        Project p = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found: " + id));
        return toDTO(p);
    }

    private ProjectDTO.Response toDTO(Project p) {
        String[] stack = p.getTechStack() != null
                ? Arrays.stream(p.getTechStack().split(","))
                        .map(String::trim).toArray(String[]::new)
                : new String[]{};
        return ProjectDTO.Response.builder()
                .id(p.getId())
                .title(p.getTitle())
                .description(p.getDescription())
                .shortDesc(p.getShortDesc())
                .techStack(stack)
                .githubUrl(p.getGithubUrl())
                .liveUrl(p.getLiveUrl())
                .imageUrl(p.getImageUrl())
                .featured(p.isFeatured())
                .sortOrder(p.getSortOrder())
                .startDate(p.getStartDate())
                .endDate(p.getEndDate())
                .build();
    }
}