drop table tb_board;

create table tb_board (
	num  int  not  null  auto_increment,
	writer   varchar(20),
	email   varchar(10),	
	subject   varchar(100),	
	passwd   varchar(10),
	reg_date   datetime,
	readcount  int,
	ref   int,
	re_step   int,
    re_level  int,
	content    text,
    ip   varchar(20),
	primary key (num)
);