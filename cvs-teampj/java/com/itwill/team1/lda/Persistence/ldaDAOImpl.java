package com.itwill.team1.lda.Persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ldaDAOImpl implements ldaDAO{

	@Inject
	private SqlSession sqlSession;
	
	// XML Mapper의 파일의 namespace값을 상수로 저장
	private static final String namespace =
				"com.itwill.team1.mappers.lda.ldaMapper";
	
	// DAO를 가져오는 메서드
	public String selectDao() {
		return sqlSession.selectOne(namespace+".selectDao");
	}
		
}
