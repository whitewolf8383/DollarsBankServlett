package com.jumpplus.dollarsbankservlet.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jumpplus.dollarsbankservlet.data.CheckingAccountDataStorage;
import com.jumpplus.dollarsbankservlet.data.CustomerDataStorage;
import com.jumpplus.dollarsbankservlet.data.SavingsAccountDataStorage;
import com.jumpplus.dollarsbankservlet.data.TransactionDataStorage;
import com.jumpplus.dollarsbankservlet.models.CheckingAccount;
import com.jumpplus.dollarsbankservlet.models.Customer;
import com.jumpplus.dollarsbankservlet.models.SavingsAccount;
import com.jumpplus.dollarsbankservlet.models.Transaction;

@Controller
public class AppController {

  private String userID = "";
  
  // Create Account
  @GetMapping("/createAccount")
  public String createNewAccount() {
    return "createNewAccount";
  }

  @PostMapping("/handleCreateAccount")
  public String createAccount(
    @RequestParam(value="userID", required=true) String userID,
    @RequestParam(value="customerName", required=true) String customerName,
    @RequestParam(value="address", required=true) String address,
    @RequestParam(value="city", required=true) String city,
    @RequestParam(value="state", required=true) String state,
    @RequestParam(value="zipCode", required=true) int zipCode,
    @RequestParam(value="contactNumber", required=true) String contactNumber,
    @RequestParam(value="email", required=true) String email,
    @RequestParam(value="password", required=true) String password,
    @RequestParam(value="confirmPassword", required=true) String confirmPassword
  ) {
    
    if (confirmPassword.equals(password)) {
      // Create Accounts
      Customer customer = new Customer(userID, customerName, address, city, state, zipCode, contactNumber, email, password);
      CheckingAccount checking = new CheckingAccount(0, userID);
      SavingsAccount savings = new SavingsAccount(0, userID);
      Transaction transaction = new Transaction(userID, "New Customer Accounts Created", 0);
      
      // Add Data to Data Storage
      CustomerDataStorage.addCustomer(customer);
      CheckingAccountDataStorage.addCheckingAccount(checking);
      SavingsAccountDataStorage.addSavingsAccount(savings);
      TransactionDataStorage.addTransaction(transaction);
    } else {
      System.out.println("Password do not match.");
    }

    return "login";
  }

  // Login
  @GetMapping("/")
  public String login() {
    return "login";
  }

  @PostMapping("/handleLogin")
  public String handleLogin(
    @RequestParam(value="userID", required=true) String userID,
    @RequestParam(value="password", required=true) String password
  ) {

    List<Customer> customers = CustomerDataStorage.getAllCustomers();
    for (Customer customer : customers) {
      if (customer.getUserID().equals(userID) && customer.getPassword().equals(password)) {
        this.userID = customer.getUserID();
        return "redirect:/accounts";
      }
    }

    return "redirect:/";
  }

  // Accounts
  @GetMapping("/accounts")
  public String accounts(Model model) {
    if (this.userID.equals("")) return "redirect:/";

    List<CheckingAccount> checkingAccounts = CheckingAccountDataStorage.getAllCheckingAccount();
    List<SavingsAccount> savingsAccounts = SavingsAccountDataStorage.getAllSavingsAccount();

    for (CheckingAccount checkingAccount : checkingAccounts) {
      if (checkingAccount.getUserID().equals(this.userID)) {
        model.addAttribute("checkingAccount", checkingAccount.getAmount());
        break;
      }
    }

    for (SavingsAccount savingsAccount : savingsAccounts) {
      if (savingsAccount.getUserID().equals(this.userID)) {
        model.addAttribute("savingsAccount", savingsAccount.getAmount());
        break;
      }
    }
    
    return "accounts";
  }

  // Deposit
  @GetMapping("/deposit")
  public String deposit() {
    if (this.userID.equals("")) return "redirect:/";
    return "deposit";
  }

