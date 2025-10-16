--The top N populated countries in a region where N is provided by the user.
SELECT *
FROM 
(
SELECT Name AS Country,Region,  SUM(Population) Population, ROW_NUMBER() OVER (PARTITION BY Region ORDER BY SUM(Population) DESC) RegionalRank
FROM Country
GROUP BY Name,Region
) query WHERE RegionalRank <= ?
