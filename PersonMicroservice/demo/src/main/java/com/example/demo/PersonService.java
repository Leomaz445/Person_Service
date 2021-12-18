package com.example.demo;
/*This is a Person service class that is the dependency injected from the person repository
 *This class is using
 *Leonid Mazarsky
 * 18/12/2021
 */

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    //Get all the persons from the DB
    public List<Person> getAllPersons() {
        return personRepository.findAll();

    }
   //Get a person from the DB by his ID
   public Optional<Person> fetchPerson(String personId) {
       Optional<Person> personOptional = personRepository.findPeronByIdPerson((personId));

       if (personOptional.isEmpty())
           throw new IllegalStateException("We don't have this ID");

        return personRepository.findPeronByIdPerson(personId);

    }
   //Add a new person if the ID is not taken
   @ResponseStatus(HttpStatus.CREATED)
    public void addNewPerson(Person person) {
        Optional<Person> personOptional = personRepository.findPeronByIdPerson((person.getIdPerson()));

        if (personOptional.isPresent())
            throw new IllegalStateException("ID ALREADY IN USE");

        person.getAddress().setConAnimal();
        personRepository.save(person);
    }
    /*Delete a person from the DB
     We get the ID of the user then we use it to find the _id of the DB .
     @param person - the person that we want to delete
    */
    public void deletePerson(Person person){
        Optional<Person> personData = personRepository.findPeronByIdPerson(person.getIdPerson());
        if(personData.isEmpty()){
            throw new IllegalStateException("student with id " + person.getIdPerson() + "dose not exists");
        }
        personRepository.deleteById(personData.get().getId());
    }


    /*Update the person information
    We get the ID of the user then and all the infraction we want to update
    @param personID - His id that we will use it to find him
    @param person - the person that we want to update his info
   */
    public void updateStudent(String personId,Person person) {
        Optional<Person> personData = personRepository.findPeronByIdPerson(personId);
        if(personData.isPresent()) {
            Person _person=personData.get();
            _person.setName(person.getName());
            _person.setAge(person.getAge());
            _person.setGender(person.getGender());
            _person.setHeight(person.getHeight());
            _person.setWeight(person.getWeight());
            _person.setAddress(person.getAddress());
            person.getAddress().setConAnimal(); //setting the boolean value
            personRepository.save(_person);
        }
        else
            throw new IllegalStateException("Person not found");
    }


}

