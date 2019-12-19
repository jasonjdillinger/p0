package bank;

import java.io.Serializable;

public class BankUser implements Serializable{
	private String userID;
	private String password;
	private static final long serialVersionUID = 2784949347979303247L;
	public BankUser(String user,String pass) {
		userID=user;
		password=pass;
	}
	public void setUserID(String user) {
		userID=user;
	}
	public void setPassword(String pass) {
		password=pass;
	}
	public String getUserID() {
		return userID;	
	}
	public String getPassword() {
		return password;	
	}
}
