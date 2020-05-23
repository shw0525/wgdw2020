package com.itwill.team1.scg.Service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwill.team1.scg.Persistence.scgDAO;

@Service
public class scgSOImpl implements scgSO{

	@Inject
	private scgDAO dao;

	@Override
	public void search() throws Exception {
		
		dao.selectDao();
			
	} 
}
