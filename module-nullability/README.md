# Nullability Example

This module shows a simple usage of the spotbugs plugin to detect nullability violations in Java code when using Javax annotations at module level.

## Description of the Example

1. The [package-info.java](src/main/java/edu/adarko22/package-info.java) is configured to enforce the annotation `@ParametersAreNonnullByDefault`.
2. The [NullabilityExample.java](src/main/java/edu/adarko22/NullabilityExample.java) violates this enforcement.
3. The build fails on the `verify` phase due to the SpotBugs plugin configuration!
4. The generated report [spotbugsXml.xml](target/spotbugsXml.xml), in the `site` phase, reports the violation.

## Spotbugs Report

Spotbugs generates a report when running `mvn clean verify`. The report is available in the `target/site/spotbugs.html` directory.