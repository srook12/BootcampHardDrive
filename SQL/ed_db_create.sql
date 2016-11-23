use education

-- drop tables if they exist
drop table if exists department;


-- create tables
create table department(
       id int not null auto_increment,
       code varchar(4),
       name varchar(20),  
       primary key id
); 

create table class(
       id int not null auto_increment, 
       department_id int not null,
       number varchar(4) not null,
       name varchar(50) not null, 
       credits int not null,
       description varchar(500),
       foreign key (department_id) references department(id)
);

-- insertions into department
insert into department (code, name) values ("ACCT", "Accounting");
insert into department (code, name) values ("", "");
insert into department (code, name) values ("", "");
insert into department (code, name) values ("", "");
insert into department (code, name) values ("", "");
insert into department (code, name) values ("", "");
insert into department (code, name) values ("", "");
insert into department (code, name) values ("", "");
insert into department (code, name) values ("", "");
insert into department (code, name) values ("", "");
insert into department (code, name) values ("", "");
insert into department (code, name) values ("", "");
insert into department (code, name) values ("", "");
insert into department (code, name) values ("", "");
insert into department (code, name) values ("", "");
insert into department (code, name) values ("", "");
