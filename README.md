## About Jobfinder
The purpose of this project is to create a web application that will become a channel of communication between employers and prospective employees. Through this platform companies and organizations who are looking for employees can post ads for open job positions. Then users who are interested in these positions can apply by filling out the appropriate form. Employers through the platform will be able to see the submitted resumes and then providing the required criteria the application will evaluate
and recommend which candidate is suitable.

## Prerequisites
* JDK 1.7
* MySQL
* Apache Maven

## Pre-installation:
1. run script db/schema.sql into your local db
2. update src/main/resources/database.properties with your local db properties

## Installation
1. git clone https://github.com/dimimav/jobfinder-thesis.git
2. cd jobfinder-thesis
3. mvn tomcat7:run

## Run
http://localhost:8080/jobfinder

## Documentation
https://apothesis.lib.teicrete.gr/bitstream/handle/11713/8194/MavroforakisDimitris2017.pdf

## License
This project is Open Source software released under the MIT License
