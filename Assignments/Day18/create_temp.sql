-- Script to set up the education database

-- Drop the tables if they exist
drop table if exists major_class_relationship;
drop table if exists student_class_relationship;
drop table if exists assignment;
drop table if exists grade;
drop table if exists student;
drop table if exists class;
drop table if exists instructor;
drop table if exists major;

-- Drop the procedures if they exist
drop procedure if exists GetStudentMajor;
drop procedure if exists ClassesRemaining;
drop procedure if exists InsertStudent;
drop procedure if exists InsertInstructor;

-- Create the tables
create table student (
	id int primary key,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	gpa decimal(5, 1) not null,
	sat int, 
	major_id int	
);

create table major (
	id int primary key auto_increment, 
	name varchar(30) not null, 
	min_sat int not null
);

create table instructor (
	id int primary key auto_increment, 
	first_name varchar(30) not null, 
	last_name varchar(30) not null, 
	yrs_exp int not null, 
	tenured tinyint default 0, 
	major_id int
);

create table class (
	id int primary key auto_increment,
	prefix varchar(30) not null,  
	number int not null,
	pre_req int,  
	instructor_id int
);

create table grade (
	id int primary key, 
	description varchar(30)
);

create table assignment (
	id int primary key auto_increment, 
	student_id int not null,
	assignment_nbr int not null,
	class_id int not null,
	grade_id int default 0, 
	index student_id_idx (student_id)
);

create table major_class_relationship (
	id int primary key auto_increment, 
	major_id int not null, 
	class_id int not null
);

create table student_class_relationship (
	id int primary key auto_increment,
	student_id int not null, 
	class_id int not null
);

-- Foreign key constraints

alter table instructor add constraint fk_instructor_major foreign key (major_id) references major (id);
alter table class add constraint fk_class_instructor foreign key (instructor_id) references instructor (id);
alter table assignment add constraint fk_assignment_student foreign key (student_id) references student(id);
alter table assignment add constraint fk_assignment_class foreign key (class_id) references class(id);
alter table assignment add constraint fk_assignment_grade foreign key (grade_id) references grade (id);
alter table student add constraint fk_student_major foreign key (major_id) references major (id);
alter table major_class_relationship add constraint fk_mcr_major foreign key (major_id) references major (id);
alter table major_class_relationship add constraint fk_mcr_class foreign key (class_id) references class (id);
alter table student_class_relationship add constraint fk_scr_student foreign key (student_id) references student (id);
alter table student_class_relationship add constraint fk_scr_class foreign key (class_id) references class (id);

-- Adding pre_req as a foreign key for the Advanced challenge
alter table class add constraint fk_class_prereq foreign key (pre_req) references class (id);
