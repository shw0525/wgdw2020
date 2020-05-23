package com.itwill.team1.lyj.Service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwill.team1.lyj.Persistence.lyjDAO;

@Service
public class lyjSOImpl implements lyjSO{

	@Inject
	private lyjDAO dao;

	@Override
	public void search() throws Exception {
		
		dao.selectDao();
			
	} 
}
