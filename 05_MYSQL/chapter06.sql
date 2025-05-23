SELECT * FROM employees.title;

USE employees;
SELECT * FROM titles;

SELECT first_name FROM employees;

SELECT * -- 모든컬럼
FROM title; -- titles 테이블

SHOW DATABASES;
SHOW TABLES;
DESCRIBE employees; 
DESC employees;


USE sqldb;
SELECT * FROM usertbl
WHERE name='김경호';

SELECT * FROM employees.employees
WHERE first_name='georgi'; -- 동등 연산 시 대소문자 구분 x

SELECT COUNT(*) 
FROM employees.employees;

CREATE