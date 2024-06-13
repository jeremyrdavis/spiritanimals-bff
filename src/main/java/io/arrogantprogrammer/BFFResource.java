package io.arrogantprogrammer;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class BFFResource {

    @Inject
    WorkflowService workflowService;

    @POST
    @Path("/assign")
    public Response assign(final String name) {
        Log.debugf("Assigning random animal for %s", name);
        return Response.ok(workflowService.assign(name)).build();
    }

    @POST
    @Path("/whatis")
    public Response whatIs(final Long id) {
        Log.debugf("What is my spirit animal for workflow %d", id);
        return Response.ok(workflowService.whatIs(id)).build();
    }

    @POST
    @Path("/poem")
    public Response poem(final Long id) {
        Log.debugf("Adding a poem to workflow %d", id);
        return Response.ok(workflowService.poem(id)).build();
    }
    @POST
    @Path("/addtopoem")
    public Response addToPoem(final Long id) {
        Log.debugf("Adding to poem to workflow %d", id);
        return Response.ok(workflowService.addToPoem(id)).build();
    }
}
