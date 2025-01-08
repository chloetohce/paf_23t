drop database if exists cart;
create database cart;

use cart;

create table orders(
    oid int not null auto_increment,
    name varchar(48) not null,
    address varchar(256) not null,
    delivery_date date,

    constraint pk_oid primary key(oid)
);

create table items(
    item_id int not null auto_increment,
    name varchar(48) not null, 
    quantity int,
    unit_price float,
    oid int,

    constraint pk_item_id primary key(item_id),
    constraint fk_oid foreign key(oid) references orders(oid)
);

grant all privileges on cart.* to 'chloe'@'%';
flush privileges;