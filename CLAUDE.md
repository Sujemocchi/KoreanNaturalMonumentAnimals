# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Language

- Write all responses, summaries and explanations to the user in **Korean**.
- Code, identifiers and commit messages may stay in English.

## Project

A website introducing Korean Natural Monuments (천연기념물) that are animals: list, detail, filter by category, and search.
This is a learning project, so keep the code simple and readable.

## Tech stack

- Kotlin 2.3, **Spring Boot 4.1.1** (not 3.x), Gradle Kotlin DSL (wrapper 9.7.1), Java 21
- Thymeleaf (server-side rendering), Spring Data JPA, H2 (in-memory), Bean Validation
- Styling: plain CSS without a framework, in `src/main/resources/static/css`
- Thymeleaf is **not in `build.gradle.kts` yet**. Add `org.springframework.boot:spring-boot-starter-thymeleaf` when the first view is built.

## Package structure

Base package: `com.example.KoreanNaturalMonumentAnimals`

- `domain`: entities and enums
- `repository`: JPA repositories
- `service`: business logic
- `controller`: web controllers (`@Controller`, returning views)
- Seed data: `src/main/resources/data.sql`

## Coding rules

- Use `data class` for everything except entities, and prefer immutable `val`.
- Use constructor injection only. Never use field injection.
- Keep logic out of controllers and delegate it to services.
- Pass DTOs to views, never entities.
- Implement one feature at a time. Don't add features that weren't requested.

## Data rules

- Never guess monument data (designation number, designation date, habitat, etc.). Leave an uncertain value empty and add a `TODO` comment.
- Reference source: 국가유산청 국가유산포털 (Korea Heritage Service portal).
- Use only images that are free of copyright issues. Otherwise use a placeholder.

## Commands

Use `.\gradlew.bat` in PowerShell, or `./gradlew` in Git Bash.

- Run: `./gradlew bootRun` → http://localhost:8080 (DevTools restarts the app on classpath changes)
- Test: `./gradlew test`
- Single test: `./gradlew test --tests "*ApplicationTests.contextLoads"`
- Build: `./gradlew build`

## Workflow

- After implementing, always confirm with `./gradlew build` that it compiles and the tests pass.
- Summarize the changes, and give the user a way to check them (URLs, etc.).

## Spring Boot 4 / Kotlin gotchas

- **Modular starters:** test starters are per feature (`spring-boot-starter-webmvc-test`, `spring-boot-starter-data-jpa-test`), and the H2 console is its own module (`spring-boot-h2console`). Don't assume Boot 3 artifact or package names.
- **Jackson 3:** packages are `tools.jackson.*`, not `com.fasterxml.jackson.*`. Annotations stay under `com.fasterxml.jackson.annotation`.
- **JPA:** `plugin.jpa` generates no-arg constructors, and `allOpen` opens `@Entity`, `@MappedSuperclass` and `@Embeddable` classes. Entities don't need the `open` modifier.
- **Compiler flags:** `-Xjsr305=strict` makes Spring's nullability annotations strict. `-Xannotation-default-target=param-property` means an annotation such as `@NotBlank` on a constructor property applies to the field without `@field:`.
- **H2:** the database is in-memory, so data resets on every restart. Seed it through `data.sql`. If entities create the tables, `spring.jpa.defer-datasource-initialization=true` is required.
