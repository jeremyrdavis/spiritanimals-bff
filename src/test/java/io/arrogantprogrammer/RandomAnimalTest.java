package io.arrogantprogrammer;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class RandomAnimalTest {

    @Test
    public void testRandomAnimal() {
        given()
                .when().get("/assign")
                .then()
                .statusCode(200);
    }
}
