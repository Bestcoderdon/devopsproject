-- All the countries in a continent organised by largest population to smallest.
SELECT Continent,  SUM(Population) Population
FROM Country
GROUP BY Continent
ORDER BY Population DESC
