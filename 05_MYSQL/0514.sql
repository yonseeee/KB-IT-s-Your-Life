USE speed_quiz;

INSERT INTO quiz_words 
VALUES(NULL, '피카츄','캐릭터',2,'노란색,전기','2025-05-10');
INSERT INTO quiz_words 
VALUES(NULL, '라면','음식',1,'뜨거운 국물, 면발','2025-05-12');
INSERT INTO quiz_words 
VALUES(NULL, '된장찌개','음식',2,NULL,'2025-05-11');
INSERT INTO quiz_words 
VALUES(NULL, '해리포터','캐릭터',5,'호그와트','2025-05-12');
INSERT INTO quiz_words 
VALUES(NULL, '붕어빵','음식',1,'겨울 간식','2025-05-08');
INSERT INTO quiz_words 
VALUES(NULL, '김연아','연예인',3,'피겨 여왕','2025-05-11');
INSERT INTO quiz_words 
VALUES(NULL, '손흥민','연예인',3,'축구 선수','2025-05-10');
INSERT INTO quiz_words 
VALUES(NULL, '아이스크림','음식',1,'차갑다','2025-05-13');

INSERT INTO players
VALUES(NULL, '지우',22,'서울','2025-05-01');
INSERT INTO players
VALUES(NULL, '이슬이',21,'부산','2025-05-03');
INSERT INTO players
VALUES(NULL, '웅이',23,'서울','2025-05-05');
INSERT INTO players
VALUES(NULL, '태훈',33,'제주','2025-05-06');
INSERT INTO players
VALUES(NULL, '민지',25,'부산','2025-05-04');

INSERT INTO game_sessions
VALUES(NULL, 1,'개인전',85,'2025-05-10');
INSERT INTO game_sessions
VALUES(NULL, 2,'개인전',92,'2025-05-11');
INSERT INTO game_sessions
VALUES(NULL, 3,'팀전',88,'2025-05-11');
INSERT INTO game_sessions
VALUES(NULL, 4,'개인전',77,'2025-05-12');
INSERT INTO game_sessions
VALUES(NULL, 1,'개인전',99,'2025-05-13');

INSERT INTO reports
VALUES(NULL, '피카츄','오타','이슬이','2025-05-10');
INSERT INTO reports
VALUES(NULL, '피카츄','오타','지우','2025-05-11');
INSERT INTO reports
VALUES(NULL, '피카츄','부적절함','웅이','2025-05-12');
INSERT INTO reports
VALUES(NULL, '마라탕','오타','민지','2025-05-11');
INSERT INTO reports
VALUES(NULL, '포켓몬빵','부적절함','민지','2025-05-13');
INSERT INTO reports
VALUES(NULL, '김연아','부적절함','test','2025-05-13');


SELECT * FROM quiz_words WHERE category='음식';
SELECT word, difficulty FROM quiz_words WHERE difficulty>=3;
SELECT * FROM quiz_words WHERE hint IS NOT NULL;
SELECT * FROM quiz_words WHERE word LIKE '%빵%';
select nickname, age FROM players WHERE age BETWEEN 20 AND 29;
SELECT * FROM players WHERE region='부산';
SELECT * FROM quiz_logs WHERE is_correct='X';
SELECT * FROM quiz_logs WHERE time_taken<=5;
SELECT * FROM reports WHERE reason='오타';
select * from quiz_words where created_at='2025-05-13';

select category, count(*) as word_count from quiz_words group by category;
select category, AVG(difficulty) as avg_diff 
from quiz_words 
where difficulty>=3 
group by category;

select region, count(*) as user_count from players group by region having count(*)>=2;
select avg(time_taken) as avg_time from quiz_logs where is_correct='O';
select reason, count(*) as report_count from reports group by reason;
select reported_at, count(*) as cnt from reports group by reported_at having count(*)>=2;
select category, max(difficulty) as max_diff from quiz_words group by category;
select FLOOR(age/10)*10 as age_group, avg(age) as avg_age from players group by FLOOR(age/10)*10;

select * FROM quiz_logs;
select answered_at, SUM(CASE WHEN is_correct='O' THEN 1 ELSE 0 END)/COUNT(*) as accuracy from quiz_logs group by answered_at;
select category, count(*) as count from quiz_words group by category with rollup;


-- 3단계
select word, difficulty from quiz_words where difficulty=(SELECT MAX(difficulty) from quiz_words);
select * from quiz_words order by created_at desc limit 5;
select * from players order by joined_at limit 1;
select * from quiz_words where difficulty>(select avg(difficulty) from quiz_words);
select * from game_sessions where total_score>=90;
select * from reports where reported_at>= DATE_SUB(NOW(), INTERVAL 4 DAY) order by reported_at desc;
select player_id, total_score from game_sessions
where total_score=(select MAX(total_score) from game_sessions);
select * from players order by age desc limit 3;

select word, count(*) as cnt from reports group by word order by count(*) desc limit 1;
select distinct player_nickname from quiz_logs where (select count(*) from quiz_logs where is_correct='O')>=1;

insert into quiz_words 
values(NULL, '마라탕', '음식', 1,'혀가 얼얼한 맛', '2025-05-14');

SET SQL_SAFE_UPDATES = 0;
update quiz_words
set hint='힌트 없음'
where hint is null;

delete from players where region='제주';
select * from quiz_words;

update quiz_words
set difficulty=4
where word='마라탕';

delete from players where nickname='민지';
select * from players;

delete from game_sessions where total_score>=90;
select * from game_sessions;

select * from quiz_logs;
select * from quiz_words;

select word
from quiz_logs 
group by word 
having SUM(CASE WHEN is_correct='O' THEN 1 ELSE 0 END)/COUNT(*) < (select SUM(CASE WHEN is_correct='O' THEN 1 ELSE 0 END)/COUNT(*) from quiz_logs);

delete from quiz_words
where word IN (select word
from quiz_logs 
group by word 
having SUM(CASE WHEN is_correct='O' THEN 1 ELSE 0 END)/COUNT(*) < (select SUM(CASE WHEN is_correct='O' THEN 1 ELSE 0 END)/COUNT(*) from quiz_logs));

select * from quiz_words;


select * from reports;
select case when (select count(*) from reports where word='피카츄')>=3 THEN '주의' ELSE '양호' END as status ;

select created_at, count(*) as count from quiz_words group by created_at having count(*)>=1;

start transaction;
insert into quiz_words values(NULL, '포켓몬빵', NULL, NULL, NULL, NULL);
rollback;
select*from quiz_words;

delete from quiz_words where word='포켓몬빵';

