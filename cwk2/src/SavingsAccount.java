
import java.util.Scanner;
import java.lang.Math;

public class SavingsAccount extends BankAccount{

  private double intRate;

  public SavingsAccount(int id, String name, int balance)
  {
    super(id, name, balance);

    this.intRate=intRate;
  }

  public double getRate()
  {
    return intRate;
  }

  // A method to manually set the rather, rather than have the object initialised
  //with it
  public void setRate(double rate) {

    if (rate <0)
    {
      throw new IllegalArgumentException("Invalid amount, please enter a valid interest rate");
    }
    intRate=rate;
    }

    public void deposit(int amount) {
      if (amount <=0)
      {
        throw new IllegalArgumentException("Invalid amount, please enter a valid deposit");
      }
      if (amount+balance>10000)
      {
        throw new IllegalArgumentException("Invalid amount, you cann have more than £10,000 in a savings account");
      }
      balance= balance+amount;
      }

      //the balance has to be converted into a double for this calaculation, and then converted back
    public void applyRate()
    {
      double dBalance= (double) balance;
      dBalance = dBalance*(1.0+(intRate/100.0));
      balance = (int) Math.round(dBalance);
    }
    //override the statement method to include the intrest and to indentify that
    //the account is a savings account
  @Override
  public String statement()
  {
      return("\nHello "+ this.getName()+
             ".\nYour savings account: "+this.getId()+" has a balance of: £" +
             this.getBalance()+"\nThe current interest rate is: "+this.getRate()
             +"%\n");
  }
}
