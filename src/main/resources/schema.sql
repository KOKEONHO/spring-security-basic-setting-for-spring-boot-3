drop table if exists member CASCADE;
create table member
(
    member_id bigint auto_increment,
    email varchar(255) not null,
    password varchar(255) not null,
    roles varchar(255) not null,
    primary key (member_id),
    unique (email)
);