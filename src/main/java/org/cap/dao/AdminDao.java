package org.cap.dao;

import org.cap.entities.Admin;

public interface AdminDao {
	boolean validateCredentials(String user_id,String password);
}
