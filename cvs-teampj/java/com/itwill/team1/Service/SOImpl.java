package com.itwill.team1.Service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwill.team1.Persistence.DAO;

@Service
public class SOImpl implements SO{

	@Inject
	private DAO dao;

	@Override
	public void search() throws Exception {
		
		dao.selectDao();
		
	} 
	
}
