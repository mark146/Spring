create table tbl_user (
 uid varchar(50) NOT NULL,
 upw varchar(50) NOT NULL,
 uname varchar(100) NOT NULL,
 upoint int NOT NULL DEFAULT 0,
 primary key(uid)
);

create table tbl_message (
 mid int NOT NULL  AUTO_INCREMENT,
 targetid varchar(50) NOT NULL,
 sender varchar(50) NOT NULL,
 message text NOT NULL,
 opendata TIMESTAMP,
 senddate TIMESTAMP NOT NULL DEFAULT now(),
 primary key(mid)
);

alter table tbl_message add constraint fk_usertarget
forign key (targetid) references tbl_user(uid);

alter table tbl_message add constraint fk_usersender
foreign key(targetid) references tbl_user(uid);

insert into tbl_user(uid, upw, uname) values ('user00', 'user00', 'IRON MAN');
insert into tbl_user(uid, upw, uname) values ('user01', 'user01', 'CAPTAIN');
insert into tbl_user(uid, upw, uname) values ('user02', 'user02', 'HULK');


select * from tbl_message;

select * from tbl_user;
