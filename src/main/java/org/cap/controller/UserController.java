package org.cap.controller;

import org.cap.entities.Account_Details;
import org.cap.entities.Login_Details;
import org.cap.entities.Transaction_Details;
import org.cap.entities.Admin;
import org.cap.entities.Beneficiary;
import org.cap.entities.User_Profiles;

import org.cap.service.AccountDetailsService;
import org.cap.service.AdminService;
import org.cap.service.BeneficiaryService;
import org.cap.service.LoginDetailsService;
import org.cap.service.TransactionDetailsService;
import org.cap.service.User_ProfilesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.mail.*;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

@Controller
public class UserController {

	int otp = 0;
	@Autowired
	private JavaMailSender javamailsender;

	@Autowired
	private LoginDetailsService service; // service for create user

	public LoginDetailsService getService() {
		return service;
	}

	public void setService(LoginDetailsService service) {
		this.service = service;
	}

	@Autowired
	private User_ProfilesService service1; // service for user profile

	public User_ProfilesService getService1() {
		return service1;
	}

	public void setService1(User_ProfilesService service1) {
		this.service1 = service1;
	}

	@Autowired
	private AccountDetailsService service2; // service for account details

	public AccountDetailsService getService2() {
		return service2;
	}

	public void setService2(AccountDetailsService service2) {
		this.service2 = service2;
	}

	@Autowired
	private TransactionDetailsService service3; // service for account details

	public TransactionDetailsService getService3() {
		return service3;
	}

	public void setService3(TransactionDetailsService service3) {
		this.service3 = service3;
	}
	
	@Autowired
	private AdminService service4; // service for account details

	public AdminService getService4() {
		return service4;
	}

	public void setService4(AdminService service4) {
		this.service4 = service4;
	}
	
	@Autowired
	private BeneficiaryService service5;

	public BeneficiaryService getService5() {
		return service5;
	}

