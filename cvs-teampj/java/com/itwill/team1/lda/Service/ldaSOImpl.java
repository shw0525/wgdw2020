package com.itwill.team1.lda.Service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwill.team1.lda.Persistence.ldaDAO;

@Service
public class ldaSOImpl implements ldaSO{

	@Inject
	private ldaDAO dao;

	@Override
	public void search() throws Exception {
		
		dao.selectDao();
			
	} 
}
