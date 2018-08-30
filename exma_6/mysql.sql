create table users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
) engine=InnoDB character set = utf8;

create table authorities(
	username varchar(50) not null,
	authority varchar(50) not null
) engine=InnoDB character set = utf8;

create UNIQUE INDEX ix_auth_username ON authorities (username, authority);

insert into users values('user', '{noop}1234', true);
insert into users values('manager', '{noop}1234', true);
insert into users values('admin', '{noop}1234', true);

insert into authorities values('user', 'USER');
insert into authorities values('manager', 'USER_MANAGER');
insert into authorities values('admin', 'USER_ADMIN');

delete from authorities;

delete from users;

drop table authorities;

drop table users;

select * from users;

select * from authorities;
