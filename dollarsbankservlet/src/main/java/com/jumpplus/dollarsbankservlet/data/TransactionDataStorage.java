package com.jumpplus.dollarsbankservlet.data;

import java.util.ArrayList;
import java.util.List;

import com.jumpplus.dollarsbankservlet.models.Transaction;

public class TransactionDataStorage {
  
  static List<Transaction> transactions = new ArrayList<Transaction>();

  public static void addTransaction(Transaction transaction) {
    transactions.add(transaction);
  }

  public static List<Transaction> getTransactions() {
    return transactions;
  }

}
