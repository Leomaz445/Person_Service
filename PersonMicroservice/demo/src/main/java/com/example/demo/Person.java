/**Class represent a given person
 * Leonid Mazarsky
 * 18-12-2021
 */
package com.example.demo;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.Valid;
import javax.validation.constraints.*;


@Data
@Document
public class Person {

    @Id
    private String id;//Auto ID created in the database by mongoDB

    @Indexed(unique = true)
    @Digits(integer = 9,fraction = 0,message="Please use only numbers for the Id")
    @NotNull(message ="Please provide an id")
    @Size(min=3,max=40,message="The Id shot be between 3 to 20 characters")
    private String idPerson; //Person ID - must be numbers between 3-40

    @NotEmpty(message="Please provide a name")
    @Size(min =3, max=20,message="The name should be  3 to 20 characters")
    private String name;//Person name - must be between 3-20

    @NotNull(message="Please provide a age")
    @DecimalMax("200.0") @DecimalMin("0.0")
    private Integer age; //Person Age must be between 0 - 200

    @NotNull(message="Please provide a Gender")
    @EnumStates(regexp = "MALE|FEMALE|OTHER",message="Please  a gender Choose from MALE|FEMALE|OTHER ")
    private Gender gender; //Gender of a person

    @NotNull(message="Please provide a height")
    @DecimalMax("1.60") @DecimalMin("0.0")
    private double height; //Height of a person must br from 0 to 1.60

    @DecimalMax("73.5") @DecimalMin("0.0")
    private Double weight; // Weight of a person

    @NotNull(message="Please provide a address")
    @Valid
    private Address address;

    /**
     * Empty Constructs
     */
    public Person() {
    }
    /**
     * Constructs users Address
     * @param idPerson person ID
     * @param name Persons Name
     * @param age Persons Age
     * @param gender Persons gender
     * @param height- Persons height
     * @param weight - Persons weight
     * @param address - person address
     */
    public Person(String idPerson, String name, Integer age, Gender gender, double height, Double weight, Address address) {

        this.idPerson = idPerson;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.address = address;
    }

//Getter and Setters

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", idPerson='" + idPerson + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", height=" + height +
                ", weight=" + weight +
                ", address=" + address.toString() +
                '}';
    }
}




