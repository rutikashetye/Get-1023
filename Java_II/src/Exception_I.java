import java.util.Scanner;

class InvalidAmountException extends Exception {
	public InvalidAmountException(String s) {
		super(s);
	}
}

class InsufficientFundException extends Exception {
	public InsufficientFundException(String s) {
		super(s);
	}
}

public class Exception_I {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Current Balance Amount:");
		int curr_bal = sc.nextInt();
		System.out.println("Enter an Amount:");
		int num = sc.nextInt();
		try {
			if (num < 0) {
				throw new InvalidAmountException("Balance Amount is negative");
			} else {
				throw new InvalidAmountException("Balance Amount is positive");
			}

		} catch (InvalidAmountException ex) {
			System.out.println("Caught: " + ex.getMessage());
		}
		try {
		if (num > curr_bal) {
			throw new InsufficientFundException("Balance Amount is less than the Amount");
		} else {
			throw new InsufficientFundException("Balance Amount is Sufficient");
		}
		}
		catch (InsufficientFundException ex) {
			System.out.println("Caught: " + ex.getMessage());
		}
		
	}

}
