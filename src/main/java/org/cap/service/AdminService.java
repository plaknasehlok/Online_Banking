package org.cap.service;

import org.cap.entities.Admin;

public interface AdminService {
	boolean validateCredentials(String user_id,String password);
	Admin findUserByUser_Id(String user_id);
}
