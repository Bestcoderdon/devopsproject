# USE CASE 8: Produce a Report with All the cities in a continent organized by largest population to smallest.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user aims to retrieve and organize all cities within a specific continent, sorted by population size from the largest to the smallest, to analyze urban demographic patterns regionally.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The continent is specified by the user.
- The system contains accurate, current population data for cities within the continent.

### SUCCESS END CONDITION

The user receives a complete and ordered list of cities in the specified continent by descending population.

### FAILED END CONDITION

The report is not produced if the data cannot be accessed or an error interrupts the retrieval process.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

User requests a list of cities within a selected continent ordered by population.

### MAIN SUCCESS SCENARIO

- The clerical user selects a continent from available options.
- The system retrieves population data for all cities in the chosen continent.
- The system sorts the cities from largest to smallest population.
- The sorted list is presented to the user for use in reporting or analysis.

### EXTENSIONS

- If there is a data retrieval error, the system notifies the user and cancels the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0