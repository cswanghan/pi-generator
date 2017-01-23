#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class ControllerTest {
	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testRootController() {
//		String apiResponse = restTemplate.getForObject("http://localhost:7001/", String.class);
//		assertNotNull(apiResponse);
//		assertEquals("Hello World!", apiResponse.toString());
	}
	
}
