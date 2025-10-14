# USE CASE 4: Produce a Report with the top N populated countries in the world where N is provided by the user.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user wants to generate a list of the top N countries worldwide sorted by population size, where N is a number specified by the user, to deliver focused demographic insights based on the requested quantity.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The user provides a valid number N indicating how many top populated countries to retrieve.
- The system contains current and accurate population data for all countries.

### SUCCESS END CONDITION

The user receives a list of the top N most populated countries worldwide, ordered from highest to lowest population.

### FAILED END CONDITION

No list is generated if the input N is invalid, or data retrieval fails.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

The user inputs the value of N and requests the top N population data.

### MAIN SUCCESS SCENARIO

- The user specifies the value of N representing how many top countries to list.
- The system queries the database and retrieves population data for all countries.
- The system sort countries from largest to smallest population and selects the top N.
- The system presents the sorted list of top N populated countries to the user.

### EXTENSIONS

- If N is missing or invalid, the system prompts the user to enter a valid number.
- If there is a data retrieval error, the system notifies the user and halts the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0