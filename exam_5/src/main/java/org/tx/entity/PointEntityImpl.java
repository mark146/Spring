package org.tx.entity;

import java.util.*;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PointEntityImpl implements IPointEntity {

	@Inject
	private SqlSession session;
	
	private static String namespace = "org.tx.mapper.PointMapper";
	
	@Override
	public void updatePoint(String uid, int point) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", uid);
		paramMap.put("point", point);
		
		session.update(namespace+".updatePoint",paramMap);
	}
}
