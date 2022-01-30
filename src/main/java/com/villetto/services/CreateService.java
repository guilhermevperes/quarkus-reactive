package com.villetto.services;

import com.villetto.entities.User;
import com.villetto.integration.TestApi;
import com.villetto.repositories.UserRepository;
import com.villetto.to.CreateRequestTO;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CreateService {

    @Inject
    private UserRepository repository;

    @Inject
    @RestClient
    private TestApi testApi;

    public Uni<User> execute(CreateRequestTO requestTO){
        User user = User.builder()
                .name(requestTO.getName())
                .document(requestTO.getDocument())
                .email(requestTO.getEmail())
                .build();

        return testApi.postTest()
                .chain((r) -> {
                    System.out.println("Response =>>>>> " + r);
                    return repository.create(user);
                });

    }
}
