# PRODUTEC - NUMBERS

*This application is dedicated to the execution of the challenge to join Produtec Corporation.*

## Configuring database

The application is configured with user 'system', the password defined is 'oracle'. 
Change the user or the password as you prefer in file 'src/main/resources/config/application.yml' to connect in oracle database. The SID is 'xe'.

```yaml
spring.datasource:
    driver-class-name: oracle.jdbc.driver.OracleDriver
    hikari.maximum-pool-size: 3
    url: jdbc:oracle:thin:@127.0.0.1:1521:xe
    username: system
    password: oracle
```

## DDL to create tables.

Execute the following sql statements in oracle database to create tables:

```sql
create table numbers (id number(19,0) not null, created timestamp not null, updated timestamp, digit number(5,0) not null check (digit<=100 AND digit>=1), processing_time number(10,0) not null, primary key (id));
create table numbers_audited (id number(19,0) not null, revision number(19,0) not null, revision_type number(3,0), digit number(5,0), processing_time number(10,0), primary key (id, revision));
create table revision (id number(19,0) not null, timestamp number(19,0) not null, user_id number(19,0), primary key (id));
alter table numbers add constraint UK_numbers_digit unique (digit);
create sequence hibernate_sequence start with 1 increment by  1;
alter table numbers_audited add constraint FKjm9qhqq9lxo2hli5lj1g92r6f foreign key (revision) references revision;
```

> These sql statements can also found in file: 'src/main/resources/db/BOOTSTRAP.sql';

## Starting the application and generating coverage tests report

Execute the following statements to generate coverage tests report:
```shell script
mvn clean install
```

> after generated the report can founded in file: 'target/site/jacoco/index.html';

Execute the following statements to start application:

```shell script
mvn spring-boot:run
```
