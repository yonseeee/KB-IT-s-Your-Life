-- 현재 서버에 존재하는 데이터베이스 확인
SHOW DATABASES;

-- 현재 데이터베이스를 employees로 설정하기 
USE employees;

-- employees 데이터베이스의 테이블 목록 보기
SHOW TABLES;

-- employees 테이블의 열 목록 출력하기 
DESC employees;

-- titles 테이블의 데이터 출력하기 
SELECT * FROM titles;


SELECT first_name FROM employees;
SELECT first_name, last_name, gender FROM employees;
SELECT * FROM employees;
SELECT first_name AS '이름', gender AS '성별', hire_date AS '회사 입사일' FROM employees;

USE sqldb;
SELECT * FROM usertbl WHERE name='김경호';
SELECT * FROM usertbl WHERE birthYear>=1970 AND height>=182;
SELECT * FROM usertbl WHERE height BETWEEN 180 AND 183;
SELECT * FROM usertbl WHERE addr IN ('경남', '전남','경북');
SELECT * FROM usertbl WHERE name LIKE '김%';
SELECT name, height FROM usertbl WHERE height>=(SELECT height FROM usertbl WHERE name='김경호');
SELECT * FROM usertbl ORDER BY mDate;
SELECT * FROM usertbl ORDER BY mDate DESC;
SELECT * FROM usertbl ORDER BY height DESC , name DESC;
SELECT DISTINCT addr FROM usertbl ORDER BY addr;


USE world;
SELECT Population FROM city WHERE CountryCode='KOR' ORDER BY Population DESC;
SELECT CountryCode, Population FROM city ORDER BY CountryCode, Population DESC;
SELECT COUNT(*) FROM city WHERE CountryCode='KOR'; 
SELECT * FROM city WHERE CountryCode IN ('KOR', 'CHN', 'JPN');
SELECT * FROM city WHERE CountryCode='KOR' AND Population>=1000000;
SELECT * FROM city WHERE CountryCode='KOR' ORDER BY Population DESC LIMIT 10;
SELECT * FROM city WHERE CountryCode='KOR' AND Population BETWEEN 1000000 AND 5000000;