  @PostMapping("/handleDeposit")
  public String handleDeposit(
    @RequestParam(value="depositTo", required=true) String depositTo,
    @RequestParam(value="depositAmount", required=true) double depositAmount
  ) {
      if (depositTo.equals("checking")) {
        CheckingAccountDataStorage.increaseAmount(this.userID, depositAmount);
        Transaction transaction = new Transaction(userID, "Deposit to Checking Account", depositAmount);
        TransactionDataStorage.addTransaction(transaction);
      } else {
        SavingsAccountDataStorage.increaseAmount(this.userID, depositAmount);
        Transaction transaction = new Transaction(userID, "Deposit to Savings Account", depositAmount);
        TransactionDataStorage.addTransaction(transaction);
      }

    return "redirect:/accounts";
  }

  // Transfer
  @GetMapping("/transfer")
  public String transfer() {
    if (this.userID.equals("")) return "redirect:/";
    return "transfer";
  }

  @PostMapping("/handleTransfer")
  public String handleTransfer(
    @RequestParam(value="transferFrom", required=true) String transferFrom,
    @RequestParam(value="transferTo", required=true) String transferTo,
    @RequestParam(value="transferAmount", required=true) double transferAmount
  ) {

    if (transferFrom.equals("checking") && transferTo.equals("savings")) {
      if (transferAmount <= CheckingAccountDataStorage.getCurrentBalance(this.userID)) {
        CheckingAccountDataStorage.decreaseAmount(this.userID, transferAmount);
        SavingsAccountDataStorage.increaseAmount(this.userID, transferAmount);
        Transaction transaction = new Transaction(userID, "Transfer from Checking to Savings", transferAmount);
        TransactionDataStorage.addTransaction(transaction);
      } else {
        System.out.println("Not enough funds in Checking Account.");
      }
    } else if (transferFrom.equals("savings") && transferTo.equals("checking")) {
      if (transferAmount <= SavingsAccountDataStorage.getCurrentBalance(this.userID)) {
        SavingsAccountDataStorage.decreaseAmount(this.userID, transferAmount);
        CheckingAccountDataStorage.increaseAmount(this.userID, transferAmount);
        Transaction transaction = new Transaction(userID, "Transfer from Savings to Checking", transferAmount);
        TransactionDataStorage.addTransaction(transaction);
      } else {
        System.out.println("Not enough funds in Savings Account.");
      }
    } else {
      System.out.println("Can not perform this action.");
    }

    return "redirect:/accounts";
  }

  // Withdraw
  @GetMapping("/withdraw")
  public String withdraw() {
    if (this.userID.equals("")) return "redirect:/";
    return "withdraw";
  }

  @PostMapping("/handleWithdraw")
  public String handleWithdraw(
    @RequestParam(value="withdrawFrom", required=true) String withdrawFrom,
    @RequestParam(value="withdrawAmount", required=true) double withdrawAmount
  ) {

    if (withdrawFrom.equals("checking") 
      && CheckingAccountDataStorage.getCurrentBalance(this.userID) >= withdrawAmount) {
      CheckingAccountDataStorage.decreaseAmount(this.userID, withdrawAmount);
      Transaction transaction = new Transaction(userID, "Withdraw from Checking", withdrawAmount);
      TransactionDataStorage.addTransaction(transaction);
    } else if (withdrawFrom.equals("savings") 
      && SavingsAccountDataStorage.getCurrentBalance(this.userID) >= withdrawAmount) {
      SavingsAccountDataStorage.decreaseAmount(this.userID, withdrawAmount);
      Transaction transaction = new Transaction(userID, "Withdraw from Savings", withdrawAmount);
      TransactionDataStorage.addTransaction(transaction);
    } else {
      System.out.println("Not enough funds for withdraw from this account.");
    }

    return "redirect:/accounts";
  }

  // Transactions
  @GetMapping("/transactions")
  public String transactions(Model model) {
    if (this.userID.equals("")) return "redirect:/";
    List<Transaction> transactions = TransactionDataStorage.getTransactions();
    model.addAttribute("transactions", transactions);
    return "transactions";
  }

  // Logout
  @GetMapping("/logout")
  public String logout() {
    this.userID = "";
    return "redirect:/";
  }

}
