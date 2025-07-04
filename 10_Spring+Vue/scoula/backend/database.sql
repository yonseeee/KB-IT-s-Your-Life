drop table if exists tbl_member;
drop table if exists tbl_member_auth;


create table tbl_member
(
    username    varchar(50) primary key,
    password    varchar(128) not null,
    email       varchar(50)  not null,
    reg_date    datetime default now(),
    update_date datetime default now()
);

create table tbl_member_auth
(
    username varchar(50) not null,
    auth     varchar(50) not null,
    primary key (username, auth),
    constraint fk_authroities_users foreign key (username) references tbl_member (username)
);

insert into tbl_member(username, password, email)
values ('admin', '$2a$10$sn.dwyk3i25gZ6c4RhJBpOFg1kRFSutW1pfAvv82M7VT05aWKKx9y', 'admin@galapgos.org'),
       ('user0', '$2a$10$sn.dwyk3i25gZ6c4RhJBpOFg1kRFSutW1pfAvv82M7VT05aWKKx9y', 'user0@galapgos.org'),
       ('user1', '$2a$10$sn.dwyk3i25gZ6c4RhJBpOFg1kRFSutW1pfAvv82M7VT05aWKKx9y', 'user1@galapgos.org'),
       ('user2', '$2a$10$sn.dwyk3i25gZ6c4RhJBpOFg1kRFSutW1pfAvv82M7VT05aWKKx9y', 'user2@galapgos.org'),
       ('user3', '$2a$10$sn.dwyk3i25gZ6c4RhJBpOFg1kRFSutW1pfAvv82M7VT05aWKKx9y', 'user3@galapgos.org'),
       ('user4', '$2a$10$sn.dwyk3i25gZ6c4RhJBpOFg1kRFSutW1pfAvv82M7VT05aWKKx9y', 'user4@galapgos.org');

insert into tbl_member_auth (username, auth)
values ('admin', 'ROLE_ADMIN'),
       ('admin', 'ROLE_MANAGER'),
       ('admin', 'ROLE_MEMBER'),
       ('user0', 'ROLE_MANAGER'),
       ('user0', 'ROLE_MEMBER'),
       ('user1', 'ROLE_MEMBER'),
       ('user2', 'ROLE_MEMBER'),
       ('user3', 'ROLE_MEMBER'),
       ('user4', 'ROLE_MEMBER');
select *from tbl_member;


select m.username, password, email, reg_date, update_date, auth
from tbl_member m
         left outer join tbl_member_auth a
                         on m.username =a.username
where m.username = 'admin';


DROP TABLE IF EXISTS tbl_board_attachment;
CREATE TABLE tbl_board_attachment
(
    no           INTEGER AUTO_INCREMENT PRIMARY KEY,-- PK
    filename     VARCHAR(256) NOT NULL,-- 원본 파일 명
    path         VARCHAR(256) NOT NULL,-- 서버에서의 파일 경로
    content_type VARCHAR(56),
    size INTEGER,
    bno INTEGER NOT NULL,
    reg_date DATETIME DEFAULT now(),
    CONSTRAINT FOREIGN KEY (bno) REFERENCES tbl_board (no) ON DELETE CASCADE
);

select * from tbl_board;
delete from tbl_board where no in(8,9,14);