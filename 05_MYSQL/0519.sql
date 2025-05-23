create database recruitDB;
use recruitDB;

create table departments(
	dept_id INT not null primary key,
    dept_name varchar(30) not null
);

create table applicants(
	applicant_id int primary key,
    name varchar(50),
    email varchar(50) unique,
    phone varchar(15),
    dept_id int,
    apply_date date,
    foreign key(dept_id) references departments(dept_id)
);

alter table applicants modify column apply_date datetime default current_timestamp;

alter table applicants add constraint check (char_length(name) between 2 and 20);
alter table applicants add constraint check (char_length(phone)between 10 and 13);

insert into departments values (1,'개발팀'),(2,'인사팀'),(3,'마케팅팀');

insert into applicants values (101,'김지은','jkim@example.com','01012345678',1, default);
insert into applicants values (102,'이현수','hyunlee@example.com','01098765432',2, default);
insert into applicants values (103,'최은비','eumbi@example.com','01022223333',9, default);
insert into applicants values (104,'강민수','jkim@example.com','01044445555',1, default);

update applicants set name='김지혜' where applicant_id=101;
update departments set dept_name='인사팀' where dept_id=2;
update departments set dept_name='연구개발팀' where dept_id=1;

alter table applicants add column is_interviewed boolean default false;
alter table applicants drop column phone;
alter table applicants drop check applicants_chk_1;
alter table applicants change column name applicant_name varchar(50) CHECK (CHAR_LENGTH(applicant_name) BETWEEN 2 AND 20)
;


show create table applicants;
alter table applicants drop foreign key applicants_ibfk_1;

create view vw_dev_applicants as
select applicant_name, email, dept_name
from applicants a
join departments d
on a.dept_id=d.dept_id where dept_name='연구개발팀';
select * from vw_dev_applicants;

create view vw_h_email_applicants as
select applicant_name, email, apply_date
from applicants where email like 'h%';
select * from vw_h_email_applicants;

select applicant_name, apply_date from vw_applicant_summary;

update vw_applicant_summary set applicant_name='김수진' where email='jkim@example.com';

drop view vw_applicant_summary;
create view vw_applicant_summary as
select applicant_id, applicant_name, email, dept_id, apply_date from applicants;

select * from vw_applicant_summary;

insert into vw_applicant_summary value (999,'박지현','jhpark@example.com', 1, default);