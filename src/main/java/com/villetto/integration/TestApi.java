package com.villetto.integration;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Set;

@Path("/tests")
@RegisterRestClient
public interface TestApi {

    @POST
    Uni<TestResponse> postTest();

}
