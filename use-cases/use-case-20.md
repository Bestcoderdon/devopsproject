# USE CASE 20: Produce a Report with the top N populated capital cities in the world where N is provided by the user.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user wants to generate a list of the top N most populated capital cities worldwide, where N is a number specified by the user. This list helps provide focused insights into the largest urban political centers globally.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The user provides a valid number N indicating how many top populated capital cities to retrieve.
- The system contains current and accurate population data for capital cities worldwide.

### SUCCESS END CONDITION

The user receives a population list of the top N capital cities in the world, ordered from largest to smallest population.

### FAILED END CONDITION

No report is generated if the input N is invalid, or data retrieval fails.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

User inputs the value of N and requests the top populated capital cities report.

### MAIN SUCCESS SCENARIO

- The user specifies the number N to define the size of the top cities list they want.
- The system accesses up-to-date population data for all capital cities globally.
- The system ranks the capital cities by population from highest to lowest and selects the top N.
- The sorted list is presented to the user.

### EXTENSIONS

- If N is missing or invalid, the system prompts the user for valid input.
- If data retrieval errors occur, the system notifies the user and stops the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0