package com.unit.testing.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Book\",\"quantity\":100,\"price\":75}";


    @Test
    public void jsonAssert_StrictTrue_ExactMatchExpectForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Book\",\"quantity\":100,\"price\":75}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);

    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Book\",\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);

    }
    @Test
    public void jsonAssert_StrictFalse_withoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id:1,name:Book,quantity:100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
