# USE CASE 18: Produce a Report with All the capital cities in a continent organized by largest population to smallest.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user wants to retrieve and organize all capital cities within a specified continent, ordered by population size from largest to smallest, to analyze demographic distribution among the continent's political centers.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The continent is specified by the user.
- The system contains current and accurate population data for the continent's capital cities.

### SUCCESS END CONDITION

The user obtains a list of all capital cities in the selected continent, sorted by population descending.

### FAILED END CONDITION

No report is generated if data is inaccessible, or an error occurs.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

User requests a population-ranked list of capital cities within a continent.

### MAIN SUCCESS SCENARIO

- The clerical user selects the continent from available options.
- The system retrieves population data for all capital cities within the selected continent.
- The system orders the capitals from largest to smallest population.
- The sorted list is presented to the user for analysis and reporting.

### EXTENSIONS

- If data retrieval encounters an error, the system notifies the user and halts the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0
