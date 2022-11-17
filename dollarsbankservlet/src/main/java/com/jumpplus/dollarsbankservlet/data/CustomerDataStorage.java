package com.jumpplus.dollarsbankservlet.data;

import java.util.ArrayList;
import java.util.List;

import com.jumpplus.dollarsbankservlet.models.Customer;

public class CustomerDataStorage {

  static List<Customer> customers = new ArrayList<Customer>();

  public static void addCustomer(Customer customer) {
    customers.add(customer);
  }

  public static List<Customer> getAllCustomers() {
    return customers;
  }

  public static String getCustomerName(String userID) {
    String customerName = "na";
    for (Customer account : customers) {
      if (account.getUserID().equals(userID)) {
        customerName = account.getCustomerName();
        break;
      }
    }

    return customerName;
  }

  public static String getCustomerAddress(String userID) {
    String customerAddress = "na";
    for (Customer account : customers) {
      if (account.getUserID().equals(userID)) {
        customerAddress = account.getAddress();
        break;
      }
    }

    return customerAddress;
  }

  public static void updateCustomerAddress(String userID, String customerAddress) {
    for (Customer account : customers) {
      if (account.getUserID().equals(userID)) {
        account.setAddress(customerAddress);
        break;
      }
    }
  }

  public static String getCustomerCity(String userID) {
    String customerCity = "na";
    for (Customer account : customers) {
      if (account.getUserID().equals(userID)) {
        customerCity = account.getCity();
        break;
      }
    }

    return customerCity;
  }

  public static void updateCustomerCity(String userID, String customerCity) {
    for (Customer account : customers) {
      if (account.getUserID().equals(userID)) {
        account.setCity(customerCity);;
        break;
      }
    }
  }

  public static String getCustomerState(String userID) {
    String customerState = "na";
    for (Customer account : customers) {
      if (account.getUserID().equals(userID)) {
        customerState = account.getState();
        break;
      }
    }

    return customerState;
  }

  public static void updateCustomerState(String userID, String customerState) {
    for (Customer account : customers) {
      if (account.getUserID().equals(userID)) {
        account.setState(customerState);
        break;
      }
    }
  }

  public static int getCustomerZipCode(String userID) {
    int customerZipCode = -1;
    for (Customer account : customers) {
      if (account.getUserID().equals(userID)) {
        customerZipCode = account.getZipCode();
        break;
      }
    }

    return customerZipCode;
  }

  public static void updateCustomerZipCode(String userID, int customerZipCode) {
    for (Customer account : customers) {
      if (account.getUserID().equals(userID)) {
        account.setZipCode(customerZipCode);
        break;
      }
    }
  }

  public static String getCustomerContactNumber(String userID) {
    String contactNumber = "na";
    for (Customer account : customers) {
      if (account.getUserID().equals(userID)) {
        contactNumber = account.getState();
        break;
      }
    }

    return contactNumber;
  }

  public static void updateCustomerCintactNumber(String userID, String contactNumber) {
    for (Customer account : customers) {
      if (account.getUserID().equals(userID)) {
        account.setContactNumber(contactNumber);
        break;
      }
    }
  }

  public static String getCustomerEmail(String userID) {
    String customerEmail = "na";
    for (Customer account : customers) {
      if (account.getUserID().equals(userID)) {
        customerEmail = account.getEmail();
        break;
      }
    }

    return customerEmail;
  }

  public static void updateCustomerEmail(String userID, String email) {
    for (Customer account : customers) {
      if (account.getUserID().equals(userID)) {
        account.setEmail(email);
        break;
      }
    }
  }

  public static void updateCustomerPassword(String userID, String password) {
    for (Customer account : customers) {
      if (account.getUserID().equals(userID)) {
        account.setPassword(password);
        break;
      }
    }
  }
  
}
