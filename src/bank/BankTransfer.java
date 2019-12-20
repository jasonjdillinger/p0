package bank;

public class BankTransfer {
	private String sender;
	private String receiver;
	private double amount;
	public BankTransfer(String sender,String receiver, double amount) {
		this.sender=sender;
		this.receiver=receiver;
		this.amount=amount;	
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
}
