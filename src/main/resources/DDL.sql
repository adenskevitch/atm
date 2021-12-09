create database atm;
use atm;

create table if not exists Banks (
id serial,
name varchar(50) not null unique,
primary key (id)
);

create table if not exists ATMs (
id serial,
cash int unsigned,
bank_id bigint unsigned not null,
primary key (id),
constraint fk_ATMs_Bank foreign key(bank_id) references Banks (id)
on update no action on delete cascade
);

create table if not exists Accounts (
id serial,
money decimal(20,2),
account_number varchar(28),
lock_status boolean not null default false,
bank_id bigint unsigned not null,
primary key (id),
constraint fk_Accounts_Bank foreign key (bank_id) references Banks (id)
on update no action on delete cascade
);

create table if not exists Cards (
id serial,
card_number varchar(16) not null,
pin varchar(4) not null,
account_id bigint unsigned not null,
primary key (id),
constraint fk_Cards_Account foreign key (account_id) references Accounts (id)
on update no action on delete cascade
);

