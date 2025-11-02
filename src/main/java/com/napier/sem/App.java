package com.napier.sem;

import java.sql.*;

/**
 * This class App will be used to connect the world database
 * and print output for reports.
 */
public class App
        /**
         * This method is used to initialize the app, call the database connect method,
         * the getallcountries method and the database disconnect method.
         */
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        a.getAllCountries();
        a.getCountriesContinent();
        a.getCountriesRegion();
        a.getTopFiveWorldCountries();
        a.getTopFiveContinentCountries();
        a.getTopFiveRegionCountries();
        a.getAllCities();
        a.getAllCitiesInAsia();
        a.getAllCitiesInMiddleEast();
        a.getAllCitiesInAruba();
        a.getAllCitiesInIstanbul();
        a.getTopFiveWorldCities();
        a.getTopFiveCitiesInAsia();
        a.getTopFiveCitiesInMiddleEast();
        a.getTopFiveCitiesInAngola();
        a.getTopFiveCitiesInBalkh();
        a.getAllCapitalCities();
        a.getAllCapitalCitiesInAsia();
        a.getAllCapitalCitiesInMiddleEast();
        a.getTopFiveCapitalCities();
        a.getTopFiveCapitalCitiesInAsia();
        a.getTopFiveCapitalCitiesInMiddleEast();

        // Disconnect from database
        a.disconnect();
    }
    /**
     * Connection to MySql database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 11;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database..");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false&allowPublicKeyRetrieval=true", "root", "example");
                System.out.println("Successfully connected.");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     *Report1. The getallcountries method to return all countries in the world
     * ordered by largest population to smallest
     */
    public void getAllCountries()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all countries in the world ordered by population descending
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital "
                    + "FROM country "
                    + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
