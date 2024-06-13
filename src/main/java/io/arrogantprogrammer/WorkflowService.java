package io.arrogantprogrammer;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class WorkflowService {

    private static final Optional<String> WHATIS = Optional.of("Rabbits are fluffy animals.  They are fast and have long ears.  They are also very cute.");
    private Optional<String> POEM = Optional.of("Roses are red, violets are blue.  Rabbits are fast, and so are you.");
    private Optional<String> UPDATEDPOEM = Optional.of("Roses are red, violets are blue.  Rabbits and the Millenium Falcon are fast, and so are you.");
    public WorkflowRecord assign(final String name) {
        return new WorkflowRecord(1L, name, RandomAnimalService.getRandomAnimal(), false, null, null, null, null);
    }

    public WorkflowRecord poem(final Long id) {
        return new WorkflowRecord(id, "Alice", "Rabbit", false, null, POEM, null, null);
    }

    public WorkflowRecord  addToPoem(long id) {
        return new WorkflowRecord(id, "Alice", "Rabbit", false, null, POEM, UPDATEDPOEM, null);
    }

    public WorkflowRecord like(long id) {
        return new WorkflowRecord(id, "Alice", "Rabbit", true, null, POEM, UPDATEDPOEM, null);
    }

    WorkflowRecord feedback(long id, String feedback) {
        return new WorkflowRecord(id, "Alice", "Rabbit", true, null, POEM, UPDATEDPOEM, Optional.ofNullable(feedback));
    }

    public WorkflowRecord whatIs(long id) {
        return new WorkflowRecord(id, "Alice", "Rabbit", true, WHATIS, POEM, UPDATEDPOEM, null);
    }
}
