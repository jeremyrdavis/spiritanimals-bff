package io.arrogantprogrammer;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class WorkflowPoemTest extends BFFTest {

    @InjectMock
    WorkflowService  workflowService;
    @BeforeEach
    public void setup() {
        Mockito.when(workflowService.poem(1L)).thenReturn(new WorkflowRecord(1L, "Alice", "Rabbit", false, null, Optional.ofNullable(POEM), null, null));
    }

    @Test
    public void testPoem() throws JsonProcessingException {

        WorkflowRecord result = given()
                .body(1L)
                .when().post("/poem")
                .then()
                .statusCode(200)
                .extract().as(WorkflowRecord.class);

        assertNotNull(result.poem());
        assertEquals(POEM, result.poem().get());
    }

}
