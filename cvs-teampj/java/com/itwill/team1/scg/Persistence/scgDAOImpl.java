package com.itwill.team1.scg.Persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class scgDAOImpl implements scgDAO{

	@Inject
	private SqlSession sqlSession;
	
	// XML Mapper의 파일의 namespace값을 상수로 저장
	private static final String namespace =
				"com.itwill.team1.mappers.scg.scgMapper";
	
	// DAO를 가져오는 메서드
	public String selectDao() {
		return sqlSession.selectOne(namespace+".selectDao");
	}
		
}
