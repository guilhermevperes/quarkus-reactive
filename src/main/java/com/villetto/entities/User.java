package com.villetto.entities;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.*;

import javax.persistence.Column;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@MongoEntity(collection = "User")
public class User extends ReactivePanacheMongoEntity {

    private String name;
    private String document;
    private String email;
}
