# Null Safety Demo in Maven Project

This project demonstrates different scenarios for using **Null Safety** in a Maven-based Java project. The project contains three modules, each illustrating different aspects of Null Safety:

1. **module-nullability** - Demonstrating the usage of `@javax.annotation.ParametersAreNonnullByDefault` and how **SpotBugs** detects nullable annotations.
2. **module-openapi-nullability** - Demonstrating how **Swagger**-generated classes handle nullability, and how **SpotBugs** detects missing nullable annotations in optional fields.
3. **module-thymeleaf-nullability** - Checking if **Thymeleaf** templates properly handle nullable properties without proper null checking.
---

## Project Overview

This Maven-based project serves as a demonstration of various **null safety** techniques and how static analysis tools, like **SpotBugs**, can help detect potential issues in Java code.

In this project, we focus on:
- **Annotations** like `@ParametersAreNonnullByDefault` and nullable attributes.
- **Code analysis tools** like SpotBugs to detect issues related to nullability.
- **Auto-generated code**, such as Swagger-generated classes and Thymeleaf templates, and how they should adhere to null safety practices.

---
todo