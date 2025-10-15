# USE CASE 16: Produce a Report with the top N populated cities in a district where N is provided by the user.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user wants to generate a list of the top N most populated cities within a specified district, where N is a number provided by the user, to obtain detailed demographic information focused on urban centers in that district.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The user provides both the district and the number N of top cities to retrieve.
- The system contains accurate and up-to-date population data for cities within the district.

### SUCCESS END CONDITION

The user receives a sorted list of the top N most populated cities in the chosen district, ordered from largest to smallest population.

### FAILED END CONDITION

No list is produced if the input is invalid or if data retrieval fails.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

User specifies the district and the number N to retrieve the top populated cities.

### MAIN SUCCESS SCENARIO

- The user selects or enters the district of interest.
- The user provides the value of N for the top cities desired.
- The system retrieves population data for all cities within the specified district.
- The system sorts the cities from largest to smallest population and selects the top N cities.
- The sorted list is presented to the user for review or reporting.

### EXTENSIONS

- If N is missing or invalid, the system requests a valid input.
- If data retrieval encounters an error, the system notifies the user and halts the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0
