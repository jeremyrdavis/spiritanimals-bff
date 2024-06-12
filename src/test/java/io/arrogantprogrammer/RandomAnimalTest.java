package io.arrogantprogrammer;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class RandomAnimalTest {

    @Test
    public void testRandomAnimal() {

        String animal = given()
                .when().get("/assign")
                .then()
                .statusCode(200)
                .extract().asString();

        assertTrue(RandomAnimalService.ANIMALS.contains(animal));
    }
}
