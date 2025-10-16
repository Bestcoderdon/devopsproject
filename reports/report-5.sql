--The top N populated countries in a continent where N is provided by the user.

SELECT *
FROM 
(
SELECT Continent,  SUM(Population) Population, ROW_NUMBER() OVER ( ORDER BY SUM(Population) DESC) ContinentRank
FROM Country
GROUP BY Continent
) query WHERE ContinentRank <= ?