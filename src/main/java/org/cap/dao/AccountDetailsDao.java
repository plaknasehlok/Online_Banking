package org.cap.dao;
import org.cap.entities.Account_Details;
import org.cap.entities.Login_Details;
import org.cap.entities.User_Profiles;

public interface AccountDetailsDao {
	
	
	Account_Details createAccount(String acc_no, String acc_type, Integer balance, Integer user_profile_id_fk);
	Account_Details findUserByAccNo(String acc_no);
	Account_Details sendFunds(String acc_no, Integer balance);
	Account_Details receiveFunds(String acc_no, Integer balance);
	
}
