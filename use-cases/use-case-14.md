# USE CASE 14: Produce a Report with the top N populated cities in a region where N is provided by the user.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user wants to generate a list of the top N most populated cities within a specific region, where N is provided by the user, to gain focused demographic insights for that region.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The user specifies the region and the number N of top cities to retrieve.
- The system contains current, accurate population data for cities within the specified region.

### SUCCESS END CONDITION

The user receives a list of the top N most populated cities in the chosen region, sorted from largest to smallest population.

### FAILED END CONDITION

No report is generated if input data is invalid or if the data retrieval process fails.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

User selects a region and inputs the number N to generate the top N cities population report.

### MAIN SUCCESS SCENARIO

- The user selects a region from the available options.
- The user provides the number N specifying the desired count of top cities.
- The system retrieves population data for all cities within the chosen region.
- The system sorts the cities by population descending and selects the top N entries.
- The sorted list is presented to the user for analysis or reporting.

### EXTENSIONS

- If N is invalid or missing, the system prompts the user to provide a valid number.
- If there is a data retrieval error, the system notifies the user and aborts the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0
