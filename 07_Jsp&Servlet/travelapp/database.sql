drop table if exists tbl_travel;

create table tbl_travel(
    no int auto_increment not null primary key,
    district varchar(50) not null,
    title varchar(512) not null,
    description text,
    address varchar(512),
    phone varchar(256)
);

select * from tbl_travel;

drop table if exists tbl_travel_image;
create table tbl_travel_image(
    no int auto_increment not null primary key ,
    filename varchar(512) not null,
    travel_no int,
    constraint foreign key (travel_no) references tbl_travel(no) on delete cascade
);