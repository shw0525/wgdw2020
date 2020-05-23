package com.itwill.team1.lbj.Service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwill.team1.lbj.Persistence.memberlbjDAO;

@Service
public class loginlbjSOimpl implements loginlbjSO{

	@Inject
	private memberlbjDAO dao;

	@Override
	public void searchId() throws Exception {
		
		dao.selectDao();
		
	}

	
}
