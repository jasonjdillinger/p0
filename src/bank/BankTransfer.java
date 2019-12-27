package bank;

public class BankTransfer {
	private int sender;
	private int receiver;
	private double amount;
	public BankTransfer(int sender,int receiver, double amount) {
		this.sender=sender;
		this.receiver=receiver;
		this.amount=amount;	
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
}
