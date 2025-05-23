drop database if exists tabledb; -- 데이터베이스 삭제
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


-- 회원 테이블 데이터 입력
INSERT INTO usertbl 
VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8'),
('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4'), 
('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');

-- 구매 테이블 데이터 입력
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL, 30, 2); 
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1); 
INSERT INTO buytbl VALUES(NULL, 'KBS', '청바지', '전자', 1000, 1); 
-- 외래키 제약 조건에 의해 usertbl에 없는 userid를 참조하면 에러
-- INSERT INTO buytbl VALUES(NULL, 'JYP', '모니터', '전자', 200, 1);  에러

-- delete from usertbl where name='KBS';  에러 


-- 외래키 제약조건 삭제
alter table buytbl drop foreign key buytbl_ibfk_1;
-- usertbl 재정의
drop table if exists usertbl;
create table usertbl(
	userID CHAR(8) NOT NULL,
    name VARCHAR(10) NOT NULL,
    birthyear int not null,
    constraint primary key PK_userTBL_userID(userID)
);
    
drop table if exists prodTbl;
create table prodTbl(
	prodCode char(3) not null,
    prodID char(4) not null,
    prodDate datetime not null,
    proCur char(10) null,
    constraint PK_prodTbl_proCode_prodID
    primary key(prodCode, prodID)
);

INSERT INTO usertbl 
VALUES('LSG', '이승기', 1987),
('KBS', '김범수', 1979), 
('KKH', '김경호', '1971');

alter table buytbl add foreign key(userid) references usertbl(userID);


use sqldb;
create view v_userbuytbl
as select u.userid, u.name, b.prodName, u.addr, concat(u.mobile1, u.mobile2) as '연락처'
from usertbl u inner join buytbl b
on u.userid=b.userid;

select * from v_userbuytbl where name='김범수';