package com.profile.config;

import com.profile.model.Experience;
import com.profile.model.Project;
import com.profile.model.Skill;
import com.profile.repository.ExperienceRepository;
import com.profile.repository.ProjectRepository;
import com.profile.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataSeeder implements ApplicationRunner {

    private final SkillRepository skillRepository;
    private final ProjectRepository projectRepository;
    private final ExperienceRepository experienceRepository;

    @Override
    public void run(ApplicationArguments args) {
        seedSkills();
        seedProjects();
        seedExperiences();
    }

    private void seedSkills() {
        if (skillRepository.count() > 0) {
            log.info("Skills already seeded, skipping.");
            return;
        }
        skillRepository.saveAll(List.of(
            Skill.builder().name("Java").category("Backend").proficiency(90).iconKey("java").sortOrder(1).build(),
            Skill.builder().name("Spring Boot").category("Backend").proficiency(88).iconKey("spring").sortOrder(2).build(),
            Skill.builder().name("Go").category("Backend").proficiency(75).iconKey("go").sortOrder(3).build(),
            Skill.builder().name("PostgreSQL").category("Database").proficiency(85).iconKey("postgresql").sortOrder(4).build(),
            Skill.builder().name("React").category("Frontend").proficiency(80).iconKey("react").sortOrder(5).build(),
            Skill.builder().name("TypeScript").category("Frontend").proficiency(78).iconKey("typescript").sortOrder(6).build(),
            Skill.builder().name("Docker").category("DevOps").proficiency(72).iconKey("docker").sortOrder(7).build(),
            Skill.builder().name("Git").category("DevOps").proficiency(90).iconKey("git").sortOrder(8).build(),
            Skill.builder().name("Maven").category("DevOps").proficiency(80).iconKey("maven").sortOrder(9).build(),
            Skill.builder().name("Linux").category("DevOps").proficiency(75).iconKey("linux").sortOrder(10).build()
        ));
        log.info("Skills seeded successfully.");
    }

    private void seedProjects() {
        if (projectRepository.count() > 0) {
            log.info("Projects already seeded, skipping.");
            return;
        }
        projectRepository.saveAll(List.of(
            Project.builder()
                .title("Portfolio Backend")
                .shortDesc("RESTful API powering this portfolio site.")
                .description("A Spring Boot 3 REST API backed by PostgreSQL. Includes endpoints for projects, skills, experience, and a contact form with SMTP email delivery.")
                .techStack("Java 17, Spring Boot 3, PostgreSQL, Maven")
                .githubUrl("https://github.com/SwaroopAV21/javaProfile")
                .featured(true)
                .sortOrder(1)
                .startDate(LocalDate.of(2024, 1, 1))
                .build(),

            Project.builder()
                .title("E-Commerce Platform")
                .shortDesc("Full-stack e-commerce with cart and payments.")
                .description("Built with Spring Boot microservices architecture. Includes product catalog, cart, order management, and Stripe payment integration.")
                .techStack("Java, Spring Boot, React, PostgreSQL, Stripe")
                .githubUrl("https://github.com/SwaroopAV21/ecommerce")
                .liveUrl("https://yourapp.com")
                .featured(true)
                .sortOrder(2)
                .startDate(LocalDate.of(2023, 6, 1))
                .build(),

            Project.builder()
                .title("CLI Task Manager")
                .shortDesc("Terminal-based task manager written in Go.")
                .description("A fast command-line productivity tool built in Go. Supports tags, priorities, due dates, and JSON export.")
                .techStack("Go, SQLite, Cobra CLI")
                .githubUrl("https://github.com/SwaroopAV21/")
                .featured(false)
                .sortOrder(3)
                .startDate(LocalDate.of(2023, 11, 1))
                .build()
        ));
        log.info("Projects seeded successfully.");
    }

    private void seedExperiences() {
        if (experienceRepository.count() > 0) {
            log.info("Experiences already seeded, skipping.");
            return;
        }
        experienceRepository.saveAll(List.of(
            Experience.builder()
                .company("Your Company")
                .role("Senior Software Engineer")
                .description("Led backend development for core product features. Architected REST APIs serving 100k+ daily users. Mentored junior engineers and conducted code reviews.")
                .location("Bengaluru, India")
                .startDate(LocalDate.of(2022, 7, 1))
                .current(true)
                .techUsed("Java, Spring Boot, PostgreSQL, Docker, Kubernetes")
                .sortOrder(1)
                .build(),

            Experience.builder()
                .company("Previous Corp")
                .role("Software Engineer")
                .description("Built and maintained microservices for the payments platform. Reduced API latency by 40% through query optimization and caching.")
                .location("Bengaluru, India")
                .startDate(LocalDate.of(2020, 8, 1))
                .endDate(LocalDate.of(2022, 6, 30))
                .current(false)
                .techUsed("Java, Spring MVC, MySQL, Redis")
                .sortOrder(2)
                .build(),

            Experience.builder()
                .company("Startup XYZ")
                .role("Junior Developer")
                .description("Full-stack development using Spring Boot and Angular. Delivered features end-to-end from design to deployment.")
                .location("Remote")
                .startDate(LocalDate.of(2019, 1, 1))
                .endDate(LocalDate.of(2020, 7, 31))
                .current(false)
                .techUsed("Java, Angular, MongoDB")
                .sortOrder(3)
                .build()
        ));
        log.info("Experiences seeded successfully.");
    }
}