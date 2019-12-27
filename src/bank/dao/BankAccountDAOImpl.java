package bank.dao;

import java.util.ArrayList;
import java.util.List;

import com.dbutil.OracleConnection;
import com.to.Team;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bank.BankAccount;
import bank.BankCustomer;
import bank.BankDB;

public class BankAccountDAOImpl implements BankAccountDAO {

	@Override
	public List<BankAccount> getBankAccounts(BankCustomer customer, Connection connection) {
		List<BankAccount> accountList=new ArrayList<>();
			String sql="Select ACCOUNTID,ACCOUNTNAME,ACCOUNTBALANCE,ACTIVE from BANKACCOUNT a"
					+ "inner join BANKUSER u on u.USERID=a.USERID"
					+ "where u.USERNAME = ?";			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getUserID());
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				BankAccount team=new BankAccount(resultSet.getInt("tid"),);//do stuff here
				accountList.add(team);
			}
		return accountList;
	}

	@Override
	public BankAccount createBankAccount(BankCustomer user, String accountName, double balance, Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBankAccount(int ID, double balance, Connection connection) {
		// TODO Auto-generated method stub
		
	}

}
