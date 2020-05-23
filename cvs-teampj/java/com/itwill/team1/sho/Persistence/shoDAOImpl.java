package com.itwill.team1.sho.Persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwill.team1.sho.Domain.Review_shoVO;
import com.itwill.team1.sho.Domain.address_latlng_shoVO;
import com.itwill.team1.sho.Domain.goodsList_shoVO;
import com.itwill.team1.sho.Domain.membershoVO;

@Repository
public class shoDAOImpl implements shoDAO{

	@Inject
	private SqlSession sqlSession;
	
	// XML Mapper의 파일의 namespace값을 상수로 저장
	private static final String namespace =
				"com.itwill.team1.mappers.sho.membershoMapper";

	
	// DAO를 가져오는 메서드
	public String selectDao() {
		return sqlSession.selectOne(namespace+".selectDao");
	}

	@Override
	public void insertDao(membershoVO vo) {
		sqlSession.insert(namespace+".insertDao",vo);
		System.out.println("가입정보 작성 완료!");
		
	}

	
	@Override
	public int idCheck(membershoVO vo) {
		int result = sqlSession.selectOne(namespace+".checkId",vo);
		return result;
	}
	@Override
	public int nickCheck(membershoVO vo) {
		int result = sqlSession.selectOne(namespace+".checkNick",vo);
		return result;
	}

	@Override
	public int loginSelectDao(String id, String password) {
		membershoVO vo = new membershoVO();
		System.out.println("loginSelectDao()가 전달 받은 값: "+id+" , "+password);
		int check = -2;
		vo.setId(id);
		membershoVO result=null;
		try{
			result=sqlSession.selectOne(namespace+".checkLogin", id);
			System.out.println("결과 값:"+result);
			
			if(result.getPassword().equals(password)) {
				check=result.getType();
			}else {
				//비밀번호 오류
				check=-1;
			}
		}catch(NullPointerException e) {
			//아이디 비존재
			check=-2;
		}
		
		return check;
	}
	
	

	@Override
	public int deleteMember(String id) {
		int check=-1;
		//해당 아이디의 편의점 정보 조회 
		String[] myCVS;
		String CVS;
		System.out.println("포인트");
		try {
			myCVS=sqlSession.selectOne(namespace+".myCVS2",id);
			System.out.println("포인트1");
		}catch(Exception e) {
			myCVS=new String[1];
			myCVS[0]=sqlSession.selectOne(namespace+".myCVS2",id);
			System.out.println("포인트2");
		}
		//조회된 편의점에 대한 정보 삭제
		try {
			for(int i=0;i<myCVS.length;i++) {
				CVS=myCVS[i];
				sqlSession.delete(namespace+".delCVS",CVS);
				check=1;
			}
			System.out.println("포인트3");
		}catch(Exception e) {
			myCVS=new String[1];
			CVS=myCVS[0];
			check=1;
			System.out.println("포인트4");
			sqlSession.delete(namespace+".delCVS",CVS);
		}
		//해당 아이디에 대한 정보 삭제
		sqlSession.delete(namespace+".delmember", id);
		return check;
	}

	@Override
	public int updatePass(membershoVO vo) {
		System.out.println("@@@@@@@@@DAO updatePass()도착! 비밀번호를 변경합니다.");
		return sqlSession.update(namespace+".updatePw",vo );
	}

	@Override
	public membershoVO selectMember(String nickname) {
		System.out.println("@@@@@@@@@DAO selectMember()도착! 회원정보를 가져갑니다.");
		membershoVO vo = sqlSession.selectOne(namespace+".selectMember",nickname);
		return vo;
	}

	@Override
	public void setGrade(String email) {
		System.out.println("@@@@@@@dao setGrade() 도착! 일반 회원으로 변경합니다.");
		sqlSession.update(namespace+".setUp",email);
	}
	
	@Override
	public int updateCVS(address_latlng_shoVO alvo) {
		System.out.println("@@@@@@@@@@@DAO updateCVS() 도착! 기업회원으로 전환됩니다!");
		
		return sqlSession.update(namespace+".updateCVS",alvo);
	}

	@Override
	public String selectNick(String email) {
		System.out.println("selectNick()도착! 전달 받은값:"+email);
		String nickname=sqlSession.selectOne(namespace+".getNick",email);
		return nickname;
	}

