package com.example.demo;
/*This is a Person controller class that is the dependency injected from the service class
  *This class supporting the CRUD Operation
  *Leonid Mazarsky
  * 18/12/2021
 */
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("api/v1/persons")
@AllArgsConstructor
public class PersonController {

        private final PersonService personService;
        //return all the persons in the database
        @GetMapping
        public ResponseEntity<List<Person>> fetchAllPersons(){
            return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
        }

       //return a person by his Id
       @GetMapping(path = "{personId}")
        public Optional<Person> fetchPersonById(@PathVariable(value = "personId") String personId){
         return personService.fetchPerson(personId);

      }
      //Add a new person
      @PostMapping
      public ResponseEntity<String> registerNewStudent(@Valid @RequestBody Person person){
          personService.addNewPerson(person);
          return new ResponseEntity<>("User successfully added", HttpStatus.OK);
      }

        //Delete a person
        @DeleteMapping()
        public ResponseEntity<String>  deleteStudent(@RequestBody Person person) {
            personService.deletePerson(person);
            return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
        }

       //Update a person
    @PutMapping(path = "{personId}")
    public ResponseEntity<String> updatePerson(@PathVariable("personId") String personId,@Valid @RequestBody Person Person) {
        personService.updateStudent(personId,Person);
        return new ResponseEntity<>("User successfully updated", HttpStatus.OK);

    }


}
