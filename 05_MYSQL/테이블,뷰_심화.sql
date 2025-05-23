create database tabledb2;

use tabledb2;

create table usertbl(
	userID char(8) not null primary key,
    name varchar(10) not null,
    birthyear int not null
);
    
create table buytbl(
	num int auto_increment not null primary key,
    userID varchar(8) not null,
    prodName char(6) not null,
    foreign key(userID) references usertbl(userID)
);


alter table buytbl drop foreign key buytbl_ibfk_1;
drop table if exists usertbl;
drop table if exists buytbl;

create table usertbl(
	userID char(8) not null primary key,
    name varchar(10) not null,
    birthyear int not null
);

create table buytbl(
	num int auto_increment not null primary key,
    userID char(8) not null,
    prodName char(6) not null,
    foreign key(userID) references usertbl(userID)
);

alter table buytbl drop foreign key buytbl_ibfk_1;
drop table if exists usertbl;
drop table if exists buytbl;

create table usertbl(
	userID char(8) not null primary key,
    name varchar(10) not null,
    birthyear int not null,
    email char(30) null unique
);

alter table buytbl drop foreign key buytbl_ibfk_1;
drop table if exists usertbl;
create table usertbl(
	userID char(8) not null primary key,
    name varchar(10),
    birthyear int check(birthYear>=1900 and birthYear<=2023),
    mobile char(3) not null
);



drop table if exists usertbl;
create table usertbl(
	userID char(8) not null primary key,
    name varchar(10) not null,
    birthyear int default -1,
    addr char(2) not null default '서울',
    mobile1 char(3),
    mobile2 char(8),
    height smallint default 170,
    mDate date
);

alter table usertbl drop column mobile1;
alter table usertbl change column name uName varchar(20) null;
alter table usertbl drop primary key;

use employees;

drop view if exists employees_info;
create view employees_info as 
select e.emp_no, e.birth_date, e.first_name, e.last_name,
e.gender, e.hire_date, t.title, t.from_date t_from, t.to_date t_to,
salary, s.from_date s_from, s.to_date s_to
from employees e
join titles t
on e.emp_no=t.emp_no
join salaries s
on t.emp_no=s.emp_no
;

select * from employees_info;
select * from employees_info where s_to='9999-01-01';

create view emp_dept_info
as select de.emp_no, de.dept_no, d.dept_name, de.from_date, de.to_date
from departments d
join dept_emp de
on d.dept_no=de.dept_no;

select * from emp_dept_info order by emp_no;
select * from emp_dept_info where to_date='9999-01-01' order by emp_no;
