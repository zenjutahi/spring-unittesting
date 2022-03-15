package com.unit.testing.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic() {

        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("Learn Testing");
        assertEquals("Learn Testing",mock.get(0));
        assertEquals(null, mock.get(1));
    }

    // Argument Matchers
    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("Learn Testing");
        assertEquals("Learn Testing",mock.get(0));
        assertEquals("Learn Testing", mock.get(1));
    }

    @Test
    public void verificationBasics() {
        //SUT
        String Value1 = mock.get(0);
        String Value2 = mock.get(2);

        //Verify that a method is called
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(4);
    }

    @Test
    public void argumentCapturing() {
        // SUT
        mock.add("SomeArgument String");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("SomeArgument String", captor.getValue());
    }
}
