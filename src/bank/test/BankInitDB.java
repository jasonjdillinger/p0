package bank.test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class BankInitDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			//step1
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("success1");
			//step2
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="SYSTEM";
			String password="catsanddogs123";
			connection=DriverManager.getConnection(url,username,password);
			System.out.println("success2");
			//step 3
			Statement statement=connection.createStatement();
			//String dropSQL="CREATE TABLE t_test(a INTEGER PRIMARY KEY,b VARCHAR(10))";
			String sql="CREATE TABLE BANKUSER(USERID NUMBER PRIMARY KEY,NAME VARCHAR(20),PASS VARCHAR(20), USERTYPE NUMBER)";
			ResultSet resultset=null;
			//resultset=statement.executeQuery(sql);
			System.out.println("success31");
			sql="CREATE TABLE BANKACCOUNT(ACCOUNTID VARCHAR(20) PRIMARY KEY,USERID NUMBER, ACCOUNTNAME VARCHAR(20), ACCOUNTBALANCE NUMBER, ACTIVE NUMBER)";
			//resultset=statement.executeQuery(sql);
			System.out.println("success32");
			sql="CREATE TABLE BANKTRANSFER(TRANSFERID VARCHAR(20) PRIMARY KEY,SENDER NUMBER, RECEIVER NUMBER, TRANSFERAMOUNT NUMBER)";
			//resultset=statement.executeQuery(sql);
			sql="INSERT INTO BANKUSER VALUES(1,'ADMIN','ADMIN',1)";
			resultset=statement.executeQuery(sql);
			
			System.out.println("success33");
			//step 5
			
		}
		catch(Exception e) {
			System.out.println(e);
		}finally {
			try{connection.close();
			System.out.println("success6");}
			catch(Exception e) {}
		}
	}

}