System.out.println("Report1: All countries in the world, largest population to smallest");
            // Print header
            System.out.println(String.format("%-5s %-40s %-20s %-20s %-15s %-10s",
                    "Code", "Name", "Continent", "Region", "Population", "Capital"));

            // Loop through results and print each country
            while (rset.next())
            {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                int capital = rset.getInt("Capital");

                System.out.println(String.format("%-5s %-40s %-20s %-20s %-15d %-10d",
                        code, name, continent, region, population, capital));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries");
        }
    }

    /**
     * Report2. The getCountriesContinent method to return all countries in the continent Asia
     * ordered by largest population to smallest
     */
    public void getCountriesContinent()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all countries in a continent ordered by population descending
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital "
                    + "FROM country "
                    + "WHERE Continent = 'Asia' "
                    + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println();
            System.out.println("Report2: All countries in the continent Asia, largest population to smallest");
            // Print header
            System.out.println(String.format("%-5s %-40s %-20s %-20s %-15s %-10s",
                    "Code", "Name", "Continent", "Region", "Population", "Capital"));

            // Loop through results and print each country
            while (rset.next())
            {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                int capital = rset.getInt("Capital");

                System.out.println(String.format("%-5s %-40s %-20s %-20s %-15d %-10d",
                        code, name, continent, region, population, capital));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries in Asia");
        }
    }

    /**
     * Report3. The getCountriesRegion method to return all countries in the region Middle East
     * ordered by largest population to smallest
     */
    public void getCountriesRegion()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all countries in a region ordered by population descending
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital "
                    + "FROM country "
                    + "WHERE Region = 'Middle East' "
                    + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println();
            System.out.println("Report3: All countries in the region Middle East, largest population to smallest");
            // Print header
            System.out.println(String.format("%-5s %-40s %-20s %-20s %-15s %-10s",
                    "Code", "Name", "Continent", "Region", "Population", "Capital"));

            // Loop through results and print each country
            while (rset.next())
            {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                int capital = rset.getInt("Capital");

                System.out.println(String.format("%-5s %-40s %-20s %-20s %-15d %-10d",
                        code, name, continent, region, population, capital));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries in Middle East");
        }
    }

    /**
     * Report4. The getTopFiveWorldCountries method to return the top 5 largest populated countries in the world
     *
     */
    public void getTopFiveWorldCountries()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get top 5 countries in the world ordered by population descending
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital "
                    + "FROM country "
                    + "ORDER BY Population DESC "
                    + "LIMIT 5";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println();
            System.out.println("Report4: Top 5 world countries, largest population to smallest");
            // Print header
            System.out.println(String.format("%-5s %-40s %-20s %-20s %-15s %-10s",
                    "Code", "Name", "Continent", "Region", "Population", "Capital"));

            // Loop through results and print each country
            while (rset.next())
            {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                int capital = rset.getInt("Capital");

                System.out.println(String.format("%-5s %-40s %-20s %-20s %-15d %-10d",
                        code, name, continent, region, population, capital));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top 5 populated countries in the world");
        }
    }

    /**
     * Report5. The getTopFiveContinentCountries method to return the top 5 largest populated countries in the continent Asia
     *
     */
    public void getTopFiveContinentCountries()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get top 5 countries in a continent ordered by population descending
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital "
                    + "FROM country "
                    + "WHERE Continent = 'Asia' "
                    + "ORDER BY Population DESC "
                    + "LIMIT 5";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println();
            System.out.println("Report5: Top 5 countries in the continent Asia, largest population to smallest");
            // Print header
            System.out.println(String.format("%-5s %-40s %-20s %-20s %-15s %-10s",
                    "Code", "Name", "Continent", "Region", "Population", "Capital"));

            // Loop through results and print each country
            while (rset.next())
            {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                int capital = rset.getInt("Capital");

                System.out.println(String.format("%-5s %-40s %-20s %-20s %-15d %-10d",
                        code, name, continent, region, population, capital));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top 5 populated countries in the continent Asia");
        }
    }

    /**
     * Report6. The getTopFiveRegionCountries method to return the top 5 largest populated countries in the region Middle East
     *
     */
    public void getTopFiveRegionCountries()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get top 5 countries in a region ordered by population descending
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital "
                    + "FROM country "
                    + "WHERE Region = 'Middle East' "
                    + "ORDER BY Population DESC "
                    + "LIMIT 5";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println();
            System.out.println("Report6: Top 5 countries in the region Middle East, largest population to smallest");
            // Print header
            System.out.println(String.format("%-5s %-40s %-20s %-20s %-15s %-10s",
                    "Code", "Name", "Continent", "Region", "Population", "Capital"));

            // Loop through results and print each country
            while (rset.next())
            {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                int capital = rset.getInt("Capital");

                System.out.println(String.format("%-5s %-40s %-20s %-20s %-15d %-10d",
                        code, name, continent, region, population, capital));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top 5 populated countries in the region Middle East");
        }
    }

    /**
     * Report7. The getAllCities method returns all cities in the world
     * ordered by largest population to smallest.
     */
    public void getAllCities()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all cities with their country names, ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, " +
                    "city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.Code " +
                    "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println();
            System.out.println("Report7: All cities in the world, largest population to smallest");

            // Print header
            System.out.println(String.format("%-35s %-35s %-25s %-15s",
                    "City", "Country", "District", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                String district = rset.getString("District");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-35s %-35s %-25s %-15d",
                        cityName, countryName, district, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities");
        }
    }

    /**
     * Report8: Get all cities in a continent (Asia) ordered by largest population to smallest
     */
    public void getAllCitiesInAsia()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all cities in Asia ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.CountryCode = country.Code "
                    + "WHERE country.Continent = 'Asia' "
                    + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report8: All cities in Asia, largest population to smallest");

            // Print header
            System.out.println(String.format("%-30s %-40s %-25s %-15s",
                    "City Name", "Country", "District", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                String district = rset.getString("District");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-30s %-40s %-25s %-15d",
                        cityName, countryName, district, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in Asia");
        }
    }

    /**
     * Report9: Get all cities in the region Middle East ordered by largest population to smallest
     */
    public void getAllCitiesInMiddleEast()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all cities in the Middle East ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.CountryCode = country.Code "
                    + "WHERE country.Region = 'Middle East' "
                    + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report9: All cities in the region Middle East, largest population to smallest");

            // Print header
            System.out.println(String.format("%-30s %-40s %-25s %-15s",
                    "City Name", "Country", "District", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                String district = rset.getString("District");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-30s %-40s %-25s %-15d",
                        cityName, countryName, district, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in the Middle East");
        }
    }

    /**
     * Report10: Get all cities in the country Aruba ordered by largest population to smallest
     */
    public void getAllCitiesInAruba()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all cities in Aruba ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.CountryCode = country.Code "
                    + "WHERE country.Name = 'Aruba' "
                    + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report10: All cities in the country Aruba, largest population to smallest");

            // Print header
            System.out.println(String.format("%-30s %-40s %-25s %-15s",
                    "City Name", "Country", "District", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                String district = rset.getString("District");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-30s %-40s %-25s %-15d",
                        cityName, countryName, district, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in Aruba");
        }
    }

    /**
     * Report11: Get all cities in the district Istanbul ordered by largest population to smallest
     */
    public void getAllCitiesInIstanbul()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all cities in the district Istanbul ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.CountryCode = country.Code "
                    + "WHERE city.District = 'Istanbul' "
                    + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report11: All cities in the district Istanbul, largest population to smallest");

            // Print header
            System.out.println(String.format("%-30s %-40s %-25s %-15s",
                    "City Name", "Country", "District", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                String district = rset.getString("District");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-30s %-40s %-25s %-15d",
                        cityName, countryName, district, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in district Istanbul");
        }
    }

    /**
     * Report12. The getTopFiveWorldCities method to return the top 5 largest populated cities in the world
     */
    public void getTopFiveWorldCities()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get top 5 cities in the world ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.CountryCode = country.Code "
                    + "ORDER BY city.Population DESC "
                    + "LIMIT 5";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println();
            System.out.println("Report12: Top 5 cities in the world, largest population to smallest");

            // Print header
            System.out.println(String.format("%-40s %-30s %-20s %-15s",
                    "City Name", "Country", "District", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                String district = rset.getString("District");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-40s %-30s %-20s %-15d",
                        cityName, countryName, district, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top 5 populated cities in the world");
        }
    }

    /**
     * Report13: Get top 5 cities in a continent (Asia) ordered by largest population to smallest
     */
    public void getTopFiveCitiesInAsia()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get top five cities in Asia ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.CountryCode = country.Code "
                    + "WHERE country.Continent = 'Asia' "
                    + "ORDER BY city.Population DESC "
                    + "LIMIT 5";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report13: All cities in Asia, largest population to smallest");

            // Print header
            System.out.println(String.format("%-30s %-40s %-25s %-15s",
                    "City Name", "Country", "District", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                String district = rset.getString("District");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-30s %-40s %-25s %-15d",
                        cityName, countryName, district, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top 5 cities in Asia");
        }
    }

    /**
     * Report14: Get top 5 cities in the region Middle East ordered by largest population to smallest
     */
    public void getTopFiveCitiesInMiddleEast()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get top five cities in the Middle East ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.CountryCode = country.Code "
                    + "WHERE country.Region = 'Middle East' "
                    + "ORDER BY city.Population DESC "
                    + "LIMIT 5";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report14: Top five cities in the region Middle East, largest population to smallest");

            // Print header
            System.out.println(String.format("%-30s %-40s %-25s %-15s",
                    "City Name", "Country", "District", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                String district = rset.getString("District");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-30s %-40s %-25s %-15d",
                        cityName, countryName, district, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top five cities in the Middle East");
        }
    }

    /**
     * Report15: Get top five cities in the country Angola ordered by largest population to smallest
     */
    public void getTopFiveCitiesInAngola()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get top five cities in Angola ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.CountryCode = country.Code "
                    + "WHERE country.Name = 'Angola' "
                    + "ORDER BY city.Population DESC "
                    +"LIMIT 5";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report15: Top Five cities in the country Angola, largest population to smallest");

            // Print header
            System.out.println(String.format("%-30s %-40s %-25s %-15s",
                    "City Name", "Country", "District", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                String district = rset.getString("District");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-30s %-40s %-25s %-15d",
                        cityName, countryName, district, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top five cities in Angola");
        }
    }

    /**
     * Report16: Get top five cities in the district Balkh ordered by largest population to smallest
     */
    public void getTopFiveCitiesInBalkh()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get top five cities in the district Balkh ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.CountryCode = country.Code "
                    + "WHERE city.District = 'Balkh' "
                    + "ORDER BY city.Population DESC "
                    +"LIMIT 5";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report16: Top five cities in the district Balkh, largest population to smallest");

            // Print header
            System.out.println(String.format("%-30s %-40s %-25s %-15s",
                    "City Name", "Country", "District", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                String district = rset.getString("District");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-30s %-40s %-25s %-15d",
                        cityName, countryName, district, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top five cities in district Balkh");
        }
    }

    /**
     * Report17: Get all capital cities in the world ordered by largest population to smallest
     *
     */
    public void getAllCapitalCities()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all capital cities ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.ID = country.Capital "
                    + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report17: All capital cities in the world, largest population to smallest");

            // Print header
            System.out.println(String.format("%-35s %-35s %-15s",
                    "City Name", "Country", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-35s %-35s %-15d",
                        cityName, countryName, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities");
        }
    }

    /**
     * Report18: Get all capital cities in the continent Asia ordered by largest population to smallest
     *
     */
    public void getAllCapitalCitiesInAsia()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all capital cities in the continent Asia ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.ID = country.Capital "
                    + "WHERE country.Continent = 'Asia' "
                    + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report18: All capital cities in Asia, largest population to smallest");

            // Print header
            System.out.println(String.format("%-35s %-35s %-15s",
                    "City Name", "Country", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-35s %-35s %-15d",
                        cityName, countryName, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities in Asia");
        }
    }

    /**
     * Report19: Get all capital cities in the region Middle East ordered by largest population to smallest
     *
     */
    public void getAllCapitalCitiesInMiddleEast()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all capital cities in the region Middle East ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.ID = country.Capital "
                    + "WHERE country.Region = 'Middle East' "
                    + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report19: All capital cities in the Middle East, largest population to smallest");

            // Print header
            System.out.println(String.format("%-35s %-35s %-15s",
                    "City Name", "Country", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-35s %-35s %-15d",
                        cityName, countryName, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities in the Middle East");
        }
    }

    /**
     * Report20: Get top five capital cities in the world ordered by largest population to smallest
     *
     */
    public void getTopFiveCapitalCities()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get top five capital cities ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.ID = country.Capital "
                    + "ORDER BY city.Population DESC "
                    + "LIMIT 5";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report20: Top five capital cities in the world, largest population to smallest");

            // Print header
            System.out.println(String.format("%-35s %-35s %-15s",
                    "City Name", "Country", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-35s %-35s %-15d",
                        cityName, countryName, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top five capital cities in the world");
        }
    }

    /**
     * Report21: Get top five capital cities in the continent Asia ordered by largest population to smallest
     *
     */
    public void getTopFiveCapitalCitiesInAsia()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get top five capital cities in the continent Asia ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.ID = country.Capital "
                    + "WHERE country.Continent = 'Asia' "
                    + "ORDER BY city.Population DESC "
                    + "LIMIT 5";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report21: Top five capital cities in Asia, largest population to smallest");

            // Print header
            System.out.println(String.format("%-35s %-35s %-15s",
                    "City Name", "Country", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-35s %-35s %-15d",
                        cityName, countryName, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top five capital cities in Asia");
        }
    }

    /**
     * Report22: Get top five capital cities in the region Middle East ordered by largest population to smallest
     *
     */
    public void getTopFiveCapitalCitiesInMiddleEast()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get top five capital cities in the region Middle East ordered by population descending
            String strSelect = "SELECT city.Name AS CityName, country.Name AS CountryName, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.ID = country.Capital "
                    + "WHERE country.Region = 'Middle East' "
                    + "ORDER BY city.Population DESC "
                    + "LIMIT 5";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report22: Top five capital cities in the Middle East, largest population to smallest");

            // Print header
            System.out.println(String.format("%-35s %-35s %-15s",
                    "City Name", "Country", "Population"));

            // Loop through results and print each city
            while (rset.next())
            {
                String cityName = rset.getString("CityName");
                String countryName = rset.getString("CountryName");
                int population = rset.getInt("Population");

                System.out.println(String.format("%-35s %-35s %-15d",
                        cityName, countryName, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top five capital cities in the Middle East");
        }
    }

}

