create database job_platform;
use job_platform;

create table company(
company_id int auto_increment primary key,
company_name varchar(100) not null,
industry varchar(50),
founded_year int check(founded_year>=1900)
);

create index idx_company_industry on company(industry);

create table recruit_post(
post_id int auto_increment primary key,
company_id int,
title varchar(100),
job_type varchar(20) check (job_type in('정규직','계약직','인턴')),
deadline date,
is_active boolean default true
);

alter table recruit_post add foreign key(company_id) references company(company_id);

insert into company values (null, '카카오','IT',2010),(null, '현대자동차','제조업',1967),(null, '토스','핀테크',2015),(null, '쿠팡','물류/유통',2010),(null, 'CJ ENM', '미디어', 1995),(null, '배달의민족','IT',2011);
insert into recruit_post 
values (
null,
(select company_id from company where company_name='카카오'),
'백엔드 개발자 채용',
'정규직',
'2025-06-15',
TRUE
);
insert into recruit_post 
values (
null,
(select company_id from company where company_name='현대자동차'),
'생산관리 신입 모집',
'정규직',
'2025-06-20',
TRUE
);

insert into recruit_post 
values (
null,
(select company_id from company where company_name='토스'),
'데이터 분석 인턴',
'인턴',
'2025-05-31',
TRUE
);

insert into recruit_post 
values (
null,
(select company_id from company where company_name='카카오'),
'UX 디자이너 계약직',
'계약직',
'2025-06-10',
FALSE
);

insert into recruit_post 
values (
null,
(select company_id from company where company_name='쿠팡'),
'물류센터 관리자 채용',
'정규직',
'2025-06-25',
TRUE
);

insert into recruit_post 
values (
null,
(select company_id from company where company_name='CJ ENM'),
'콘텐츠 마케팅 인턴',
'인턴',
'2025-05-30',
TRUE
);
 insert into recruit_post 
values (
null,
(select company_id from company where company_name='배달의민족'),
'앱 서비스 운영 계약직',
'계약직',
'2025-06-12',
TRUE
);
insert into recruit_post 
values (
null,
(select company_id from company where company_name='배달의민족'),
'데이터 엔지니어 채용',
'정규직',
'2025-06-18',
TRUE
);

   insert into recruit_post 
values (
null,
(select company_id from company where company_name='현대자동차'),
'브랜드전략팀 계약직 채용',
'계약직',
'2025-06-08',
FALSE
);
	insert into recruit_post 
values (
null,
(select company_id from company where company_name='쿠팡'),
'풀필먼트 혁신 프로젝트 인턴',
'인턴',
'2025-05-27',
TRUE
);

show index from recruit_post;
show index from company;

select * from recruit_post;

select post_id, title, job_type, deadline, is_active from recruit_post where is_active=true order by deadline;

select company_name, title, job_type, deadline, is_active
from recruit_post r
join company c
on r.company_id=c.company_id
order by company_name;

select company_name, industry, title, job_type, deadline, is_active
from recruit_post r
join company c
on r.company_id=c.company_id
where industry in ('IT', '핀테크')
order by deadline desc;

select company_name, title, job_type, deadline
from recruit_post r
join company c
on r.company_id=c.company_id
where deadline>='2025-05-25' and deadline<='2025-06-01'
order by deadline desc;

select company_name, title, job_type, deadline, is_active
from recruit_post r
join company c
on r.company_id=c.company_id
where title like '%데이터%'
order by deadline desc;

select company_name, count(*) as 공고수
from recruit_post r
join company c
on r.company_id=c.company_id
group by company_name
order by count(*) desc;

select company_name, count(*) as 공고수
from recruit_post r
join company c
on r.company_id=c.company_id
group by company_name
having count(*)>=2
order by count(*) desc;

select job_type, count(*) as '공고수'
from recruit_post
group by job_type
order by count(*) desc;

