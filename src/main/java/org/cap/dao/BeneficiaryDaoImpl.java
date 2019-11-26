package org.cap.dao;

import org.cap.entities.Beneficiary;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class BeneficiaryDaoImpl implements BeneficiaryDao
{
	@PersistenceContext
    private EntityManager em;
	
	public BeneficiaryDaoImpl() {
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public Beneficiary createB(Beneficiary bene) {
		bene=em.merge(bene); 
		return bene;
	}

	@Override
	public Beneficiary createBene(String bene_acc_no, String bene_nickname, String bene_bankname, String acc_no_fk) {
 
		Beneficiary b= new Beneficiary();
		b.setBene_acc_no(bene_acc_no);
		b.setBene_nickname(bene_nickname);
		b.setBene_bankname(bene_bankname);
		b.setAcc_no_fk(acc_no_fk);
		b=em.merge(b);
        return b;
	}

	@Override
	public List<Beneficiary> allBene(String accno) {
		TypedQuery<Beneficiary> query = em.createQuery("select bene FROM Beneficiary bene where ACC_NO_FK=:accno",
				Beneficiary.class);
		query.setParameter("accno", accno);
		
		List<Beneficiary> bene = query.getResultList();
		System.out.println("hello god");
		
		return bene;
	}

}
