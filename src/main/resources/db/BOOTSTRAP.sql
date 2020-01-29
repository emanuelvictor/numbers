create table numbers (id number(19,0) not null, created timestamp not null, updated timestamp, digit number(5,0) not null check (digit<=100 AND digit>=1), processing_time number(10,0) not null, primary key (id));
create table numbers_audited (id number(19,0) not null, revision number(19,0) not null, revision_type number(3,0), digit number(5,0), processing_time number(10,0), primary key (id, revision));
create table revision (id number(19,0) not null, timestamp number(19,0) not null, user_id number(19,0), primary key (id));
alter table numbers add constraint UK_numbers_digit unique (digit);
create sequence hibernate_sequence start with 1 increment by  1;
alter table numbers_audited add constraint FKjm9qhqq9lxo2hli5lj1g92r6f foreign key (revision) references revision;
