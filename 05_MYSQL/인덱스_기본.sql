use sqldb;

create table tbl1(
	a int primary key,
    b int,
    c int
);

create table tbl2(
	a int primary key, -- PK: 클러스터형 인덱스 생성
    b int unique, -- UQ: 보조 인덱스 생성
    c int unique,
    d int
);

create table tbl3(
	a int unique,
    b int unique,
    c int unique,
    d int
);
show index from tbl3;

create table tbl4(
	a int unique not null,
    b int unique,
    c int unique,
    d int
);
show index from tbl4;
create table tbl5(
	a int unique not null,
    b int unique,
    c int unique,
    d int primary key -- unique+not null과 pk가 둘 다 있다면 pk가 클러스터형 인덱스
);

show index from tbl5;



create database if not exists testdb;
use testdb;

drop table if exists usertbl;
create table usertbl(
	userID char(8) not null primary key,
    name varchar(10) not null,
    birthYear int not null,
    addr char(2) not null
);
show index from usertbl;
insert into usertbl values('LSG', '이승기', 1987, '서울'),('KBS', '김범수', 1979, '경남'),('KKH', '김경호', 1971, '전남'),('JYP', '조용필', 1950, '경기'),('S나', '성시경', 1979, '서울');
select * from usertbl;

alter table usertbl drop primary key;
alter table usertbl add constraint pk_name primary key(name);
select * from usertbl;