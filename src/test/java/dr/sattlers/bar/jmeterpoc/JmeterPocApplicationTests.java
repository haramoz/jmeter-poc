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

	@Test
	void testShowMenu(){
		RestAssured.baseURI = host;
        RestAssured.port = port;

        given()
          .when()
          .get("/menu")
          .then()
          .statusCode(200)
          .body(equalTo("[{\"item\":\"Food & Drinks\"},{\"item\":\"Pommes & Beers\"},{\"item\":\"Pasta & Limoncello\"}]"));
	}

}
