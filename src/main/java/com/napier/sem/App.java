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
        a.getPopulationByContinent();
        a.getPopulationByRegion();
        a.getPopulationByCountry();
        a.getWorldPopulation();
        a.getContinentPopulation();
        a.getPopulationOfRegion();
        a.getPopulationOfCountry();
        a.getPopulationOfDistrict();
        a.getPopulationOfCity();
        a.getChineseSpeakersByCountry();
        a.getEnglishSpeakersByCountry();
        a.getHindiSpeakersByCountry();
        a.getSpanishSpeakersByCountry();
        a.getArabicSpeakersByCountry();

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

            System.out.println();
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

    /**
     * Report23: Population of people, people living in cities, and people not living in cities in each continent.
     * Shows: Continent Name, Total Population, City Population (+%), Non-City Population (+%)
     */
    public void getPopulationByContinent()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get total population and city population by continent
            String strSelect =
                    "SELECT country.Continent AS Continent, " +
                            "SUM(country.Population) AS TotalPopulation, " +
                            "SUM(city.Population) AS CityPopulation, " +
                            "(SUM(country.Population) - SUM(city.Population)) AS NonCityPopulation, " +
                            "ROUND((SUM(city.Population) / SUM(country.Population)) * 100, 2) AS CityPercentage, " +
                            "ROUND(((SUM(country.Population) - SUM(city.Population)) / SUM(country.Population)) * 100, 2) AS NonCityPercentage " +
                            "FROM country " +
                            "LEFT JOIN city ON country.Code = city.CountryCode " +
                            "GROUP BY country.Continent " +
                            "ORDER BY SUM(country.Population) DESC;";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report23: Population distribution in each continent (Total, In Cities, Not In Cities)");

            // Print header
            System.out.println(String.format("%-20s %-20s %-25s %-25s",
                    "Continent", "Total Population", "In Cities (%, count)", "Not in Cities (%, count)"));

            // Loop through results and print each row
            while (rset.next())
            {
                String continent = rset.getString("Continent");
                long totalPop = rset.getLong("TotalPopulation");
                long cityPop = rset.getLong("CityPopulation");
                long nonCityPop = rset.getLong("NonCityPopulation");
                double cityPct = rset.getDouble("CityPercentage");
                double nonCityPct = rset.getDouble("NonCityPercentage");

                System.out.println(String.format("%-20s %-20d %-15d (%.2f%%)   %-15d (%.2f%%)",
                        continent, totalPop, cityPop, cityPct, nonCityPop, nonCityPct));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population by continent");
        }
    }

    /**
     * Report24: Get population details (total, city, non-city) for each region
     */
    public void getPopulationByRegion()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query
            String strSelect =
                    "SELECT " +
                            "country.Region AS Region, " +
                            "SUM(country.Population) AS TotalPopulation, " +
                            "SUM(city.Population) AS CityPopulation, " +
                            "ROUND((SUM(city.Population) / SUM(country.Population)) * 100, 2) AS CityPercentage, " +
                            "(SUM(country.Population) - SUM(city.Population)) AS NonCityPopulation, " +
                            "ROUND(((SUM(country.Population) - SUM(city.Population)) / SUM(country.Population)) * 100, 2) AS NonCityPercentage " +
                            "FROM country " +
                            "LEFT JOIN city ON country.Code = city.CountryCode " +
                            "GROUP BY country.Region " +
                            "ORDER BY TotalPopulation DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report24: Population of people, in cities, and not in cities (by Region)");

            // Print header
            System.out.println(String.format(
                    "%-30s %-20s %-20s %-10s %-20s %-10s",
                    "Region", "Total Pop", "City Pop", "%City", "Non-City Pop", "%Non-City"
            ));

            // Loop through results
            while (rset.next())
            {
                String region = rset.getString("Region");
                long totalPop = rset.getLong("TotalPopulation");
                long cityPop = rset.getLong("CityPopulation");
                double cityPct = rset.getDouble("CityPercentage");
                long nonCityPop = rset.getLong("NonCityPopulation");
                double nonCityPct = rset.getDouble("NonCityPercentage");

                System.out.println(String.format(
                        "%-30s %-20d %-20d %-10.2f %-20d %-10.2f",
                        region, totalPop, cityPop, cityPct, nonCityPop, nonCityPct
                ));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population by region");
        }

    }

    /**
     * Report25: Get population details (total, city, non-city) for each country
     */
    public void getPopulationByCountry()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query
            String strSelect =
                    "SELECT " +
                            "country.Name AS Country, " +
                            "country.Continent AS Continent, " +
                            "SUM(country.Population) AS TotalPopulation, " +
                            "SUM(city.Population) AS CityPopulation, " +
                            "ROUND((SUM(city.Population) / SUM(country.Population)) * 100, 2) AS CityPercentage, " +
                            "(SUM(country.Population) - SUM(city.Population)) AS NonCityPopulation, " +
                            "ROUND(((SUM(country.Population) - SUM(city.Population)) / SUM(country.Population)) * 100, 2) AS NonCityPercentage " +
                            "FROM country " +
                            "LEFT JOIN city ON country.Code = city.CountryCode " +
                            "GROUP BY country.Code, country.Name, country.Continent " +
                            "ORDER BY TotalPopulation DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report25: Population of people, in cities, and not in cities (by Country)");

            // Print header
            System.out.println(String.format(
                    "%-35s %-20s %-20s %-20s %-10s %-20s %-10s",
                    "Country", "Continent", "Total Pop", "City Pop", "%City", "Non-City Pop", "%Non-City"
            ));

            // Loop through results
            while (rset.next())
            {
                String country = rset.getString("Country");
                String continent = rset.getString("Continent");
                long totalPop = rset.getLong("TotalPopulation");
                long cityPop = rset.getLong("CityPopulation");
                double cityPct = rset.getDouble("CityPercentage");
                long nonCityPop = rset.getLong("NonCityPopulation");
                double nonCityPct = rset.getDouble("NonCityPercentage");

                System.out.println(String.format(
                        "%-35s %-20s %-20d %-20d %-10.2f %-20d %-10.2f",
                        country, continent, totalPop, cityPop, cityPct, nonCityPop, nonCityPct
                ));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population by country");
        }
    }

    /**
     * Report26: Get total population of the world
     */
    public void getWorldPopulation()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query
            String strSelect = "SELECT SUM(Population) AS WorldPopulation FROM country";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report26: Total Population of the World");

            // Print header
            System.out.println(String.format("%-20s", "World Population"));

            // Display result
            if (rset.next())
            {
                long worldPopulation = rset.getLong("WorldPopulation");
                System.out.println(String.format("%-20d", worldPopulation));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world population");
        }
    }

    /**
     * Report27: Get total population of a continent (e.g., Asia)
     */
    public void getContinentPopulation()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get the total population of a specific continent
            String strSelect = "SELECT Continent, SUM(Population) AS TotalPopulation "
                    + "FROM country "
                    + "WHERE Continent = 'Asia' "
                    + "GROUP BY Continent";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report27: Total Population of the Continent (Asia)");

            // Print header
            System.out.println(String.format("%-20s %-20s", "Continent", "Total Population"));

            // Display result
            if (rset.next())
            {
                String continent = rset.getString("Continent");
                long population = rset.getLong("TotalPopulation");

                System.out.println(String.format("%-20s %-20d", continent, population));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent population");
        }
    }

    /**
     * Report28: Get total population of a specific region (e.g., Middle East)
     */
    public void getPopulationOfRegion()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get the total population of a region
            String strSelect = "SELECT Region, SUM(Population) AS TotalPopulation "
                    + "FROM country "
                    + "WHERE Region = 'Middle East' "
                    + "GROUP BY Region";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report28: Total Population of the Region (Middle East)");
            System.out.println(String.format("%-25s %-20s", "Region", "Total Population"));

            // Loop through results
            while (rset.next())
            {
                String region = rset.getString("Region");
                long totalPopulation = rset.getLong("TotalPopulation");

                System.out.println(String.format("%-25s %-20d", region, totalPopulation));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population of region");
        }
    }

    /**
     * Report29: Get total population of a specific country (e.g., India)
     */
    public void getPopulationOfCountry()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get the total population of a country
            String strSelect = "SELECT Name AS Country, Population AS TotalPopulation "
                    + "FROM country "
                    + "WHERE Name = 'India'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report29: Total Population of the Country (India)");
            System.out.println(String.format("%-40s %-20s", "Country", "Total Population"));

            // Loop through results
            while (rset.next())
            {
                String country = rset.getString("Country");
                long totalPopulation = rset.getLong("TotalPopulation");

                System.out.println(String.format("%-40s %-20d", country, totalPopulation));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population of country");
        }
    }

    /**
     * Report30: Get total population of a specific district (e.g., Istanbul)
     */
    public void getPopulationOfDistrict()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get the total population of a district
            String strSelect = "SELECT District, SUM(Population) AS TotalPopulation "
                    + "FROM city "
                    + "WHERE District = 'Istanbul' "
                    + "GROUP BY District";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report30: Total Population of the District (Istanbul)");
            System.out.println(String.format("%-25s %-20s", "District", "Total Population"));

            // Loop through results
            while (rset.next())
            {
                String district = rset.getString("District");
                long totalPopulation = rset.getLong("TotalPopulation");

                System.out.println(String.format("%-25s %-20d", district, totalPopulation));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population of district");
        }
    }

    /**
     * Report31: Get total population of a specific city (e.g., Herat)
     */
    public void getPopulationOfCity()
    {
        try
        {
            // Create SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get the population of a city
            String strSelect = "SELECT Name AS City, Population AS TotalPopulation "
                    + "FROM city "
                    + "WHERE Name = 'Herat'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report31: Total Population of the City (Herat)");
            System.out.println(String.format("%-30s %-20s", "City", "Total Population"));

            // Loop through results
            while (rset.next())
            {
                String city = rset.getString("City");
                long totalPopulation = rset.getLong("TotalPopulation");

                System.out.println(String.format("%-30s %-20d", city, totalPopulation));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population of city");
        }
    }

    /**
     * Report32: Number of people who speak Chinese in each country, ordered from greatest to smallest,
     * including percentage of the world population.
     */
    public void getChineseSpeakersByCountry() {
        try {
            Statement stmt = con.createStatement();

            // SQL query: calculate number of Chinese speakers per country and world percentage
            String strSelect = "SELECT c.Name AS CountryName, "
                    + "cl.Percentage, "
                    + "ROUND((cl.Percentage / 100) * c.Population) AS ChineseSpeakers, "
                    + "ROUND(((cl.Percentage / 100) * c.Population / "
                    + "(SELECT SUM(Population) FROM country)) * 100, 4) AS WorldPercentage "
                    + "FROM countrylanguage cl "
                    + "JOIN country c ON cl.CountryCode = c.Code "
                    + "WHERE cl.Language = 'Chinese' "
                    + "ORDER BY ChineseSpeakers DESC";

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report32: Number of people who speak Chinese by country (largest to smallest)");
            System.out.println(String.format("%-40s %-15s %-20s %-20s", "Country", "Percentage", "Speakers", "World %"));

            while (rset.next()) {
                String countryName = rset.getString("CountryName");
                double percentage = rset.getDouble("Percentage");
                long speakers = rset.getLong("ChineseSpeakers");
                double worldPercent = rset.getDouble("WorldPercentage");

                System.out.println(String.format("%-40s %-15.1f %-20d %-20.4f",
                        countryName, percentage, speakers, worldPercent));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Chinese speakers");
        }
    }

    /**
     * Report33: Number of people who speak English in each country, ordered from greatest to smallest,
     * including percentage of the world population.
     */
    public void getEnglishSpeakersByCountry() {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT c.Name AS CountryName, "
                    + "cl.Percentage, "
                    + "ROUND((cl.Percentage / 100) * c.Population) AS EnglishSpeakers, "
                    + "ROUND(((cl.Percentage / 100) * c.Population / "
                    + "(SELECT SUM(Population) FROM country)) * 100, 4) AS WorldPercentage "
                    + "FROM countrylanguage cl "
                    + "JOIN country c ON cl.CountryCode = c.Code "
                    + "WHERE cl.Language = 'English' "
                    + "ORDER BY EnglishSpeakers DESC";

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report33: Number of people who speak English by country (largest to smallest)");
            System.out.println(String.format("%-40s %-15s %-20s %-20s", "Country", "Percentage", "Speakers", "World %"));

            while (rset.next()) {
                String countryName = rset.getString("CountryName");
                double percentage = rset.getDouble("Percentage");
                long speakers = rset.getLong("EnglishSpeakers");
                double worldPercent = rset.getDouble("WorldPercentage");

                System.out.println(String.format("%-40s %-15.1f %-20d %-20.4f",
                        countryName, percentage, speakers, worldPercent));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get English speakers");
        }
    }

    /**
     * Report34: Number of people who speak Hindi in each country, ordered from greatest to smallest,
     * including percentage of the world population.
     */
    public void getHindiSpeakersByCountry() {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT c.Name AS CountryName, "
                    + "cl.Percentage, "
                    + "ROUND((cl.Percentage / 100) * c.Population) AS HindiSpeakers, "
                    + "ROUND(((cl.Percentage / 100) * c.Population / "
                    + "(SELECT SUM(Population) FROM country)) * 100, 4) AS WorldPercentage "
                    + "FROM countrylanguage cl "
                    + "JOIN country c ON cl.CountryCode = c.Code "
                    + "WHERE cl.Language = 'Hindi' "
                    + "ORDER BY HindiSpeakers DESC";

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report34: Number of people who speak Hindi by country (largest to smallest)");
            System.out.println(String.format("%-40s %-15s %-20s %-20s", "Country", "Percentage", "Speakers", "World %"));

            while (rset.next()) {
                String countryName = rset.getString("CountryName");
                double percentage = rset.getDouble("Percentage");
                long speakers = rset.getLong("HindiSpeakers");
                double worldPercent = rset.getDouble("WorldPercentage");

                System.out.println(String.format("%-40s %-15.1f %-20d %-20.4f",
                        countryName, percentage, speakers, worldPercent));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Hindi speakers");
        }
    }

    /**
     * Report35: Number of people who speak Spanish in each country, ordered from greatest to smallest,
     * including percentage of the world population.
     */
    public void getSpanishSpeakersByCountry() {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT c.Name AS CountryName, "
                    + "cl.Percentage, "
                    + "ROUND((cl.Percentage / 100) * c.Population) AS SpanishSpeakers, "
                    + "ROUND(((cl.Percentage / 100) * c.Population / "
                    + "(SELECT SUM(Population) FROM country)) * 100, 4) AS WorldPercentage "
                    + "FROM countrylanguage cl "
                    + "JOIN country c ON cl.CountryCode = c.Code "
                    + "WHERE cl.Language = 'Spanish' "
                    + "ORDER BY SpanishSpeakers DESC";

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report35: Number of people who speak Spanish by country (largest to smallest)");
            System.out.println(String.format("%-40s %-15s %-20s %-20s", "Country", "Percentage", "Speakers", "World %"));

            while (rset.next()) {
                String countryName = rset.getString("CountryName");
                double percentage = rset.getDouble("Percentage");
                long speakers = rset.getLong("SpanishSpeakers");
                double worldPercent = rset.getDouble("WorldPercentage");

                System.out.println(String.format("%-40s %-15.1f %-20d %-20.4f",
                        countryName, percentage, speakers, worldPercent));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Spanish speakers");
        }
    }

    /**
     * Report36: Number of people who speak Arabic in each country, ordered from greatest to smallest,
     * including percentage of the world population.
     */
    public void getArabicSpeakersByCountry() {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT c.Name AS CountryName, "
                    + "cl.Percentage, "
                    + "ROUND((cl.Percentage / 100) * c.Population) AS ArabicSpeakers, "
                    + "ROUND(((cl.Percentage / 100) * c.Population / "
                    + "(SELECT SUM(Population) FROM country)) * 100, 4) AS WorldPercentage "
                    + "FROM countrylanguage cl "
                    + "JOIN country c ON cl.CountryCode = c.Code "
                    + "WHERE cl.Language = 'Arabic' "
                    + "ORDER BY ArabicSpeakers DESC";

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println();
            System.out.println("Report36: Number of people who speak Arabic by country (largest to smallest)");
            System.out.println(String.format("%-40s %-15s %-20s %-20s", "Country", "Percentage", "Speakers", "World %"));

            while (rset.next()) {
                String countryName = rset.getString("CountryName");
                double percentage = rset.getDouble("Percentage");
                long speakers = rset.getLong("ArabicSpeakers");
                double worldPercent = rset.getDouble("WorldPercentage");

                System.out.println(String.format("%-40s %-15.1f %-20d %-20.4f",
                        countryName, percentage, speakers, worldPercent));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Arabic speakers");
        }
    }


}

