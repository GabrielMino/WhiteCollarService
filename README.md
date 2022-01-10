# WhiteCollarService

Description


Design and build a REST API using databases as persistence

Level 1

We have an illegal checkered store franchise that claims to sell white necklaces, which is why it is called a "white collar".

This franchise has several stores, each with a name and a maximum capacity of pictures (or necklaces ^^). Some paintings have an author name and others are anonymous. Of course, they all have a name, a price, and a check-in date (this is the date you enter the store). The client asks us to implement an API with Spring with the following functionalities:

Create store: we will tell you the name and capacity (POST / shops /).
List stores: Returns the list of stores with their name and capacity (GET / shops /).
Add painting: we will give it the name of the painting and the author (POST / shops / {ID} / pictures)
List store pictures (GET / shops / {ID} / pictures).
Burning pictures: In case the police come, you can remove all the pictures from the store without leaving a trace (DELETE / shops / {ID} / pictures).
NOTES

Please note the following construction details:

Includes in a project directory the Postman collection for http invocations
Use the SpringBootInitialDemo project as an example structure
You must persist the data in a database in h2 memory (included in Spring boot)


Level 2

Use mysql to persist the data, instead of h2.



Level 3

Add unit, component, and integration tests to the project. You can use jUnit, AssertJ, Hamcrest or Mockito, for example.
