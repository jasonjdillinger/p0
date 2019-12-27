package bank;

import java.io.Serializable;

public class BankAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BankCustomer user;
	private String accountName;
	private int accountID;
	private double balance;
	private boolean active;
	public BankAccount() {}
	public BankAccount(BankCustomer user, String accountName, double balance,int accountID,boolean active) {
		this.setUser(user);
		this.setBalance(balance);	
		this.setAccountName(accountName);
		this.setAccountID(accountID);
	}
	public BankCustomer getUser() {
		return user;
	}
	public void setUser(BankCustomer user) {
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
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
