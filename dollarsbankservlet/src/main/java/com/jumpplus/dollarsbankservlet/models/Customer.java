package com.jumpplus.dollarsbankservlet.models;

public class Customer {
  
  private String userID;
	private String customerName;
	private String address;
  private String city;
  private String state;
  private int zipCode;
	private String contactNumber;
  private String email;
	private String password;


  public Customer(String userID, String customerName, String address, String city, String state, int zipCode, String contactNumber, String email, String password) {
    super();
    this.userID = userID;
    this.customerName = customerName;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.contactNumber = contactNumber;
    this.email = email;
    this.password = password;
  }

	
  public String getUserID() {
    return this.userID;
  }

  public String getCustomerName() {
    return this.customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public int getZipCode() {
    return this.zipCode;
  }

  public void setZipCode(int zipCode) {
    this.zipCode = zipCode;
  }

  public String getContactNumber() {
    return this.contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "{" +
      " userID='" + getUserID() + "'" +
      ", customerName='" + getCustomerName() + "'" +
      ", address='" + getAddress() + "'" +
      ", city='" + getCity() + "'" +
      ", state='" + getState() + "'" +
      ", zipCode='" + getZipCode() + "'" +
      ", contactNumber='" + getContactNumber() + "'" +
      ", email='" + getEmail() + "'" +
      "}";
  }	
	
}
