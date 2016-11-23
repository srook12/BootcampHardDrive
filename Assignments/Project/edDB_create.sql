-- Database Creation Script

use education;

-- Drop tables if they exist
drop table if exists prerequisites;
drop table if exists student_classes_taken;
drop table if exists major_class_relationship;
drop table if exists instructor;
drop table if exists class_list;
drop table if exists class;
drop table if exists classroom;
drop table if exists department;
drop table if exists student;
drop table if exists major;

-- create tables
create table major(
	id int primary key auto_increment,
	name varchar(50) not null,
	description varchar(1000) not null,
	req_sat int not null
);

create table department(
	id int primary key auto_increment,
	code varchar(10) not null, 
	name varchar(50) not null
);

create table instructor(
	id int primary key auto_increment,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	year_hired int not null,
	is_tenured tinyint not null default 0,
	department_id int,
	foreign key (department_id) references department(id)
);

create table student(
	id int primary key auto_increment,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	sat int,
	gpa decimal(4, 2) not null,
	major_id int,
	foreign key (major_id) references major(id)
);

create table class(
	id int primary key auto_increment,
	department_id int not null,
	num varchar(10) not null,
	credits int not null,
	description varchar(1000) not null,
	foreign key (department_id) references department(id)
);

create table classroom(
	id int primary key auto_increment,
	building varchar(30) not null,
	num int not null,
	num_seats int not null
);

create table class_list(
	id int primary key auto_increment,
	class_id int not null,
	section int not null,
	semester varchar(15) not null,
	classroom_id int not null,
	days set ("M", "T", "W", "R", "F", "S") not null,
	begin_time time not null,
	end_time time not null,
	foreign key (class_id) references class(id),
	foreign key (classroom_id) references classroom(id) 
);

create table major_class_relationship(
	id int primary key auto_increment,
	major_id int not null,
	class_id int not null,
	foreign key (major_id) references major(id),
	foreign key (class_id) references class(id)
);

create table student_classes_taken(
	id int primary key auto_increment,
	student_id int not null,
	class_list_id int not null,
	grade set ("A", "B", "C", "D", "F"),
	foreign key (student_id) references student(id),
	foreign key (class_list_id) references class_list(id)
);

create table prerequisites(
	id int primary key auto_increment,
	class_id int not null,
	prereq_class_id int not null,
	foreign key (class_id) references class(id),
	foreign key (prereq_class_id) references class(id)
);

-- Insert into major
insert into department (code, name) values ('ACCT', 'Accounting');
insert into department (code, name) values ('AHS', 'Allied Health Sciences');
insert into department (code, name) values ('ASL', 'American Sign Language');
insert into department (code, name) values ('ANTH', 'Anthropology');
insert into department (code, name) values ('ART', 'Art + Design');
insert into department (code, name) values ('APL', 'Assessment for Prior Learning');
insert into department (code, name) values ('ASTR', 'Astronomy');
insert into department (code, name) values ('BIO', 'Biology');
insert into department (code, name) values ('BA', 'Business Administration');
insert into department (code, name) values ('CHEM', 'Chemistry');
insert into department (code, name) values ('CMST', 'Communication Studies');
insert into department (code, name) values ('CADD', 'Computer Aided Design &amp; Draft');
insert into department (code, name) values ('CIS', 'Computer Information Systems');
insert into department (code, name) values ('CSI', 'Computer Science');
insert into department (code, name) values ('CJ', 'Criminal Justice');
insert into department (code, name) values ('DRAM', 'Drama');
insert into department (code, name) values ('ES', 'Earth Science');
insert into department (code, name) values ('ECON', 'Economics');
insert into department (code, name) values ('EDUC', 'Education');
insert into department (code, name) values ('ELEC', 'Electronics');
insert into department (code, name) values ('ENGR', 'Engineering');
insert into department (code, name) values ('ENGT', 'Engineering Technology');
insert into department (code, name) values ('ENG', 'English');
insert into department (code, name) values ('ENV', 'Environmental Sciences');
insert into department (code, name) values ('FIN', 'Finance');
insert into department (code, name) values ('FS', 'Forensic Science');
insert into department (code, name) values ('FR', 'French');
insert into department (code, name) values ('GEOG', 'Geography');
insert into department (code, name) values ('GER', 'German');
insert into department (code, name) values ('HLTH', 'Health');
insert into department (code, name) values ('HIST', 'History');
insert into department (code, name) values ('HD', 'Human Development');
insert into department (code, name) values ('ISS', 'Information Systems Security');
insert into department (code, name) values ('IDS', 'Interdisciplinary Studies');
insert into department (code, name) values ('MC', 'Mass Communications');
insert into department (code, name) values ('MATH', 'Mathematics');
insert into department (code, name) values ('MAS', 'Medical Assisting');
insert into department (code, name) values ('MUS', 'Music');
insert into department (code, name) values ('NURS', 'Nursing');
insert into department (code, name) values ('OS', 'Office Systems');
insert into department (code, name) values ('ORIE', 'Orientation');
insert into department (code, name) values ('PL', 'Paralegal');
insert into department (code, name) values ('PHIL', 'Philosophy');
insert into department (code, name) values ('PHOT', 'Photography');
insert into department (code, name) values ('PE', 'Physical Education');
insert into department (code, name) values ('SCI', 'Physical Science');
insert into department (code, name) values ('PHYS', 'Physics');
insert into department (code, name) values ('PS', 'Political Science');
insert into department (code, name) values ('PN', 'Practical Nursing');
insert into department (code, name) values ('PSY', 'Psychology');
insert into department (code, name) values ('RELG', 'Religion');
insert into department (code, name) values ('SOC', 'Sociology');
insert into department (code, name) values ('SPAN', 'Spanish');
insert into department (code, name) values ('SDEV', 'Student Development');
insert into department (code, name) values ('THEA', 'Theatre');
insert into department (code, name) values ('VPA', 'Visual and Performing Arts');