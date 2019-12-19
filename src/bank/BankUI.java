package bank;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class BankUI {
	private Scanner scan;
	private BankDB db;
	public BankUI() {
		scan = new Scanner(System.in);
		db=new BankDB();
	}
	
	public void loginScreen() {
		boolean end=false;
		while(!end) {
			System.out.println("1. Login");
			System.out.println("2. Create User");
			System.out.println("3. Exit");
			String option= scan.next();		
			char optionchar=option.charAt(0);
			switch(optionchar) {
				case '1':
					this.userLogin();
				case '2':
					break;
				
				case '3': end=true; break;
				default: 
					System.out.println("Invalid Input");
		
				}
		}
	}
	private void userLogin() {
		String user="";
		String password="";
		Boolean found;
		while(!user.equals("QUIT")) {
			System.out.println("Login Screen(enter QUIT to quit)");
			System.out.println();
			System.out.print("User:");
			user= scan.next();
			if(user.equals("QUIT")) {break;}
			found=db.doesUserExist(user);
			if(found==true) {
				while(!password.equals("QUIT")) {
					System.out.print("Password:");
					password= scan.next();
					if(password.equals("QUIT")) {break;}
					found=db.isPasswordCorrect(user,password);
					if(found==true) {
						BankUser bUser=db.getUser(user, password);
						if(bUser.getClass().equals(BankCustomer.class)) {
							this.customerMenu((BankCustomer)bUser);
						}
						else if(bUser.getClass().equals(BankEmployee.class)) {
														
						}
						password="QUIT";
					}
					else {
						System.out.println("Password incorrect.");
					}
				}
				user="QUIT";
			}
			else {
				System.out.println("User doesn't exist.");
			}
		}
		}
		private void customerMenu(BankCustomer customer) {
			boolean end=false;
			while(!end) {
				System.out.println("1. View accounts:");
				System.out.println("2. Create new account:");
				System.out.println("3. Withdraw from account:");
				System.out.println("4. Deposit to account:");
				System.out.println("5. Exit:");
				String option= scan.next();		
				char optionchar=option.charAt(0);
				switch(optionchar) {
					case '1':
						this.viewAccounts(customer);
					case '2':
						break;
					case '3':
						break;
					case '4':
						break;
					case '5': end=true; break;
					default: 
						System.out.println("Invalid Input");			
					}
			}
		}
		private void viewAccounts(BankCustomer customer) {
			ArrayList<BankAccount> accounts = customer.getAccounts();
			for(BankAccount b:accounts) {
				System.out.println(b.toString());
			}
			System.out.println("Enter anything to continue.");
			scan.next();
		}
}
