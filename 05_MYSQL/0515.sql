use sqldb;

select *
from buytbl b join usertbl u
on b.userID=u.userID;

select *
from buytbl b join usertbl u
on b.userID=u.userID
where b.userId='JYP';


-- sqldb데이터베이스에서다음조건을처리하세요. 
-- 각사용자별로구매이력을출력하세요.
-- 연결컬럼은userID로함
-- ○ 결과를userID를기준으로오름차순으로정렬함
-- ○ 구매이력이없는사용자도출력하세요. 
--  userID, name, prodName, addr, 연락처를 다음과 같이 출력함
SELECT b.userID, name, prodName, addr, CONCAT(mobile1, mobile2) as 연락처
from buytbl b
left outer join usertbl u
on b.userID=u.userID
order by userID;

select * from buytbl;
select * from usertbl;

SELECT *
from buytbl b
right outer join usertbl u
on b.userID=u.userID
where mobile1 is not null
order by b.userID;

SELECT *
from buytbl b
right outer join usertbl u
on b.userID=u.userID
where mobile1 is null
order by b.userID;

create table stdtbl(
stdName VARCHAR(10) NOT NULL PRIMARY KEY,
addr CHAR(4) NOT NULL
);
create table clubtbl(
clubName VARCHAR(10) not null primary key,
roomNo CHAR(4) not null
);
create table stdclubtbl(
num int auto_increment not null primary key,
stdName VARCHAR(10) not null,
clubName VARCHAR(10) not null,
foreign key(stdName) references stdtbl(stdName),
foreign key(clubName) references clubtbl(clubName)
);

insert into stdclubtbl 
values (NULL, '김범수', '바둑'),(NULL, '김범수','축구'), (NULL, '조용필','축구'),(NULL, '은지원', '축구'),(NULL, '은지원','봉사'),(NULL, '바비킴', '봉사');

select s.stdName, s.addr, sc.clubName, c.roomNo
from stdtbl s
join stdclubtbl sc
on s.stdName=sc.stdName
join clubtbl c
on sc.clubName=c.clubName
order by s.stdName;



select c.clubName, c.roomNo, s.stdName, s.addr
from stdtbl s
join stdclubtbl sc
on s.stdName=sc.stdName
join clubtbl c
on sc.clubName=c.clubName
order by c.clubName;

create table empTbl(emp CHAR(3), manager CHAR(3), empTel VARCHAR(8));
insert into emptbl values('나사장', NULL, '0000');
insert into emptbl values('김재무', '나사장', '2222');
insert into emptbl values('김부장', '김재무', '2222-1');
insert into emptbl values('이부장', '김재무', '2222-2');
insert into emptbl values('우대리', '이부장', '2222-2-1');
insert into emptbl values('지사원', '이부장', '2222-2-2');
insert into emptbl values('이영업', '나사장', '1111');
insert into emptbl values('한과장', '이영업', '1111-1');
insert into emptbl values('최정보', '나사장', '3333');
insert into emptbl values('윤차장', '최정보', '3333-1');
insert into emptbl values('이주임', '윤차장', '3333-1-1');

select E.emp as 부하직원, S.emp as 직속상관, S.empTel as 직속상관연락처
from emptbl E 
join emptbl S
on E.manager=S.emp;

use employees;

select E.emp_no, E.first_name, E.last_name, T.title
from employees as E
join titles as T
on E.emp_no=T.emp_no;

select * from titles;
select E.emp_no, E.birth_date, E.first_name, E.last_name, E.gender, E.hire_date,T.title, S.salary
from employees as E
join titles as T
on E.emp_no=T.emp_no
join salaries as S
on T.emp_no=S.emp_no
;

select E.emp_no, E.first_name, E.last_name, D.dept_name
from titles T
join employees E
on T.emp_no=E.emp_no
join dept_emp DE
on E.emp_no=DE.emp_no
join departments D
on DE.dept_no=D.dept_no
where T.to_date='9999-01-01'
order by emp_no;

select*from employees;
select*from dept_emp;
select*from departments;
select * from employees;
select * from titles;

select D.dept_no, D.dept_name, count(*)
from titles T
join employees E
on T.emp_no=E.emp_no
join dept_emp DE
on E.emp_no=DE.emp_no
join departments D
on DE.dept_no=D.dept_no
where T.to_date='9999-01-01'
group by dept_no
order by dept_no;

select E.emp_no, E.first_name, E.last_name, D.dept_name, DE.from_date, DE.to_date
from employees E
join dept_emp DE
on E.emp_no=DE.emp_no
join departments D
on DE.dept_no=D.dept_no
order by E.emp_no;
