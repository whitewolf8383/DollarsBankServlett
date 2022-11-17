package com.jumpplus.dollarsbankservlet.data;

import java.util.ArrayList;
import java.util.List;

import com.jumpplus.dollarsbankservlet.models.SavingsAccount;

public class SavingsAccountDataStorage {
  
  static List<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();

  public static void addSavingsAccount(SavingsAccount savingsAccount) {
    savingsAccounts.add(savingsAccount);
  }

  public static List<SavingsAccount> getAllSavingsAccount() {
    return savingsAccounts;
  }

  public static int getAccountNumber(String userID) {
    int accountNumber = -1;
    for (SavingsAccount account : savingsAccounts) {
      if (account.getUserID().equals(userID)) {
        accountNumber = account.getAccountNumber();
        break;
      }
    }

    return accountNumber;
  }

  public static double getCurrentBalance(String userID) {

    double amount = -1;
    for (SavingsAccount account : savingsAccounts) {
      if (account.getUserID().equals(userID)) {
        amount = account.getAmount();
        break;
      }
    }

    return amount;
  }

  public static void increaseAmount(String userID, double amount) {

    for (SavingsAccount account : savingsAccounts) {
      if (account.getUserID().equals(userID)) {
        account.setAmount(account.getAmount() + amount);
        break;
      }
    }

  }

  public static void decreaseAmount(String userID, double amount) {

    for (SavingsAccount account : savingsAccounts) {
      if (account.getUserID().equals(userID)) {
        account.setAmount(account.getAmount() - amount);
        break;
      }
    }

  }
}
