use sqldb;

select *
from buytbl
inner join usertbl
on buytbl.userID=usertbl.userID
where buytbl.userID='JYP';

select *
from buytbl
right outer join usertbl
on buytbl.userID=usertbl.userID;

-- 구매 이력이 없는 사용자만 출력하세요.
select *
from buytbl b
right outer join usertbl u
on b.userID=u.userID
-- where b.userID=null
where IFNULL(b.userID, TRUE)
order by b.userId;