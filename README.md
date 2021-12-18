# Person_Service
Person Microservice
This is A microserivce that reveals an API supporting CRUD Operation of a Person Model,that saven in MongoDB
- Create Single Person
- Read Single Person
- Read multiple Person
- Update Single Person
- Delete Single Person

Validation:
Validation is preform when person is created and updated using a spring-boot-starter-validation.

Classes:
Person Class:
• id : String
• name : String
• age : int
• gender : Gender
• height: double
• weight: double
• address: Address

Address
• state: State
• city: String
• street: String
• zipcode : String
• containsAnimals: Boolean

State ( Enum )
• Israel
• USA

Gender ( Enum )
• Male
• Female
• Other

