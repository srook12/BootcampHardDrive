-- Day 17 script

-- Drop the tables ?if they exist
drop table if exists student;
drop table if exists major;
drop table if exists instructor;
drop table if exists class;
drop table if exists assignment;
drop table if exists major_class_relationship;
drop table if exists student_class_relationship;

-- Create the tables
create table student (
	id int primary key auto_increment,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	gpa decimal(5, 1),
	sat int,
	major_id int,
	constraint sat_range_check
        	check(sat >= 400 and sat <= 1600)
);

create table major (
	id int primary key auto_increment, 
	name varchar(30), 
	min_sat int
);
--create table instructor ();
--create table class ();
--create table assignment ();
--create table major_class_relationship ();
--create table student_class_relationship ();

-- Add foreign keys
--alter table <table> add constraint <constraint name> foreign key (<column>) references (<alt primary key>)

