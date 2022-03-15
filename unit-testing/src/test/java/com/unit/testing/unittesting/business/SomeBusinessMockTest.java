package com.unit.testing.unittesting.business;

import com.unit.testing.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SomeBusinessMockTest {
    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
        business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumFromSomeDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumFromSomeDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {7});
        business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumFromSomeDataService();
        int expectedResult = 7;
        assertEquals(expectedResult, actualResult);
    }
}
