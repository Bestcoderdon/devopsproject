# USE CASE 19: Produce a Report with All the capital cities in a region organized by largest to smallest.

## CHARACTERISTIC INFORMATION

### GOAL IN CONTEXT

A user wants to generate a list of all capital cities within a specified region, organized by population size from the largest to the smallest, to analyze demographic and urban trends in the political centers of the region.

### SCOPE

Population Reporting System within the company's data management platform.

### LEVEL

Primary task

### PRECONDITIONS

- The user specifies the target region.
- The system holds current and accurate population data for the capital cities in the region.

### SUCCESS END CONDITION

The user obtains a fully sorted list of capital cities in the region from largest to smallest population.

### FAILED END CONDITION

No report is generated if data is unavailable, or retrieval is unsuccessful.

### PRIMARY ACTOR

Clerical staff responsible for report generation

### TRIGGER

User requests a population-ranked list of capital cities within a region.

### MAIN SUCCESS SCENARIO

- The clerical user selects or specifies the region.
- The system retrieves current population data for all capital cities in the region.
- The data is sorted by population in descending order.
- The sorted list is presented to the user for analysis or reporting.

### EXTENSIONS

- If data retrieval errors occur, the system notifies the user and stops the process.

### SUB-VARIATIONS

None.

### SCHEDULE

DUE DATE: Release 1.0