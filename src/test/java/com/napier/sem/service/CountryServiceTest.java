package com.napier.sem.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



class CountryServiceTest {
    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryService countryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTopNCountriesReturnsSortedList() {
       
        when(countryRepository.findAll()).thenReturn(List.of(
                new Country("AAA", "CountryA", "Asia", "RegionA", 1000L, 1),
                new Country("BBB", "CountryB", "Asia", "RegionA", 5000L, 2),
                new Country("CCC", "CountryC", "Asia", "RegionA", 2000L, 3)
        ));

     
        List<Country> top2 = countryService.getTopNCountries(2);

      
        assertNotNull(top2, "Result should not be null");
        assertEquals(2, top2.size(), "Expected two countries in top list");
        assertEquals("CountryB", top2.get(0).getName(), "Expected largest population first");
        assertEquals("CountryC", top2.get(1).getName(), "Expected second largest population next");

        verify(countryRepository, times(1)).findAll();
    }

    @Test
    void testGetTopNCountriesWithNExceedingListSize() {
        when(countryRepository.findAll()).thenReturn(List.of(
                new Country("AAA", "CountryA", "Asia", "RegionA", 1000L, 1),
                new Country("BBB", "CountryB", "Asia", "RegionA", 5000L, 2)
        ));

        List<Country> top5 = countryService.getTopNCountries(5);

        assertEquals(2, top5.size(), "Expected all countries returned when N exceeds list size");
    }

    @Test
    void testGetTopNCountriesEmptyList() {
        when(countryRepository.findAll()).thenReturn(List.of());

        List<Country> top = countryService.getTopNCountries(3);

        assertTrue(top.isEmpty(), "Expected empty list when repository has no countries");
    }

    @Test
    void testGetTopNCountriesWithZeroN() {
        when(countryRepository.findAll()).thenReturn(List.of(
                new Country("AAA", "CountryA", "Asia", "RegionA", 1000L, 1)
        ));

        List<Country> top0 = countryService.getTopNCountries(0);

        assertTrue(top0.isEmpty(), "Expected empty list when N=0");
    }
}


class Country {
    private final String code;
    private final String name;
    private final String continent;
    private final String region;
    private final long population;
    private final int capital;

    Country(String code, String name, String continent, String region, long population, int capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getContinent() { return continent; }
    public String getRegion() { return region; }
    public long getPopulation() { return population; }
    public int getCapital() { return capital; }
}

interface CountryRepository {
    List<Country> findAll();
}


class CountryService {
    private final CountryRepository repository;

    CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public List<Country> getTopNCountries(int n) {
        if (n <= 0) return List.of();
        return repository.findAll().stream()
                .sorted(Comparator.comparingLong(Country::getPopulation).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }
}
