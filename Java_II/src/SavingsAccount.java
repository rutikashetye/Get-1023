public class SavingsAccount extends Account {
private double minimumBalance = 20000;
	
	public SavingsAccount(int accountNo, double accountBalance, String accountPassword,double minimumBalance) {
		super(accountNo,accountBalance,accountPassword);
		this.minimumBalance = minimumBalance;
	}


	public void displayAccount() {
		super.displayAccount();
		System.out.println("Minimum Balance:"+minimumBalance);
	}
	public static void main(String[] args)
	{

	SavingsAccount sv = new SavingsAccount(101, 23000, "1234",3000);
	sv.displayAccount();
		
	}


	@Override
	double withdraw(double amount) {
		// TODO Auto-generated method stub
		return minimumBalance-amount;
	}
}
