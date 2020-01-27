--
-- PostgreSQL database dump
--

-- Dumped from database version 11.4
-- Dumped by pg_dump version 11.4

-- Started on 2019-07-15 17:06:21 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;


create table public.number (id  bigserial not null, created timestamp not null, updated timestamp, digit int2 not null, processing_time int4 not null, primary key (id));
create table public.number_audited (id int8 not null, revision int8 not null, revision_type int2, digit int2, processing_time int4, primary key (id, revision));
create table public.revision (id  bigserial not null, timestamp int8 not null, user_id int8, primary key (id));
alter table public.number drop constraint if exists UK_number_digit;
alter table public.number add constraint UK_number_digit unique (digit);
alter table public.number_audited add constraint FK_number_audited_revision foreign key (revision) references public.revision;
