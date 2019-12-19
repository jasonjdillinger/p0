package bank;

import java.io.Serializable;

public class BankAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String accountName;
	private double balance;
	public BankAccount() {}
	public BankAccount(String user, String accountName, double balance) {
		this.setUser(user);
		this.setBalance(balance);	
		this.setAccountName(accountName);
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getaccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String toString() {
		return String.format("%20s  %.2f",accountName,balance);
		
	}
}
