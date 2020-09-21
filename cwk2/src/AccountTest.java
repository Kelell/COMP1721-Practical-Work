
import java.lang.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {

  SavingsAccount s1 = new SavingsAccount(11000010, "Ezra Ellefson",5000);
  SavingsAccount s2 = new SavingsAccount(11567123, "Yang Yager",0);
  SavingsAccount s3 = new SavingsAccount(65936549, "Verla Vandermeulen",10000);

  StudentAccount s4 = new StudentAccount(14758355, "Xavier Xie",1000);
  StudentAccount s5 = new StudentAccount(65493609, "Chantelle Carmen",8000);
  StudentAccount s6 = new StudentAccount(93655127, "Maria Moulton",150);

  //initialisation testing
  @Test
  public void nameTest() {
  assertEquals("Ezra Ellefson", s1.getName());
  assertEquals("Yang Yager", s2.getName());
  assertEquals("Verla Vandermeulen", s3.getName());
  assertEquals("Xavier Xie", s4.getName());
  assertEquals("Chantelle Carmen", s5.getName());
  assertEquals("Maria Moulton", s6.getName());
  }

  @Test
  public void balanceTest() {
    assertEquals(5000, s1.getBalance());
    assertEquals(0, s2.getBalance());
    assertEquals(10000, s3.getBalance());
    assertEquals(1000, s4.getBalance());
    assertEquals(8000, s5.getBalance());
    assertEquals(150, s6.getBalance());
  }

  @Test
  public void idTest() {
  assertEquals(11000010, s1.getId());
  assertEquals(11567123, s2.getId());
  assertEquals(65936549, s3.getId());
  assertEquals(14758355, s4.getId());
  assertEquals(65493609, s5.getId());
  assertEquals(93655127, s6.getId());
  }

  @Test
  public void statementTest() {
    assertEquals("\nHello Ezra Ellefson.\nYour savings account: 11000010 has a balance of: £5000\nThe current interest rate is: 0.0%\n", s1.statement());
    assertEquals("\nHello Yang Yager.\nYour savings account: 11567123 has a balance of: £0\nThe current interest rate is: 0.0%\n", s2.statement());
    assertEquals("\nHello Verla Vandermeulen.\nYour savings account: 65936549 has a balance of: £10000\nThe current interest rate is: 0.0%\n", s3.statement());
    assertEquals("\nHello Xavier Xie.\nYour student account: 14758355 has a balance of: £1000\n", s4.statement());
    assertEquals("\nHello Chantelle Carmen.\nYour student account: 65493609 has a balance of: £8000\n", s5.statement());
    assertEquals("\nHello Maria Moulton.\nYour student account: 93655127 has a balance of: £150\n", s6.statement());
  }

  //withdraw and desposit tests
  @Test
  public void normalSavingsDesposit(){
    s1.deposit(4000);
    assertEquals(9000, s1.getBalance());
    s2.deposit(10000);
    assertEquals(10000, s2.getBalance());
  }

  @Test
  public void minimumSavingsDesposit() {
  boolean thrown = false;

  try {
      s1.deposit(0);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
  assertTrue(thrown);

  thrown = false;
  try {
      s2.deposit(-1000);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
  assertTrue(thrown);
  }

  @Test
  public void normalStudentDesposit(){
  s4.deposit(50);
  assertEquals(1050, s4.getBalance());
  s5.deposit(5000);
  assertEquals(13000, s5.getBalance());
  }

  @Test
  public void minimumStudentDesposit() {
    boolean thrown = false;

    try {
      s4.deposit(0);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    assertTrue(thrown);

    thrown = false;
    try {
      s5.deposit(-1000);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }

  @Test
  public void normalSavingsWithdrawal(){
    s1.withdraw(1000);
    assertEquals(4000, s1.getBalance());
    s3.withdraw(10000);
    assertEquals(0, s2.getBalance());
  }

  @Test
  public void maximumSavingsWithdrawal(){
    boolean thrown = false;

    try {
      s1.withdraw(5001);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    assertTrue(thrown);

    thrown = false;
    try {
      s2.withdraw(1000);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }

  @Test
  public void minimumSavingsWithdrawal(){
    boolean thrown = false;

    try {
      s1.withdraw(0);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    assertTrue(thrown);

    thrown = false;
    try {
      s2.withdraw(-50);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }

  @Test
  public void normalStudentWithdrawal(){
    s4.withdraw(500);
    assertEquals(500, s4.getBalance());
    s5.withdraw(8000);
    assertEquals(0, s5.getBalance());
  }

  //unique functionaility tests
  @Test
  public void maximumSavingsDesposit() {
  boolean thrown = false;

  try {
    s3.deposit(1000);
  } catch (IllegalArgumentException e) {
    thrown = true;
  }
  assertTrue(thrown);
  }

  @Test
  public void overdraftTest(){
    s4.withdraw(1100);
    assertEquals(-100, s4.getBalance());
    s4.withdraw(150);
    assertEquals(-250, s4.getBalance());
  }

  @Test
  public void maximumOverdraft() {
    boolean thrown = false;

    try {
      s6.withdraw(1000);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }

  @Test
  public void intrestTest(){
    s1.setRate(10);
    s1.applyRate();
    assertEquals(5500, s1.getBalance());
    s3.setRate(1.5);
    s3.applyRate();
    assertEquals(10150, s3.getBalance());
  }

  @Test
  public void finalTest(){
    System.out.println(s1.statement());
    System.out.println(s2.statement());
    System.out.println(s3.statement());
    System.out.println(s4.statement());
    System.out.println(s5.statement());
    System.out.println(s6.statement());


    s1.setRate(2.3);
    s1.withdraw(4500);
    s1.withdraw(250);
    s1.deposit(1000);
    s1.applyRate();
    s1.withdraw(500);
    s1.deposit(7500);
    assertEquals(8279, s1.getBalance());

    s2.deposit(5000);
    s2.withdraw(2500);
    s2.setRate(0.5);
    s2.applyRate();
    assertEquals(2512, s2.getBalance());

    s3.setRate(3.5);
    s3.applyRate();
    s3.applyRate();
    s3.applyRate();
    s3.setRate(1.7);
    s3.withdraw(7500);
    assertEquals(3587, s3.getBalance());

    s4.withdraw(50);
    s4.withdraw(500);
    s4.deposit(2000);
    s4.withdraw(1000);
    s4.deposit(50);
    assertEquals(1500, s4.getBalance());

    s5.deposit(8000);
    s5.deposit(1000);
    s5.deposit(6000);
    s5.withdraw(5);
    assertEquals(22995, s5.getBalance());

    s6.withdraw(300);
    s6.deposit(50);
    s6.withdraw(10);
    s6.deposit(100);
    assertEquals(-10, s6.getBalance());


    System.out.println(s1.statement());
    System.out.println(s2.statement());
    System.out.println(s3.statement());
    System.out.println(s4.statement());
    System.out.println(s5.statement());
    System.out.println(s6.statement());
  }

}
