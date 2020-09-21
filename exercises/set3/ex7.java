class BankAccount
{
    // Instance Variables
    private int id;
    private String name;
    private static int balance;

    // Constructor Declaration of Class
    public BankAccount(int id, String name, int balance)
    {
        this.id = id;
        this.name = name;
        BankAccount.balance = balance;
    }

    // method 1
    public int getId()
    {
        return id;
    }

    // method 4
    public String getName()
    {
        return name;
    }

    public int getBalance()
    {
        return balance;
    }

    public static boolean deposit(int amount) {
      if (amount >0)
      {
        balance= balance+amount;
        return true;
      }
      else
        return false;
      }

      public static boolean withdraw(int amount) {
        if (amount >0 && amount <= balance)
        {
          balance= balance-amount;
          return true;
        }
        else
          return false;
        }

    public String statement()
    {
        return("Hello "+ this.getName()+
               ".\nYour balance is currently £:" +
               this.getBalance());
    }

    public static void main(String[] args)
    {
        BankAccount acc = new BankAccount(1100110, "myAccount", 20000);
        withdraw(2500);
        deposit(4000);
        System.out.println(acc.statement());
    }
}
