import java.util.ArrayList;
////////////////BankAccount class (INCLUDE IN EVERY FILE) //////////////////////////
//
//Title: (descriptive title of the program making use of this file)
//Course: CS 300 Fall 2020
//
//Author: Zhuoyan Xu
//Email: zxu444@wisc.edu
//Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
//Persons: Hobbes LeGault
//Online Sources: zybook + piazza
//
///////////////////////////////////////////////////////////////////////////////
/**
* 
* @author Zhuoyan Xu
* 
*/
public class BankAccount {
  private String BANK_NAME;
  private static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
  private static int numberGenerator = 1001;
  protected int NUMBER;
  private double balance;

  public BankAccount(double initialBalance) throws IllegalArgumentException {

    if (initialBalance < 10.0) {
      throw new IllegalArgumentException("Error! Provided initialBalance is less than 10.0.");
    }
    this.balance = initialBalance;

    this.BANK_NAME = "Fantastic Bank";

    numberGenerator++;
    this.NUMBER = numberGenerator;
    accounts.add(this);

  }

  /**
   * – Adds the specified amount provided as input to the balance of this bank account. – Throws an
   * IllegalArgumentException with a descriptive error message if the amount to deposit is
   * non-positive ( <= 0.0).
   * 
   * @param amount
   */
  public void deposit(double amount) throws IllegalArgumentException {
    if (amount < 0.0) {
      throw new IllegalArgumentException("Error! The amount to deposit is non-positive.");
    }
    this.balance += amount;
  }

  /**
   * – Withdraws the specified amount from this bank account from the balance of this bank account.
   * – Returns false if the provided amount as input is non-positive (<= 0.0) or if the balance of
   * this account is NOT enough to complete this withdrawal operation, and true otherwise
   * 
   * @param amount
   * @return
   */
  public boolean withdraw(double amount) {
    boolean isWit = false;
    if (amount <= 0.0)
      return isWit;
    if (this.balance - amount < 0.0)
      return isWit;

    this.balance -= amount;
    isWit = true;
    return isWit;
  }

  /**
   * – Returns the current balance of this bank account.
   * 
   * @return
   */
  public double balance() {
    return this.balance;
  }

  /**
   * – Checks whether this bank account equals a provided object as input. – other represents an
   * Object with which to compare. – true if other object is an instance of BankAccount and has the
   * same NUMBER as this account.
   */
  public boolean equals(Object other) {
    if(other instanceof BankAccount) {
      return this.NUMBER == ((BankAccount) other).NUMBER;
    }
    return false;
  }


  /**
   * – Returns a String representation of this bank account in the following format: "Bank Account
   * #" + NUMBER + ": $" + balance
   */
  public String toString() {
    return "Bank Account #" + this.NUMBER + ": $" + this.balance;
  }

  
  /**
   * – Returns a String representation of all the accounts that have been created. – Feel free to
   * define the details of the format of the returned string at your choice. But this string must
   * contain: ∗ the name of the bank, and
   * 
   * @return
   */
  public static String getAllAccounts() {
    String all = "";
    for(int i = 0; i<accounts.size();i++) {
      all += "Account name: " + accounts.get(i).BANK_NAME + "; Account Type: " + accounts.get(i).toString() + "\n";
    }
    return all;
  }
  
  public static void demo() {
    BankAccount BB1 = new BankAccount(10);
    BankAccount BB2 = new BankAccount(20);
    BankAccount BB3 = new BankAccount(30);
    BB1.deposit(1); BB1.withdraw(1);
    BB2.deposit(2); BB2.withdraw(2);
    BB2.deposit(3); BB2.withdraw(3);
    
    MoneyMarketAccount MM1 = new MoneyMarketAccount(10);
    MoneyMarketAccount MM2 = new MoneyMarketAccount(20);
    MM1.deposit(1); MM1.withdraw(1);
    MM2.deposit(2); MM2.withdraw(2);
    
    MM1.addInterest(); MM2.addInterest();
    
    System.out.println(getAllAccounts());
    
    
    
  }

  public static void main(String[] args) {
    demo();

  }

}
















