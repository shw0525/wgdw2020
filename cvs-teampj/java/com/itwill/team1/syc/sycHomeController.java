package com.itwill.team1.syc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.team1.syc.Domain.sycVO;
import com.itwill.team1.syc.Service.sycSO;

@Controller
@RequestMapping(value = "/syc/*")
public class sycHomeController {
	
	//1. 전역에 위치한 상수변수
	private static final Logger logger = LoggerFactory.getLogger(sycHomeController.class);
	
	//2. 주입처리 맴버변수
	@Inject
	private sycSO service;
	
	//3. 각종 URL 처리 메서드
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, sycVO vo) throws Exception{
		logger.info("@@START /syc/ 주소 호출, GET, locale : {}.", locale);
	
		// 1. 현재시간 저장
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);		
		model.addAttribute("serverTime", formattedDate );
		
		// 2. 서비스 동작
		
		// 3. URL 이동 처리
		logger.info("vo: " + vo);
		logger.info("@@END /syc/ 주소 호출, GET, locale : {}.", locale);
		
		return "syc/home";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchGET(Locale locale, Model model, sycVO vo) throws Exception{
		logger.info("@@START /syc/search 주소 호출, GET, locale : {}.", locale);
		
		// 1. 현재시간 저장
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);		
		model.addAttribute("serverTime", formattedDate );
		
		// 2. 서비스 동작
		service.search();
		
		// 3. URL 이동 처리
		logger.info("vo: " + vo);
		logger.info("@@END /syc/search 주소 호출, GET, locale : {}.", locale);
		
		return "syc/home";
	}
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchPOST(Locale locale, Model model, sycVO vo) throws Exception{
		logger.info("@@START /syc/search 주소 호출, POST, locale : {}.", locale);
		
		// 1. 현재시간 저장
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);		
		model.addAttribute("serverTime", formattedDate );
		
		// 2. 서비스 동작
		service.search();
		
		// 3. URL 이동 처리
		logger.info("vo: " + vo);
		logger.info("@@END /syc/search 주소 호출, POST, locale : {}.", locale);
		
		return "syc/home";
	}
		
}
