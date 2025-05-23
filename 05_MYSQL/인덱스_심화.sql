use sqldb;
select * from usertbl;
show index from usertbl;

create index idx_usertbl_addr on usertbl(addr);
show index from usertbl;

show table status like 'usertbl';
analyze table usertbl;

-- unique는 중복값 있을 시 에러
create unique index idx_usertbl_birthYear on usertbl(birthYear);

create index idx_usertbl_name on usertbl(name);
show index from usertbl;
drop index idx_usertbl_name on usertbl;
show index from usertbl;
create unique index idx_usertbl_name_birthYear on usertbl(name, birthYear);

-- 인덱스 삭제
drop index idx_usertbl_addr on usertbl;
drop index idx_usertbl_birthYear on usertbl;
drop index idx_usertbl_name_birthYear on usertbl;


-- 실습 데이터베이스 및 사용자를 생성하고, 해당 데이터베이스에 대해 모든 권한을 부여하세요
create database scoula_db;
drop user if exists 'scoula'@'%';
create user 'scoula'@'%' identified by '1234';
grant all privileges on scoula_db.* to 'scoula'@'%';-- 해당 데이터베이스에 대한 권한 부여
grant all privileges on sqldb.* to 'scoula'@'%';
flush privileges; -- 실제 권한 적용