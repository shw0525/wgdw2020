package com.itwill.team1.syc.Service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwill.team1.syc.Persistence.sycDAO;

@Service
public class sycSOImpl implements sycSO{
	
	@Inject
	private sycDAO dao;

	@Override
	public void search() throws Exception {
		
		dao.selectDao();
			
	} 
}
