package org.cap.service;

import java.util.List;

import org.cap.dao.BeneficiaryDao; 
import org.cap.entities.Beneficiary; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BeneficiaryServiceImpl implements BeneficiaryService
{

	@Autowired private BeneficiaryDao dao;
	
	public BeneficiaryDao getDao() {
		return dao;
	}

	
	public void setDao(BeneficiaryDao dao) {
		this.dao = dao;
	}

	@Override
	public Beneficiary createB(Beneficiary bene) {
		bene= dao.createB(bene); //transaction closed by spring 
		return bene;
	}

	@Override
	public Beneficiary createBene(String bene_acc_no, String bene_nickname, String bene_bankname, String acc_no_fk) {
		return dao.createBene(bene_acc_no, bene_nickname, bene_bankname, acc_no_fk);
		
	}

	@Override public List<Beneficiary> allBene(String acc_no) {
		List<Beneficiary> list= dao.allBene(acc_no);
	    return list; 
	}
	
}
