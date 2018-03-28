select * from tbl_message;

select * from tbl_user;

alter table tbl_board add column replycnt int default 0;

select 
	bno, title, content, writer, regdate, viewcnt, replycnt 
from 
	tbl_board 
where bno > 0 
order by bno desc, regdate desc

select * from tbl_board;