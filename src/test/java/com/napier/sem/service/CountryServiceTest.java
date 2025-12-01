package com.napier.sem.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.napier.sem.model.Country;
import com.napier.sem.repository.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

class CountryServiceTest {

    @Mock
    private CountryRepository countryRepository; // Repository mock

    @InjectMocks
    private CountryService countryService; // Service under test

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testTopNCountriesReturnsSortedList() {
        // Arrange: mock repository response
        when(countryRepository.findAll()).thenReturn(List.of(
                new Country("AAA", "CountryA", "Asia", "RegionA", 1000L, 1),
                new Country("BBB", "CountryB", "Asia", "RegionA", 5000L, 2),
                new Country("CCC", "CountryC", "Asia", "RegionA", 2000L, 3)
        ));

        // Act: call the service method
        List<Country> top2 = countryService.getTopNCountries(2);

        // Assert: verify results
        assertEquals(2, top2.size(), "Expected two countries in top list");
        assertEquals("CountryB", top2.get(0).getName(), "Expected largest population first");
        assertEquals("CountryC", top2.get(1).getName(), "Expected second largest population next");

        // Verify repository interaction
        verify(countryRepository, times(1)).findAll();
    }

    @Test
    void testGetTopNCountriesWithNExceedingListSize() {
        // Arrange
        when(countryRepository.findAll()).thenReturn(List.of(
                new Country("AAA", "CountryA", "Asia", "RegionA", 1000L, 1),
                new Country("BBB", "CountryB", "Asia", "RegionA", 5000L, 2)
        ));

        // Act
        List<Country> top5 = countryService.getTopNCountries(5);

        // Assert: should return all countries without error
        assertEquals(2, top5.size(), "Expected all countries returned when N exceeds list size");
    }

    @Test
    void testGetTopNCountriesEmptyList() {
        // Arrange
        when(countryRepository.findAll()).thenReturn(List.of());

        // Act
        List<Country> top = countryService.getTopNCountries(3);

        // Assert: empty list returned
        assertTrue(top.isEmpty(), "Expected empty list when repository has no countries");
    }

    @Test
    void testGetTopNCountriesWithZeroN() {
        // Arrange
        when(countryRepository.findAll()).thenReturn(List.of(
                new Country("AAA", "CountryA", "Asia", "RegionA", 1000L, 1)
        ));

        // Act
        List<Country> top0 = countryService.getTopNCountries(0);

        // Assert: empty list for N=0
        assertTrue(top0.isEmpty(), "Expected empty list when N=0");
    }
}
