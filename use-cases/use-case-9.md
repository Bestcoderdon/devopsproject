# USE CASE 9: Produce a Report with All the cities in a region organized by largest population to smallest.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user wants to retrieve and organize all cities within a specified region sorted by population size, from the largest to the smallest, to analyze urban population distribution and support regional demographic reporting.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The region is identified by the user.
- The system contains current and accurate population data for cities located in that region.

### vSUCCESS END CONDITION

The user receives a complete and population-sorted list of all cities in the selected region.

### FAILED END CONDITION

No report is generated if data is inaccessible, or retrieval fails.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

The user selects a region and requests a city population report sorted by size.

### MAIN SUCCESS SCENARIO

- The clerical user selects a region from a list of available options.
- The system retrieves population data for every city in the specified region.
- The system sorts cities by population in descending order.
- The sorted list of cities with their population figures is presented to the user.

### EXTENSIONS

- If data retrieval fails, the system notifies the user and terminates the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0