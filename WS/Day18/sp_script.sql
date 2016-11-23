drop procedure if exists getallstudents;
drop procedure if exists GetStudentMajor;
drop procedure if exists ClassesRemaining;
drop procedure if exists InsertStudent;

delimiter //

create procedure GetStudentMajor(in studentId int, out majorId int)
begin
select major_id into majorId from student where id = studentId;
end //

create procedure ClassesRemaining(in studentId int)
begin
declare majorId int;
call GetStudentMajor(studentId, majorId);

select id as CRN, concat(prefix, ' ', number) as Class
from class
where id in (
select mcr.class_id 
from major_class_relationship mcr
where mcr.major_id = majorId and mcr.class_id not in
	(select scr.class_id
	from student_class_relationship scr
	where scr.student_id = studentId));

end //

create procedure InsertStudent(in id_in int, in first_name_in varchar(30), in last_name_in varchar(30), in gpa_in decimal(5, 1), in sat_in int, in major_in int)
begin
  declare speciality condition for sqlstate '45000';

  if sat_in not between 400 and 1600 then
    signal sqlstate '45000' set message_text = 'SAT score must be between 400 and 1600!';
  end if;

  insert into student (id, first_name, last_name, gpa, sat, major_id) values (id_in, first_name_in, last_name_in, gpa_in, sat_in, major_in);
end //

delimiter ;