drop database if exists atm;
create database atm;
use atm;

create table if not exists Banks (
id serial,
name varchar(50) not null unique,
commission double unsigned,
primary key (id)
);

create table Addresses (
id serial,
city varchar(45) not null,
street varchar(45) not null,
building varchar(45) not null,
primary key (id));

create table if not exists ATMs (
id serial,
number varchar(8) unique not null,
cash int unsigned,
bank_id bigint unsigned not null,
address_id bigint unsigned not null,
primary key (id),
constraint fk_ATMs_Bank foreign key(bank_id) references Banks (id)
on update no action on delete cascade,
constraint fk_Addresses_ATM foreign key(address_id) references Addresses (id)
on update no action on delete cascade
);

create table if not exists Banknotes (
id serial,
denomination int not null,
number int unsigned,
currency_unit varchar(30) not null,
atm_id bigint unsigned not null,
primary key (id),
constraint fk_ATM_Banknotes foreign key(atm_id) references ATMs (id)
on update cascade on delete cascade
);

create table if not exists Accounts (
id serial,
money decimal(20,2),
number varchar(28) not null unique,
lock_status boolean not null default false,
bank_id bigint unsigned not null,
primary key (id),
constraint fk_Accounts_Bank foreign key (bank_id) references Banks (id)
on update no action on delete cascade
);

create table if not exists Cards (
id serial,
number char(64) not null unique,
pin char(64) not null,
blocked boolean not null default false,
account_id bigint unsigned not null,
primary key (id),
constraint fk_Cards_Account foreign key (account_id) references Accounts (id)
on update no action on delete cascade
);

