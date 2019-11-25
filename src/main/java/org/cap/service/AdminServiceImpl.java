package org.cap.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cap.dao.AdminDao;
import org.cap.dao.LoginDetailsDao;
import org.cap.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private AdminDao dao;

	public AdminDao getDao() {
		return dao;
	}

	public void setDao(AdminDao dao) {
		this.dao = dao;
	}
	
	@Override
	public boolean validateCredentials(String user_id, String password) {
		return dao.validateCredentials(user_id, password);
	}
}
