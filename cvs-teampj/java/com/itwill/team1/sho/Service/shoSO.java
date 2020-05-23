package com.itwill.team1.sho.Service;

import java.util.List;

import com.itwill.team1.sho.Domain.Review_shoVO;
import com.itwill.team1.sho.Domain.address_latlng_shoVO;
import com.itwill.team1.sho.Domain.goodsList_shoVO;
import com.itwill.team1.sho.Domain.membershoVO;

public interface shoSO {

	public void search() throws Exception;
	public void join(membershoVO vo) throws Exception;
	public int login(membershoVO vo) throws Exception;
	public List<address_latlng_shoVO> marking() throws Exception;
	public List<goodsList_shoVO> goodslist(String cvs_title,String menuCate) throws Exception;
	public List<Review_shoVO> reviewlist(String cvs_title) throws Exception;
	public int writeReview(Review_shoVO rvo,int type) throws Exception;
	public String getNick(String email) throws Exception;
	public int addGoods(goodsList_shoVO glvo) throws Exception;
	public int fixReview(String nickname,int r_num) throws Exception;
	public String[] getCVS(String nickname) throws Exception;
	public int idCheck(membershoVO vo) throws Exception;
	public int nickCheck(membershoVO vo) throws Exception;
	public void setGrade(String email) throws Exception;
	public void mailSending(String email) throws Exception;
	public membershoVO memberInfo(String nickname) throws Exception;
	public int fixpass(membershoVO vo)  throws Exception;
	public int gradeUp(address_latlng_shoVO alvo)  throws Exception;
	public int delMember(String id) throws Exception;
}
