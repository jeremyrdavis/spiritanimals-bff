package io.arrogantprogrammer;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class WorkflowAddToPoemTest extends BFFTest{

    private static final String UPDATEDPOEM = "Roses are red, violets are blue.  Rabbits and Land Speeders are fast, and so are you";
    @InjectMock
    WorkflowService  workflowService;

    @BeforeEach
    public void setup() {
        Mockito.when(workflowService.addToPoem(1L)).thenReturn(new WorkflowRecord(1L, "Alice", "Rabbit", false, null, Optional.ofNullable(POEM), Optional.ofNullable(UPDATEDPOEM), null));
    }
    @Test
    public void testWorkflowAddToPoem() {
        // Test the workflow
        WorkflowRecord result = given()
                .body(1L)
                .when().post("/addtopoem")
                .then()
                .statusCode(200)
                .extract().as(WorkflowRecord.class);

        assertNotNull(result.poem());
        assertEquals(POEM, result.poem().get());
        assertEquals(UPDATEDPOEM, result.updatedPoem().get());
    }
}
