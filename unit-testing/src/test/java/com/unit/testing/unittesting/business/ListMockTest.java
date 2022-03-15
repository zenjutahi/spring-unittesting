package com.unit.testing.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
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

    @Test
    public void multipleArgumentCapturing() {
        // SUT
        mock.add("SomeArgument String");
        mock.add("SomeArgument String2");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());
        List<String> allValues = captor.getAllValues();
        assertEquals("SomeArgument String", allValues.get(0));
        assertEquals("SomeArgument String2", allValues.get(1));
    }

    @Test
    public void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); //null
        System.out.println(arrayListMock.size()); //0
        System.out.println(arrayListMock.add("Test"));
        System.out.println(arrayListMock.size());

        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());
    }
    @Test
    public void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test 0");
        System.out.println(arrayListSpy.get(0)); //null
        System.out.println(arrayListSpy.size()); //0
        System.out.println(arrayListSpy.add("Test"));
        System.out.println(arrayListSpy.size());

        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());

        verify(arrayListSpy).add("Test");
    }
}
