package com.villetto.repositories;

import com.villetto.entities.User;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements ReactivePanacheMongoRepository<User> {

    public Uni<User> create(User user) {
        return persist(user).map(f -> f);
    }

    public Multi<User> getAll() {
        return findAll().stream().onItem().transform(i -> i);
    }



}
