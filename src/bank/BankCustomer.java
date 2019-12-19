package bank;

import java.util.ArrayList;


public class BankCustomer extends BankUser{
	private static final long serialVersionUID = 632766117509040575L;
	private ArrayList<BankAccount> accounts;
	
	public BankCustomer(String user,String pass) {
		super(user,pass);	
	}

	public ArrayList<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<BankAccount> accounts) {
		this.accounts = accounts;
	}
	
}
