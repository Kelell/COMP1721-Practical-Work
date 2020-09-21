
 class BankAccount
{

    private int id;
    private String name;
    protected int balance;


    public BankAccount(int id, String name, int balance)
    {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }


    public int getId()
    {
        return id;
    }


    public String getName()
    {
        return name;
    }

    public int getBalance()
    {
        return balance;
    }

    public void deposit(int amount) {
      if (amount <=0)
      {
        throw new IllegalArgumentException("Invalid amount, please enter a valid deposit");
      }
      balance= balance+amount;
      }

      public void withdraw(int amount) {
        if (amount <=0 || amount > balance)
        {
          throw new IllegalArgumentException("Invalid amount, you cannot withdraw less than £1 or more than your balance");
        }
        balance= balance-amount;
        }

    public String statement()
    {
        return("Hello "+ this.getName()+
               ".\nYour basic account: "+this.getId()+" has a balance of: £" +
                this.getBalance()+"\n");
    }
}
