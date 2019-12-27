package bank.dao;

import java.sql.Connection;
import java.util.List;
import bank.BankAccount;
import bank.BankCustomer;
public interface BankAccountDAO {
	public List<BankAccount> getBankAccounts(BankCustomer customer, Connection connection);
	public BankAccount createBankAccount(BankCustomer user, String accountName, double balance, Connection connection);
	public void updateBankAccount(int ID, double balance, Connection connection);
}
