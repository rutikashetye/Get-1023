class CurrentAccount extends Account{
	
	private double overdraftLimitAmount=5000;
	public CurrentAccount(int accountNo, double accountBalance, String accountPassword,double overdraftLimitAmount) {
		super(accountNo,accountBalance,accountPassword);
		this.overdraftLimitAmount = overdraftLimitAmount;
	}
	public void displayAccount() {
		super.displayAccount();
		System.out.println("overdraft Limit Amount:"+overdraftLimitAmount);
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CurrentAccount cr = new CurrentAccount(101, 23000, "1234",2000);
		Account obj = cr; //Upcasting
		obj.displayAccount();
	}
	@Override
	double withdraw(double amount) {
		// TODO Auto-generated method stub
		return overdraftLimitAmount-amount;
	}

}
