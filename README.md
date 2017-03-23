Requirements: 
jdk 1.7, Apache Maven

Pre installation:
1. run script db/schema.sql into your local db
2. change src/main/resources/database.properties with your local db properties

Installation:
1. git clone https://github.com/dimimav/jobfinder-thesis.git
2. cd jobfinder-thesis
3. mvn tomcat7:run

Type in your browser
localhost:8080/jobfinder
