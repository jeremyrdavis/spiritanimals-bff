package io.arrogantprogrammer;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class WorkflowAssignTest extends BFFTest {

    @Test
    public void testRandomAnimal() {

        WorkflowRecord result = given()
                .body("Alice")
                .when().post("/assign")
                .then()
                .statusCode(200)
                .extract().as(WorkflowRecord.class);

        assertTrue(RandomAnimalService.ANIMALS.contains(result.spiritAnimal()));
    }



}
