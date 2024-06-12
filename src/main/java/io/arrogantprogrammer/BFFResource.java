package io.arrogantprogrammer;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BFFResource {


    @GET
    @Path("/assign")
    public Response assign() {
        Log.debugf("Assigning random animal");
        return Response.ok(RandomAnimalService.getRandomAnimal()).build();
    }
}
