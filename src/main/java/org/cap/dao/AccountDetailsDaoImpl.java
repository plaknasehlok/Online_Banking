package org.cap.dao;
import org.cap.entities.Account_Details;
import org.cap.entities.Login_Details;
import org.cap.entities.User_Profiles;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDetailsDaoImpl implements AccountDetailsDao {

    @PersistenceContext
    private EntityManager em;

    public AccountDetailsDaoImpl(){
    }
    
    
    @Override
	public Account_Details findUserByAccNo(String acc_no) {
		String qStr = "SELECT ad FROM Account_Details ad WHERE ad.acc_no= :ano";
		TypedQuery<Account_Details> query = em.createQuery(qStr, Account_Details.class);
		query.setParameter("ano", acc_no);
		// System.out.println(query.getSingleResult());
		return query.getSingleResult();
	}
    
	@Override
	public Account_Details sendFunds(String acc_no, Integer balance) {
		Account_Details user=em.find(Account_Details.class,acc_no);
		int bal=user.getBalance();
		bal=bal-balance;
		user.setBalance(bal);
	    user=em.merge(user);
	    return user;
	    
	}
	
	@Override
	public Account_Details receiveFunds(String acc_no, Integer balance) {
		Account_Details user=em.find(Account_Details.class,acc_no);
		int bal=user.getBalance();
		bal=bal+balance;
		user.setBalance(bal);
	    user=em.merge(user);
	    return user;
	    
	}
	
	@Override
	public Account_Details createAccount(String acc_no, String acc_type, Integer balance, Integer user_profile_id_fk) {
		Account_Details acc = new Account_Details();
		acc.setAcc_no(acc_no);
		acc.setAcc_type(acc_type);
		acc.setBalance(balance);
		acc.setUser_profile_id_fk(user_profile_id_fk);	
		acc = em.merge(acc);
		return acc;
		
	}
	
	@Override
	public Integer findBalance(String acc_no) {

		Account_Details currentbalance = em.find(Account_Details.class, acc_no);
		Integer currbal = currentbalance.getBalance();
		return currbal;

	}
	
}	
	