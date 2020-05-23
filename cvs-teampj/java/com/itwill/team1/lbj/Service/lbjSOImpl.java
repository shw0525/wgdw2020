package com.itwill.team1.lbj.Service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwill.team1.lbj.Persistence.lbjDAO;

@Service
public class lbjSOImpl implements lbjSO{

	@Inject
	private lbjDAO dao;

	@Override
	public void search() throws Exception {
		
		dao.selectDao();
			
	} 
}
