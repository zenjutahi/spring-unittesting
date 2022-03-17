package com.unit.testing.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTesting {

    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(12,39,45);
        
        assertThat(numbers).hasSize(3)
                .contains(39)
                .allMatch(x -> x < 100)
                .noneMatch(x -> x < 0)
                .allMatch(x -> x > 10);

        assertThat("").isEmpty();
        assertThat("ABCDE").contains("BCD")
                .startsWith("ABC")
                .endsWith("CDE");
    }

}
