# USE CASE 12: Produce a Report with the top N populated cities in the world where N is provided by the user.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user wants to generate a list of the top N most populated cities worldwide, where N is a number provided by the user, to gain insights into the largest urban populations globally.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The user specifies a valid number N for the top cities to retrieve.
- The system contains accurate, up-to-date population data for cities across the world.

### SUCCESS END CONDITION

The user receives a report listing the top N most populated cities in the world.

### FAILED END CONDITION

No report is produced if the input N is invalid or if data retrieval fails.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

User inputs the value of N and requests the top populated cities report.

### MAIN SUCCESS SCENARIO

- User specifies the value of (N).
- The system retrieves data of all cities and their populations.
- The system sorts the cities based on their population, from largest to smallest.
- The system selects the top (N) cities based on the user-provided value.
- The sorted list of the top (N) populated cities along with their populations is presented to the user.

### EXTENSIONS

- If N is missing or invalid, the system prompts the user for a valid input.
- If data retrieval encounters an error, the system notifies the user and stops the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0