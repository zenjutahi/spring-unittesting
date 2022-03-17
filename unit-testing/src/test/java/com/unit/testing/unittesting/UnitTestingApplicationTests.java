package com.unit.testing.unittesting;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UnitTestingApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() throws JSONException {
		String response = this.restTemplate.getForObject("/all-items-from-database", String.class);
		JSONAssert.assertEquals("[{id:11001},{id:11002},{id:11003}]", response, false);
	}

}
