drop database if exists tabledb;
create database tabledb;
use tabledb;

drop table if exists usertbl;

create table usertbl(
	userID CHAR(8) not null primary key,
    name varchar(10) not null,
    birthYear int not null,
    addr char(2) not null,
    mobile1 char(3) null,
    mobile2 char(8) null,
    height smallint null,
    mDate date null
    );
    
drop table if exists buytbl;

create table buytbl(
	num int auto_increment not null primary key,
    userid char(8) not null,
    prodName char(6) not null,
    groupName char(4) null,
    price int not null,
    amount smallint not null,
    foreign key(userid) references usertbl(userID)
);


INSERT INTO usertbl 
VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8'),
('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4'), 
('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');


INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL, 30, 2); 
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1); 
-- INSERT INTO buytbl VALUES(NULL, 'JYP', '모니터', '전자', 200, 1);  에러

-- delete from usertbl where name='KBS';  에러 