	public void setService5(BeneficiaryService service5) {
		this.service5 = service5;
	}
	/*@RequestMapping("/error")
	public ModelAndView error() {
		return new ModelAndView("errorpage", new HashMap<>());
	}*/

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index", new HashMap<>());
	}

	@RequestMapping("/getdetails")
	public ModelAndView detailsForm() {
		return new ModelAndView("createuser", new HashMap<>());
	}

	@RequestMapping("/createprocess")
	public ModelAndView createProcess(@RequestParam String acc_no_fk, @RequestParam String user_id,
			@RequestParam String password, @RequestParam String trans_pass) {

		try {

			Account_Details reg = service2.findUserByAccNo(acc_no_fk);
			System.out.println("acc no exists");

		} catch (Exception e) {
			Map<String, String> map = new HashMap<>();
			map.put("error", "This acc no doesn't exist");
			System.out.println("acc no doesn't exist");
			ModelAndView mv = new ModelAndView("createuser", map);
			return mv;
		}

		try {
			Login_Details regacc = service.findUserByUser_Id(user_id);
			System.out.println("user already exists");
			Map<String, String> map = new HashMap<>();
			map.put("error", "user already exists");
			ModelAndView mv = new ModelAndView("createuser", map);
			return mv;
		} catch (Exception e) {
			Map<String, Object> map = new HashMap<>();
			System.out.println("good");
			Login_Details reg = service.createUser(acc_no_fk, user_id, password, trans_pass);
			map.put("acc_no_fk", reg.getAcc_no_fk());
			map.put("user_id", reg.getUser_id());
			ModelAndView mv = new ModelAndView("usercreated", map);
			return mv;
		}

	}

	@RequestMapping("/createuserprofile")
	public ModelAndView createuserprofile() {
		return new ModelAndView("userprofileDetails", new HashMap<>());
	}

	@RequestMapping("/userprofileprocess")
	public ModelAndView userprofileprocess(@RequestParam String aadhar_no, @RequestParam String f_name,
			@RequestParam String l_name, @RequestParam String m_name, @RequestParam String fathers_name,
			@RequestParam long mobile_no, @RequestParam String email_id, @RequestParam Date dob,
			@RequestParam String res_addr, @RequestParam String per_addr, @RequestParam String occ_details) {
		System.out.println("inside userprofileprocess");
		User_Profiles up = service1.createUser_Profiles(aadhar_no, f_name, l_name, m_name, fathers_name, mobile_no,
				email_id, dob, res_addr, per_addr, occ_details);
		Map<String, Object> map = new HashMap<>();
		System.out.println("good");
		map.put("user_profile_id", up.getUser_profile_id());
		map.put("aadhar_no", up.getAadhar_no());
		map.put("f_name", up.getF_name());
		ModelAndView mv = new ModelAndView("userinfoCreated", map);
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Map<String, Object> map = new HashMap<>();
			// map.put("user_id", user_id);
			ModelAndView mv = new ModelAndView("dashboard", map);
			return mv;
		} else {
			return new ModelAndView("login", new HashMap<>());
		}
	}

	@RequestMapping("/loginprocess")
	public ModelAndView loginProcess(HttpServletRequest request, HttpSession session, @RequestParam String user_id,
			@RequestParam String password) {
		if (session.getAttribute("user_id") != null) {
			Map<String, Object> map = new HashMap<>();
			
			// map.put("user_id", user_id);
			ModelAndView mv = new ModelAndView("dashboard", map);
			return mv;
		} else {
			try {
				Login_Details regacc = service.findUserByUser_Id(user_id);
				System.out.println("user exists");
				
			} catch (Exception e) {
				Map<String, String> map = new HashMap<>();
				map.put("error", "user doesn't exist");
				ModelAndView mv = new ModelAndView("login", map);
				return mv;
			}
			boolean flag = service.validateCredentials(user_id, password);
			if (flag) {
				/*
				 * session=request.getSession(); session.setAttribute("session", user_id);
				 * session.setMaxInactiveInterval(10);
				 */

				session.setAttribute("user_id", user_id);

				// session.invalidate();
				Map<String, Object> map = new HashMap<>();
				// map.put("user_id", user_id);
				
				String acc_no=service.findAccNo(user_id);
				session.setAttribute("acc_no",acc_no);

				map.put("acc_no_fk", acc_no);
				ModelAndView mv = new ModelAndView("dashboard", map);
				return mv;
			} else {

				Map<String, String> map = new HashMap<>();
				map.put("error", "Incorrect credentials");
				ModelAndView mv = new ModelAndView("login", map);
				return mv;
			}

		}
	}

	@RequestMapping("/fundstransfer")
	public ModelAndView fundstransfer(HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("user_id") != null) {
			String uname = (String) request.getSession().getAttribute("user_id");
			Map<String, Object> map = new HashMap<>();
			System.out.println("good");
			map.put("user_id", uname);
			
			String acc_no=(String) session.getAttribute("acc_no");
			
			List<Beneficiary> bene =service5.allBene(acc_no);
			List<String> beneList = new ArrayList<String>();
			
			for (Beneficiary b : bene) {
	
				beneList.add(b.getBene_acc_no());
			}
			System.out.println(beneList);
			map.put("bene_accounts",beneList);
			
			map.put("acc_no", acc_no);
			ModelAndView mv = new ModelAndView("transferfunds", map);
			return mv;
		} else {
			return new ModelAndView("login", new HashMap<>());
		}

	}

	@RequestMapping("/fundstransferprocess")
	public ModelAndView createProcess(@RequestParam String sender_acc_no, @RequestParam String receiver_acc_no,
			@RequestParam Integer amount, HttpSession session, HttpServletRequest request) {
		/*
		 * String uname=(String)request.getSession().getAttribute("user_id");
		 * System.out.println(uname);
		 */
		Map<String, Object> map = new HashMap<>();
		Integer balance=service2.findBalance(sender_acc_no);
		if(balance<amount) {
			String error="Not enough balance";
			map.put("balanceerror", error);
			ModelAndView mv = new ModelAndView("transferfunds", map);
			return mv;
		}
		else {
			Account_Details senderuser = service2.sendFunds(sender_acc_no, amount);
			Account_Details receiveruser = service2.receiveFunds(receiver_acc_no, amount);
			Transaction_Details transaction = service3.createtrans(sender_acc_no, receiver_acc_no, amount);
			map.put("acc_no", senderuser.getAcc_no());
			map.put("balance", senderuser.getBalance());
			ModelAndView mv = new ModelAndView("userupdated", map);
			return mv;
		}
		
	}

	@RequestMapping("/accountstatement")
	
	public ModelAndView accountstatement(HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("user_id") != null) {
			return new ModelAndView("accountstatementform", new HashMap<>());
		} else {
			return new ModelAndView("login", new HashMap<>());
		}
	}

	@RequestMapping("/accountstatementprocess")
	public ModelAndView accountstatementsent(@RequestParam Date fromdate, @RequestParam Date todate,
			HttpSession session, HttpServletRequest request) {
		/*
		 * String uname=(String)request.getSession().getAttribute("user_id");
		 * System.out.println(uname);
		 */
		String uname = (String) session.getAttribute("user_id");
		Login_Details u = service.findUserById(uname);
		String currentaccno = u.getAcc_no_fk();
		Map<String, Object> map = new HashMap<>();

		// Sent
		List<List<String>> listOfStatements = new ArrayList<List<String>>();
		List<Transaction_Details> statements = service3.allStatementsSent(currentaccno, fromdate, todate);
		System.out.println("before for");
		for (Transaction_Details td : statements) {
			List<String> statementDetails = new ArrayList<String>();
			System.out.println("inside for");
			String transaction_id_string = td.getTrans_id().toString();
			statementDetails.add(transaction_id_string);
			statementDetails.add(td.getSender_acc_no());
			statementDetails.add(td.getReceiver_acc_no());
			String transaction_amount_string = td.getAmount().toString();
			statementDetails.add(transaction_amount_string);
			statementDetails.add(td.getDate_of_transfer().toString());

			listOfStatements.add(statementDetails);

		}
		System.out.println(listOfStatements);
		map.put("Statements", listOfStatements);

		/*
		 * //Received List<List<String>> listOfStatementsReceived = new
		 * ArrayList<List<String>>(); List<Transaction_Details> statementsreceived =
		 * service3.allStatementsReceived(currentaccno,fromdate,todate);
		 * 
		 * for (Transaction_Details tdr : statementsreceived) { List<String>
		 * statementDetailsReceived = new ArrayList<String>();
		 * System.out.println("inside for"); String transaction_id_string =
		 * tdr.getTrans_id().toString();
		 * statementDetailsReceived.add(transaction_id_string);
		 * statementDetailsReceived.add(tdr.getSender_acc_no());
		 * statementDetailsReceived.add(tdr.getReceiver_acc_no()); String
		 * transaction_amount_string = tdr.getAmount().toString();
		 * statementDetailsReceived.add(transaction_amount_string);
		 * statementDetailsReceived.add(tdr.getDate_of_transfer().toString());
		 * 
		 * listOfStatementsReceived.add(statementDetailsReceived);
		 * 
		 * } map.put("StatementsReceived", listOfStatementsReceived);
		 */
		return new ModelAndView("statements", map);
	}

	@RequestMapping("/loggingout")
	public ModelAndView indexagain(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();
		// response.sendRedirect(request.getContextPath() + "/LogoutPage.jsp");
		return new ModelAndView("LogoutPage", new HashMap<>());
	}

	@RequestMapping("/adminlogin")
	public ModelAndView adminlogin() {
		return new ModelAndView("adminlogin", new HashMap<>());
	}

	@RequestMapping("/adminloginprocess")
	public ModelAndView adminloginProcess(HttpServletRequest request, HttpSession session, @RequestParam String user_id,
			@RequestParam String password) {
		if (session.getAttribute("user_id") != null) {
			Map<String, Object> map = new HashMap<>();
			
			// map.put("user_id", user_id);
			ModelAndView mv = new ModelAndView("adminview", map);
			return mv;
		} else {
			try {
				Admin regacc = service4.findUserByUser_Id(user_id);
				System.out.println("user exists");
				
			} catch (Exception e) {
				Map<String, String> map = new HashMap<>();
				map.put("error", "admin doesn't exist");
				ModelAndView mv = new ModelAndView("adminlogin", map);
				return mv;
			}
		boolean flag = service4.validateCredentials(user_id, password);
		if (flag) {

			session.setAttribute("user_id", user_id);

			String uname = (String) request.getSession().getAttribute("user_id");
			Map<String, Object> map = new HashMap<>();
			map.put("user_id", uname);
			ModelAndView mv = new ModelAndView("adminview", map);
			return mv;
		} else {
			Map<String, String> map = new HashMap<>();
			map.put("error", "Incorrect credentials");
			ModelAndView mv = new ModelAndView("adminlogin", map);
			return mv;
		}

	}
	}
	@RequestMapping("/adminsview")
	public ModelAndView view(HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("user_id") != null) {
			String uname = (String) session.getAttribute("user_id");
			Map<String, Object> map = new HashMap<>();

			List<List<String>> listOfProfiles = new ArrayList<List<String>>();

			// Retrieval from db
			List<User_Profiles> profiles = service1.allRequests();
			System.out.println("before for");
			for (User_Profiles up : profiles) {
				List<String> profileDetails = new ArrayList<String>();
				System.out.println("inside for");
				String user_profile_id_string = up.getUser_profile_id().toString();
				profileDetails.add(user_profile_id_string);
				profileDetails.add(up.getAadhar_no());
				profileDetails.add(up.getF_name());
				profileDetails.add(up.getL_name());
				profileDetails.add(up.getM_name());
				profileDetails.add(up.getFathers_name());
				long mobile_no_long = up.getMobile_no();
				String mobile_no_string = Long.toString(mobile_no_long);
				profileDetails.add(mobile_no_string);
				profileDetails.add(up.getEmail_id());

				profileDetails.add(up.getDob().toString());

				profileDetails.add(up.getRes_addr());
				profileDetails.add(up.getPer_addr());
				profileDetails.add(up.getOcc_details());
				String status_string=Integer.toString(up.getStatus());
				
				profileDetails.add(status_string);

				listOfProfiles.add(profileDetails);

				System.out.print(profileDetails);

			}
			System.out.println("after for");
			// System.out.print(listOfProfiles);
			map.put("Requests", listOfProfiles);
			map.put("user_id", uname);
			return new ModelAndView("viewrequests", map);
		} else {
			return new ModelAndView("adminlogin", new HashMap<>());
		}
	}

	// ADMIN APPROVE PROCESS WHICH CREATES ACCOUNT
	@RequestMapping("/approveprocess")
	public ModelAndView approveprocess(HttpSession session, HttpServletRequest request,
			@RequestParam Integer user_profile_id_fk) {
		if (session.getAttribute("user_id") != null) {
			String uname = (String) request.getSession().getAttribute("user_id");

			String num = "";
			do {
				num = "BB";
				Random value = new Random();
				// Generate two values to append to 'BB'
				int r1 = value.nextInt(10);
				int r2 = value.nextInt(10);
				num += Integer.toString(r1) + Integer.toString(r2);

				int count = 0;
				int n = 0;
				for (int i = 0; i < 5; i++) {
					if (count == 4) {
						count = 0;
					} else {
						n = value.nextInt(10);
					}
					num += Integer.toString(n);
					count++;

				}
				System.out.println(num);
				String acc_no = num;
				String acc_type = "Saving";
				Integer balance = 0;
				Account_Details ad = service2.createAccount(acc_no, acc_type, balance, user_profile_id_fk);
				Map<String, Object> map = new HashMap<>();
				System.out.println("good");
				User_Profiles u = service1.updateProfile(user_profile_id_fk);
				
				String email=service1.findEmail(user_profile_id_fk);
				javamailsender.send(new MimeMessagePreparator() {

					@Override
					public void prepare(MimeMessage mimeMessage) throws Exception {
						MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
						
						messageHelper.setTo(InternetAddress.parse(email));
						messageHelper.setFrom("humpty07.tester@gmail.com","BerenBurg Bank");
						messageHelper.setSubject("Account Creation");
						//messageHelper.setText("Dear"+ nm);
						//messageHelper.setText("Your account has been created in BerenBurg Bank");
						//messageHelper.setText(" Your Account Number is: " + acc_no);
						//messageHelper.setText("Kindly contact our nearest branch & submit your Aadhar Card copy");
						
						messageHelper.setText("<html> <body><h2>Your account has been created in BerenBurg Bank</h2></br><h2>Your Account Number is:    "+acc_no+"</h2></br>Kindly contact our nearest branch & submit your Aadhar Card copy</body></html>",true);
						

						System.out.println("Sending Done");

					}
				});
				// service1.deleteUserProfile(user_profile_id_fk);
				/*
				 * map.put("user_profile_id",up.getUser_profile_id()); map.put("aadhar_no",
				 * up.getAadhar_no()); map.put("f_name", up.getF_name());
				 */
				ModelAndView mv = new ModelAndView("adminview", map);
				return mv;
			} while (false);
		} else {
			return new ModelAndView("adminlogin", new HashMap<>());
		}
	}

	@RequestMapping("/adminlogout")
	public ModelAndView indexagain1(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();
		// response.sendRedirect(request.getContextPath() + "/LogoutPage.jsp");
		return new ModelAndView("LogoutPage", new HashMap<>());
	}

	@RequestMapping("/forgotpassword")
	public ModelAndView forgotpassword() {
		return new ModelAndView("getotpPage", new HashMap<>());
	}

	@RequestMapping("/otpActionProcess") /* value = "otp" */
	public ModelAndView checkOtp(@RequestParam String userotp) {

		System.out.println("otp got: " + userotp);

		int userotp1 = Integer.parseInt(userotp);
		if (userotp1 == otp) {
			System.out.println("otp compared :");
			ModelAndView modelAndView = new ModelAndView("otpsuccess");
			return modelAndView;

		} else {
			Map<String, Object> map = new HashMap<>();
			map.put("error", "Inavlid otp");
			ModelAndView mv = new ModelAndView("invalidotp", map);
			return mv;
		}
	}
	
	@RequestMapping("/emailActionProcess")
	public ModelAndView sendotp(@RequestParam String emailid) {

		Random random = new Random();

		otp = (int) (Math.random() * 9000) + 1000;
		System.out.println("random is " + otp);
		System.out.println("email is" + emailid);

		javamailsender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

				messageHelper.setTo(InternetAddress.parse(emailid));
				messageHelper.setFrom("humpty07.tester@gmail.com","BerenBurg Bank");
				messageHelper.setSubject("OTP for forget password");
				messageHelper.setText("Your otp is " + otp);

				System.out.println("Sending Done");

			}
		});
		ModelAndView modelAndView = new ModelAndView("getotpPage", "msg", "OTP sent successfully to your email-id");
		return modelAndView;

	}

	@RequestMapping("/forgetpasswordprocess")
	public ModelAndView createProcess(@RequestParam String user_id, @RequestParam String password) {
		try {
			Login_Details regacc = service.findUserByUser_Id(user_id);
			System.out.println("user exists");
			
		} catch (Exception e) {
			Map<String, String> map = new HashMap<>();
			map.put("error", "user doesn't exist");
			ModelAndView mv = new ModelAndView("otpsuccess", map);
			return mv;
		}
		Login_Details updatepass = service.updatePassword(user_id, password);
		Map<String, Object> map = new HashMap<>();
		map.put("password", updatepass.getPassword());
		ModelAndView mv = new ModelAndView("passwordupdated", map);
		return mv;

	}

	@RequestMapping("/beneficiary")
	public ModelAndView beneficiary(HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("user_id") != null) {
			String acc_no=(String) session.getAttribute("acc_no");
			Map<String, Object> map = new HashMap<>();
			map.put("acc_no", acc_no);
			return new ModelAndView("beneficiaryadd", map);
		}else {
			return new ModelAndView("login", new HashMap<>());
		}
		
	}
	
	@RequestMapping("/beneficiaryprocess")
	public ModelAndView beneficiaryprocess(@RequestParam String bene_acc_no, @RequestParam String bene_nickname,
			@RequestParam String bene_bankname,@RequestParam String acc_no_fk, HttpSession session, HttpServletRequest request) {
		
		Beneficiary b = service5.createBene(bene_acc_no, bene_nickname, bene_bankname, acc_no_fk);
		Map<String, Object> map = new HashMap<>();
		System.out.println("good");
		map.put("bene_nickname", b.getBene_nickname());
		map.put("bene_bankname", b.getBene_bankname());
		ModelAndView mv = new ModelAndView("beneficiaryCreated", map);
		return mv;
	}
	
}
