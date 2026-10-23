-- Skills
INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'Java', 'Backend', 90, 'java', 1
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'Java');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'Python', 'Backend', 90, 'python', 1
    WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'Python');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'Go', 'Backend', 75, 'go', 3
    WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'Go');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'C++', 'Backend', 75, 'cpp', 3
    WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'C++');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'Spring Boot', 'Backend', 88, 'spring', 2
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'Spring Boot');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'Spring JPA & Hibernate', 'Backend', 88, 'spring', 2
    WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'Spring JPA & Hibernate');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'PostgreSQL', 'Database', 85, 'postgresql', 4
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'PostgreSQL');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'NoSQL', 'Database', 85, 'nosql', 4
    WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'NoSQL');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'Kubernetes', 'DevOps', 50, 'kubernetes', 5
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'Kubernetes');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'TypeScript', 'Frontend', 78, 'typescript', 6
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'TypeScript');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'Docker', 'DevOps', 72, 'docker', 7
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'Docker');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'Git', 'DevOps', 90, 'git', 8
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'Git');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'GitHub Actions', 'DevOps', 90, 'github', 8
    WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'GitHub Actions');

-- Projects
INSERT INTO projects (title, short_desc, description, tech_stack, github_url, live_url, featured, sort_order, start_date)
SELECT 'Associate Software Engineer - Backend Ownership [ Inserted from docker db image ]',
       'Owned Responsibilities and End to End Delivery.',
       '• Own DevOps for production products, automating 70–80% of the development-to-QA pipeline and materially reducing manual
                      release effort per cycle.
                    • Built and maintained 6 CI/CD pipelines using GitHub Actions, with containerized Docker builds deployed to backend services on
                      Kubernetes (Proxmox) via ArgoCD (GitOps) for automated, repeatable releases.
                    • Authored Go-based internal tooling that enforces coding consistency across teams, reducing style and lint feedback in code review.
                    • Integrated AI-powered code scanning (GitHub Copilot) into CI/CD workflows and authored custom instructions and prompts for
                      automated bug identification and fix suggestions, surfacing defects before human review.
                    • Delivered a Python feature in a client validator tool used daily across the organization — running issue-free in production since
                      release.
                    • Owned end-to-end development of a full-stack product on Python (Flask), Angular, NoSQL and Elasticsearch, extending an
                      existing boilerplate into a new product line as client requirements evolved.',
       'Python, Go, Flask, NoSQL[ElasticSearch],Git GitHubActions, Github Copilot, Angular, Docker, Kubernetes, ArgoCD',
       'https://github.com/SwaroopAV21/javaProfile/',
       NULL, true, 1, '2024-01-01'
WHERE NOT EXISTS (SELECT 1 FROM projects WHERE title = 'Associate Software Engineer - Backend Ownership');

INSERT INTO projects (title, short_desc, description, tech_stack, github_url, live_url, featured, sort_order, start_date)
SELECT 'Associate Software Engineer - Full Stack Delivery',
       'Developed import microservices on a upscaling application.',
       '• Designed and shipped an import/export RESTful API using Java 8, Spring Data JPA, Hibernate and MySQL, later extracted into a
                      standalone microservice deployed on AWS.
                    • Built the matching React.js feature with import file-type and schema validation, improving data-entry reliability and cutting
                      malformed-import failures.
                    • Stepped into the engagement to close a client-side engineering gap — productive within one week and owning independent
                      deliverables by week two.
                    • Automated regression test cases with Playwright and TypeScript, increasing regression coverage and shortening the QA cycle.',
       'Java, Spring MVC, Spring boot, Spring Data JPA, Hibernate, Playwright, TypeScript, MySQL, AWS',
       'https://github.com/SwaroopAV21/javaProfile/',
       'NULL', false, 2, '2023-09-01'
WHERE NOT EXISTS (SELECT 1 FROM projects WHERE title = 'Associate Software Engineer - Full Stack Delivery');
INSERT INTO projects (title, short_desc, description, tech_stack, github_url, live_url, featured, sort_order, start_date)
SELECT 'Associate Software Engineer - Backend Development',
       'Developed backend RESTful APIs in Java 17 / Spring Boot and an CLI tool in C++ from scratch.',
       '• Designed and developed backend RESTful APIs in Java 17 / Spring Boot with Spring Data JPA, Hibernate and PostgreSQL,
                      applying multithreading for concurrent request handling on a shared server providing centralized database access across
                      products.
                    • Architected, built and optimized a multithreaded C++ CLI automation tool with full ownership of design and performance, reducing
                      testing turnaround time by 50%.
                    • Implemented extensible command handling using the Command and Factory design patterns, linked-list based structures and
                      thread-safe object-oriented design to encapsulate business logic and isolate it from transport concerns.
                    • Presented the solution prototype to senior client stakeholders, driving adoption into production and validating its technical and
                      business value.',
       'Java, Spring MVC, Spring boot, Spring Data JPA, Hibernate, Playwright, TypeScript, MySQL, AWS',
       'https://github.com/SwaroopAV21/javaProfile/',
       'NULL', false, 2, '2023-04-11'
    WHERE NOT EXISTS (SELECT 1 FROM projects WHERE title = 'Associate Software Engineer - Backend Development');

-- Experiences
INSERT INTO experiences (company, role, description, location, start_date, end_date, is_current, tech_used, sort_order)
SELECT 'Mphasis | Hewlett Packard Enterprise', 'Associate Software Engineer - Backend & Platform Ownership',
       'Backend-focused Software Engineer with 3.6 years of experience building production RESTful APIs and microservices in Java 8/17,
                Spring Boot, Spring Data JPA and Hibernate on PostgreSQL/MySQL. Embedded on-site with Hewlett Packard Enterprise (HPE)
                engineering teams, working directly alongside HPE stakeholders on day-to-day delivery. Applies multithreading and concurrency to
                high-throughput services, and owns delivery end to end — containerized builds with Docker, deployment to Kubernetes via ArgoCD
                GitOps, and GitHub Actions CI/CD on AWS. Also ships full-stack features with React.js/Angular and Python. Strong in system design,
                design patterns and OOP; architected and presented a tool to senior client stakeholders that was adopted into production.',
       'Bengaluru, India', '2023-04-11', '2026-10-17', false,
       'Java, Python, Go, C++, Spring boot JPA & Hibernate, Flask, NoSQL[ElasticSearch], postgreSQL, Git GitHubActions, Github Copilot, Angular, AWS, Docker, Kubernetes, ArgoCD', 1
WHERE NOT EXISTS (SELECT 1 FROM experiences WHERE company = 'Mphasis | Hewlett Packard Enterprise');
