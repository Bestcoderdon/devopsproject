# USE CASE 13: Produce a Report with the top N populated cities in a continent where N is provided by the user.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user wants to generate a list of the top N most populated cities within a specific continent, where N is provided by the user, to gain focused demographic insights for that continent.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The user specifies the continent and the number N of top cities to retrieve.
- The system holds accurate and current population data for cities within each continent.

### SUCCESS END CONDITION

The user obtains a sorted list of the top N most populous cities in the selected continent, ordered from largest to smallest population.

### FAILED END CONDITION

No report is produced if inputs are invalid, or data retrieval fails.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

User selects a continent and specifies the value of N to generate the top N cities list.

### MAIN SUCCESS SCENARIO

- The user selects a continent from available choices.
- The user provides the desired number N of top cities.
- The system retrieves population data of all cities within that continent.
- The system sorts cities by population in descending order and returns the top N entries.
- The system presents the sorted list to the user.

### EXTENSIONS

- If N is invalid or missing, the system prompts for correct input.
- If data retrieval errors occur, the system notifies the user and cancels the operation.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0
