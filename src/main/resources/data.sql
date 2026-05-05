-- Skills
INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'Java', 'Backend', 90, 'java', 1
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'Java');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'Spring Boot', 'Backend', 88, 'spring', 2
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'Spring Boot');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'Go', 'Backend', 75, 'go', 3
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'Go');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'PostgreSQL', 'Database', 85, 'postgresql', 4
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'PostgreSQL');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'React', 'Frontend', 80, 'react', 5
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'React');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'TypeScript', 'Frontend', 78, 'typescript', 6
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'TypeScript');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'Docker', 'DevOps', 72, 'docker', 7
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'Docker');

INSERT INTO skills (name, category, proficiency, icon_key, sort_order)
SELECT 'Git', 'DevOps', 90, 'git', 8
WHERE NOT EXISTS (SELECT 1 FROM skills WHERE name = 'Git');

-- Projects
INSERT INTO projects (title, short_desc, description, tech_stack, github_url, live_url, featured, sort_order, start_date)
SELECT 'Portfolio Backend',
       'RESTful API powering this portfolio site.',
       'A Spring Boot 3 REST API backed by PostgreSQL.',
       'Java 17, Spring Boot 3, PostgreSQL, Maven',
       'https://github.com/SwaroopAV21/javaProfile/',
       NULL, true, 1, '2024-01-01'
WHERE NOT EXISTS (SELECT 1 FROM projects WHERE title = 'Portfolio Backend');

INSERT INTO projects (title, short_desc, description, tech_stack, github_url, live_url, featured, sort_order, start_date)
SELECT 'E-Commerce Platform',
       'Full-stack e-commerce with cart and payments.',
       'Built with Spring Boot microservices architecture.',
       'Java, Spring Boot, React, PostgreSQL, Stripe',
       'https://github.com/SwaroopAV21/javaProfile/',
       'https://yourapp.com', true, 2, '2023-06-01'
WHERE NOT EXISTS (SELECT 1 FROM projects WHERE title = 'E-Commerce Platform');

-- Experiences
INSERT INTO experiences (company, role, description, location, start_date, end_date, is_current, tech_used, sort_order)
SELECT 'Your Company', 'Senior Software Engineer',
       'Led backend development for core product features.',
       'Bengaluru, India', '2022-07-01', NULL, true,
       'Java, Spring Boot, PostgreSQL, Docker', 1
WHERE NOT EXISTS (SELECT 1 FROM experiences WHERE company = 'Your Company');

INSERT INTO experiences (company, role, description, location, start_date, end_date, is_current, tech_used, sort_order)
SELECT 'Previous Corp', 'Software Engineer',
       'Built and maintained microservices for the payments platform.',
       'Bengaluru, India', '2020-08-01', '2022-06-30', false,
       'Java, Spring MVC, MySQL, Redis', 2
WHERE NOT EXISTS (SELECT 1 FROM experiences WHERE company = 'Previous Corp');