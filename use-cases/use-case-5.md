# USE CASE 5: Produce a Report with the top N populated countries in a continent where N is provided by the user.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user needs to obtain a list of the top N countries by population within a specific continent, where N is a user-defined number, to provide targeted demographic insights for that continent.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The user specifies both the continent and the number N of top countries to retrieve.
- The system has reliable and updated population data for all countries categorized by continent.

### SUCCESS END CONDITION

The user receives a list of the top N most populated countries in the chosen continent.

### FAILED END CONDITION

No populated country list is generated if input data is missing, invalid, or the system fails to retrieve the data.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

The user selects a continent and inputs the number N to generate the top N populated countries list.

### MAIN SUCCESS SCENARIO

- The user selects a continent from the available options.
- The user provides the desired value of N.
- The system retrieves all countries' population data within the selected continent.
- The system sorts countries by population in descending order and selects the top N.
- The system presents the resulting list to the user.

### EXTENSIONS

- If N is invalid or missing, the system requests a valid input from the user.
- If data retrieval fails, the system alerts the user and terminates the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0
