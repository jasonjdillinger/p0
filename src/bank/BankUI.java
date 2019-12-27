package bank;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class BankUI {
	private Scanner scan;
	private BankBusiness busi;
	private BankDB db;
	public BankUI() {
		scan = new Scanner(System.in);
		busi=new BankBusiness();
		db=new BankDB();
	}
	
	public void loginScreen() {
		boolean end=false;
		while(!end) {
			System.out.println("1. Login");
			System.out.println("2. Create User");
			System.out.println("3. Exit");		
			char optionchar=BankBusiness.querySelection(scan);
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
		System.out.println("Login Screen(enter QUIT to quit)");
		user=busi.getUser(scan,"User:",false);
		BankUser bUser=busi.checkPassword(scan, user);		
		if(bUser.getClass().equals(BankCustomer.class)) {
			this.customerMenu((BankCustomer)bUser);
		}
		else if(bUser.getClass().equals(BankEmployee.class)) {
			this.employeeMenu((BankEmployee)bUser);							
		}

		}
	private void employeeMenu(BankEmployee employee) {
		boolean end=false;
		while(!end) {
			System.out.println("1. View accounts:");
			System.out.println("2. Approve pending account requests");
			System.out.println("3. View all transactions");
			System.out.println("4. Exit:");
			String option= scan.nextLine();		
			char optionchar=option.charAt(0);
			switch(optionchar) {
				case '1':
					viewUserAccounts(employee);
					break;
				case '2':
					break;
				case '3':
					break;
				case '4': 
				case 'q':
				case 'Q':end=true; break;
				default: 
					System.out.println("Invalid Input");			
				}
		}
	}
	private void viewUserAccounts(BankEmployee employee) {
		String user=busi.getUser(scan,"Enter User:(QUIT to quit)",true);
		BankCustomer customer=(BankCustomer)db.getUser(user);
		ArrayList<BankAccount> accounts = customer.getAccounts();
		for(BankAccount b:accounts) {
			System.out.println(b.toString());
		}
		System.out.println("Enter anything to continue.");
		scan.nextLine();
	}
		private void customerMenu(BankCustomer customer) {
			boolean end=false;
			while(!end) {
				System.out.println("1. View accounts:");
				System.out.println("2. Create new account:");
				System.out.println("3. Withdraw from account:");
				System.out.println("4. Deposit to account:");
				System.out.println("5. Transfer to user:");
				System.out.println("6. Recieve transfer:");
				System.out.println("7. Exit:");
				String option= scan.nextLine();		
				char optionchar=option.charAt(0);
				switch(optionchar) {
					case '1':
						this.viewAccounts(customer);
						break;
					case '2':
						this.requestAccount(customer);
						break;
					case '3':
						this.makeWithdrawl(customer);
						break;
					case '4':
						this.makeDeposit(customer);
						break;
					case '5':
						this.sendTransfer(customer);
						break;
					case '6':
						this.acceptTransfer(customer);
						break;
					case '7': 
					case 'q':
					case 'Q':end=true; break;
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
			scan.nextLine();
		}
		private void requestAccount(BankCustomer customer) {
			System.out.println("Enter desired accont name");
			String name=scan.nextLine();
			if(name.equals("QUIT") || name.equals("")) {return;}
			Double startingAmount = busi.selectDouble(scan, "Enter starting balance","Please enter valid starting balance");
			db.createAccountRequest(name,startingAmount,customer);
		}
		private void makeDeposit(BankCustomer customer) {
			BankAccount b=busi.selectPromptAccount(scan,customer,"Deposit to which account?(enter QUIT to quit)");
			if(b==null) {return;}
			Double depositAmount = busi.selectDouble(scan, "Deposit how much? (enter QUIT to quit)","Please enter valid deposit amount.");
			if(depositAmount<0) {return;}		
		}
		private void makeWithdrawl(BankCustomer customer) {
			BankAccount b=busi.selectPromptAccount(scan,customer,"Withdraw from which account?(enter QUIT to quit)");
			if(b==null) {return;}
			Double withdrawAmount = busi.selectDouble(scan, "Withdraw how much? (enter QUIT to quit)","Please enter valid withdrawl amount.",b.getBalance());
			if(withdrawAmount<0) {return;}		
		}
		private void sendTransfer(BankCustomer customer) {
			int transferTo=busi.selectAccount(scan, "Transfer to which account?(enter QUIT to quit)");
			if(transferTo<0) {return;}
			BankAccount b=busi.selectPromptAccount(scan,customer,"Transfer from which account?(enter QUIT to quit)");
			if(b==null) {return;}
			Double transferAmount = busi.selectDouble(scan, "Transfer how much? (enter QUIT to quit)","Please enter valid transfer amount.",b.getBalance());
			if(transferAmount<0) {return;}		
		}
		private void acceptTransfer(BankCustomer customer) {
			int transferTo=busi.selectAccount(scan, "Transfer to which account?(enter QUIT to quit)");
			if(transferTo<0) {return;}
			BankAccount b=busi.selectPromptAccount(scan,customer,"Transfer from which account?(enter QUIT to quit)");
			if(b==null) {return;}
			Double transferAmount = busi.selectDouble(scan, "Transfer how much? (enter QUIT to quit)","Please enter valid transfer amount.",b.getBalance());
			if(transferAmount<0) {return;}		
		}
		}

