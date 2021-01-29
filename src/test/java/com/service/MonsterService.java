package com.service;

// Adapted from https://github.com/in28minutes/SpringBootForBeginners/blob/96aac7f51218090c1fa45747b9b48de5e0faabac/04.Mockito-Introduction-In-5-Steps/src/test/java/com/in28minutes/mockito/mockitodemo/SomeBusinessMockAnnotationsTest.java
/*
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MonsterServiceTest {

    @Mock
    DataService dataServiceMock;

    @InjectMocks
    SomeBusinessImpl businessImpl;

    @Test
    public void testFindTheGreatestFromAllData() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });
        assertEquals(24, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    public void testFindTheGreatestFromAllData_ForOneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 15 });
        assertEquals(15, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    public void testFindTheGreatestFromAllData_NoValues() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }
}


 */