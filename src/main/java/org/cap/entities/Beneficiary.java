package org.cap.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "beneficiary")

public class Beneficiary implements Serializable 
{
	@Id
	private String bene_acc_no;
	private String bene_nickname;
	private String bene_bankname;
	private String acc_no_fk;
	
	
	public String getBene_acc_no() {
		return bene_acc_no;
	}
	public void setBene_acc_no(String bene_acc_no) {
		this.bene_acc_no = bene_acc_no;
	}
	
	public String getBene_nickname() {
		return bene_nickname;
	}
	public void setBene_nickname(String bene_nickname) {
		this.bene_nickname = bene_nickname;
	}
	public String getBene_bankname() {
		return bene_bankname;
	}
	public void setBene_bankname(String bene_bankname) {
		this.bene_bankname = bene_bankname;
	}
	public String getAcc_no_fk() {
		return acc_no_fk;
	}
	public void setAcc_no_fk(String acc_no_fk) {
		this.acc_no_fk = acc_no_fk;
	}
	public Beneficiary(String bene_acc_no, String bene_nickname, String bene_bankname, String acc_no_fk) {
		super();
		this.bene_acc_no = bene_acc_no;
		this.bene_nickname = bene_nickname;
		this.bene_bankname = bene_bankname;
		this.acc_no_fk = acc_no_fk;
	}
	public Beneficiary() {
		
		// TODO Auto-generated constructor stub
	}
	
	 @Override
	    public boolean equals(Object obj) {
	      if(obj==this){
	          return true;
	      }
	      if(obj==null || !(obj instanceof Beneficiary)){
	          return false;
	      }
	      Beneficiary b=(Beneficiary)obj;
	      return b.bene_acc_no.equals(this.bene_acc_no);
	    }


	    @Override
	    public int hashCode() {
	        if(bene_acc_no==null){
	            return 0;
	        }
	        return bene_acc_no.hashCode();
	    }
	

}
