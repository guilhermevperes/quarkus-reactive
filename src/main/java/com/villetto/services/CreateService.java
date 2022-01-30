package com.villetto.services;

import com.villetto.entities.User;
import com.villetto.repositories.UserRepository;
import com.villetto.to.CreateRequestTO;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CreateService {

    @Inject
    private UserRepository repository;

    public Uni<User> execute(CreateRequestTO requestTO){
        User user = User.builder()
                .name(requestTO.getName())
                .document(requestTO.getDocument())
                .email(requestTO.getEmail())
                .build();

        return repository.create(user);
    }
}
