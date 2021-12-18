/*This is a person configuration class we dont use in currently
 * Leonid Mazarsky
 * 18-12-2021
 */



/*package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class PersonConfig {
    @Bean
    CommandLineRunner runner(PersonRepository repository, MongoTemplate mongoTemplate) {
        return args -> {
            Address address = new Address(
                    State.ISRAEL,
                    "Kfar Saba",
                    "ben yahoda",
                    "jk",
                    true
            );
            String idPerson = "1878656541";
            Person person = new Person(
                    idPerson,
                    "Test It",
                    999,
                    Gender.FEMALE,
                    1.58,
                    78.5,
                    address
            );
            //	usingMongoTemplateAndQuery(repository, mongoTemplate, idPerson, person);
            repository.findPeronByIdPerson(idPerson)
                    .ifPresentOrElse(s -> {
                        System.out.println(s + "already exists");
                    }, () -> {
                        System.out.println("Inserting person " + person);
                        repository.insert(person);
                    });

        };
    }


    private void usingMongoTemplateAndQuery(PersonRepository repository, MongoTemplate mongoTemplate, String idPerson, Person person) {
        Query query = new Query();
        query.addCriteria(Criteria.where("idPerson").is(idPerson));
        List<Person> persons = mongoTemplate.find(query, Person.class);
        if (persons.size() > 1)
            throw new IllegalStateException("fond many persons with same id" + idPerson);

        if (persons.isEmpty()) {
            System.out.println("Inserting person " + person);
            repository.insert(person);
        } else {
            System.out.println(person + "already exists");
        }
    }
}
*/
