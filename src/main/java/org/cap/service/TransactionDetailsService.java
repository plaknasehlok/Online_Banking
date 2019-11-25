package org.cap.service;
import java.util.Date;
import java.util.List;

import org.cap.entities.Transaction_Details;

public interface TransactionDetailsService {
	Transaction_Details createtrans(String sender_acc_no, String receiver_acc_no, Integer amount);
	List<Transaction_Details> allStatementsSent(String currentaccno, Date from, Date to);
	List<Transaction_Details> allStatementsReceived(String currentaccno, Date from, Date to);
}
