package com.unit.testing.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JsonPathTest {

    @Test
    public void learning(){
        String responseFromService = "[" +
                "{\"id\":1000, \"name\":\"pen\", \"quantity\":17}," +
                "{\"id\":1001, \"name\":\"Pink\", \"quantity\":12}," +
                "{\"id\":1002, \"name\":\"Tie\", \"quantity\":10}" +
                "]";
        DocumentContext context = JsonPath.parse(responseFromService);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids = context.read("$..id");

//        assertThat(ids).containsExactly(3);
        System.out.println(ids.toString());
        System.out.println(context.read("$.length()").toString());
        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:2]").toString());
        System.out.println(context.read("$.[?(@.name == 'pen')]").toString());
    }










}
