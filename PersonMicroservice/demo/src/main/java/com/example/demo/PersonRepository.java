package com.example.demo;
/* This interface is extends MongoRepository and talking to the DB
 */
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface PersonRepository
        extends MongoRepository<Person,String> {
    Optional<Person> findPeronByIdPerson(String idPerson); //fetching the user idPerson from the db to is
                                                           //if exited


}
