package br.com.helison.core.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AdminResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/admin")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}