# USE CASE 2: Produce a Report on all the Countries in a Continent Organized by Largest Population to Smallest.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

The objective is for a user to retrieve and arrange population data (largest to smallest) of countries within a selected continent to analyze demographic trends and understand population distribution within that region.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The system has access to a validated dataset containing country and population information.
- The user has specified the target continent for the report.

### SUCCESS END CONDITION

The user obtains a population-sorted list of countries within the chosen continent.

### FAILED END CONDITION

The population list is not provided due to data access errors or dataset unavailability.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

The user selects a continent to generate a report listing countries ordered by population (largest to smallest).

### MAIN SUCCESS SCENARIO

- The user chooses a continent from the system's available options.
- The system retrieves population data for all countries in the selected continent.
- The data is sorted from highest to lowest population.
- The system displays the sorted list with corresponding population figures to the user.

### EXTENSIONS

- If data access error occurs, the system notifies the user and aborts the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0