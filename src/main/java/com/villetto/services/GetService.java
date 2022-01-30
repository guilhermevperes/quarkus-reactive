package com.villetto.services;

import com.villetto.entities.User;
import com.villetto.repositories.UserRepository;
import io.smallrye.mutiny.Multi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GetService {

    @Inject
    private UserRepository repository;

    public Multi<User> execute(){
        return repository.getAll();
    }

}
