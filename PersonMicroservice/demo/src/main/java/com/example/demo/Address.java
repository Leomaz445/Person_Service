package com.example.demo;
/*Class represent an address of the person
 * Leonid Mazarsky
 * 18-12-2021
 */


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.*;
@Data
@NoArgsConstructor
public class Address  {


    @NotNull(message="Please Enter a State")
    @EnumStates(regexp = "ISRAEL",message = "State allowed input: ISRAEL")
    private State state; //The state must be Israel

    @NotNull(message="Please provide a city")
    @Size(min=3,max=20,message="The length of the city should be between 3- 20 characters")
    private String city;//The city where the person live

    @NotNull(message="Please provide a street")
    @Size(min=3,max=50,message="The length of the street must be between 3- 50 characters")
    private String street; //The street where the person live

    @NotNull(message="Please provide a zipcode")
    @Digits(integer = 9,fraction = 0,message="The zip code must be only numbers")
    private String zipcode; //The ZipCode of the person


    @NotNull(message="Please enter if you have pets")
    @Pattern(regexp = "^true$|^false$", message = "allowed input for pet is: true or false")
    @Transient
    private String booleanField;


    private boolean containAnimal; //After the user will Enter true or false we will initially it with a
    //Proper boolean value

    //function that updating the value of the boolean.
    public void setConAnimal()
    {
        containAnimal=Boolean.parseBoolean(booleanField);
    }



}
