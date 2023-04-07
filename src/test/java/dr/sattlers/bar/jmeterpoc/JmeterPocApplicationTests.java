package dr.sattlers.bar.jmeterpoc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class JmeterPocApplicationTests {
  @Value("${server.port}")
  int port;

  @Value("${server.host}")
  String host;

	@Test
	void contextLoads() {
	}

	/*@Test
	void testShowMenu(){
		RestAssured.baseURI = host;
        RestAssured.port = port;

        given()
          .when()
          .get("/menu")
          .then()
          .statusCode(200)
          .body(equalTo("[{\"item\":\"Spicy Tacos\",\"description\":\"Tacos with a kick of spice\",\"ingredients\":[\"pork\",\"lettuce\",\"tomatoes\",\"cheese\",\"spicy salsa\"],\"spicyLevel\":\"hot\"},{\"item\":\"Margherita Pizza\",\"description\":\"Classic Italian pizza with fresh mozzarella and basil\",\"ingredients\":[\"mozzarella cheese\",\"tomato sauce\",\"fresh basil\",\"olive oil\"],\"spicyLevel\":\"mild\"},{\"item\":\"Spicy Chicken Curry\",\"description\":\"Creamy chicken curry with a spicy kick\",\"ingredients\":[\"chicken\",\"coconut milk\",\"curry powder\",\"chili peppers\",\"onions\",\"garlic\"],\"spicyLevel\":\"very hot\"}]"));
	}*/

}
