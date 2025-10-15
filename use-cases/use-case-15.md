# USE CASE 15: Produce a Report with the top N populated cities in a country where N is provided by the user.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user wants to generate a list of the top N most populated cities within a specific country, where N is provided by the user, to gain focused demographic insights for that country.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The user has specified both the country and the number N of top cities to retrieve.
- The system contains accurate and up-to-date population data on cities within the specified country.

### SUCCESS END CONDITION

The user receives a list of the top N cities in the country, sorted by population from largest to smallest.

### FAILED END CONDITION

No report is generated if the input is invalid, or data retrieval fails.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

User inputs the country name and the number N to request the top N cities report.

### MAIN SUCCESS SCENARIO

- The user selects or enters the country of interest.
- The user specifies the desired number N of top populated cities.
- The system accesses accurate population data for all cities in the country.
- The system sorts cities by population in descending order and selects the top N.
- The sorted list of top N cities is presented to the user for review or reporting.

### EXTENSIONS

- If N is invalid or missing, the system requests a valid input from the user.
- If data retrieval errors occur, the system notifies the user and cancels the operation.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0