# This is the backend part of the Bookshelf application
This was written with Java Spring Boot, with a H2 in-memory database, and Lombok to remove a lot of the excess boilerplate code that Java has.
I've created a REST api, and use Dalesbred to fetch data from the database.
The H2 database will not persist the data, as it's an in-memory database. It's mostly used for use cases like for example: rapid prototyping, testing, high performance operations, read-only databases,
and is not something I'd use in production, it's just nice for projects like these where the data doesnt really have to be kept.

I've populated the database with some data, just for testing/viewing purposes, with the user login:
Username: Bookshelf
Pass: pass


## Start project
The simplest way to start this application is to the main method in the BookshelfApplication.java class (path: bookshelf/src/main/java/dev/ingeb/bookshelf/) from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

```mvn spring-boot:run```



This will run on http://localhost:8080/ in case you want to try out some of the endpoints without doing it through the FE.
You can also check out the H2 database where you can query directly against the database here: http://localhost:8080/h2/
Driver class: org.h2.Driver
JDBC URL: jdbc:h2:mem:memDb
User Name: sa
Password:
(and yes, password is actually nothing)

There's 3 database tables, Users, Books and Library. Users and Books have a many-to-many relationship, so I've created Library to have the foreign keys + some additional information.
These are created in schema.sql, and populated with (some) data in data.sql

### TODO: What I would've done with more time:
-Create tests
-Authentication, and an admin page
-Less methods that return void, especially the POST-methods (some return void)
-Set up a proper database, and not an in-memory db
-Better exception handling
-Possibly handle the data from the third-party api in the BE instead of the FE
