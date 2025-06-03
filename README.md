# Null Safety Demo in Maven Project

This project demonstrates different scenarios for using **Null Safety** in a Maven-based Java project. The project contains modules illustrating different aspects of Null Safety:

1. **module-nullability** - Demonstrates the usage of `@javax.annotation.ParametersAreNonnullByDefault` and **SpotBugs** detection of violations.
2. **module-openapi-nullability** - Demonstrates how **Swagger**-generated classes handle nullability and  **SpotBugs** detection of violations.

---

## The Spotbugs Plugin

The [SpotBugs](https://spotbugs.github.io/) tool integrated as Maven Plugin allows to fail the build on bugs and vulnerabilities, and to generate a report with vulnerability
violations.

```
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-project-info-reports-plugin</artifactId>
  <version>3.9.0</version>
</plugin>
```

### Nullability Violations

The tool integrates with Nullability annotations from `Javax`/`Jakarta` and includes in the generated report Nullability Violations.

This Demo exploits such a feature to encourage the use of Nullability annotations.

### Enforcing Checks during Development

The SpotBugs plugin can be configured to run during the Maven build process and fail based on the severity of the issues found:

```xml

<plugin>
    <groupId>com.github.spotbugs</groupId>
    <artifactId>spotbugs-maven-plugin</artifactId>
    <executions>
        <!-- Always generate report -->
        <execution>
            <id>spotbugs-report</id>
            <phase>verify</phase>
            <goals>
                <goal>spotbugs</goal>
            </goals>
        </execution>
        <!-- Fail when verifying -->
        <execution>
            <id>spotbugs-check</id>
            <phase>verify</phase>
            <goals>
                <goal>check</goal>
            </goals>
            <configuration>
                <failOnError>true</failOnError>
                <threshold>high</threshold>
                <effort>Max</effort>
            </configuration>
        </execution>
    </executions>
</plugin>
```

#### Usage

```bash
mvn -fae clean verify
```

### Extend to Detect Security Vulnerabilities

The SpotBugs plugin can
be [extended to detect security vulnerabilities](https://spotbugs.readthedocs.io/en/latest/maven.html#integrate-find-security-bugs-into-spotbugs-maven-plugin) with:

```xml

<configuration>
    <plugins>
        <plugin>
            <groupId>com.h3xstream.findsecbugs</groupId>
            <artifactId>findsecbugs-plugin</artifactId>
            <version>1.13.0</version>
        </plugin>
    </plugins>
</configuration>
```

### Enforcing Bug and Vulnerability Checks in CI/CD

The spotbugs report can be analysed in a CI/CD step to prevent merging potential bugs, or displayed in a dashboard for awareness.

Many CI/CD tools support integration with SpotBugs, allowing you to upload reports and annotate pull requests with findings.

- **GitHub Actions:** Use the `actions/upload-artifact` to store SpotBugs XML/HTML reports, and third-party actions to annotate pull requests with findings.
    - [jwgmeligmeyling/spotbugs-github-action](https://github.com/jwgmeligmeyling/spotbugs-github-action)
- **GitLab CI:** Upload SpotBugs reports as job artifacts and use the JUnit or Code Quality report features for integration.
    - [Import Code Quality results from a CI/CD job](https://docs.gitlab.com/ci/testing/code_quality/#import-code-quality-results-from-a-cicd-job)
    - [Static Application Security Testing (SAST)](https://docs.gitlab.com/user/application_security/sast/)
- **SonarQube:** Import SpotBugs results for advanced dashboards, history, and code quality gates.
    - [External Analyzer Reports - Importing reports from third-party tools](https://docs.sonarsource.com/sonarqube-server/10.3/analyzing-source-code/importing-external-issues/external-analyzer-reports/)
    - [sonar-findbugs plugin](https://github.com/spotbugs/sonar-findbugs)

---

## Project Overview

This Maven-based project serves as a demonstration of various **null safety** techniques and how static analysis tools, like **SpotBugs**, can help detect potential issues in Java
code.

### module-nullability

See [README.md](module-nullability/README.md) for details on how to use the SpotBugs plugin to detect nullability violations in Java code.

### module-openapi-nullability

See [README.md](module-openapi-nullability/README.md) for details on how to use the SpotBugs plugin to detect nullability violations in Swagger-generated classes.
