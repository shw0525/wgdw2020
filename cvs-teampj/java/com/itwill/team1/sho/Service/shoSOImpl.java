package com.itwill.team1.sho.Service;

import java.util.List;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.itwill.team1.sho.Domain.Review_shoVO;
import com.itwill.team1.sho.Domain.address_latlng_shoVO;
import com.itwill.team1.sho.Domain.goodsList_shoVO;
import com.itwill.team1.sho.Domain.membershoVO;
import com.itwill.team1.sho.Persistence.shoDAO;

@Service
public class shoSOImpl implements shoSO{

	@Inject
	private shoDAO dao;
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void search() throws Exception {
		
		dao.selectDao();
			
	}

	@Override
	public void join(membershoVO vo) throws Exception {
		
		dao.insertDao(vo);
		System.out.println(".insertDao()정보 처리 완료!");
	}

	@Override
	public int login(membershoVO vo) throws Exception {
		System.out.println("전달 받은 값: "+vo.getId()+" , "+vo.getPassword());
		int result=dao.loginSelectDao(vo.getId(),vo.getPassword());
		return result;
	}
	
	

	@Override
	public String getNick(String email) throws Exception {
		System.out.println("getNick() 도착! DAO로 전달!");
		
		return dao.selectNick(email);
	}

	@Override

		public List<address_latlng_shoVO> marking() throws Exception {
		System.out.println("@@@@@marking()도착! DAO로 이동!");
		List<address_latlng_shoVO> alvList=dao.markedAll();

		return alvList;
	}

	@Override
	public List<goodsList_shoVO> goodslist(String cvs_title,String menuCate) throws Exception {
		System.out.println("@@@@@@@@@goodslist()도착! DAO로 이동!!!");
		List<goodsList_shoVO> goodsList=dao.goodsAll(cvs_title,menuCate);
		System.out.println("@@@@@@@@service로 객체 반환!");
		return goodsList;
	}

	@Override
	public List<Review_shoVO> reviewlist(String cvs_title) throws Exception {
		System.out.println("@@@@@@@@@goodslist()도착! DAO로 이동!!!");
		List<Review_shoVO> reviewList=dao.reviewCVS(cvs_title);
		System.out.println("@@@@@@@@service로 객체 반환!");
		return reviewList;
	}

	@Override
	public int writeReview(Review_shoVO rvo,int type) throws Exception {
		System.out.println("writeReview()메서드 호출 DAO로 이동!!");
		int check=-1;
		check = dao.updateReview(rvo,type);
		
		return check;
	}

	@Override
	public int addGoods(goodsList_shoVO glvo) throws Exception {
		int check=-1;
		System.out.println("addGoods()메서드 호출 DAO로 이동!!");
		check = dao.insertGoods(glvo);
		
		return check;
	}

	@Override
	public int fixReview(String nickname, int r_num) throws Exception {
		int check=-1;
		check=dao.checkReview(nickname,r_num);
		return check;
	}

	@Override
	public String[] getCVS(String nickname) throws Exception {
		System.out.println("getCVS도착 ! DAO로 이동!");
		return dao.selectMyCVS(nickname);
	}

	@Override
	public int idCheck(membershoVO vo) throws Exception {
		int result = dao.idCheck(vo);
		return result;
	}
	@Override
	public int nickCheck(membershoVO vo) throws Exception {
		int result = dao.nickCheck(vo);
		return result;
	}

	@Override
	public void setGrade(String email) throws Exception {
		dao.setGrade(email);
	}
	
	

	@Override
	public int delMember(String id) throws Exception {
		
		return dao.deleteMember(id);
	}

	@Override
	public membershoVO memberInfo(String nickname) throws Exception {
		return dao.selectMember(nickname);
	}
	
	@Override
	public int fixpass(membershoVO vo) throws Exception {
		return dao.updatePass(vo);
	}
	
	@Override
	public int gradeUp(address_latlng_shoVO alvo) throws Exception {
		
		return dao.updateCVS(alvo);
	}

	@Override
	public void mailSending(String email) throws Exception {
		// 인증 메일 보내기 메서드
		
		String setfrom = "teampj(가칭)";
		String tomail = email; // 받는 사람 이메일
		
		String title = "teampj(가칭) 인증 메일입니다."; // 제목
		String content = "회원 가입한 경우가 아니시라면 wgdw2020@gmail.com으로 문의 주세요.\n http://192.168.0.3:8080/team1/sho/certain?email="+tomail; // 내용

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,
					true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(content); // 메일 내용

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
		
	
	
	
}
