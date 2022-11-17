package com.jumpplus.dollarsbankservlet.data;

import java.util.ArrayList;
import java.util.List;

import com.jumpplus.dollarsbankservlet.models.CheckingAccount;

public class CheckingAccountDataStorage {
  
  static List<CheckingAccount> checkingAccounts = new ArrayList<CheckingAccount>();

  public static void addCheckingAccount(CheckingAccount savingsAccount) {
    checkingAccounts.add(savingsAccount);
  }

  public static List<CheckingAccount> getAllCheckingAccount() {
    return checkingAccounts;
  }

  public static int getAccountNumber(String userID) {
    int accountNumber = -1;
    for (CheckingAccount account : checkingAccounts) {
      if (account.getUserID().equals(userID)) {
        accountNumber = account.getAccountNumber();
        break;
      }
    }

    return accountNumber;
  }

  public static double getCurrentBalance(String userID) {

    double amount = -1;
    for (CheckingAccount account : checkingAccounts) {
      if (account.getUserID().equals(userID)) {
        amount = account.getAmount();
        break;
      }
    }

    return amount;
  }

  public static void increaseAmount(String userID, double amount) {

    for (CheckingAccount account : checkingAccounts) {
      if (account.getUserID().equals(userID)) {
        account.setAmount(account.getAmount() + amount);
        break;
      }
    }

  }

  public static void decreaseAmount(String userID, double amount) {

    for (CheckingAccount account : checkingAccounts) {
      if (account.getUserID().equals(userID)) {
        account.setAmount(account.getAmount() - amount);
        break;
      }
    }

  }
}
