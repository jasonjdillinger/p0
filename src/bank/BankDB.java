package bank;

import java.util.ArrayList;

public class BankDB {
	public BankDB(){
		
	}
	public boolean doesUserExist(String user){
		if(user.equals("user")) {return true;}
		else {return false;}
	}
	public boolean isPasswordCorrect(String user,String pass){
		if(pass.equals("pass")) {return true;}
		else {return false;}
	}
	public BankUser getUser(String user, String pass) {
		BankCustomer b= new BankCustomer(user,pass);
		ArrayList<BankAccount> l = new ArrayList();
		BankAccount b1= new BankAccount(user,"Test name",100.00);
		BankAccount b2= new BankAccount(user,"Test name2",100.00);
		BankAccount b3= new BankAccount(user,"Test 323232323",100.00);
		l.add(b1);
		l.add(b2);
		l.add(b3);
		b.setAccounts(l);
		return b;
	}
	public void sendTransfer(BankTransfer t) {
		
		
	}
}
