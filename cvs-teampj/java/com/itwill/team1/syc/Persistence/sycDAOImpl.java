package com.itwill.team1.syc.Persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class sycDAOImpl implements sycDAO{

	@Inject
	private SqlSession sqlSession;
	
	// XML Mapper의 파일의 namespace값을 상수로 저장
	private static final String namespace =
				"com.itwill.team1.mappers.syc.sycMapper";
	
	// DAO를 가져오는 메서드
	public String selectDao() {
		return sqlSession.selectOne(namespace+".selectDao");
	}
		
}
