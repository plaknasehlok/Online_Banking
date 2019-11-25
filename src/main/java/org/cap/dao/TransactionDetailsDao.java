package org.cap.dao;

import java.util.Date;
import java.util.List;

import org.cap.entities.Transaction_Details;
import org.cap.entities.User_Profiles;


public interface TransactionDetailsDao {
	
	Transaction_Details createtrans(String sender_acc_no, String receiver_acc_no, Integer amount);
	List<Transaction_Details> allStatementsSent(String currentaccno, Date from, Date to);
	List<Transaction_Details> allStatementsReceived(String currentaccno, Date from, Date to);
}
