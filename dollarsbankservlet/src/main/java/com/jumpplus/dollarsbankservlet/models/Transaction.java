package com.jumpplus.dollarsbankservlet.models;

import java.util.Date;
import java.util.UUID;

public class Transaction {
  
  private String transactionID;
  private String userID;
	private String accountAction;
	private double amount;
	private String date;
	
	public Transaction(String userID, String accountAction, double amount) {
		super();
    this.transactionID = UUID.randomUUID().toString();
		this.userID = userID;
		this.accountAction = accountAction;
		this.amount = amount;
		this.date = new Date().toString();
	}

  public String getTransactionID() {
    return this.transactionID;
  }

	public String getUserID() {
		return this.userID;
	}

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public String getAccountAction() {
    return this.accountAction;
  }

  public void setAccountAction(String accountAction) {
    this.accountAction = accountAction;
  }

  public double getAmount() {
    return this.amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getDate() {
    return this.date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "{" +
      " userID='" + getUserID() + "'" +
      ", accountAction='" + getAccountAction() + "'" +
      ", amount='" + getAmount() + "'" +
      ", date='" + getDate() + "'" +
      "}";
  }

}
