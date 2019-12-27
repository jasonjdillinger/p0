package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class BankDB {
	private Connection connection;
	public BankDB(){
		try {
			//step1
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("success1");
			//step2
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="SYSTEM";
			String password="catsanddogs123";
			connection=DriverManager.getConnection(url,username,password);
		}
		catch(ClassNotFoundException e) {
			
		}
		catch(SQLException e) {
			
		}
	}
	public boolean doesUserExist(String user,boolean onlyCustomer){
		if(user.equals("user")) {return true;}
		else {return false;}
	}
	public boolean doesAccountExist(int ID){
		if(ID==5) {return true;}
		else {return false;}
	}
	public boolean isPasswordCorrect(String user,String pass){
		if(pass.equals("pass")) {return true;}
		else {return false;}
	}
	public BankUser getUser(String user, String pass) {
		BankCustomer b= new BankCustomer(user,pass);
		ArrayList<BankAccount> l = new ArrayList();
		BankAccount b1= new BankAccount(b,"Test name",100.00,1,true);
		BankAccount b2= new BankAccount(b,"Test name2",100.00,2,true);
		BankAccount b3= new BankAccount(b,"Test 323232323",100.00,3,true);
		l.add(b1);
		l.add(b2);
		l.add(b3);
		b.setAccounts(l);
		return b;
	}
	public BankUser getUser(String user) {
		BankCustomer b= new BankCustomer(user,"");
		ArrayList<BankAccount> l = new ArrayList();
		BankAccount b1= new BankAccount(b,"Test name",100.00,1,true);
		BankAccount b2= new BankAccount(b,"Test name2",100.00,2,true);
		BankAccount b3= new BankAccount(b,"Test 323232323",100.00,3,true);
		l.add(b1);
		l.add(b2);
		l.add(b3);
		b.setAccounts(l);
		return b;
	}
	public void createAccountRequest(String name, double balance,BankCustomer customer) {
		int id=1;//change this
		BankAccount b=new BankAccount(customer,name,balance,id,false);
		//do database stuff
	}
	public void sendTransfer(BankTransfer t) {
		
		
	}
}
