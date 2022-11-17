package com.jumpplus.dollarsbankservlet.models;

public class CheckingAccount {

  private int accountNumber;
	private String userID;
	private double amount;
		
	public CheckingAccount(double amount, String userID) {
		super();
		this.accountNumber = (int) Math.floor(Math.random() * (999999999 - 111111111 + 1) + 111111111);
		this.userID = userID;
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
		
	public int getAccountNumber() {
		return accountNumber;
	}
		
	public String getUserID() {
		return userID;
	}

	@Override
	public String toString() {
		return "CheckingAccount [userID= " + userID + ", accountNumber=" + accountNumber + ", amount=" + amount + "]";
	}
  
}
