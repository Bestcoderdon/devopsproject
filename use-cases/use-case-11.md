# USE CASE 11: Produce a Report with All the cities in a district organized by largest population to smallest.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user wants to obtain a complete list of all cities within a specific district, sorted in descending order by population, to help analyze population distribution at the district level.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The district is identified by the user.
- The system maintains accurate and up-to-date population data for cities within the district.

### SUCCESS END CONDITION

The user receives a fully ordered list of cities in the district, sorted from the largest to smallest population.

### FAILED END CONDITION

The report is not produced if data is unavailable, or retrieval is unsuccessful.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

User requests a population-sorted city list for a specified district.

### MAIN SUCCESS SCENARIO

- The clerical user selects or specifies the district of interest.
- The system retrieves population data for all cities within that district.
- The system sorts the cities from largest population to smallest.
- The sorted list is presented to the user for review or reporting.

### EXTENSIONS

- If a data retrieval error occurs, the system notifies the user and terminates the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0
