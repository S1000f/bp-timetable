create database bptimetable;

use bptimetable;

create table USER (
    USER varchar(30) not null,
    PASSWD varchar(30) not null,
    HAS_SUB int null,
    HAS_PLAN int null,
    primary key (USER)
);

create table subject (
    sub_num int not null auto_increment primary key,
    user varchar(30) not null,
    sid int not null,
    sub_name varchar(20) not null,
    color varchar(20) null,
    teacher varchar(20) null,
    description varchar(100) null,
    foreign key (user) references USER(USER) on update cascade on delete cascade
);

create table plan (
    row_num bigint not null auto_increment primary key,
    user varchar(30) not null,
    year int not null,
    month int not null,
    week int not null,
    mon int null,
    tue int null,
    wed int null,
    thur int null,
    fri int null,
    sat int null,
    sun int null,
    foreign key (user) references USER(USER) on update cascade on delete cascade
);