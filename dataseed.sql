-- ============================================================
-- Portfolio Seed Data — run once after first startup
-- ============================================================

-- Skills
INSERT INTO skills (name, category, proficiency, icon_key, sort_order) VALUES
  ('Java',        'Backend',  90, 'java',        1),
  ('Spring Boot', 'Backend',  88, 'spring',      2),
  ('Go',          'Backend',  75, 'go',          3),
  ('PostgreSQL',  'Database', 85, 'postgresql',  4),
  ('React',       'Frontend', 80, 'react',       5),
  ('TypeScript',  'Frontend', 78, 'typescript',  6),
  ('Docker',      'DevOps',   72, 'docker',      7),
  ('Git',         'DevOps',   90, 'git',         8),
  ('Maven',       'DevOps',   80, 'maven',       9),
  ('Linux',       'DevOps',   75, 'linux',      10)
ON CONFLICT DO NOTHING;

-- Projects
INSERT INTO projects (title, short_desc, description, tech_stack, github_url, live_url, featured, sort_order, start_date) VALUES
  ('Portfolio Backend',
   'RESTful API powering this portfolio site.',
   'A Spring Boot 3 REST API backed by PostgreSQL. Includes endpoints for projects, skills, experience, and a contact form with SMTP email delivery.',
   'Java 17, Spring Boot 3, PostgreSQL, Maven',
   'https://github.com/yourusername/portfolio-backend', NULL, true, 1, '2024-01-01'),

  ('E-Commerce Platform',
   'Full-stack e-commerce with cart and payments.',
   'Built with Spring Boot microservices architecture. Includes product catalog, cart, order management, and Stripe payment integration.',
   'Java, Spring Boot, React, PostgreSQL, Stripe',
   'https://github.com/yourusername/ecommerce', 'https://yourapp.com', true, 2, '2023-06-01'),

  ('CLI Task Manager',
   'Terminal-based task manager written in Go.',
   'A fast command-line productivity tool built in Go. Supports tags, priorities, due dates, and JSON export.',
   'Go, SQLite, Cobra CLI',
   'https://github.com/yourusername/taskcli', NULL, false, 3, '2023-11-01')
ON CONFLICT DO NOTHING;

-- Experiences
INSERT INTO experiences (company, role, description, location, start_date, end_date, is_current, tech_used, sort_order) VALUES
  ('Your Company', 'Senior Software Engineer',
   'Led backend development for core product features. Architected REST APIs serving 100k+ daily users. Mentored junior engineers and conducted code reviews.',
   'Bengaluru, India', '2022-07-01', NULL, true,
   'Java, Spring Boot, PostgreSQL, Docker, Kubernetes', 1),

  ('Previous Corp', 'Software Engineer',
   'Built and maintained microservices for the payments platform. Reduced API latency by 40%% through query optimization and caching.',
   'Bengaluru, India', '2020-08-01', '2022-06-30', false,
   'Java, Spring MVC, MySQL, Redis', 2),

  ('Startup XYZ', 'Junior Developer',
   'Full-stack development using Spring Boot and Angular. Delivered features end-to-end from design to deployment.',
   'Remote', '2019-01-01', '2020-07-31', false,
   'Java, Angular, MongoDB', 3)
ON CONFLICT DO NOTHING;