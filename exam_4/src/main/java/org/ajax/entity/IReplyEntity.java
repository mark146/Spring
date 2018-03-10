package org.ajax.entity;

import java.util.*;
import org.ajax.vo.*;

public interface IReplyEntity {

	public List<ReplyVO> list(Integer bno) throws Exception;
	
	public void create(ReplyVO vo) throws Exception;
	
	public void update(ReplyVO vo) throws Exception;
	
	public void delete(Integer rno) throws Exception;
	
}
