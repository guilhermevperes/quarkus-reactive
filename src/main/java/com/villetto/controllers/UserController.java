package com.villetto.controllers;

import com.villetto.entities.User;
import com.villetto.repositories.UserRepository;
import com.villetto.services.CreateService;
import com.villetto.services.GetService;
import com.villetto.to.CreateRequestTO;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/users")
@ApplicationScoped
public class UserController {

    @Inject
    private CreateService createService;

    @Inject
    private GetService getService;

    @POST
    public Uni<User> post(CreateRequestTO requestTO) {
        return createService.execute(requestTO);
    }

    @GET
    public Multi<User> GET() {
        return getService.execute();
    }

}
