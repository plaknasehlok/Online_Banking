package org.cap.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cap.entities.Admin;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao{
	@PersistenceContext
	private EntityManager em;
	
	public AdminDaoImpl() {
	}

	@Override
	public boolean validateCredentials(String user_id, String password) {
		Admin ad= em.find(Admin.class, user_id);
		String pwd = ad.getPassword();
		if (pwd.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
