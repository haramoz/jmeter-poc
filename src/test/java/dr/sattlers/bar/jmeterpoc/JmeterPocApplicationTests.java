package dr.sattlers.bar.jmeterpoc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class JmeterPocApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testShowMenu(){
		RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;

        given()
          .when()
          .get("/menu")
          .then()
          .statusCode(200)
          .body(equalTo("Food & Drinks!"));
	}

}
