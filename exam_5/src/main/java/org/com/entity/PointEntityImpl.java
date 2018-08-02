package org.com.entity;

import java.util.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PointEntityImpl implements PointEntity {

	@Inject
	private SqlSession session;
	
	private static String namespace = "org.com.mapper.PointMapper";
	
	@Override
	public void updatePoint(String uid, int point) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", uid);
		paramMap.put("point", point);
		session.update(namespace + ".updatePoint", paramMap);
	}
}