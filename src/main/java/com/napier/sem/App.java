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
        // Disconnect from database
        a.disconnect();
    }
    /**
     * Connection to MySQL database.
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

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false&allowPublicKeyRetrieval=true", "root", "example");
                System.out.println("Successfully connected");
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
}

