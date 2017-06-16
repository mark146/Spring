package entity;

import java.sql.*;
import java.util.*;
import org.springframework.jdbc.core.*;
import vo.*;

public class BoardEntityImpl implements IBoardEntity{
	private JdbcTemplate jdbcTemplate;

	public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void getArticleCount(BoardVO vo) {
		int count = 0;
		String sql = "select count(*) from tb_board";
		count = jdbcTemplate.queryForInt(sql);
		vo.setCount(count);
	}

	@SuppressWarnings("unchecked")
	public void getArticles(BoardVO vo){
		String sql = "select * from tb_board order by ref desc, re_step asc limit ?,? ";
		List<BoardVO> list = jdbcTemplate.query(sql, new Object[] { vo.getStartRow()-1, vo.getPageSize() }, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPasswd(rs.getString("passwd"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip")); 
				return article;
			}
		});
		vo.setList(list);
	}

	public void insertArticle(BoardVO vo) {
		StringBuffer buffer = new StringBuffer();
		int num = vo.getNum();
		int ref = vo.getRef();
		int re_step = vo.getRe_step();
		int re_level = vo.getRe_level();
		vo.setReadcount(0);

		buffer.append(" select max(num) from tb_board ");
		int number = jdbcTemplate.queryForInt(buffer.toString());
		buffer.delete(0, 80);

		if (number > 0) {
			number += 1;
		} else {
			number = 1;
		}

		if (num != 0)  {  
			buffer.append(" update tb_board set re_step=re_step+1 where ref= ? and re_step> ? ");
			jdbcTemplate.update(buffer.toString(), new Object[] {ref, re_step});
			buffer.delete(0, 80);
			re_step = re_step + 1;
			re_level = re_level + 1;
		} else {
			ref = number;
			re_step = 0;
			re_level = 0;
		}	 

		buffer.append("insert into tb_board(writer,email,subject,passwd,reg_date,readcount,ref,re_step,re_level,content,ip) values(?,?,?,?,?,?,?,?,?,?,?)");
		jdbcTemplate.update(buffer.toString(), new Object[] {vo.getWriter(), vo.getEmail(), vo.getSubject(), vo.getPasswd(),vo.getReg_date(), vo.getReadcount(), ref, re_step, re_level, vo.getContent(), vo.getIp()});
		buffer.delete(0, 150);
	}

	public void getArticle(BoardVO vo) {
		StringBuffer buffer = new StringBuffer(60);
		buffer.append("update tb_board set readcount=readcount+1 where num = ?");
		jdbcTemplate.update(buffer.toString(), new Object[] {vo.getNum()});
		buffer.delete(0, 80);

		buffer.append("select * from tb_board where num = ?");
		jdbcTemplate.query(buffer.toString(), new Object[] { vo.getNum()}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				vo.setNum(rs.getInt("num"));
				vo.setWriter(rs.getString("writer"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setReg_date(rs.getTimestamp("reg_date"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setRef(rs.getInt("ref"));
				vo.setRe_step(rs.getInt("re_step"));
				vo.setRe_level(rs.getInt("re_level"));
				vo.setContent(rs.getString("content"));
				vo.setIp(rs.getString("ip"));
				return vo;
			}
		});
	}

	public void updateGetArticle(BoardVO vo) {
		StringBuffer buffer = new StringBuffer(60);
		buffer.append("select * from tb_board where num = ?");
		jdbcTemplate.query(buffer.toString(), new Object[] { vo.getNum()}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				vo.setNum(rs.getInt("num"));
				vo.setWriter(rs.getString("writer"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setReg_date(rs.getTimestamp("reg_date"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setRef(rs.getInt("ref"));
				vo.setRe_step(rs.getInt("re_step"));
				vo.setRe_level(rs.getInt("re_level"));
				vo.setContent(rs.getString("content"));
				vo.setIp(rs.getString("ip"));
				return vo;
			}
		});
	}

	public void updateArticle(BoardVO vo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select passwd from tb_board where num = ?");
		int dbpasswd = jdbcTemplate.queryForInt(buffer.toString(), new Object[] { vo.getNum()} );
		buffer.delete(0, 60);

		if(dbpasswd != Integer.parseInt(vo.getPasswd())){
			vo.setCheck(0);
		} else {
			buffer.append("update tb_board set writer=?, email=?, subject=?, passwd=?, content=? where num=?");
			jdbcTemplate.update(buffer.toString(), new Object[] {vo.getWriter(), vo.getEmail(), vo.getSubject(), vo.getPasswd(), vo.getContent(), vo.getNum()});
			vo.setCheck(1);
		}
	}

	public void deleteArticle(BoardVO vo) {
		StringBuffer buffer = new StringBuffer(60);
		buffer.append(" select passwd from tb_board where num = ? ");
		int dbpasswd = jdbcTemplate.queryForInt(buffer.toString(), new Object[] { vo.getNum()} );
		buffer.delete(0, 60);

		if(dbpasswd != Integer.parseInt(vo.getPasswd())){
			vo.setCheck(0);
		} else {
			buffer.append("delete from tb_board where num=?");
			jdbcTemplate.update(buffer.toString(), new Object[] {vo.getNum()});
			vo.setCheck(1);
		}
	}
}