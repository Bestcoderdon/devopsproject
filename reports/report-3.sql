--All the countries in a region organised by largest population to smallest.
SELECT Region,  SUM(Population) Population
FROM Country
GROUP BY Region
ORDER BY Population DESC