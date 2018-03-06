package week5;

public class AssertionTest {

	public static void main(String[] args) {
		BankAccount acc = new BankAccount();
		acc.deposit(-100);
		System.out.println(acc.getBalance());
		acc.withdraw(50);
		System.out.println(acc.getBalance());
	}

}
