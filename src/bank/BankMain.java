package bank;

import org.apache.log4j.Logger;
public class BankMain {
	final static Logger Log = Logger.getLogger(BankMain.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankUI ui=new BankUI();
		ui.loginScreen();
	}
}
