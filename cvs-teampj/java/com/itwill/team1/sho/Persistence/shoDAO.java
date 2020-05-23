package com.itwill.team1.sho.Persistence;

import java.util.List;

import com.itwill.team1.sho.Domain.Review_shoVO;
import com.itwill.team1.sho.Domain.address_latlng_shoVO;
import com.itwill.team1.sho.Domain.goodsList_shoVO;
import com.itwill.team1.sho.Domain.membershoVO;

public interface shoDAO {

	// DAO를 가져오는 메서드
	public String selectDao();
	public void insertDao(membershoVO vo);
	public int loginSelectDao(String id,String password);
	public List<address_latlng_shoVO> markedAll();
	public List<goodsList_shoVO> goodsAll(String cvs_title,String menuCate);
	public List<Review_shoVO> reviewCVS(String cvs_title);
	public int updateReview(Review_shoVO rvo,int type);
	public String selectNick(String email);
	public int checkReview(String nickname,int r_num);
	public int insertGoods(goodsList_shoVO glvo);
	public String[] selectMyCVS(String nickname);
	public int idCheck(membershoVO vo);
	public int nickCheck(membershoVO vo);
	public void setGrade(String email);
	public membershoVO selectMember(String nickname);
	public int updatePass(membershoVO vo);
	public int updateCVS(address_latlng_shoVO alvo);
	public int deleteMember(String id);
}