	@Override
	public List<address_latlng_shoVO> markedAll() {
		System.out.println("@@@@@@@@@DAO의 markedAll()도착! 객체 담을 준비");
		List<address_latlng_shoVO> alvlist=null;
		alvlist=sqlSession.selectList(namespace+".selectMarker");
		System.out.println("List alvlist의 값: "+alvlist);
		return alvlist;
	}

	@Override
	public List<goodsList_shoVO> goodsAll(String cvs_title,String menuCate) {
		System.out.println("@@@@@@@@@@@DAO의 goodsAll()도착! 객체에 담을 준비");
		goodsList_shoVO glvo = new goodsList_shoVO();
		List<goodsList_shoVO> goodsList;
		glvo.setCvs_title(cvs_title);
		if(!menuCate.equals("all")) {
			glvo.setCategory(menuCate);
			goodsList=sqlSession.selectList(namespace+".ftgoodsList",glvo);
		}else {
			goodsList=sqlSession.selectList(namespace+".goodsList",glvo);
		}
		System.out.println("DAO객체 저장완료: "+goodsList);
		return goodsList;
	}

	@Override
	public List<Review_shoVO> reviewCVS(String cvs_title) {
		System.out.println("@@@@@@@@@@@DAO의 reviewCVS()도착! 객체에 담을 준비");
		List<Review_shoVO> reviewList=sqlSession.selectList(namespace+".reviewList",cvs_title);
		
		System.out.println("DAO객체 저장완료: "+reviewList);
		return reviewList;
	}

	@Override
	public int updateReview(Review_shoVO rvo,int type) {
		System.out.println("@@@@@@@@@@updateReview() 도착! 해당 정보를 리뷰로 변경합니다. ");
		int check=-1;

		if(rvo.getR_num()!=0) {
			if(type==2) {
				System.out.println("@@@@@@@@@@@@@@@@@@리뷰에 답변을 작성합니다.");

				//r_num 계산용 쿼리
				check=sqlSession.insert(namespace+".insertReply",rvo);
				System.out.println("@@@@@@@@@해당 상품정보를 리뷰로 변경합니다. ");


			}else {
				//r_num 계산용 쿼리
				System.out.println("계산된 r_num & 이외의 값: "+rvo.getR_num()+","+rvo.getStarScore()+","+rvo.getG_num()+","+rvo.getContent());
				check=sqlSession.update(namespace+".updateReview",rvo);
			}
		}else {
		

		//r_num 계산용 쿼리
		rvo.setR_num((int)sqlSession.selectOne(namespace+".RnumFind")+1);
		check=sqlSession.update(namespace+".updateReview",rvo);
		}
		return check;
	}
	

	@Override
	public int checkReview(String nickname, int r_num) {
		int check=-1;
		String result=sqlSession.selectOne(namespace+".checkReview",r_num);
		if(result.equals(nickname)) {
			check=1;
		}else {
			String cvs_title=sqlSession.selectOne(namespace+".checkReviewCEO",r_num);
			result=sqlSession.selectOne(namespace+".checkReview2",cvs_title);
			if(result.equals(nickname)) {
				//CEO답글로 전환
				check=2;
			}else {
				//본인이 아님
				check=0;
			}
		}
		return check;
	}

	@Override
	public int insertGoods(goodsList_shoVO glvo) {
		System.out.println("@@@@@@@@@@insertGoods() 도착! 해당 상품을 등록합니다. ");
		int check=-1;
		//g_num 계산용 쿼리
		glvo.setG_num((int)sqlSession.selectOne(namespace+".GnumFind")+1);
		System.out.println("계산된 g_num의 값:"+glvo.getG_num());
		//insert()는 리턴값이 없음
		check=sqlSession.insert(namespace+".insertGoods",glvo);
		
		return check;
	}

	@Override
	public String[] selectMyCVS(String nickname) {
		System.out.println("@@@@@@@@@@@selectMyCVS() 도착! 소장중인 편의점 정보 조회!!!!");
		String[] myCVS;
		
		try {
			myCVS=sqlSession.selectOne(namespace+".myCVS",nickname);
		}catch(Exception e) {
			myCVS=new String[1];
			myCVS[0]=sqlSession.selectOne(namespace+".myCVS",nickname);
		}
		
		return myCVS;
	}
	
	
}
