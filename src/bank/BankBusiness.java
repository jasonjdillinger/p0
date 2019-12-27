package bank;

import java.util.ArrayList;
import java.util.Scanner;

public class BankBusiness {
	private BankDB db;
	public BankBusiness() {
		db=new BankDB();	
	}
	public static char querySelection(Scanner scan) {	
		String option= scan.nextLine();		
		return option.charAt(0);
	}
	public String getUser(Scanner scan,String prompt,boolean onlyCustomer) {
		String user="";
		while(true) {
			System.out.println();
			System.out.print(prompt);
			user= scan.nextLine();
			if(user.equals("QUIT")) {return "";}
			if(db.doesUserExist(user,onlyCustomer)) {
				return user;
			}
			else {
				System.out.println("User doesn't exist.");
			}
		}
		
	}
	public BankUser checkPassword(Scanner scan,String user) {
		String password;
		while(true) {
			System.out.print("Password:");
			password= scan.nextLine();
			if(password.equals("QUIT")) {return null;}
			if(db.isPasswordCorrect(user,password)) {
				return db.getUser(user, password);
			}
			else {
				System.out.println("Password incorrect.");
			}
		}
	}
	public int selectAccount(Scanner scan,String prompt) {	
		String receiver="";
		while(true) {
			System.out.println(prompt);
			System.out.println();
			System.out.print("Account:");
			receiver= scan.nextLine();
			if(receiver.equals("QUIT")) {return -1;}
			if(receiver.matches("[0-9]") && db.doesAccountExist(Integer.parseInt(receiver))) {//valid destination account ID
				return Integer.parseInt(receiver);
			}
			else {
				System.out.println("Please enter valid account number.");	
			}
		}
	}
	public double selectDouble(Scanner scan,String prompt,String failedPrompt) {	
		return selectDouble(scan,prompt,failedPrompt,Double.MAX_VALUE);
	}
	public double selectDouble(Scanner scan,String prompt,String failedPrompt,double limit) {	
		String amount;
		boolean validAmount;
		double transferAmount;
		while(true) {
			System.out.println(prompt);
			amount= scan.nextLine();
			if(amount.equals("QUIT")) {return -1d;}
			validAmount=amount.matches("[0-9]*(\\.[0-9]{2})?");
			if(validAmount) {
				transferAmount=Double.parseDouble(amount);
				if(transferAmount<=limit && transferAmount!=0.0) {
					return transferAmount;
				}
				else {
					System.out.println(failedPrompt);
				}
			}
			else {
				System.out.println(failedPrompt);
			}
		}
	}
	
	public BankAccount selectPromptAccount(Scanner scan,BankCustomer customer,String prompt) {	
		String account;
		int i;
		boolean validAccount;
		int accountno;
		ArrayList<BankAccount> accounts = customer.getAccounts();
		while(true) {
			System.out.println(prompt);
			i=1;
			for(BankAccount b:accounts) {
				System.out.println((i++)+". "+b.toString());
			}
			String option= scan.nextLine();	
			if(option.equals("QUIT")) {return null;}
			validAccount=option.matches("[0-9]");
			if(validAccount) {
				accountno=Integer.parseInt(option);				
				if(accountno<i) {//Valid user account selected
					return accounts.get(accountno-1);	
				}
				else {
					System.out.println("Please enter valid account number.");
					}
			}
			else {
				System.out.println("Please enter valid account number.");
			}
		}
	}
	
	
}
