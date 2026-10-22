---
applyTo: '**/*.{java,kt,js,ts,tsx,jsx,py,go,rs,cs,php,rb,yml,yaml,properties,json,md}'
---
You are working in a Java/Spring Boot project and must prioritize correctness, security, and reliability.

Always check for:
- Syntax correctness and compile-time issues before finalizing any code change.
- Invalid imports, missing types, wrong method signatures, bad annotations, and broken configuration keys.
- Potential memory leaks, especially in loops, long-lived objects, caching, listeners, streams, database sessions, thread usage, and static state.
- Resource leaks such as unclosed streams, sockets, DB connections, file handles, and background tasks.
- Vulnerabilities including SQL injection, command injection, insecure deserialization, unsafe file handling, unsafe logging, hardcoded secrets, weak validation, and improper authentication/authorization.
- Secret exposure such as API keys, passwords, tokens, private keys, connection strings, and credentials in source, configs, logs, comments, or test data.
- Misconfiguration risks in environment variables, Docker, and deployment settings.

Coding guidance:
- Prefer secure, minimal, explicit code over clever or overly abstract solutions.
- Validate all user-controlled input.
- Never commit secrets or placeholder credentials into code, config files, or docs.
- Avoid storing sensitive values in logs, exceptions, or debug output.
- Use proper exception handling and avoid swallowing errors silently.
- Keep object lifetimes short unless required by design; remove listeners, timers, and references when no longer needed.
- Use dependency injection and existing project patterns instead of ad hoc singletons or global mutable state.
- Keep code readable, maintainable, and consistent with the project’s existing conventions.
- Before finalizing, review for correctness, security, and memory/resource safety.

When generating or reviewing code, call out:
- syntax issues,
- potential memory leaks,
- security vulnerabilities,
- exposed secrets,
- risky configuration patterns.

If a fix requires a secret or credential, use environment variables or secure secret management and do not hardcode them.
