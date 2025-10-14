# USE CASE 6:Produce a Report with the top N populated countries in a region where N is provided by the user.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user wants to generate a list of the top N countries by population within a specified region, where N is a number provided by the user, to gain focused demographic insights on that region.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The user specifies the region and the number N for the top countries to retrieve.
- The system holds accurate and current population data organized by region.

### SUCCESS END CONDITION

The user obtains a sorted list of the top N most populated countries in the chosen region.

### FAILED END CONDITION

No report is produced if the input is invalid or if data retrieval fails.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

User selects a region and specifies the value of N to generate the report.

### MAIN SUCCESS SCENARIO

- The user chooses a region from the list of available options.
- The user provides the number N representing how many top countries to include.
- The system retrieves population data for all countries in the specified region.
- The system sorts the data by population descending and selects the top N countries.
- The sorted list is displayed or delivered to the user.

### EXTENSIONS

- If N is missing or invalid, the system prompts the user to enter a valid number.
- If data access error occurs, the system notifies the user and aborts the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0