package com.example.demo;
/*This is a Microservice that reveals an API supporting CRUD Operation of a Person Model
 *that is saved in MongoDB DataBase
 * Leonid Mazarsky
 * 18/12/2021
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
