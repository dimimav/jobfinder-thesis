CREATE DATABASE jobfinder DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

USE jobfinder;

CREATE TABLE users (
  id         int(10) NOT NULL AUTO_INCREMENT, 
  username   varchar(50) NOT NULL, 
  password   varchar(255) NOT NULL, 
  created_at datetime NOT NULL, 
  PRIMARY KEY (id));
  CREATE TABLE roles (
  id     int(10) NOT NULL AUTO_INCREMENT, 
  name   varchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE users_roles (
  role_id int(10) NOT NULL, 
  user_id int(10) NOT NULL, 
  PRIMARY KEY (role_id, 
  user_id));
CREATE TABLE companies (
  id         int(10) NOT NULL AUTO_INCREMENT, 
  name       varchar(100) NOT NULL, 
  tax_number int(10), 
  country    varchar(100), 
  city       varchar(100), 
  address    varchar(100), 
  email      varchar(100), 
  telephone  varchar(100), 
  user_id    int(10) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE candidates (
  id        int(10) NOT NULL AUTO_INCREMENT, 
  fname     varchar(50) NOT NULL, 
  lname     varchar(50) NOT NULL, 
  age       int(3) NOT NULL, 
  gender    varchar(10) NOT NULL, 
  address   varchar(100), 
  email     varchar(100), 
  telephone varchar(100), 
  user_id   int(10) NOT NULL, 
  PRIMARY KEY (id));
  CREATE TABLE job_categories (
  id        int(10) NOT NULL AUTO_INCREMENT, 
  name      varchar(100) NOT NULL, 
  PRIMARY KEY (id));
  CREATE TABLE jobs (
  id                  int(10) NOT NULL AUTO_INCREMENT, 
  title               varchar(100) NOT NULL, 
  description         varchar(255) NOT NULL, 
  employment_type     varchar(50) NOT NULL, 
  required_experience varchar(100), 
  salary              float, 
  location            varchar(255) NOT NULL, 
  telephone           varchar(20) NOT NULL, 
  email               varchar(50) NOT NULL, 
  date_posted         datetime DEFAULT NOW() NOT NULL, 
  job_category_id     int(10), 
  company_id          int(10) NOT NULL, 
  PRIMARY KEY (id));

  CREATE TABLE job_applications (
  id           int(10) NOT NULL AUTO_INCREMENT, 
  fname        varchar(100) NOT NULL, 
  lname        varchar(100) NOT NULL, 
  email        varchar(100) NOT NULL, 
  address      varchar(255) NOT NULL, 
  phone        varchar(50) NOT NULL, 
  qualified    varchar(50), 
  created_at   datetime NOT NULL, 
  cover_letter varchar(512), 
  job_id       int(10) NOT NULL, 
  candidate_id int(10), 
  PRIMARY KEY (id));
  CREATE TABLE job_applications_working_experiences (
  int                int(10) NOT NULL AUTO_INCREMENT, 
  title              varchar(100) NOT NULL, 
  company            varchar(100) NOT NULL, 
  description        varchar(255) NOT NULL, 
  industry           varchar(255) NOT NULL, 
  start_date         date NOT NULL, 
  end_date           date NOT NULL, 
  job_application_id int(10) NOT NULL, 
  PRIMARY KEY (int));
  CREATE TABLE education_levels (
  id      int(10) NOT NULL AUTO_INCREMENT, 
  title   varchar(20) NOT NULL, 
  ranking int(3) NOT NULL, 
  PRIMARY KEY (id));
  CREATE TABLE job_applications_education (
  id                 int(10) NOT NULL AUTO_INCREMENT, 
  degree             varchar(50) NOT NULL, 
  school             varchar(50) NOT NULL, 
  field_of_study     varchar(100), 
  description        varchar(255), 
  grade              float, 
  start_date         date, 
  end_date           date, 
  job_application_id int(10) NOT NULL, 
  education_level_id int(10) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE languages (
  id   int(10) NOT NULL AUTO_INCREMENT, 
  name varchar(50) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE job_applications_languages (
  job_application_id int(10) NOT NULL, 
  language_id        int(10) NOT NULL, 
  level              int(2) NOT NULL, 
  PRIMARY KEY (job_application_id, 
  language_id));

ALTER TABLE users_roles ADD INDEX fk_role_id (role_id), ADD CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES roles (id);
ALTER TABLE users_roles ADD INDEX fk_user_id (user_id), ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE job_applications_working_experiences ADD INDEX fk_working_experience_job_application_id (job_application_id), ADD CONSTRAINT fk_working_experience_job_application_id FOREIGN KEY (job_application_id) REFERENCES job_applications (id) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE companies ADD INDEX fk_company_user_id (user_id), ADD CONSTRAINT fk_company_user_id FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE candidates ADD INDEX fk_candidate_user_id (user_id), ADD CONSTRAINT fk_candidate_user_id FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE job_applications ADD INDEX fk_candidate_id (candidate_id), ADD CONSTRAINT fk_candidate_id FOREIGN KEY (candidate_id) REFERENCES candidates (id);
ALTER TABLE jobs ADD INDEX fk_company_id (company_id), ADD CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES companies (id) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE job_applications_education ADD INDEX fk_education_level (education_level_id), ADD CONSTRAINT fk_education_level FOREIGN KEY (education_level_id) REFERENCES education_levels (id);
ALTER TABLE job_applications_languages ADD INDEX fk_language_id (language_id), ADD CONSTRAINT fk_language_id FOREIGN KEY (language_id) REFERENCES languages (id) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE job_applications_languages ADD INDEX fk_job_application_id (job_application_id), ADD CONSTRAINT fk_job_application_id FOREIGN KEY (job_application_id) REFERENCES job_applications (id) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE job_applications_education ADD INDEX fk_education_job_application_id (job_application_id), ADD CONSTRAINT fk_education_job_application_id FOREIGN KEY (job_application_id) REFERENCES job_applications (id) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE job_applications ADD INDEX fk_job_id (job_id), ADD CONSTRAINT fk_job_id FOREIGN KEY (job_id) REFERENCES jobs (id);
ALTER TABLE jobs ADD INDEX fk_job_category_id (job_category_id), ADD CONSTRAINT fk_job_category_id FOREIGN KEY (job_category_id) REFERENCES job_categories (id);

INSERT INTO roles VALUES (1,'ROLE_COMPANY');
INSERT INTO roles VALUES (2,'ROLE_CANDIDATE');

INSERT INTO job_categories VALUES (1,'All Categories');
INSERT INTO job_categories VALUES (2,'IT - Telecommunications');
INSERT INTO job_categories VALUES (3,'Health Sector');
INSERT INTO job_categories VALUES (4,'Manufacturing');
INSERT INTO job_categories VALUES (5,'Business/ Management');
INSERT INTO job_categories VALUES (6,'Sales');
INSERT INTO job_categories VALUES (7,'Marketing');
INSERT INTO job_categories VALUES (8,'Hospitality');
INSERT INTO job_categories VALUES (9,'Education');
INSERT INTO job_categories VALUES (10,'Public Sector');

INSERT INTO education_levels VALUES (1,'Phd',10);
INSERT INTO education_levels VALUES (2,'Master',9);
INSERT INTO education_levels VALUES (3,'BSc',8);
INSERT INTO education_levels VALUES (4,'Post-Secondary',5);
INSERT INTO education_levels VALUES (5,'Secondary',4);
INSERT INTO education_levels VALUES (6,'Primary',2);

INSERT INTO languages VALUES (1,'English');
INSERT INTO languages VALUES (2,'German');
INSERT INTO languages VALUES (3,'French');
INSERT INTO languages VALUES (4,'Greek');



