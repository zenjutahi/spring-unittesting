package com.unit.testing.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(12,39,45);

        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(39,45));
        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers, everyItem(lessThan(100)));

        assertThat("", isEmptyString());
        assertThat("ABCDEF", endsWith("DEF"));
    }

}
