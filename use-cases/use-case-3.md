# USE CASE 3: Produce a Report on all Countries in a Region by Population from Largest to Smallest.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user aims to retrieve and sort all countries within a specified region by their population, from the largest to the smallest, to better understand demographic distribution in that region and support reporting or analysis.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The system has access to accurate and current population data for countries in that region.
- The user has specified the target region for the report.

### SUCCESS END CONDITION

The user obtains a complete list of countries in the region, sorted by population in descending order.

### FAILED END CONDITION

No report is produced if data retrieval fails or if the system is unable to access the necessary information.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

User selects a region and requests population data sorted by country population size.

### MAIN SUCCESS SCENARIO

- The clerical user selects a region from a provided list.
- The system retrieves population data for all countries in the chosen region.
- The system sorts the countries from the largest to the smallest population.
- The sorted list is presented to the user for review or distribution.

### EXTENSIONS

Condition Data retrieval error

Action The system informs the user about the error and halts the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0