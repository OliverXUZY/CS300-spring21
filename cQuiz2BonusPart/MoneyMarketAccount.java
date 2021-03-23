////////////////MoneyMarketAccount class (INCLUDE IN EVERY FILE) //////////////////////////
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
public class MoneyMarketAccount extends BankAccount {
  private double PENALTY_RATE;
  private double INTERST_RATE;

  public MoneyMarketAccount(double initialBalance) {
    super(initialBalance);
    this.PENALTY_RATE = 0.1;
    this.INTERST_RATE = 0.05;

  }

  /**
   * – Adds interest to the balance of this account with respect to the INTEREST RATE
   */
  public void addInterest() {
    this.deposit(INTERST_RATE * this.balance());
  }

  @Override
  /**
   * – Withdraws the specified amount, plus the penalty for withdrawing from this money market
   * account with respect to PENALTY RATE. This method overrides the withdraw() method defined in
   * the super class BankAccount, and uses BankAccount.withdraw() method to perform the actual
   * withdrawal operation (partial overriding).
   * – Returns true if this operation completes successfully, and false if not.
   */
  public boolean withdraw(double amount) {
    return super.withdraw(amount * (1 + PENALTY_RATE));
  }
  
  @Override
  public String toString() {
    return "Money Market Account #" + this.NUMBER + ": $" + this.balance();
  }

}
