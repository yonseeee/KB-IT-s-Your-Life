CREATE DATABASE sejong_festival_2025;

use sejong_festival_2025;
alter table scheduletbl add foreign key(eventID) references eventtbl(eventID);
alter table scheduletbl add foreign key(artistID) references artisttbl(artistID);
alter table scheduletbl add foreign key(stageID) references stagetbl(stageID);

select artistName, genre from artistTbl;
select*from artistTbl where debutYear>=2015;
select artistName from artistTbl where genre='아이돌';

select * from scheduletbl where durationMin>=40;

select * from stagetbl where capacity>=2000;
select artistName, debutYear from artisttbl order by debutYear desc;
select scheduleID, durationMin, durationMin+5 as '예상종료시간(분)' from scheduletbl;
select scheduleID, concat_ws(' ', eventDate, performTime) as 공연일시
from eventtbl E 
join scheduletbl S
on E.eventID=S.eventID;

select artistName, genre from artisttbl order by genre, artistName;
select stageName, concat(capacity, '명 수용가능')  as 수용정보 from stagetbl;
select artistName, left(artistName, 3) as 약칭 from artisttbl;
select artistID, artistName, genre, debutYear from artisttbl where artistName like '%밴드%';
select artistName, lower(artistName) as 소문자표기 from artisttbl;
select stageName, replace(stageName, '존', '') as 구역명 from stagetbl;
select distinct trim(genre) as 장르 from artisttbl order by  trim(genre);
select * from eventtbl where eventDate>=NOW();
select S.scheduleID, E.eventDate, DAYOFWEEK(E.eventDate) as 요일
from eventtbl E
join scheduletbl S
on E.eventID=S.eventID;

select S.scheduleID, S.performTime, addtime(S.performTime, '00:10:00') as 예상종료시각
from eventtbl E
join scheduletbl S
on E.eventID=S.eventID;

select eventName, YEAR(eventDate) as 연도, MONTH(eventdate) as 월, day(eventdate) as 일 from eventtbl;

select eventDate, sum(debutYear) as debutYearSum
from artisttbl A
join scheduletbl S
on A.artistID=S.artistID
join eventtbl E
on S.eventID=E.eventID
group by eventDate
order by sum(debutYear) desc limit 1;
;