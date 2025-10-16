--The top N populated countries in the world where N is provided by the user.
SELECT *
FROM 
(
SELECT Name AS Country,  Population, ROW_NUMBER() OVER ( ORDER BY Population DESC) CountryRank
FROM Country
GROUP BY  Name,  Population
) query WHERE CountryRank <= ?