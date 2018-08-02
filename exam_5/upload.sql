create table tbl_attach (
 fullName varchar(150) NOT NULL,
 bno int NOT NULL,
 regdate timestamp default now(),
 primary key(fullName)
);

alter table tbl_attach add constraint fk_board_attach
foreign key(bno) references tbl_board(bno);