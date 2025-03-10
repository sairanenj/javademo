# Javademo (Peliapuriapp)

I made this project for myself as a pure exercise in Java.
Basically, the project is the same as the exercise I did for the university of applied sciences with Vaadin flow (VaadinPractice).

Main technologies used for this project:
Visual Studio Code:
Java (Spring Boot/MVC/JPA/Security)
MySQL
HTML/CSS, Thymeleaf

## Briefly about the game assistant app:

A simple helper tool for language/speech therapists (LST). With the program you can keep basic information about clients and locations, which are of course connected to each other.

The program has a separate section for games that are in use by you/your company. Games refer to board games that are used in speech therapy, etc. You can modify this list freely.

These games can then be linked to clients using the game assistant. Is the game used by the client, is the game functional and there is an opportunity for free comments.

In the home games section, you can keep up with games that are used by the client, e.g. at home and daycare, based on which homework and exercises can be given.

Then there is a list of users of the program, which the admin can modify. The basic user does not have rights to add or remove new users.

## Instructions

The project was made with Visual Studio Code, so the instructions have been created accordingly.

You should have:
JDK 17 or later installed, MySQL Database/MySQL Server, Visual Studio Code, Maven

Configure MySQL database:
Create a databse named javademodb
Update application.properties file with your MySQL username and pw:
spring.datasource.url=jdbc:mysql://localhost:3306/javademodb
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>

Open VSC, Open folder and choose this project directory.

Install the following extensions in Visual Studio Code:
Java Extension Pack
Spring Boot Extension Pack
Maven for Java

Build the project:
Open terminal and run the command 'mvn clean install'

Run the application, open your browser and go to http://localhost:8080

If you want to use the premade SQL data:
After the first application start, stop application and rename RENAMEdata.sql file in resources as data.sql and run the application again.
You should rename it back to something else after that again, just incase (or just delete it).

That data displays you some idea behind the application.
Obviously you can add and test everything yourself and findout if the application is even working.

