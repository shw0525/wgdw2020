package com.itwill.team1.sho;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Locale;


import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.team1.sho.Domain.Review_shoVO;
import com.itwill.team1.sho.Domain.address_latlng_shoVO;
import com.itwill.team1.sho.Domain.goodsList_shoVO;
import com.itwill.team1.sho.Domain.membershoVO;
import com.itwill.team1.sho.Domain.shoVO;
import com.itwill.team1.sho.Service.shoSO;

@Controller
@RequestMapping(value = "/sho/*")
public class shoHomeController {
	
	
	//1. 전역에 위치한 상수변수
	private static final Logger logger = LoggerFactory.getLogger(shoHomeController.class);
	
	//2. 주입처리 맴버변수
	@Inject
	private shoSO service;
	
	
	
	//3. 각종 URL 처리 메서드
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, shoVO vo) throws Exception{
		logger.info("@@START /sho/ 주소 호출, GET, locale : {}.", locale);
	
		// 1. 현재시간 저장
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);		
		model.addAttribute("serverTime", formattedDate );
		
		// 2. 서비스 동작
		
		// 3. URL 이동 처리
		logger.info("vo: " + vo);
		logger.info("@@END /sho/ 주소 호출, GET, locale : {}.", locale);
		
		return "sho/home";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchGET(Locale locale, Model model, shoVO vo) throws Exception{
		logger.info("@@START /sho/search 주소 호출, GET, locale : {}.", locale);
		
		// 1. 현재시간 저장
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);		
		model.addAttribute("serverTime", formattedDate );
		
		// 2. 서비스 동작
		service.search();
		
		// 3. URL 이동 처리
		logger.info("vo: " + vo);
		logger.info("@@END /sho/search 주소 호출, GET, locale : {}.", locale);
		
		return "sho/home";
	}
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchPOST(Locale locale, Model model, shoVO vo) throws Exception{
		logger.info("@@START /sho/search 주소 호출, POST, locale : {}.", locale);
		
		// 1. 현재시간 저장
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);		
		model.addAttribute("serverTime", formattedDate );
		
		// 2. 서비스 동작
		service.search();
		
		// 3. URL 이동 처리
		logger.info("vo: " + vo);
		logger.info("@@END /sho/search 주소 호출, POST, locale : {}.", locale);
		
		return "sho/home";
	}
	@ResponseBody
	@RequestMapping(value="/idCheck",method=RequestMethod.POST)
	public int idChk(Locale locale,Model model,membershoVO vo) throws Exception {
		// 1. 현재시간 저장
				Date date = new Date();
				DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
				String formattedDate = dateFormat.format(date);		
				model.addAttribute("serverTime", formattedDate );
				// 2. 서비스 동작
				int result = service.idCheck(vo);
		
		return result;
	}
	@ResponseBody
	@RequestMapping(value="/ncCheck",method=RequestMethod.POST)
	public int nickChk(Locale locale,Model model,membershoVO vo) throws Exception {
		// 1. 현재시간 저장
				Date date = new Date();
				DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
				String formattedDate = dateFormat.format(date);		
				model.addAttribute("serverTime", formattedDate );
				// 2. 서비스 동작
				int result = service.nickCheck(vo);
		
		return result;
	}
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinGET(Locale locale,Model model) throws Exception {
		logger.info("@@START /sho/join 주소 호출, GET, locale : {}.", locale);
		
		// 1. 현재시간 저장
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);		
		model.addAttribute("serverTime", formattedDate );
		// 2. 서비스 동작
				
				// 3. URL 이동 처리
				logger.info("service: "+service);
				logger.info("@@END /sho/join 주소 호출, GET, locale : {}.", locale);
				
				return "sho/join";
	}
	@ResponseBody
	@RequestMapping(value="/join",produces="application/json; charset=utf-8",method=RequestMethod.POST)
	public String joinPOST(membershoVO vo,RedirectAttributes rttr) throws Exception{
		
		// 2. 서비스 동작
		int result=service.idCheck(vo);
		logger.info("@@@@@@@@ /sho/join 주소 호출!"+result);
		logger.info("@@@@@@@컨트롤러 registPOST() 호출!");
		logger.info("서비스 객체 : "+service);
		logger.info("vo:"+vo);
		try {
			if(result==1) {
				return "sho/join";

			}else if(result==0) {
				service.join(vo);
			}
		}catch (Exception e) {
			throw new RuntimeException();
		}
		
		// 서비스 시작
		
			// 인증 메일 보내기 메서드
			service.mailSending(vo.getId());
		// 3. URL 이동 처리
		logger.info("vo: " + vo);
//		logger.info("@@END /sho/join 주소 호출, POST, locale : {}.", locale);
		return "가입 완료! 뒤로가기 버튼을 눌러 돌아가세요.";
	}
	
	@ResponseBody
	@RequestMapping(value="/certain",  produces="application/json; charset=utf-8", method=RequestMethod.GET)
	public String certain(Model model, HttpServletRequest request) throws Exception {
			String email=request.getParameter("email");
			service.setGrade(email);
		
		
		return "인증 완료! 일반회원으로 변경됩니다! 다시 로그인해주세요!";
	}
	
	@ResponseBody
	@RequestMapping(value="/resending",  produces="application/json; charset=utf-8")
	public int resending(@RequestBody JSONObject json) {
		if(json.get("email")!=null) {
			try {
				service.mailSending(json.get("email").toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 1;
	}
	@ResponseBody
	@RequestMapping(value="/gradeUp",  produces="application/json; charset=utf-8")
	public int gradeUp(@RequestBody JSONObject json) throws Exception {
		int check=-1;
		address_latlng_shoVO alvo = new address_latlng_shoVO();
		if(json.get("cvs_title")!=null) {
			alvo.setCvs_title(json.get("cvs_title").toString());
			alvo.setCvs_locationX(Double.parseDouble(json.get("lat").toString()));
			alvo.setCvs_locationY(Double.parseDouble(json.get("lng").toString()));
			alvo.setId(json.get("id").toString());
		}
		check=service.gradeUp(alvo);
		logger.info("체크값: "+check);
		
		return check;
	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/login",  produces="application/json; charset=utf-8")
	public JSONObject androidLogin(String email,  String userpw){
		
		JSONObject json=new JSONObject();
		
		membershoVO vo =new membershoVO();
		vo.setId(email);
		vo.setPassword(userpw);
		int check=-2;
		String nickname="";
		String[] myCVS=null;
		//이메일 체크 후 정보를 가져 온다.
		try {
			check = service.login(vo);
			if(check>0) {
				nickname=service.getNick(email);
				if(check==1) {
					//영업장 정보
					myCVS=service.getCVS(nickname);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(check>0){
			logger.info("로그인 성공");
			// 널이 아니면  이메일이 존재하는 것이다. 따라서 등록된 가입자 이다.
			
			//패스워드 매치를 통해 다시 비밀번호 확인 한다
			if(check==1){	
				// 로그인 성공 - 로그인이 가능한 유저 확인 정보 가져오기
				json.put("message", "CEO회원 로그인!");
				json.put("nick", nickname);
				for(int i=0;i<myCVS.length;i++) {
					json.put("myCVS"+i, myCVS[i]);
				}
			}else if(check==2){			
				
				json.put("message", "일반 회원 로그인!");
				json.put("nick", nickname);
			}else {
				json.put("message", "미인증 회원 로그인!");
				json.put("nick", nickname);
			}
		}else if(check==-1){
				//비밀 번호 오류	
			   
			json.put("message", "비밀번호 오류!");
		}else {
			//등록 되지 않은 이메일
			json.put("message", "비등록 회원입니다!");
		}
		
		return json; //json 객체 리턴
	}
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/info",  produces="application/json; charset=utf-8")
	public JSONObject androidInfo(@RequestBody JSONObject json) {
		String nickname="";
		membershoVO vo=null;
		if(json.get("nickname")!=null) {
			nickname=json.get("nickname").toString();
		}
		try {
			vo = service.memberInfo(nickname);
			logger.info("결과값: "+vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject rtJson=new JSONObject();
		rtJson.put("id",vo.getId());
		rtJson.put("pw",vo.getPassword());
		rtJson.put("addr",vo.getAddress());
		rtJson.put("addrDetail",vo.getAddress_detail());
		return rtJson;
	}
	
	@ResponseBody
	@RequestMapping(value="/delMember",  produces="application/json; charset=utf-8")
	public int delMember(@RequestBody JSONObject json) {
		int check=-1;
		if(json.get("id")!=null) {
			try {
				logger.info("전달받은 값:"+json.get("id").toString());
				check=service.delMember(json.get("id").toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return check;
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/fixPw",  produces="application/json; charset=utf-8")
	public int fixPass(@RequestBody JSONObject json) {
		membershoVO vo=new membershoVO();
		int check=-1;
		if(json.get("id")!=null) {
			vo.setId(json.get("id").toString());
			vo.setPassword(json.get("pw").toString());
		}
		try {
			check=service.fixpass(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject rtJson=new JSONObject();
		rtJson.put("id",vo.getId());
		rtJson.put("pw",vo.getPassword());
		rtJson.put("addr",vo.getAddress());
		rtJson.put("addrDetail",vo.getAddress_detail());
		return check;
	}
	////////////////////////////////////////////////////매핑//////////////////////////
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/mapCVS",  produces="application/json; charset=utf-8")
	public JSONArray andMarking() {
		JSONObject json=new JSONObject();
		JSONArray jarray = new JSONArray();
		List<address_latlng_shoVO> alvlist=null;
		try {
			alvlist = service.marking();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<alvlist.size();i++) {
		address_latlng_shoVO vo=alvlist.get(i);
		
		json.put("title"+i, vo.getCvs_title());
		json.put("lat"+i, vo.getCvs_locationX().toString());
		json.put("lng"+i, vo.getCvs_locationY().toString());
		jarray.add(json);
		logger.info("@@@@@@@@@@@"+vo.getCvs_title());
		logger.info("json의 값: "+json.get("title"+i).toString());
		logger.info("jarray 저장갑 확인: "+jarray.get(0).toString());
		}
		return jarray;
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/CVSGoodsInfo",  produces="application/json; charset=utf-8")
	public JSONObject CVSGoodsInfo(@RequestBody JSONObject sendJson) {
		logger.info("@@@@@@@@@@@@@@@@@@@전달 받은 값: "+sendJson.toString());
		String cvs_title=sendJson.get("cvs_title").toString();
		String menuCate=sendJson.get("menuCate").toString();
		logger.info("@@@@@@@@@@@@@@@@@@@@@ 변환값: "+cvs_title+"::"+menuCate);
		List<goodsList_shoVO> goodslist=null;
		try {
			goodslist=(ArrayList<goodsList_shoVO>)service.goodslist(cvs_title,menuCate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("반환된 값: "+goodslist);
		
		JSONObject rtJSON = new JSONObject();
		SimpleDateFormat transDate = new SimpleDateFormat("yyyy-MM-dd");
		String date;
		logger.info("goodsList.size: "+goodslist.size());
		for(int i=0;i<goodslist.size();i++) {
			goodsList_shoVO glvo=goodslist.get(i);
			JSONObject json=new JSONObject();
			json.put("category",glvo.getCategory());
			json.put("g_name", glvo.getG_name());
			json.put("g_num", glvo.getG_num());
			json.put("price", glvo.getPrice());
			json.put("stock", glvo.getStock());
			json.put("discount", glvo.getDiscount());
			date=transDate.format(glvo.getTerm_date());
			json.put("term_date", date);
			rtJSON.put("json"+i,json);
			logger.info("@@@@@@@@@json1의 "+i+"번째 값: "+json.toString()+"!!@!@!+!@!@"+date);
		}
		
		
		
		
		return rtJSON;
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/CVSReviewInfo",  produces="application/json; charset=utf-8")
	public JSONObject CVSReviewInfo(
			@RequestBody JSONObject sendjson
			) {
		
		logger.info("전달받은 값:"+sendjson.toString());
		String cvs_title = sendjson.get("cvs_title").toString();
		List<Review_shoVO> reviewlist=null;
		try {
			reviewlist=(ArrayList<Review_shoVO>)service.reviewlist(cvs_title);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("반환된 값2: "+reviewlist);
		JSONObject json=new JSONObject();
		JSONObject rtJSON = new JSONObject();
		String re_date = "";
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(int i=0;i<reviewlist.size();i++) {
			Review_shoVO rvo=reviewlist.get(i);
			json.put("category"+i,rvo.getCategory());
			json.put("g_name"+i,rvo.getG_name());
			json.put("r_num"+i,rvo.getR_num());
			json.put("content"+i,rvo.getContent());
			json.put("starScore"+i,rvo.getStarScore());
			re_date=formatter.format(rvo.getRe_date());
			json.put("re_date"+i,re_date);
			json.put("re_ref"+i,rvo.getRe_ref());
			json.put("id"+i,rvo.getNickname());
			logger.info("@@@@@@@@@@@@json"+i+"번째 값: "+json.toString());
			
			rtJSON.put("json"+i,json);
		}
		
		logger.info("@@@@@@@@@@@json2저장후 jarray:"+rtJSON.toJSONString());
		
		
		return rtJSON;
	}
	
	@ResponseBody
	@RequestMapping(value="/writeReview",  produces="application/json; charset=utf-8")
	public int writeReview(
			@RequestBody JSONObject json
			) {
		int type=-1;
		logger.info("@@@@@@@@@@@@@@@스프링 /writeReview 도착 ! 서비스로 보내기 준비중! ");
		logger.info("@@@@@@@@@@@전달 받은 값: "+json.toString());
		Review_shoVO rvo = new Review_shoVO();
		rvo.setG_num((int)json.get("g_num"));
		rvo.setStarScore((int)json.get("starScore"));
		rvo.setContent(json.get("content").toString());
		if(json.get("r_num")!=null) {
			rvo.setR_num((int)json.get("r_num"));
		}
		rvo.setCvs_title(json.get("cvs_title").toString());
		rvo.setCategory(json.get("category").toString());
		rvo.setG_name(json.get("g_name").toString());
		rvo.setNickname(json.get("id").toString());
		if(json.get("type")!=null) {
			type=(int)json.get("type");
		}
		int i=-1;
		try {
			i=service.writeReview(rvo,type);
			logger.info("반환된 값 i: "+i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	@ResponseBody
	@RequestMapping(value="/fixReview",  produces="application/json; charset=utf-8")
	public int fixReview(
			@RequestBody JSONObject json
			) {
		logger.info("@@@@@@@@@@@@@@@스프링 /fixReview 도착 ! 서비스로 보내기 준비중! ");
		logger.info("@@@@@@@@@@@전달 받은 값: "+json.toString());
		String nickname=json.get("nick").toString();
		int r_num=(int)json.get("r_num");
		int i=-1;
		try {
			logger.info("저장값: "+nickname+"::"+r_num);
			i=service.fixReview(nickname,r_num);
			logger.info("반환된 값 i: "+i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	@ResponseBody
	@RequestMapping(value="/RegistGds",  produces="application/json; charset=utf-8")
	public int RegistGoods(
			@RequestBody JSONObject json
			) {
		logger.info("@@@@@@@@@@@@@@@스프링 /RegistGds 도착 ! 서비스로 보내기 준비중! ");
		goodsList_shoVO glvo=new goodsList_shoVO();
		SimpleDateFormat transDate = new SimpleDateFormat("yyyy-MM-dd");
		logger.info(json.get("cvs_title").toString());
		glvo.setCvs_title(json.get("cvs_title").toString());
        glvo.setCategory(json.get("category").toString());
        glvo.setG_name(json.get("g_name").toString());
        glvo.setPrice((int)json.get("price"));
        glvo.setDiscount((int)json.get("discount"));
        try {
			glvo.setTerm_date(transDate.parse(json.get("term_date").toString()));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int i=-1;
		try {
			i=service.addGoods(glvo);
			logger.info("반환된 값 i: "+i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
}
