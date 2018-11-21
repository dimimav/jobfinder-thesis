## About Jobfinder
The purpose of this project is to create a web application that will become a channel of communication between employers and prospective employees. Through this platform companies and organizations who are looking for employees can post ads for open job positions. Then users who are interested in these positions can apply by filling out the appropriate form. Employers through the platform will be able to see the submitted resumes and then providing the required criteria the application will evaluate
and recommend which candidate is suitable.

## Prerequisites
* JDK 1.7
* MySQL
* Apache Maven

## Pre-installation:
1. execute script db/schema.sql into your local db
2. update src/main/resources/database.properties with your local db properties

## Installation
`git clone https://github.com/dimimav/jobfinder-thesis.git`

`cd jobfinder-thesis`

`mvn tomcat7:run`

## Run in Docker container
Update jdbc url in database.properties to:

jdbc.url=jdbc:mysql://mysql-jobfinder:3306/jobfinder?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&useSSL=false

Start containers:

`docker-compose up`

## App url
`http://localhost:8080/jobfinder`

## Documentation (Greek)
https://apothesis.lib.teicrete.gr/bitstream/handle/11713/8194/MavroforakisDimitris2017.pdf

## License
This project is Open Source software released under the MIT License
