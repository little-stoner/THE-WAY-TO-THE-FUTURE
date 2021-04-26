-- auto-generated definition
create table user
(
    id         bigint unsigned auto_increment
        primary key,
    username   varchar(255)     not null,
    password   varchar(255)     not null,
    salt       varchar(255)     not null,
    valid      int(1) default 1 not null,
    created_by varchar(255)     not null,
    updated_by varchar(255)     not null,
    created_at datetime         not null,
    updated_at datetime         not null
);

