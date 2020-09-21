public class StudentAccount extends BankAccount{

  public StudentAccount(int id, String name, int balance)
  {
    super(id, name, balance);
  }

  //override the method to allow the £250 overdraft
  @Override
  public void withdraw(int amount) {
    if (amount <=0)
    {
      throw new IllegalArgumentException("Invalid amount, you cannot withdraw less than £1");
    }
    if (balance-amount< -250)
    {
      throw new IllegalArgumentException("Your overdraft cannot exceed £250.\n");
    }
    if(balance-amount <0 && balance-amount >-250){
      System.out.println("You have entered your overdraft.\n");
    }
    balance= balance-amount;
    }

    @Override
    public String statement()
    {
        return("\nHello "+ this.getName()+
               ".\nYour student account: "+this.getId()+" has a balance of: £" +
               this.getBalance()+"\n");
    }
  }
