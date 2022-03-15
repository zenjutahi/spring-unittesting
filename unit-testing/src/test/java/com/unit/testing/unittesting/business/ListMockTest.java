package com.unit.testing.unittesting.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {

    @Test
    public void size_basic() {
        List mock = mock(List.class);
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void returnDifferentValues() {
        List mock = mock(List.class);
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        List mock = mock(List.class);
        when(mock.get(0)).thenReturn("Learn Testing");
        assertEquals("Learn Testing",mock.get(0));
        assertEquals(null, mock.get(1));
    }
}