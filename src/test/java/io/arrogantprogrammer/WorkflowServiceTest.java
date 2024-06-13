package io.arrogantprogrammer;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class WorkflowServiceTest {

    private static final String FEEDBACK = "This is a great demo!";
    @Inject
    WorkflowService workflowService;
    @Test
    public void testAssign() {
        Log.info("Test assigning random animal");
        WorkflowRecord result = workflowService.assign("Alice");
        assertNotNull(result);
        assertEquals("Alice", result.name());
        assertNotNull(result.spiritAnimal());
    }

    @Test
    public void testWhatIs() {
        Log.info("Test what is my spirit animal");
        WorkflowRecord result = workflowService.whatIs(1L);
        assertNotNull(result);
        assertEquals("Alice", result.name());
        assertNotNull(result.spiritAnimal());
    }

    @Test
    public void testPoem() {
        Log.info("Test adding a poem to workflow");
        WorkflowRecord result = workflowService.poem(1L);
        assertNotNull(result);
        assertNotNull(result.poem());
    }

    @Test
    public void testAddToPoem() {
        Log.info("Test adding to poem to workflow");
        WorkflowRecord result = workflowService.addToPoem(1L);
        assertNotNull(result);
        assertNotNull(result.poem());
    }

    @Test
    public void testLike() {
        Log.info("Test liking a poem");
        WorkflowRecord result = workflowService.like(1L);
        assertNotNull(result);
        assertTrue(result.liked());
    }

    @Test
    public void testFeedback() {
        Log.info("Test adding feedback to workflow");
        WorkflowRecord result = workflowService.feedback(1L, "This is a great demo!");
        assertNotNull(result);
        assertEquals(FEEDBACK, result.feedback().get());
    }
}
