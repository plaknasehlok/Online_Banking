package org.cap.dao;
import org.cap.entities.Transaction_Details;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
/*import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;*/
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Repository
public class TransactionDetailsDaoImpl implements TransactionDetailsDao {
	
	
	@PersistenceContext
    private EntityManager em;

	public TransactionDetailsDaoImpl() {
		
	}
	 
	@Override
    public Transaction_Details createtrans(String sender_acc_no, String receiver_acc_no, Integer amount) {
        Transaction_Details usert=new Transaction_Details();
        
        usert.setSender_acc_no(sender_acc_no);
        usert.setReceiver_acc_no(receiver_acc_no);
        usert.setAmount(amount);
        
        /*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yy");
    	LocalDate localDate = LocalDate.now();
    	date_of_transfer=dtf.format(localDate);
        usert.setDate_of_transfer(date_of_transfer);*/
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		usert.setDate_of_transfer(date);
        usert=em.merge(usert);
        return usert;
    }
	
	@Override
	public List<Transaction_Details> allStatementsSent(String currentaccno, Date from, Date to) {
		TypedQuery<Transaction_Details> querysent = em.createQuery("select transactions FROM Transaction_Details transactions where date_of_transfer between :from and :to AND SENDER_ACC_NO=:currentaccno or RECEIVER_ACC_NO=:currentaccno",
				Transaction_Details.class);
		
		querysent.setParameter("currentaccno", currentaccno);
		querysent.setParameter("from", from);
		querysent.setParameter("to", to);
		
		List<Transaction_Details> statements = querysent.getResultList();
		
		return statements;

	}

	
	@Override
	public List<Transaction_Details> allStatementsReceived(String currentaccno, Date from, Date to) {
		TypedQuery<Transaction_Details> query = em.createQuery("select transactions FROM Transaction_Details transactions where date_of_transfer between :from and :to AND RECEIVER_ACC_NO=:currentaccno",
				Transaction_Details.class);
		query.setParameter("currentaccno", currentaccno);
		query.setParameter("from", from);
		query.setParameter("to", to);
		
		List<Transaction_Details> statementsreceived = query.getResultList();
		System.out.println("hello god");
		/*
		 * for (User_Profiles up : profiles) { System.out.print(up.getAadhar_no());
		 * 
		 * }
		 */
		return statementsreceived;

	}
}
