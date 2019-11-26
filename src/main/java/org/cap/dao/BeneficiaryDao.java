package org.cap.dao;

import java.util.List;

import org.cap.entities.Beneficiary;
import org.cap.entities.User_Profiles;

public interface BeneficiaryDao
{
	Beneficiary createB(Beneficiary bene);
	Beneficiary createBene(String bene_acc_no,String bene_nickname, String bene_bankname,String acc_no_fk );
	List<Beneficiary> allBene(String accno);
}
