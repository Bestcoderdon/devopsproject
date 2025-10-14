# Product Backlog  
**Population Reporting System – DevOps Implementation**  
**Module:** SET09803 DevOps  
**Lecturer:** Kevin Sim  
**Date:** 08 October 2025  
**Team:** Population Reporting Scrum Team  

---

## E1. Platform & Data Access

| ID | Story Title | Acceptance Criteria | Priority | SP | Deps | Status |
|----|--------------|--------------------|-----------|----|------|--------|
| 1 | Git repo & GitFlow | Repo exists; branches master, develop, release; CODEOWNERS & PR template; Conventional Commits; README with run/test. | Must | 3 | — | Done |
| 2 | Maven build to self-contained JAR | `mvn package` outputs runnable JAR; `java -jar app.jar` starts. | Must | 3 | 1 | Done |
| 3 | Dockerfile & .dockerignore | Multi-stage build; healthcheck; `docker run` works locally. | Must | 5 | 2 | Done |
| 4 | GitHub Actions — build & unit test | CI triggers on PR/main; caches deps; uploads test reports; status badges in README. | Must | 5 | 2 | Done |
| 5 | Database connectivity (MySQL world) | Config via env vars; `.env.example` provided; secrets not in repo. | Must | 3 | 2 | Done |
