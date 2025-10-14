# USE CASE 10: Produce a Report with All the cities in a country organized by largest population to smallest.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user needs to generate a report listing all cities within a specified country, ordered by their population size from the largest to smallest, to help analyze urban population distribution across that country.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The country is specified by the user.
- The system contains accurate and up-to-date population data for cities in that country.

### SUCCESS END CONDITION

The user receives a complete list of all cities in the country, sorted by population from largest to smallest.

### FAILED END CONDITION

The report is not produced if data is missing or cannot be retrieved.

### PRIMARY ACTO

Clerical staff responsible for report generation

### TRIGGER

User requests a city population report ordered by size for a particular country.

### MAIN SUCCESS SCENARIO

- The user selects a country from an available list.
- The system retrieves population data for all cities within the selected country.
- The system sorts the cities by population in descending order.
- The sorted list is displayed or provided to the user for reporting or analysis.

### EXTENSIONS

- If data retrieval fails, the system notifies the user and terminates the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0