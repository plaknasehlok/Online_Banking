package org.cap.service;

import java.util.List;

import org.cap.entities.Beneficiary;

public interface BeneficiaryService {
	Beneficiary createB(Beneficiary bene);

	Beneficiary createBene(String bene_acc_no,String bene_nickname, String bene_bankname,String acc_no_fk );

	List<Beneficiary> allBene(String acc_no);
}
