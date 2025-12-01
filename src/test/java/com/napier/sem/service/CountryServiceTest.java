package com.napier.sem.service;

import com.napier.sem.model.Country;
import com.napier.sem.repository.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests for CountryService
 */
class CountryServiceTest {

    @Mock
    private CountryRepository countryRepository; // mock repository

    @InjectMocks
    private CountryService countryService; // service under test

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // initialize mocks
    }

    @Test
    void testTopNCountriesReturnsSortedList() {
        // Arrange: mock repository returns sample countries
        when(countryRepository.findAll()).thenReturn(List.of(
                new Country("AAA", "CountryA", "Asia", "RegionA", 1000L, 1),
                new Country("BBB", "CountryB", "Asia", "RegionA", 5000L, 2),
                new Country("CCC", "CountryC", "Asia", "RegionA", 2000L, 3)
        ));

        // Act
        List<Country> top2 = countryService.getTopNCountries(2);

        // Assert
        assertEquals(2, top2.size(), "Expected two countries in top list");
        assertEquals("CountryB", top2.get(0).getName(), "Expected largest population first");
        assertEquals("CountryC", top2.get(1).getName(), "Expected second largest population next");

        // Verify interaction with repository
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
